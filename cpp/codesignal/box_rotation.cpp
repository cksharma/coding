#include <bits/stdc++.h>
using namespace std;

struct Box {
    int s, m, b;
    Box(int len, int wid, int height) {
        array<int, 3> tmpArr = {len, wid, height};
        sort(tmpArr.begin(), tmpArr.end());
        s = tmpArr[0];
        m = tmpArr[1];
        b = tmpArr[2];
    }

    bool operator<(const Box& box) const {
        if (s != box.s) return s < box.s;
        if (m != box.m) return m < box.m;
        return b < box.b;
    }

    bool operator>(const Box& box) const {
        return s > box.s and m > box.m && b > box.b;
    }
};

bool boxesPacking(std::vector<int> length, std::vector<int> width, std::vector<int> height)
{
    vector<Box> boxes;
    int n = width.size();
    for (int i = 0; i < n; ++i) {
        boxes.emplace_back(length[i], width[i], height[i]);
    }
    sort(boxes.begin(), boxes.end());
    for (int i = 1; i < boxes.size(); ++i) {
        if (not(boxes[i] > boxes[i - 1])) return false;
    }
    return true;
}


int main()
{

}
