#include "header.h"

stack <int> stk;
stack <int> minStk;

void MinStack::push(int x) {
	stk.push(x);
	if (minStk.empty() || x <= minStk.top())
		minStk.push(x);
}
void MinStack::pop() {
	int r = stk.top();
	stk.pop();
	if (r == minStk.top())
		minStk.pop();
}
int MinStack::top() {
	return stk.top();
}
int MinStack::getMin() {
	return minStk.top();
}
