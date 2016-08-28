#!/bin/bash

set -e

RESULT_FILE_TEMP="$HOME/connections.temp"
RESULT_FILE="$HOME/connections.out"

mysql --default-character-set=utf8 -hxxx -P3306 -uxxx -pxxx -e "SELECT p.* 
FROM information_schema.processlist p
INNER JOIN
(
 SELECT LEFT(HOST,LOCATE(':',HOST)-1) AS IP,COUNT(*) AS CONNECTIONS 
 FROM information_schema.processlist 
 WHERE HOST != 'localhost'
 GROUP BY IP
 ORDER BY CONNECTIONS DESC
)AS origin ON origin.IP=LEFT(p.HOST,LOCATE(':',p.HOST)-1)
WHERE origin.IP='192.168.0.12' AND origin.CONNECTIONS>200
"  > $RESULT_FILE_TEMP

line_number=1
for line in `cat $RESULT_FILE_TEMP`; do
  if [ $line_number -eq 1 ]; then
    if [[ ${line} -eq "ID" ]]; then
      #echo "got data!"
      cat $RESULT_FILE_TEMP >> $RESULT_FILE
      cat $RESULT_FILE_TEMP | mail -s "Many connections `date '+%Y%m%d_%H:%M:%S'`" "pfyuit@gmail.com"
      exit
    fi  
  fi  
  line_number=$((line_number + 1))
done