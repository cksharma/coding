#include <iostream>
#include <cstdio>
#include <map>
using namespace std;

int main() {
	int N, M;
	cin >> N >> M;
	map <string, string> nameCountryMap;
	map <string, int> nameCount;
	map <string, int> countryCount;
	
	string name, country;
	
	for (int i = 0; i < N; i++) {
		cin >> name >> country;
		nameCountryMap[name] = country;		
	}
	
	for (int i = 0; i < M; i++) {
		cin >> name;
		nameCount[name]++;
		countryCount[nameCountryMap[name]]++;
	}
	
	int min = 0;
	
	for (map <string, int> :: iterator it = nameCount.begin(); it != nameCount.end(); it++) {
		if (it->second > min) {
			min = it -> second;
			name = it -> first;
		}
	}
	min = 0;
	for (map <string, int> :: iterator it = countryCount.begin(); it != countryCount.end(); it++) {
		if (it -> second > min) {
			min = it -> second;
			country = it -> first;
		}
	}
	cout << country << endl << name << endl;
}
