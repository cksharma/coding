#include "header.h"

void testBalancedBinaryTree() {
	TreeNode *tree = new TreeNode(1);
	tree->left = new TreeNode(2);
	tree->right = new TreeNode(3);
	tree->left->left = new TreeNode(4);
	tree->left->right = new TreeNode(5);
	BalancedBinaryTree sol;
	cout << sol.isBalanced(tree) << endl;
}

void testExcelSheetColumnTitle() {
	ExcelSheetColumnTitle sol;
	cout << sol.convertToTitle(53) << endl;
}

void testIntersectionOfTwoLinkedLists() {
	IntersectionOfTwoLinkedLists sol;

	ListNode* nodeA = new ListNode(1);
	nodeA->next = new ListNode(2);
	nodeA->next->next = new ListNode(3);

	ListNode* nodeB = new ListNode(4);
	nodeB->next = nodeA;

	ListNode* ans = sol.getIntersectionNode(nodeA, nodeB);
	
	while (ans != NULL) {
		cout << ans->val << " ==> ";
		ans = ans->next;
	}
}

void testMinStack() {
	MinStack minStack;
	minStack.push(5); minStack.push(7); minStack.push(2); minStack.push(6);
	minStack.push(3); minStack.push(1); minStack.push(8); minStack.push(5);

	minStack.pop(); cout << (minStack.getMin()) << endl;
	minStack.pop(); cout << (minStack.getMin()) << endl;
	minStack.pop(); cout << (minStack.getMin()) << endl;
	minStack.pop(); cout << (minStack.getMin()) << endl;
	minStack.pop(); cout << (minStack.getMin()) << endl;
	minStack.pop(); cout << (minStack.getMin()) << endl;
}

void testZigZagConversion() {
	ZigZagConversion sol;
	cout << (sol.convert("PAYPALISHIRING", 3)) << endl;
	cout << (sol.convert("ABC", 2)) << endl;
	cout << (sol.convert("A", 1)) << endl;
	cout << (sol.convert("A", 2)) << endl;
	cout << (sol.convert("", 1)) << endl;
}

void testIntegerReverse() {
	ReverseInteger sol;
	cout << sol.reverse(1234) << endl;
	cout << sol.reverse(INT_MAX) << endl;
	cout << sol.reverse(INT_MIN) << endl;
	cout << sol.reverse(100) << endl;
	cout << sol.reverse(0) << endl;
	cout << sol.reverse(-123) << endl;
}

void testStringToInteger() {
	StringToInteger sol;
	//cout << (sol.atoi("12345677")) <<endl;
	//cout << (sol.atoi("99999345677")) <<endl;
	//cout << (sol.atoi("  -9223372036854775809  ")) <<endl;
	cout << (sol.atoi("  -12345677  787767")) <<endl;
	cout << (sol.atoi("  -98abcd 123455  ")) <<endl;
	cout << (sol.atoi("  -9090909090  787767")) <<endl;
	cout << (sol.atoi("  9090909090  787767")) <<endl;
	cout << (sol.atoi("  +1")) <<endl;
	cout << (sol.atoi("  -0012a42")) <<endl;
}

void testIsPalindrome() {
	PalindromeNumber sol;
	cout << (sol.isPalindrome(1234321)) << endl;
	cout << (sol.isPalindrome(INT_MAX)) << endl;
	cout << (sol.isPalindrome(-1234321)) << endl;
	cout << (sol.isPalindrome(7)) << endl;
	cout << (sol.isPalindrome(0)) << endl;
}

void printLinkedList(ListNode* head) {
	while (head != NULL) {
		cout << head->val << " => ";
		head = head->next;
	}
}

void testRemoveNthFromLast() {
	RemoveNthElementFromLast sol;
	ListNode* head = new ListNode(1);
	head->next = new ListNode(2);
	head->next->next = new ListNode(3);
	head->next->next->next = new ListNode(4);
	
	head = sol.removeNthFromEnd(head, 2);
	printLinkedList(head);
}

void testThreeSum() {
	clock_t start_time = clock();
	ThreeSum sol;
	//vector <int> num = { 7, 5, -8, -6, -13, 7, 10, 1, 1, -4, -14, 0, -1, -10, 1, -13, -4, 6, -11, 8, -6, 0, 0, -5, 0, 11, -9, 8, 2, -6, 4, -14, 6, 4, -5, 0, -12, 12, -13, 5, -6, 10, -10, 0, 7, -2, -5, -12, 12, -9, 12, -9, 6, -11, 1, 14, 8, -1, 7, -13, 8, -11, -11, 0, 0, -1, -15, 3, -11, 9, -7, -10, 4, -2, 5, -4, 12, 7, -8, 9, 14, -11, 7, 5, -15, -15, -4, 0, 0, -11, 3, -15, -15, 7, 0, 0, 13, -7, -12, 9, 9, -3, 14, -1, 2, 5, 2, -9, -3, 1, 7, -12, -3, -1, 1, -2, 0, 12, 5, 7, 8, -7, 7, 8, 7, -15 };
	//vector <int> num = { 7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6, -15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6 };
	vector <int> num = {};
	vector <vector<int>> ans = sol.threeSum(num);
	if (ans.size() == 0) return;
	cout << ans.size() << endl;
	for (int i = 0; i < ans.size(); i++) {
		//cout << ans[i][0] << ", " << ans[i][1] << ", " << ans[i][2] << endl;
	}
	clock_t end_time = clock();
	cout << (end_time - start_time) * 1. / CLOCKS_PER_SEC << endl;
}

