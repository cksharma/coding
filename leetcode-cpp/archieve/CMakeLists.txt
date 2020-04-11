cmake_minimum_required(VERSION 3.2)
project(leetcode_cpp)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES
    3Sum.cpp
    BalancedBinaryTree.cpp
    BestTimeToBuyAndSellStock.cpp
    BestTimeToBuyAndSellStockII.cpp
    bigint.cpp
    ContainerWithMostWater.cpp
    ExcelSheetColumnTitle.cpp
    GasStation.cpp
    GrayCode.cpp
    header.h
    IntersectionOfTwoLinkedLists.cpp
    LargestNumber.cpp
    LetterCombinationsOfAPhoneNumber.cpp
    LongestPalindromicSubstring.cpp
    LongestSubstringWithoutRepeatingCharacters.cpp
    main.cpp
    MinStack.cpp
    PalindromeNumber.cpp
    PathSumII.cpp
    PopulatingNextRightPointersInEachNode.cpp
    RemoveNthElementFromLast.cpp
    ReverseInteger.cpp
    StringToInteger.cpp
    ZigZagConversion.cpp
    RemoveDuplicatesFromSortedArray.cpp)

add_executable(leetcode_cpp ${SOURCE_FILES})