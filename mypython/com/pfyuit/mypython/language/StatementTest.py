'''
Created on Jan 29, 2016
@author: yupengfei
'''

print("==>if statement")
flag = False
name = 'luren'
if name == 'python':
    flag = True
    print('welcome boss')
else:
    print(name)
    
num = 5     
if num == 3:
    print('boss')        
elif num == 2:
    print('user')
elif num == 1:
    print('worker')
elif num < 0:
    print('error')
else:
    print('roadman')
    
print("==>while statement")    
count = 0
while (count < 5):
    print('The count is:', count)
    count = count +1
print("Good bye!")

print("==>for statement")
fruits=['Apple','Orange','Banana']
for fruit in fruits:
    print(fruit)
print("Good bye!")

print("==>pass statement")
if True:
    pass
    print("pass")





    
    