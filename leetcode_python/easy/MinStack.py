'''
Created on Dec 20, 2014

@author: Chandra Kant
'''

class MinStack:
        
    def __init__(self):
        self.stk = [];
        self.min_stack = [];
    # @param x, an integer
    # @return an integer
    def push(self, x):
        self.stk.append(x);
        if len(self.min_stack) == 0:
            self.min_stack.append(x);
        else :
            top = self.min_stack.pop();
            self.min_stack.append(top);
            if x <= top:
                self.min_stack.append(x);


    # @return nothing
    def pop(self):
        top = self.stk.pop();
        top1 = self.min_stack.pop();
        if top != top1 :
            self.min_stack.append(top1);

    # @return an integer
    def top(self):
        top = self.stk.pop();
        self.stk.append(top);
        return top;

    # @return an integer
    def getMin(self):
        top = self.min_stack.pop();
        self.min_stack.append(top);
        return top;

if __name__ == '__main__':
        
        abc = MinStack();
        abc.push(-3);
        print(abc.top());
        print(abc.getMin());
        
        minStack = MinStack();
        minStack.push(-1);
        print(minStack.top());
        print(minStack.getMin());
        
#         minStack.push(5);
#         minStack.push(7);
#         minStack.push(2);
#         minStack.push(6);
#         minStack.push(3);
#         minStack.push(1);
#         minStack.push(8);
#         minStack.push(5);
#         
#         print (minStack);
#         
#         minStack.pop();
#         print(minStack.getMin());
#         minStack.pop();
#         print(minStack.getMin());
#         minStack.pop();
#         print(minStack.getMin());
#         minStack.pop();
#         print(minStack.getMin());
#         minStack.pop();
#         print(minStack.getMin());
#         minStack.pop();
#         print(minStack.getMin());

