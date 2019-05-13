#include <iostream>
using namespace std;

// Regex would have * which could mean zero or more occurrences of the characters
bool regexMatch(const string& regex, const string& pattern, int regexS, int patternIdx)
{
    if (regexS == regex.size() && patternIdx == pattern.size()) return true;
    if (regexS == regex.size() || patternIdx == pattern.size()) return false;

    for (int r = regexS; r < regex.size() && patternIdx < pattern.size(); ++r) {
        if (regex[r] == pattern[patternIdx]) {
            if (r == regex.size() - 1 && patternIdx == pattern.size() - 1)
                return true;
            patternIdx++;
            continue;
        }

        if (regex[r] != '*' && regex[r] != pattern[patternIdx]) { return false; }

        for (int p = patternIdx; p < pattern.size(); ++p) {
            if (regexMatch(regex, pattern, r, p + 1)) return true;
            else if (regexMatch(regex, pattern, r + 1, p)) return true;
        }
    }
    return false;
}

int main()
{
    string regex = "A*CDE*F";
    string pattern = "ABBBBBBBBBCGGGCDEF";
    cout << regexMatch(regex, pattern, 0, 0) << endl;
}