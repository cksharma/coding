'''
Created on Jan 8, 2015

@author: Chandra Kant
'''

class Shape(object):
    def __eq__(self, s1):
        return self.area() == s1.area();
    def __lt__(self, s1):
        return self.circum() < s1.circum();
    
class Rectangle(Shape):
    def __init__(self, h, w):
        self.height = float(h);
        self.width = float(w);
    def circum(self):
        return 2*(self.height + self.width)
    def __str__(self):
        return 'Rectangle with area ' + str(self.height*self.width)
class Square(Rectangle):
    def __init__(self, s):
        Rectangle.__init__(self, s, s)
    def __str__(self):
        return 'Square with side ' + str(self.height)
class Circle(Shape):
    def __init__(self, radius):
        self.radius = float(radius)
    def circum(self):
        return 3.14159*(2*self.radius)
    def __lt__(self, other):
        return self.radius < other.radius
    def __str__(self):
        return 'Circle with diameter ' + str(2.0*self.radius)

def reorder(L):
    for e in L:
        if e < L[0]:
            L[0] = e;
            
L = [Square(6), Rectangle(2, 3), Circle(1)];
try:
    reorder(L);
    for e in L:
        print (e);
except:
    print ('Got an exception');
    for e in L:
        print (e);