void testLongestPalindromicSubstring() {
	LongestPalindromicSubstring *sol = new LongestPalindromicSubstring();
	cout << (sol->longestPalindrome("aaa")) << endl;
	cout << (sol->longestPalindrome("aab")) << endl;
	cout << (sol->longestPalindrome("kjhhhhkkjh")) << endl;
	cout << (sol->longestPalindrome("aajja")) << endl;
	cout << (sol->longestPalindrome("apple")) << endl;
}

void testBestTimeToBuyAndSellStock() {
	BestTimeToBuyAndSellStock sol;
	vector <int> prices = { 6, 7, 5, 7, 7, 10, 4, 8, 9, 14, 11, 2, 13 };
	//prices = { 6, 1, 3, 2, 4, 7 };
	cout << sol.maxProfit(prices) << endl;
}

void testBestTimeToBuyAndSellStockII() {
	BestTimeToBuyAndSellStockII sol;
	vector <int> prices = { 6, 7, 5, 7, 7, 10, 4, 8, 9, 14, 11, 2, 13 };
	//prices = { 6, 1, 3, 2, 4, 7 };
	cout << sol.maxProfit(prices) << endl;
}

void testLetterCombinationsOfAPhoneNumber() {
	LetterCombinationsOfAPhoneNumber sol;
	vector <string> ans = sol.letterCombinations("23");
	for (int i = 0; i < (int)ans.size(); i++) {
		cout << ans[i] << endl;
	}
}

void testLongestSubstringWithoutRepeatingCharacters() {
	LongestSubstringWithoutRepeatingCharacters sol;
	cout << (sol.lengthOfLongestSubstring("abcabcbb")) << endl;
	cout << (sol.lengthOfLongestSubstring("ABDEFGABEF")) << endl;
	cout << (sol.lengthOfLongestSubstring("GEEKSFORGEEKS")) << endl;
	cout << (sol.lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~")) << endl;
}

void printTreeLinkNode(TreeLinkNode* root) {
	if (root == NULL) return;
	if (root->next != NULL)
		cout << (root->val ) << " => " << root->next->val << endl;
	else
		cout << root->val << " NULL " <<  endl;
	printTreeLinkNode(root->left);
	printTreeLinkNode(root->right);
}

void testPopulatingNextRightPointersInEachNode() {
	TreeLinkNode* root = new TreeLinkNode(1);
	root->left = new TreeLinkNode(2);
	root->right = new TreeLinkNode(3);
	root->left->left = new TreeLinkNode(4);
	root->left->right = new TreeLinkNode(5);
	root->right->left = new TreeLinkNode(6);
	root->right->right = new TreeLinkNode(7);

	PopulatingNextRightPointersInEachNode sol;
	sol.connect(root);
	printTreeLinkNode(root);
}

void testPathSumII() {
	PathSumII sol;
	TreeNode* root = new TreeNode(5);
	root->left = new TreeNode(4);
	root->right = new TreeNode(8);
	root->left->left = new TreeNode(11);
	root->right->left = new TreeNode(13);
	root->right->right = new TreeNode(4);
	root->left->left->left = new TreeNode(7);
	root->left->left->right = new TreeNode(2);
	root->right->right->left = new TreeNode(5);
	root->right->right->right = new TreeNode(1);

	vector <vector <int>> ans = sol.pathSum(root, 22);
	for(int i = 0; i < ans.size(); i++) {
		vector <int> r = ans[i];
		for (int k = 0; k < r.size(); k++) {
			cout << r[k] << " , ";
		}
		cout << endl;
	}
}

void testGrayCode() {
	GrayCode sol;
	vector <int> v = sol.grayCode(3);
	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << " " ;
	}
	cout << endl;
}

void testContainerWithMostWater() {
	ContainerWithMostWater sol;
	vector <int> v1 = { 5, 4, 7, 8, 6, 3 };
	cout << sol.maxArea(v1) << endl;
}

void testLargestNumber() {
	LargestNumber sol;
	vector <int> v1 = {3, 30, 34, 5, 9};
	cout << sol.largestNumber(v1) << endl;
	
	vector <int> v2 = {987, 9, 89, 5, 51};
	cout << sol.largestNumber(v2) << endl;

	vector <int> v3 = {824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247};
	cout << sol.largestNumber(v3) << endl;
}

void testGasStation() {
	GasStation sol;
	vector <int> gas = {10, 5, 7, 14, 9};
	vector <int> cost = {8, 5, 14, 3, 1};
	cout << (sol.canCompleteCircuit(gas, cost)) << endl;
	
	gas = {10};
	cost = {8};
	cout << (sol.canCompleteCircuit(gas, cost)) << endl;
}

void testRemoveDuplicates() {
	RemoveDuplicatesFromSortedArray sol;
	int arr[] = {1, 1, 2, 2, 3, 3, 4};
	cout << sol.removeDuplicates(arr, 7) << endl;
}

int main() {
	//testBalancedBinaryTree();
	//testExcelSheetColumnTitle();
	//testIntersectionOfTwoLinkedLists();
	//testMinStack();
	//testZigZagConversion();
	//testIntegerReverse();
	//testStringToInteger();
	//testIsPalindrome();
	//testRemoveNthFromLast();
	//testThreeSum();
	//testLongestPalindromicSubstring();
	//testBestTimeToBuyAndSellStock();
	//testBestTimeToBuyAndSellStockII();
	//testLetterCombinationsOfAPhoneNumber();
	//testLongestSubstringWithoutRepeatingCharacters();
	//testPopulatingNextRightPointersInEachNod	e();
	//testPathSumII();
	//testGrayCode();
	//testContainerWithMostWater();
	//testLargestNumber();
	//testGasStation();
	testRemoveDuplicates();
}
