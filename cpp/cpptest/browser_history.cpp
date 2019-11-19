#include <bits/stdc++.h>
using namespace std;

const int RCODE_OK = 0;

class HistoryManager {
public:
    map<string, list<string>::iterator> url_map;
    list<string> urls;
    int maxNumOfURLs;

    //////////////
    //Constructor
    //////////////
    HistoryManager(std::size_t maxNumOfURLs);
    // Creates an instance of the HistoryManager class that holds upto
    // a maximum of maxNumOfURLs URLs

    ////////////////////////////////////
    //Public interface using int rcodes
    ////////////////////////////////////
    int recordVisit(const std::string& url);
    // Records a visit to url in the history manager

    std::vector<std::string> getAll() const;
    // Retrieves all the urls visited in chronological order (most
    // recently visited first)

    int clear();
    // Deletes all history
};

HistoryManager::HistoryManager(std::size_t maxNumOfURLs) {
    this->maxNumOfURLs = maxNumOfURLs;
}

int HistoryManager::recordVisit(const std::string& url)
{
    auto it = url_map.find(url);
    if (it != url_map.end()) {
        // delete the record
        urls.erase(it->second);
        url_map.erase(url);
    }
    //insert the record at the front of list
    urls.push_front(url);
    url_map[url] = urls.begin();

    if (urls.size() > maxNumOfURLs) {
        const string& last_url = urls.back();
        urls.pop_back();
        url_map.erase(last_url);
    }
    return 0;
}

std::vector<std::string> HistoryManager::getAll() const {
    vector<string> v;
    for (auto& item : urls) {
        v.push_back(item);
    }
    return v;
}

int HistoryManager::clear()
{
    urls.clear();
    url_map.clear();
    return RCODE_OK;
}

int main() {

    //Populate history
    HistoryManager mgr(100);
    mgr.recordVisit("http://www.bloomberg.com/articles/123");
    mgr.recordVisit("http://www.bbc.com");
    mgr.recordVisit("http://www.cnn.com");
    mgr.recordVisit("http://www.google.com?search=hello");
    mgr.recordVisit("http://www.bloomberg.com/articles/123");
    mgr.recordVisit("http://www.cnn.com");
    mgr.recordVisit("http://www.bloomberg.com/articles/123");
    mgr.recordVisit("http://www.bloomberg.com/articles/123");

    //Print it
    std::vector<std::string> visitedUrls = mgr.getAll();
    if (4 == visitedUrls.size()) cout << "PASSED" << endl;

    if ("http://www.bloomberg.com/articles/123" == visitedUrls[0]) cout << "GOOD" << endl; else cout << "FAILED";
    if ("http://www.cnn.com" == visitedUrls[1]) cout << "GOOD" << endl; else cout << "FAILED";
    if ("http://www.bbc.com" == visitedUrls[3]) cout << "GOOD" << endl; else cout << "FAILED";

    //Clean up
    mgr.clear();
    assert(mgr.getAll().empty());

    return 0;
}