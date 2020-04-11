#include <bits/stdc++.h>
using namespace std;

class Solution {
public:

    struct Word {
        int cnt;
        string word;
        
        Word(int cnt, const string& word) : cnt(cnt), word(word) {} 
        
        bool operator<(const Word& w) const {
            if (cnt != w.cnt) return cnt > w.cnt;
            return word < w.word;
        } 
    };

    vector<string> topKFrequent(vector<string>& words, int k) {
        priority_queue<Word> PQ;
        unordered_map<string, int> MP;
        
        for (const auto& word : words) {
            MP[word]++;
        }
        
        for (const auto& [word, cnt] : MP) {
            if (PQ.size() == k) {
                auto& top = PQ.top();
                if (top.cnt < cnt || (top.cnt == cnt && top.word > word)) {
                    PQ.pop();
                }
            }
            
            if (PQ.size() < k) {
                PQ.emplace(cnt, word);
            }
        }
        vector<string> ans;
        while (not PQ.empty()) {
            ans.push_back(PQ.top().word);
            PQ.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};
int main()
{
    vector<string> v = {"i", "love", "leetcode", "i", "love", "coding"}; 
    int k = 2;
    vector<string> ans = Solution().topKFrequent(v, k);
    for (const auto& item : ans) cout << item << ", ";
    cout << endl;
}