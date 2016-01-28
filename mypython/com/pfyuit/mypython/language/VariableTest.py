'''
Created on Jan 29, 2016
@author: yupengfei
'''

# -*- coding: UTF-8 -*-

print("==>numeric")
var1 = 1
var2 = 10.9
print(var1)
print(var2)
del var1
del var2

print("==>string")
var3='ilovepython'
var4=var3[1:5]
print(var4)

print("==>aList")
aList=['a','b','c','d','e']
sublist=aList[1:5]
print(sublist)
print(sublist[0])

print("==>read only aList")
readOnlyList=['a','b','c','d','e']
print(readOnlyList)
print(readOnlyList[0])

print("==>dictionary")
dictionary={}
dictionary['key1']='value1'
dictionary['key2']='value2'
print(dictionary)
print(dictionary['key1'])
print(dictionary['key2'])
