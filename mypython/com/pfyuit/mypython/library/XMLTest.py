'''
Created on Apr 30, 2016
@author: yupengfei
'''
import os
from xml.dom import minidom

fileName = os.path.expanduser("~/v3/conf/db_v3center.xml")
domTree = minidom.parse(fileName)

print ("XML file name is: %s" % fileName)

url = domTree.getElementsByTagName('url')[0].firstChild.data
print("URL is: %s" % url)

user = domTree.getElementsByTagName('user')[0].firstChild.data
print("User is: %s" % user)

password = domTree.getElementsByTagName('password')[0].firstChild.data
print("Password is: %s" % password)

