'''
Created on Feb 1, 2016
@author: yupengfei
'''

try:
   fh = open("C:\\abc.txt", "w")
   1/0
   fh.write("This is my test file for exception handling!!")
except IOError:
   print("Error: can\'t find file or read data")
except BaseException:
   print("Error: unexpected exception")
else:
   print("Written content in the file successfully")


try:
   fh = open("C:\\abc.txt", "w")
   fh.write("This is my test file for exception handling!!")
except BaseException:
   print("Error: unexpected exception")
finally:
   print("Finally end")