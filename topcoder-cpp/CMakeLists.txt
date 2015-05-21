cmake_minimum_required(VERSION 3.2)
project(topcoder)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES Jumping.cpp)
add_executable(topcoder ${SOURCE_FILES})