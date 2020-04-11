cmake_minimum_required(VERSION 3.2)
project(cpp)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++17")

#add_executable(cpp ${SOURCE_FILES} codeforces/edu53/D.cpp)
#add_executable(cpp ${SOURCE_FILES} topcoder/RainForecast.cpp)
#add_executable(cpp ${SOURCE_FILES} codeforces/contest519/G.cpp)
#add_executable(cpp ${SOURCE_FILES} codeforces/mail.ru/vector.cpp)


add_executable(a atcoder/live_contest/D.cpp)
set_target_properties(a PROPERTIES RUNTIME_OUTPUT_DIRECTORY "${CMAKE_CURRENT_SOURCE_DIR}/atcoder/live_contest/")
