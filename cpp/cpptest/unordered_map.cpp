#include <bits/stdc++.h>
using namespace std;

void init() {
	unordered_map<string, string> umap({{"A", "1"}, {"B", "2"}, {"C", "3"}, {"B", "3"}});
	cout << "Size of umap: " << umap.size() << endl;

	unordered_map<string, string> first(umap);
	cout << "Size of first: " << first.size() << endl;

	unordered_map<string, string> second(umap.begin(), umap.end());
	cout << "Size of second: " << second.size() << endl;

	first.insert(make_pair("D", "4"));
	cout << "Size of first: " << first.size() << endl;
}

void buckets() {
	
	unordered_map<string, string> mymap = {
    	{"us","United States"},
    	{"uk","United Kingdom"},
    	{"fr","France"},
    	{"de","Germany"}
  	};
  	cout << "Bucket count " << mymap.bucket_count() << endl;
  	for (int i = 0; i < mymap.bucket_count(); i++) {
  		cout << "Bucket no. # " << i << " : " << mymap.bucket_size(i) << " ";
  		for (auto it = mymap.begin(i); it != mymap.end(i); it++) 
  			cout << " ( " << it->first << " => " << it->second << "), ";
  		cout << endl;
  	}
}
void test() {
	std::cout << "This is the test function for far manager" << std::endl;
	return;	
}

int main() {
	init();
	buckets();
	test();
}