'''
Created on Apr 30, 2016
@author: yupengfei
'''

# -*- coding: UTF-8 -*-

'''
MySQLdb no longer support Python 3 and above, so use PyMySQL
'''
import pymysql

host = '192.168.66.66'
port = 3306
user = 'db_admin'
password = 'light2902'
dbname = 'products_center_v1'

try:
    '''
    Connect to MySQL server
    '''
    conn = pymysql.connect(host, user, password, dbname, port, charset='utf8')
    cur = conn.cursor()
    
    sql = '''SELECT COUNT(pol.procurement_order_line_id) AS executingNum, SUM(pol.amount/c.value) AS executingAmount
            FROM v3_procurement_order_line pol
            INNER JOIN v3_procurement_order po ON po.procurement_order_id=pol.procurement_order_id
            INNER JOIN currencies c ON c.currencies_id=pol.currencies_id
            WHERE po.supplier_id=3265 AND pol.fsm_state=4'''
    cur.execute(sql)
    rows = cur.fetchall()
    result = []
    for row in rows:
        result.append(row[0])
        result.append(row[1])
    print(result)        
except Exception:
    print("Read database error")
finally:
    cur.close()
    conn.close()
