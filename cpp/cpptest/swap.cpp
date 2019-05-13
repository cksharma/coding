#include <bits/stdc++.h>
using namespace std;

int N;

int arrange( vector<int>& arr )
{
    int cnt = 0;
    set<int> visited;
    for (int i = 1; i <= N; i += 1) {
        int seed = i; int expectedPosition = seed - 1;
        if (visited.find(i) != visited.end()) continue;
        if (arr[expectedPosition] == seed ) { visited.insert(seed); continue; }

        while ( arr[ expectedPosition ] != seed && visited.find(seed) == visited.end() ) {
            visited.insert( seed );
            int seedCopy = seed;
            int temp = arr[expectedPosition];
            arr[expectedPosition] = seed;
            seed = temp;
            expectedPosition = seed - 1;
            ++cnt;
        }
    }
    return cnt;
}

void print(const vector<int>& arr) {
    for (int item : arr) cout << item << ", ";
    cout << endl;
}

int main()
{
    vector<int> arr{1, 2, 4, 3, 5, 6, 7, 8, 9, 10};
    N = arr.size();

    for (int i = 1; i <= 5; ++i) {
        random_shuffle( arr.begin(), arr.end() );
        cout << "BEFORE: ";
        print(arr);
        int minSwaps = arrange( arr );
        cout << "AFTER: ";
        print(arr);
        cout <<"TOTAL = " <<  minSwaps << endl << endl << endl << endl;
    }
}
