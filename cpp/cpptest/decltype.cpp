#include <bits/stdc++.h>
using namespace std;

decltype(auto) get_string() {
	return "Test string";
}

auto get_string_11() -> decltype(auto) {
    return "chandra knat";
}

template <typename T, size_t index>
auto get_array_val(T& arr) -> decltype(arr[index]) {
    return arr[index];
}

template <typename H>
int getValue() {
    return 10;
}

int main()
{
	auto ck = get_string();
	std::cout << ck << std::endl;

	cout << get_string_11() << endl;

	vector<int> v(11, 100);
	cout << get_array_val<vector<int>, 10>(v) << endl;

}