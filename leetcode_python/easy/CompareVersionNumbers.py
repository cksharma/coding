'''
Created on Dec 22, 2014

@author: Chandra Kant
'''
class Solution:
    # @param version1, a string
    # @param version2, a string
    # @return an integer
    def compareVersion(self, version1, version2):
        v1 = version1.split('.');
        v2 = version2.split('.');
        #print (v1);
        #print (v2);
        while len(v1) < len(v2):
            v1.append('0');
        while len(v1) > len(v2):
            v2.append('0');
        
        for i in range(len(v1)) :
            v_one = int(v1[i]);
            v_two = int(v2[i]);
            if v_one < v_two:
                return -1;
            if v_one > v_two:
                return 1;        
        return 0;
if __name__ == '__main__':
    sol = Solution();
    print (sol.compareVersion('0.1', '0.0.1'));
    