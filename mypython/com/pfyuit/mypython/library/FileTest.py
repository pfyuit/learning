'''
Created on Jan 29, 2016
@author: yupengfei
'''

file=open("C:\\abc.txt", "rb")
print("file name:",file.name)
print("file isclosed:",file.closed)
print("file access mode:",file.mode)

file.close()