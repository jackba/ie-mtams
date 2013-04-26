#!/bin/sh
singlefile="mtams.create.sql"
scriptsdir=~/projects/mtams/source/branches/Aaron/database/sqlscripts/derby

echo $singlefile
echo $scriptsdir
cp $singlefile $singlefile.bk
#echo ~
#ls ~

#stat $singlefile
#ls $scriptsdir
#r! grep -ci "FOREIGN" ./derby/mtams_* | sort -t: -k2 -n
#vim command line subsititue to add # in front of lines
#.,+27s/./#./
# ordered by foreign keys 

# Sepcial notes where grep does not work
# table X comess >> after table Y

# Itinerary >> Travel
# RewardsProgram >> TravlerProfile
# TravelDocument >> TravlerProfile
# Approval >> Application


#./derby/mtams_Account.sql:0
#./derby/mtams_Conference.sql:0
#./derby/mtams_CountryLookup.sql:0
#./derby/mtams_DepartmentLookup.sql:0
#./derby/mtams_ForexOrder.sql:0
#./derby/mtams_LeaveLookup.sql:0
#./derby/mtams_Motivation.sql:0
#./derby/mtams_Quotes.sql:0
#./derby/mtams_Role.sql:0
#./derby/mtams_Task.sql:0
#./derby/mtams_Title.sql:0
#./derby/mtams_AccomodationQuotes.sql:1
#./derby/mtams_CarQuotes.sql:1
#./derby/mtams_CityLookup.sql:1
#./derby/mtams_FinalCosting.sql:1
#./derby/mtams_FlightQuotes.sql:1
#./derby/mtams_Session.sql:1
#./derby/mtams_TravelerProfile.sql:1
#./derby/mtams_RewardsProgram.sql:1
#./derby/mtams_TravelDocument.sql:1
#./derby/mtams_Travel.sql:1
#./derby/mtams_Itinerary.sql:1
#./derby/mtams_AccountRole.sql:2
#./derby/mtams_Permission.sql:2
#./derby/mtams_Application.sql:7
#./derby/mtams_Approval.sql:2
#./derby/mtams_Attachement.sql:15



# remove the fine counts
#.,+27s/:.*//

# format lines into working scripts
# .,+27s/#.\/derby\(.*\)/echo "-- $scriptsdir\1 >> $singlefile" \rcat $scriptsdir\1 >> $singlefile/

#initial run clears file
echo "-- $scriptsdir/mtams_Account.sql > $singlefile"
cat $scriptsdir/mtams_Account.sql > $singlefile

# append to singlefile 
echo "-- $scriptsdir/mtams_Conference.sql >> $singlefile" 
cat $scriptsdir/mtams_Conference.sql >> $singlefile
echo "-- $scriptsdir/mtams_CountryLookup.sql >> $singlefile" 
cat $scriptsdir/mtams_CountryLookup.sql >> $singlefile
echo "-- $scriptsdir/mtams_DepartmentLookup.sql >> $singlefile" 
cat $scriptsdir/mtams_DepartmentLookup.sql >> $singlefile
echo "-- $scriptsdir/mtams_ForexOrder.sql >> $singlefile" 
cat $scriptsdir/mtams_ForexOrder.sql >> $singlefile
echo "-- $scriptsdir/mtams_LeaveLookup.sql >> $singlefile" 
cat $scriptsdir/mtams_LeaveLookup.sql >> $singlefile
echo "-- $scriptsdir/mtams_Motivation.sql >> $singlefile" 
cat $scriptsdir/mtams_Motivation.sql >> $singlefile
echo "-- $scriptsdir/mtams_Quotes.sql >> $singlefile" 
cat $scriptsdir/mtams_Quotes.sql >> $singlefile
echo "-- $scriptsdir/mtams_Role.sql >> $singlefile" 
cat $scriptsdir/mtams_Role.sql >> $singlefile
echo "-- $scriptsdir/mtams_Task.sql >> $singlefile" 
cat $scriptsdir/mtams_Task.sql >> $singlefile
echo "-- $scriptsdir/mtams_Title.sql >> $singlefile" 
cat $scriptsdir/mtams_Title.sql >> $singlefile
echo "-- $scriptsdir/mtams_AccomodationQuotes.sql >> $singlefile" 
cat $scriptsdir/mtams_AccomodationQuotes.sql >> $singlefile
echo "-- $scriptsdir/mtams_CarQuotes.sql >> $singlefile" 
cat $scriptsdir/mtams_CarQuotes.sql >> $singlefile
echo "-- $scriptsdir/mtams_CityLookup.sql >> $singlefile" 
cat $scriptsdir/mtams_CityLookup.sql >> $singlefile
echo "-- $scriptsdir/mtams_FinalCosting.sql >> $singlefile" 
cat $scriptsdir/mtams_FinalCosting.sql >> $singlefile
echo "-- $scriptsdir/mtams_FlightQuotes.sql >> $singlefile" 
cat $scriptsdir/mtams_FlightQuotes.sql >> $singlefile
echo "-- $scriptsdir/mtams_Session.sql >> $singlefile" 
cat $scriptsdir/mtams_Session.sql >> $singlefile
echo "-- $scriptsdir/mtams_TravelerProfile.sql >> $singlefile" 
cat $scriptsdir/mtams_TravelerProfile.sql >> $singlefile
echo "-- $scriptsdir/mtams_RewardsProgram.sql >> $singlefile" 
cat $scriptsdir/mtams_RewardsProgram.sql >> $singlefile
echo "-- $scriptsdir/mtams_TravelDocument.sql >> $singlefile" 
cat $scriptsdir/mtams_TravelDocument.sql >> $singlefile
echo "-- $scriptsdir/mtams_Travel.sql >> $singlefile" 
cat $scriptsdir/mtams_Travel.sql >> $singlefile
echo "-- $scriptsdir/mtams_Itinerary.sql >> $singlefile" 
cat $scriptsdir/mtams_Itinerary.sql >> $singlefile
echo "-- $scriptsdir/mtams_AccountRole.sql >> $singlefile" 
cat $scriptsdir/mtams_AccountRole.sql >> $singlefile
echo "-- $scriptsdir/mtams_Permission.sql >> $singlefile" 
cat $scriptsdir/mtams_Permission.sql >> $singlefile
echo "-- $scriptsdir/mtams_Application.sql >> $singlefile" 
cat $scriptsdir/mtams_Application.sql >> $singlefile
echo "-- $scriptsdir/mtams_Approval.sql >> $singlefile" 
cat $scriptsdir/mtams_Approval.sql >> $singlefile
echo "-- $scriptsdir/mtams_Attachement.sql >> $singlefile" 
cat $scriptsdir/mtams_Attachement.sql >> $singlefile

