#!/bin/sed -nf
# simple sed script to convert mysql datadump to 
# simple ansi / db2 / derby understandable sql

# deletes and removales
#sed -ne '/^\/\*\!/p' delete special mysql comments
/^\/\*\!/d 
s/\/\*\!.*/;/
#sed -ne '/ENGINE/ s/ENGINE.*//p' remove code after create tables statements
# ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
#sed -ne 's/(11)//p' removes mysql specific int(11)
s/(11)//
/smallint(6)/ s/(6)//
#sed -ne '/  KEY / s/KEY/FOREIGN KEY/p'
#/  KEY / s/KEY/FOREIGN KEY/
# sed -ne '/  KEY / s/KEY ''[^ ]*''/FOREIGN KEY/p'
#/  KEY / s/KEY "[^ ]*"/FOREIGN KEY/
/^  KEY /d


#replacements
#sed -ne '/^USE/ s/USE/SET SCHEMA /p' change use db to SET SCHEMA db
/^USE/ s/USE/-- SET SCHEMA / 
#sed -ne 's/`/\"/gp' replace [`] chars with ["] chars
s/`/\"/g
/ENGINE/ s/ENGINE.*/;/
#sed -ne '/CREATE DATABASE/ s/DATABASE.*EXISTS/SCHEMA/p'
/CREATE DATABASE/ s/DATABASE.*EXISTS/SCHEMA/
#sed -ne '/CREATE SCHEMA/ s/^\(.\)/-- \1/p' comment out Create database statements
/CREATE SCHEMA/ s/^\(.\)/-- \1/
#sed -ne '/IF EXISTS/ s/^\(.\)/-- \1/p' comment out drop table and if exists statements
/IF EXISTS/ s/^\(.*\)/-- \1/
s/IF EXISTS//
#sed -ne 's/AUTO_INCREMENT/GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) /p'
s/AUTO_INCREMENT/GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) /
#sed -ne '/LOCK TABLES/ s/WRITE/EXCLUSIVE/
/^LOCK TABLES/ s/WRITE/IN EXCLUSIVE MODE/
/LOCK TABLES/ s/TABLES/TABLE/
/LOCK TABLE/ s/\(^.\)/-- \1/
#s/UNLOCK TABLES;/COMMIT;/
/UNLOCK TABLE/d
#sed -ne '/CONSTRAINT/ s/CONSTRAINT/-- CONSTRAINT/p'
#/CONSTRAINT/ s/CONSTRAINT/-- CONSTRAINT/
#sed -ne '/timestamp/ s/NULL//p'
/timestamp/ s/NULL//
#sed -ne "/smallint/ s/'//gp"
/smallint/ s/'//g

#sed -ne '/VALUES/ s/VALUES ([^,]*/VALUES (DEFAULT/p' ./mtams_Role.sql
/VALUES/ s/VALUES ([^,]*/VALUES (DEFAULT/
s/INSERT/-- INSERT/

# fix sql statments with ') ;' to ');'
s/).*;/);/

#sed -e "s/COMMENT/, --COMMENT/"
# move the end of line ',' to before --comment
s/COMMENT/, --COMMENT/

#sed -e ":start;$!N;s/,\n)\;/\n);/;tstart;"
# http://stackoverflow.com/questions/1251999/sed-how-can-i-replace-a-newline-n
# http://backreference.org/2009/12/23/how-to-match-newlines-in-sed/
# remove ',' char before the end of a sql creat statment ');'
#:start;$!N;s/,\n)\;/\n)\;/;tstart;P;D;

# sed low to upper case
s/\(.*\)/\U\1/
