#!/bin/sh
singlefile="mtams.create.sql"
scriptsdir=~/projects/mtams/source/branches/database/sqlscripts/derby

echo $singlefile
echo $scriptsdir
#echo ~
#ls ~

#stat $singlefile
#ls $scriptsdir
#ls -1 ./derby/*.sql
#./derby/mtams_AccountRole.sql
#./derby/mtams_Account.sql
#./derby/mtams_Permission.sql
#./derby/mtams_Role.sql
#./derby/mtams_Session.sql
#./derby/mtams_Task.sql
#./derby/mtams_TravelDocument.sql
#./derby/mtams_TravelerProfile.sql


#initial run clears file
echo "-- $scriptsdir/mtams_Role.sql > $singlefile"
cat $scriptsdir/mtams_Role.sql > $singlefile

#appends additional files
echo "-- $scriptsdir/mtams_Task.sql >> $singlefile"
cat $scriptsdir/mtams_Task.sql >> $singlefile
echo "-- $scriptsdir/mtams_Account.sql >> $singlefile"
cat $scriptsdir/mtams_Account.sql >> $singlefile
echo "-- $scriptsdir/mtams_AccountRole.sql >> $singlefile"
cat $scriptsdir/mtams_AccountRole.sql >> $singlefile
echo "-- $scriptsdir/mtams_Permission.sql >> $singlefile"
cat $scriptsdir/mtams_Permission.sql >> $singlefile

echo "-- $scriptsdir/mtams_Session.sql >> $singlefile"
cat $scriptsdir/mtams_Session.sql >> $singlefile

echo "-- $scriptsdir/mtams_TravelerProfile.sql >> $singlefile"
cat $scriptsdir/mtams_TravelerProfile.sql >> $singlefile

echo "-- $scriptsdir/mtams_TravelDocument.sql >> $singlefile"
cat $scriptsdir/mtams_TravelDocument.sql >> $singlefile
