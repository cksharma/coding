#include <iostream>
#include <algorithm>
#include <string.h>
#include <stack>
#include <sstream>
#include <vector>
#include <time.h>
#include <unordered_map>
#include <array>
#include <limits.h>
using namespace std;

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

class BalancedBinaryTree {
	public:
		bool isBalanced(TreeNode * root);
};

class ExcelSheetColumnTitle {
	public:
		string convertToTitle(int n);
};

class IntersectionOfTwoLinkedLists {
	public:
		ListNode *getIntersectionNode(ListNode *headA, ListNode *headB);	
};

class MinStack {
	public:
		void push(int x);
		void pop();
		int top();
		int getMin();
};

class ZigZagConversion {
	public:
		string convert(string s, int nRows);
};

class ReverseInteger {
	public:
		int reverse(int x);
};

class StringToInteger {
	public:
		int atoi(const char *str);
};

class PalindromeNumber {
	public:
	bool isPalindrome(int x);
};

class RemoveNthElementFromLast {
	public:
		ListNode *removeNthFromEnd(ListNode *head, int n);		
};

class ThreeSum {
	public:
		vector<vector<int> > threeSum(vector<int> num);	
};

class LongestPalindromicSubstring {
	public:
		string longestPalindrome(string s);	
};

class BestTimeToBuyAndSellStock {
	public:
		int maxProfit(vector<int> &prices);	
};

class BestTimeToBuyAndSellStockII {
	public:
		int maxProfit(vector<int> &prices);
};

class LetterCombinationsOfAPhoneNumber {
	public:
		unordered_map<char, string> mp;
	
		vector <string> ans;
		string digits;

		vector<string> letterCombinations(string digits);
	
		void recurse(string ch, int steps);	
	
};

class LongestSubstringWithoutRepeatingCharacters {
	public:
		int lengthOfLongestSubstring(string s);	
};

struct TreeLinkNode {
	int val;
	TreeLinkNode *left, *right, *next;
	TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
};


class PopulatingNextRightPointersInEachNode {
	public:
	void connect(TreeLinkNode *root);
};

class PathSumII {
	public:
	vector <vector<int>> ans;
	int sum;
	void recurse(TreeNode* root, int running_sum, int height, vector <int> v);
	vector<vector<int> > pathSum(TreeNode *root, int sum);
	
};

class GrayCode {
	public:
		vector<int> grayCode(int n);
};

class ContainerWithMostWater {
	public:
		int maxArea(vector<int> &height);
};
