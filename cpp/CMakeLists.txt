cmake_minimum_required(VERSION 3.2)
project(cpp)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

#add_executable(cpp ${SOURCE_FILES} main.cpp contest303/SolutionC.cpp)
#add_executable(cpp ${SOURCE_FILES} codeforces/contest341/SolutionD.cpp)
#add_executable(cpp ${SOURCE_FILES} contest304/SolutionD.cpp)
#add_executable(cpp ${SOURCE_FILES} codeforces/contest342/SolutionB.cpp)
#add_executable(cpp ${SOURCE_FILES} codeforces/contest8vc/RobotSequence.cpp)
add_executable(cpp ${SOURCE_FILES} A2Online/C197.cpp)