#include <bits/stdc++.h>

using namespace std;
using namespace std::string_literals;
using ll = int64_t;
using vecint = vector<int>;
using vecll = vector<ll>;

bool ok(const string& str) {
  char mx = 'a';
  for(char c:str) {
    if (c > mx+1) return false;
    mx = max(mx, c);
  }
  return true;
}

void solve(int n, int i, const string& str) {
  if (n == i) {
    if(ok(str)) cout<<str<<'\n';
    return;
  }
  for(int j = 0; j < i + 1; ++j) {
    string nx = str;
    nx += 'a' + j;
    solve(n,i+1,nx);
  }
}

int main() {
  int n;
  cin>>n;
  solve(n, 0, "");
  return 0;
}
