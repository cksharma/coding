cmake_minimum_required(VERSION 3.2)
project(codeforces_cpp)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

add_executable(codeforces_cpp ${SOURCE_FILES} main.cpp)
#add_executable(codeforces_cpp ${SOURCE_FILES} contest303/SolutionA.cpp)
#add_executable(codeforces_cpp ${SOURCE_FILES} contest303/SolutionB.cpp)
#add_executable(codeforces_cpp ${SOURCE_FILES} contest303/SolutionD.cpp)