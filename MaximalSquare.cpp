#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if (matrix.size() == 0) return 0;
        int n = matrix.size();
        int m = matrix[0].size();
        int ans = 0;
        
        int cumuRow[n][m];
        int cumuCol[n][m];
        int aggMatr[n][m];
        
        //row cumu

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) cumuRow[i][j] = (int)(matrix[i][j] - '0');
                else cumuRow[i][j] = cumuRow[i][j - 1]  + (int)(matrix[i][j] - '0');                
            }
        }
        
        
        //col cumu
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) cumuCol[i][j] = matrix[i][j] - '0';
                else cumuCol[i][j] = cumuCol[i - 1][j] + matrix[i][j] - '0';
            }
        }
        

        //for agg matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    aggMatr[i][j] = cumuRow[i][j];
                } else if (j == 0) {
                    aggMatr[i][j] = cumuCol[i][j];
                } else {
                    aggMatr[i][j] = aggMatr[i][j - 1] + cumuCol[i][j];
                }
            }
        }
        
        cout << endl;
        for (int i = 0; i < n; i++) { for (int j = 0; j < m; j++) cout << cumuRow[i][j] << " "; cout << endl; }
        cout << endl;
        for (int i = 0; i < n; i++) { for (int j = 0; j < m; j++) cout << cumuCol[i][j] << " "; cout << endl; }    
        cout << endl;
        for (int i = 0; i < n; i++) { for (int j = 0; j < m; j++) cout << aggMatr[i][j] << " "; cout << endl; }
        cout << endl;
        

        //now compute the ans
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sz = min(n - i, m - j) - 1;
                ans = max(ans, matrix[i][j] - '0');
                
                for (int k = sz; k >= 1; k--) {
                    
                    
                    if (cumuCol[i + k][j] - cumuCol[i][j] != k) continue;
                    if (cumuCol[i + k][j + k] - cumuCol[i][j + k] != k) continue;
                    if (cumuRow[i][j + k] - cumuRow[i][j] != k) continue;
                    if (cumuRow[i + k][j + k] - cumuRow[i + k][j] != k) continue;



                  
                    if (matrix[i][j] == '1' && matrix[i + k][j + k] == '1' && matrix[i + k][j] == '1' && matrix[i][j + k] == '1') {
                        
                        //This part contains the bug. I figured out it jut need to think a bit..
                        int me = aggMatr[i][j];
                        int he = aggMatr[i + k][j + k] - cumuRow[i + k][j] - cumuCol[i][j + k] + 2;
                        //Buggy part ends

                        if (he - me + 1 == (k + 1) * (k + 1)) {
                            ans = max(ans, he - me + 1);
                            break;
                        }
                    }    
                }
            }
        }
        return ans;
        
    }
};

int main() {
    int n, m; cin >> n >> m;
    vector<vector<char>> vect;

    for (int i = 0; i < n; i++) {
        vector<char> v;
        for (int j = 0; j < m; j++) {
            char ch;
            cin >> ch;
            v.push_back(ch);
        }
        vect.push_back(v);
    }
    Solution sol;
    cout << "Ans = ";
    cout << sol.maximalSquare(vect) << endl;
}