'''
Created on Dec 21, 2014

@author: Chandra Kant
'''
class Solution:
    # @return a string
    def longestCommonPrefix(self, strs):
        arr = [];
        for ss in strs:
            arr.append(len(ss));
        arr = sorted(arr);
        ans = "";
        for ss in strs:
            if len(ss) == arr[0]:
                sf = ss;
                break;
        if len(arr) == 0:
            return "";
        for i in reversed(range(arr[0])):
            done = True;
            sk = sf[0:i+1];
            for ss in strs:
                ss = ss[0:i+1];
                if ss != sk:
                    done = False;
                    break;
            if done is True:
                ans = sk;
                break;
        return ans;        
if __name__ == '__main__':
    sol = Solution();
    print (sol.longestCommonPrefix(["asd", "cks"]));
    print (sol.longestCommonPrefix(["cks123", "cks"]));