cmake_minimum_required(VERSION 3.3)
project(Topcoder)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES
    src/pastchallenges/FilipTheFrog.cpp
    )

add_executable(Topcoder ${SOURCE_FILES})