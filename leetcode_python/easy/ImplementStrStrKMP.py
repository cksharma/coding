'''
Created on Dec 23, 2014

@author: Chandra Kant
'''
class Solution:
    
    def preProcess(self, pattern):
        lps = [0] * len(pattern);
        lps[0] = 0;
        Len = 0;
        i = 1;
        #ans = -1;
        while i < len(pattern):
            if pattern[Len] == pattern[i]:
                Len = Len + 1;
                lps[i] = Len;
                i = i + 1;
            else:
                if Len != 0:
                    Len = lps[Len - 1];
                else:
                    lps[i] = 0;
                    i = i + 1;
        #print (lps);
        return lps;
    
    def kmp(self, text, pattern, lps ):
        ans = -1;
        i = 0;
        j = 0;
        while i < len(text):
            if text[i] == pattern[j]:
                i = i + 1;
                j = j + 1;
            if j == len(pattern):
                ans = i - j;
                j = int(lps[j - 1]);
                return ans;
            elif i < len(text) and pattern[j] != text[i]:
                if j != 0:
                    #try:
                        j = int(lps[j - 1]);
                    #    break;
                    #except:
                    #    print (j, end='');
                else:
                    i = i + 1;  
        return ans;
    
    # @param haystack, a string
    # @param needle, a string
    # @return an integer
    def strStr(self, text, pattern):
        if pattern == None or pattern == "":
            return 0;
        if text == None or text == "":
            return -1;
        lps = self.preProcess(pattern);
        return self.kmp(text, pattern, lps);
        
if __name__ == '__main__':
    sol = Solution();
    text = "There are two needles in this haystack with needles.";
    pattern = "needle";
    #text = "ABABABCABABABCABABABC";
    #pattern = "ABABCABAB";
    text = "";
    pattern = "";
    print (sol.strStr(text, pattern));

