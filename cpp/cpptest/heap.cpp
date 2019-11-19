#include <bits/stdc++.h>
using namespace std;

class Stock {
 public:
    int qty;
    string ticker;

    bool operator<(const Stock& stock) const {
        if (stock.qty != qty) return qty < stock.qty;
        if (stock.ticker != ticker) return ticker < stock.ticker;
        return false;
    }

    //friend ostream& operator<<(ostream& os, const Stock& stock);
    //friend bool operator<(const Stock& stock, const Stock& stock2);

    public:
        Stock(int q, string t) : qty(q), ticker(t) {}
};

ostream& operator<<(ostream& os, const Stock& stock) {
    os << "[" << stock.qty << ", " << stock.ticker << "]";
    return os;
}

struct compare {
    bool operator()(const Stock& s1, const Stock& s2) const {
        if (s1.qty != s2.qty) return s1.qty > s2.qty;
        return s1.ticker > s2.ticker;
    }
};

int main()
{
    priority_queue<Stock, vector<Stock>, compare > stocks;
    vector<Stock> arr = { Stock(1000, "IBM"), Stock(10000, "GOOG"),
                          Stock(100000, "MSFT"), Stock(1000000, "AMZN") };
    for (auto& item : arr) stocks.push(item);
    //for (auto& item : stocks) cout << item << ", ";
    while (stocks.empty() == false) {
        cout << stocks.top() << ", ";
        stocks.pop();
    }
    cout << endl;
}