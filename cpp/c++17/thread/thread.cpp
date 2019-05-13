#include <bits/stdc++.h>
#include <thread>
#include <mutex>

int counter = 0;
std::mutex g_counter_mutex;

void increaseCounter()
{
    std::lock_guard< std::mutex > lock( g_counter_mutex );
    ++counter;
    std::cout << "Variable increased to " << counter
              << " ThreadID " << std::this_thread::get_id() << std::endl;
}

int main()
{
    std::vector<std::thread> vec;

    for(int i = 0; i < 100; ++i) {
        std::thread t;
        vec.push_back( std::move( t ));
    }

    for(auto& th : vec) {
        th = std::thread( increaseCounter );
    }

    for(auto& th : vec ) {
        th.join();
    }

    std::cout << "Done with counter now " << std::endl;
}
