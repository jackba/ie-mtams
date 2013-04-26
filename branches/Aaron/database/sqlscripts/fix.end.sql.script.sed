#!/bin/sed
#sed -e ":start;$!N;s/,\n)\;/\n);/;tstart;"
# http://stackoverflow.com/questions/1251999/sed-how-can-i-replace-a-newline-n
# http://backreference.org/2009/12/23/how-to-match-newlines-in-sed/
# remove ',' char before the end of a sql creat statment ');'
:start;$!N;s/,\n)\;/\n);/;tstart;
