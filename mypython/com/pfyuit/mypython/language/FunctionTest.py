'''
Created on Jan 29, 2016
@author: yupengfei
'''
#-*- encoding: UTF-8 -*-

print("==>invoke function")
def printFunc(strs):
    "required parameter"
    print(strs)
    return
printFunc("hello")

def printinfo(name,age):
    "named parameter"
    print(name)
    print(age)
    return
printinfo( age=50, name="miki" );

def printinfodefault(name,age=40):
    "default parameter"
    print(name)
    print(age)
    return
printinfodefault(name="tom" );
printinfodefault( age=50, name="miki" );

def printinfovar(name,*ages):
    "variable parameter"
    print(name)
    for age in ages:
        print(age)
    return
printinfovar('tom',20,30);

print("==>reference parameter pass")
def changeList(myList):
    "changeList comment"
    print(myList)
    myList.append([5,6,7])
    return
myList=[1,2,3,4]
changeList(myList)
print(myList)
