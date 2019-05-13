#include <bits/stdc++.h>
using namespace std;

string trim(string& str) {
    int left = 0, right = str.size() - 1;
    while (left < str.size() && str[left] == ' ') { ++left; }
    while (right >=0 && str[right] == ' ') { --right; }
    return str.substr(left, right + 1);
}

list<string> tokenize(string cmd, char delim) {
    istringstream iss(cmd);
    string token;
    list<string> tokens;
    while (getline(iss, token, delim)) {
        token = trim(token);
        if(not token.empty()) tokens.push_back(token);
    }
    return tokens;
}

ostream& operator<<(ostream& os, const list<string>& v) {
    os << "[";
    for (auto vi : v) os << vi << ",";
    os << "]";
    return os;
}

string printPath(const string& curDir, const string& cmd) {
    list<string> dir_tokens = tokenize(curDir, '/');
    list<string> cmd_tokens = tokenize(cmd, '/');

    if (cmd[0] == '/') { dir_tokens.clear(); }

    for (string command : cmd_tokens) {
        if (command == ".") continue;
        else if (command == "..") {
            if (dir_tokens.size() > 0)
                dir_tokens.pop_back();
        }

        else {
            dir_tokens.push_back(command);
        }
    }

    string path = "/";
    for (auto& p : dir_tokens) path += p + "/";
    return path;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);

    string curDir = "/root/a/b";
    string cmd = "../../";
    string cmd1 = "/root/g/n";
    string cmd2 = "a/g";
    string cmd3 = "/root/a/../b/./c";

    /*cout << "<" << curDir << ">, " << "<" << cmd << ">, "
        << "result=<" << printPath(curDir, cmd) << ">\n";
    cout << "<" << curDir << ">, " << "<" << cmd1 << ">, "
         << "result=<" << printPath(curDir, cmd1) << ">\n";
    cout << "<" << curDir << ">, " << "<" << cmd2 << ">, "
         << "result=<" << printPath(curDir, cmd2) << ">\n";*/
    cout << "<" << curDir << ">, " << "<" << cmd3 << ">, "
         << "result=<" << printPath(curDir, cmd3) << ">\n";
}
