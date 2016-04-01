#!/bin/bash
set -e

if [ $# -lt 2 ]; then
 echo "Usage: $0 <branch> <digest>"
 exit
fi

echo "=>Adopt Java and Maven environment..."
source /etc/profile
echo "=>Using JAVA_HOME: $JAVA_HOME"
echo "=>Using MVN_HOME: $MVN_HOME"

echo "=>Pull latest code and execute package..."
cd /var/home/dev/gitlab/zeus.api/
bin/deploy-gzip-local.sh $1 $2

echo "=>Copy package to target directory..."
cp /var/home/dev/gitlab/zeus.api/zeus/target/$1_1.0-SNAPSHOT_$2.tgz /var/home/dev/zeus/

echo "=>Kill zeus process..."
cd /var/home/dev/zeus/
./bin/kill-app
sleep 5

echo "=>Remove old folders and jars..."
rm -rf bin
rm -rf dependency
rm -rf target
rm -rf zeus-1.0-SNAPSHOT.jar

echo "=>Unzip tgz file and copy resources..."
tar -zxvf $1_1.0-SNAPSHOT_$2.tgz
cp -r $1_1.0-SNAPSHOT_$2/bin ./
cp -r $1_1.0-SNAPSHOT_$2/dependency ./
cp -r $1_1.0-SNAPSHOT_$2/target ./
cp -p $1_1.0-SNAPSHOT_$2/zeus-1.0-SNAPSHOT.jar ./
rm -rf $1_1.0-SNAPSHOT_$2

echo "=>Start zeus process...."
source ~/.bash_profile
./bin/start-app

echo "=>Start zeus process successfully..."