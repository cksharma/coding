#include <bits/stdc++.h>
#include <mutex>
#include <thread>
#include <condition_variable>


int g_counter = 0;
std::queue<int> Q;

std::mutex g_q_mutex;
std::condition_variable cv;

bool addNow = false;
bool consumeNow = false;
void consume();

void produce() {
    while(true) {
        std::unique_lock<std::mutex> lock( g_q_mutex );
        cv.wait(lock, [] { return addNow; });
        std::cout << "Produce " << 10 << ", " << 20 << ", "
                  << 30 << ", " << 40 << std::endl;
        Q.push(10); Q.push(20); Q.push(30); Q.push(40);

        consumeNow = true;
        //addNow = false;
        ++g_counter;
        lock.unlock();
        cv.notify_one();
        if(g_counter >= 5 ) break;
    }
}

void consume() {
    while( true ) {
        std::unique_lock<std::mutex> lock( g_q_mutex );
        cv.wait( lock, [] { return consumeNow; });
        while ( Q.empty() == false ) {
            std::cout << "Consume " << Q.front() << std::endl;
            Q.pop();
        }

        addNow = true;
        //consumeNow = false;
        lock.unlock();
        cv.notify_one();
        if(g_counter >= 5 ) break;
    }
}


int main() {
    addNow = true;
    std::thread pThread(produce);
    std::thread cThread(consume);

    pThread.join();
    cThread.join();
    return 0;
}