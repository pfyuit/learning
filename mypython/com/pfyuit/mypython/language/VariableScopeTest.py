'''
Created on Jan 29, 2016
@author: yupengfei
'''

total = 0

def sumFunc(a,b):
    total=a+b
    print("local variable:",total)
    return

sumFunc(1,2)
print('global variable:', total)
