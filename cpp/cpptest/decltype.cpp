#include <bits/stdc++.h>
using namespace std;

decltype(auto) get_string() {
	return "Test string";
}

auto get_string_11() -> decltype(auto) {
    return "chandra knat";
}

int main()
{
	auto ck = get_string();
	std::cout << ck << std::endl;

	cout << get_string_11() << endl;
}