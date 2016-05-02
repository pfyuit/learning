'''
Created on May 2, 2016
@author: yupengfei
'''
# -*- coding:UTF-8 -*-

print("==>Numbers")
var = 123 #int
print(var)
var = 12345678912345566 #long
print(var)
var = 123.456 #float
print(var)

print("==>String")
var = "MyString"
print(var)
print(var[0])
print(var[1:3])
print(len(var))

print("==>List")
list = [ 'abcd', 786 , 2.23, 'john', 70.2 ]
print(list)
print(list[0])
print(list[1:3])
print(list[2:])

print("==>Tuple")
tuple = ( 'abcd', 786 , 2.23, 'john', 70.2 )
print(tuple)
print(tuple[0])
print(tuple[1:3])
print(tuple[2:])

print("==>Dictionary")
tinydict = {'name': 'john','code':6734, 'dept': 'sales'}
print(tinydict)
print(tinydict['name'])
print(tinydict.keys())
print(tinydict.values())
