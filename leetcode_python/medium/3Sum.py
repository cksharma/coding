'''
Created on Dec 26, 2014

@author: Chandra Kant
'''
import time


class Solution:
    # @return a list of lists of length 3, [[val1,val2,val3]]
    def threeSum(self, num):
        #startTime = time.clock();
        num = sorted(num);
        #print(num);
        st = [[]];

        for f in range(0, len(num) - 2):        
            temp1 = f + 1;
            temp2 = len(num) - 1;
            while temp2 - 1 > temp1 and temp1 > f and num[temp1] + num[temp2] + num[f] > 0:
                temp2 = temp2 - 1;
            while temp2 - 1 > temp1 and temp1 > f and num[temp1] + num[temp2] + num[f] < 0:
                temp1 = temp1 + 1; 
            #print(f, temp1, temp2, end=", ")
            self.getTriplets(num, f, temp1, temp2, st);
        st = st[1:];
        if len(st) == 0:
            return st;
        ans = [[]];
        ans = ans[1:];
        #ans.append(st[0]);
        #prev = st[0];
        #sorted(st[0]);
        
        for i in range(0, len(st)):
            found = False;
            for j in range(i + 1, len(st)):
                prev = st[j];
                if st[i][0] == prev[0] and st[i][1] == prev[1] and st[i][2] == prev[2]:
                    found = True;                 
            if not found:
                ans.append(st[i]);

        return ans;
    def getTriplets(self, num, f, m, l, st):
        
        while m < l:
            if num[f] + num[m] + num[l] == 0:
                arr = [num[f], num[m], num[l]];
                #arr.append(num[f]);arr.append(num[m]);arr.append(num[l]);
                st.append(arr);
                l = l - 1;
                m = m + 1;
            elif num[f] + num[m] + num[l] > 0:
                l = l - 1;
            else:
                m = m + 1;
if __name__ == '__main__':
    sol = Solution();
    #a = [-1, 0, 1, 2, -1, -4];
    a = [7,5,-8,-6,-13,7,10,1,1,-4,-14,0,-1,-10,1,-13,-4,6,-11,8,-6,0,0,-5,0,11,-9,8,2,-6,4,-14,6,4,-5,0,-12,12,-13,5,-6,10,-10,0,7,-2,-5,-12,12,-9,12,-9,6,-11,1,14,8,-1,7,-13,8,-11,-11,0,0,-1,-15,3,-11,9,-7,-10,4,-2,5,-4,12,7,-8,9,14,-11,7,5,-15,-15,-4,0,0,-11,3,-15,-15,7,0,0,13,-7,-12,9,9,-3,14,-1,2,5,2,-9,-3,1,7,-12,-3,-1,1,-2,0,12,5,7,8,-7,7,8,7,-15];
    #print (len(a));
    a = [-11,-3,-6,12,-15,-13,-7,-3,13,-2,-10,3,12,-12,6,-6,12,9,-2,-12,14,11,-4,11,-8,8,0,-12,4,-5,10,8,7,11,-3,7,5,-3,-11,3,11,-13,14,8,12,5,-12,10,-8,-7,5,-9,-11,-14,9,-12,1,-6,-8,-10,4,9,6,-3,-3,-12,11,9,1,8,-10,-3,2,-11,-10,-1,1,-15,-6,8,-7,6,6,-10,7,0,-7,-7,9,-8,-9,-9,-14,12,-5,-10,-15,-9,-15,-7,6,-10,5,-7,-14,3,8,2,3,9,-12,4,1,9,1,-15,-13,9,-14,11,9];
    k = sol.threeSum(a);
    print (k);
    print (len(k));