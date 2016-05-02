'''
Created on Apr 30, 2016
@author: yupengfei
'''

import socket

ss = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
host = socket.gethostname()
port = 12345
ss.bind(('localhost',8009))
ss.listen(5)

while True:
        print('listren for client...')
        conn,addr = ss.accept()
        print('get client')
        print(addr)
        
        conn.settimeout(5)
        szBuf = conn.recv(1024)
        byt = 'recv:' + szBuf.decode('gbk')
        print(byt)
        
        if '0' == szBuf:
            conn.send('exit')
        else:
            conn.send('welcome client!')
        
        conn.close()
        print('end of the service')
