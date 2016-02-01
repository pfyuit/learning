'''
Created on Jan 29, 2016
@author: yupengfei
'''

import os

file=open("C:\\abc.txt", "rb")
print("file name:",file.name)
print("file isclosed:",file.closed)
print("file access mode:",file.mode)

str =file.read(10)
print("read:",str)

position = file.tell();
print(position)

os.mkdir("C:\\test")
os.rmdir("C:\\test")

#os.rename( "C:\\abc.txt", "C:\\test.txt" )

file.close()