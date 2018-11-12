# coding: utf-8
'''
Created on 2018��11��12��

@author: yz-li
'''

import socket
import sys

def main(serverip, serverport):
    
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.connect((serverip, serverport))
    send_data = b"POST /index.html HTTP/1.1\rHost: loci.wisc.edu\r\r"
    sock.send(send_data)
    data = sock.recv(4096)
    print (len(data))
    print (data)
    
if __name__ == '__main__':
    
    serverip = '144.92.48.171'
    serverport = 80
    main(serverip, serverport)