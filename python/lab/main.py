'''
Created on Jan 8, 2015

@author: Chandra Kant
'''

import pylab

y1, y2, y3, y4 = [], [], [], []
for i in range(100):
    y1.append((i**2)/50.0)
    y2.append(2*i)
for i in range(99):
    y3.append(y1[i+1] - y1[i])
    y4.append(y2[i+1] - y2[i])
pylab.figure(1)
pylab.plot(y1)
pylab.figure(2)
pylab.plot(y2)
pylab.figure(3)
pylab.plot(y3)
pylab.figure(4)
pylab.plot(y4)
pylab.show()
