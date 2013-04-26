#!/bin/bash
#
# used to create the mtams.data.sql mtams.create.sql files by processing all 
# the necessary files and running necessary scripts.

# run from this directory
#/common/projects/mtams/source/branches/Aaron/database/sqlscripts
# relative to the project directory
# ./branches/Aaron/database/sqlscripts


#cp ./mysql/* ./derby/
#find ./derby/mtams_*.sql | xargs -I{} sh -c "sed -i.old -f ./fix.sql.script.sed {}"
#replaces the above two commands
echo "processing mysql exports into derby create table statements"
find ./mysql/* -printf "%f\\n" | xargs -I{} sh -c "sed -f ./fix.sql.script.sed ./mysql/{} > ./derby/{}"

#find ./derby/mtams_*.sql | xargs -I{} sh -c "sed -i.cfix -f ./fix.end.sql.script.sed {}"
#find ./derby/mtams_*.sql.* -exec mv '{}' ./derby-del/ \;
echo "creating the mtams.create.sql and the mtams.data.sql"
./cat.script.sh

# create data export script 
cp ./mtams.data.sql ./mtams.data.sql.bk
sed -nf ./insert.sql.sed ./mtams.create.sql > mtams.data.sql

