//
// Created by cksharma on 5/20/15.
//
#include "header.h"

int RemoveDuplicatesFromSortedArray::removeDuplicates(vector<int> &nums) {
    int index = 0;
    for (int i = 1; i < nums.size(); i++) {
        if (nums[i - 1] != nums[i]) {
            nums[index++] = nums[i - 1];
        }
    }
    if (nums.size() > 1) {
        nums[index++] = nums[nums.size() - 1];
    }
    return index == 0 ? min(1, (int) nums.size()) : index;
}

