'''
Created on Jan 29, 2016
@author: yupengfei
'''

import time

ticks = time.time()
print("Number of ticks since epoch:", ticks)

localtime=time.localtime(time.time())
print("Local current time :", localtime)

localtime = time.asctime( time.localtime(time.time()) )
print("Local current time :", localtime)