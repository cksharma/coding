#include <bits/stdc++.h>
#include <thread>
#include <mutex>
#include <condition_variable>

using namespace std;

mutex g_mutex;
condition_variable cv;
int i = 0;
queue<int> g_Q;
int g_cnt = 0;

void produce()
{
    while(true) {
        cout << "CKS cnt = " << g_cnt << endl;
        unique_lock<mutex> lock(g_mutex);
        cv.wait(lock, [] { return i == 1; });
        g_Q.push(10);
        g_Q.push(20);
        g_Q.push(30);
        g_Q.push(40);
        cout << "Produce 10 20 30 40" << endl;
        i = 0;
        lock.unlock();
        cv.notify_one();
        if(++g_cnt > 5) break;
    }
}

void consume()
{
    while(g_cnt <= 5) {
        unique_lock<mutex> lock(g_mutex);
        cv.wait(lock, [] { return i == 0; });
        while (not g_Q.empty()) {
            cout << "Consume" << g_Q.front() << " ";
            g_Q.pop();
        }
        i = 1;
        lock.unlock();
        cv.notify_one();
    }
}

int main()
{
    thread pThread( produce );
    thread cThread( consume );

    pThread.join();
    cThread.join();
    return 0;
}