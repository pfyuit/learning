'''
Created on Apr 30, 2016
@author: yupengfei
'''

import json

class Boy:
    def __init__(self, name, age):
        self.age = age
        self.name = name
    

obj = [1, 2, 3, {"a":1, "b":2, "c":3}]
str = json.dumps(obj)
print(str)

desobj = json.loads(str)
print(desobj)

def boydefault(obj):
    if isinstance(obj, Boy):
        return {'name': obj.name, 'age': obj.age}
    return obj;

def boyhook(dic):
    print('test')
    if dic['name']:
        return Boy(dic['name'], dic['age'])
    return dic

boy = Boy("Tom", 21)
str = json.dumps(boy, default=boydefault)
print(str)

desobj = json.loads(str,object_hook=boyhook)
print(desobj)







    
