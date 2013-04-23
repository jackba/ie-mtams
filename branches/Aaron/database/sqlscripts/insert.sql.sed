#!/bin/sed -nf
# simple sed script to dump out the insert statements from the mtams.create.sql

/LOCK /p
/INSERT/ s/--//p

