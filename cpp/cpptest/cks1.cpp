#include <bits/stdc++.h>

using namespace std;

struct Trade {
    int qty;
    double price;
    int id;
    string side;

    Trade(int q, double p, int i, const string& s) : qty(q), price(p), id(i), side(s) {}

    bool operator<(const Trade& rhs) const {
        if (rhs.qty != qty) return qty < rhs.qty;
        if (rhs.price != price) return price < rhs.price;
        if (rhs.side != side) return side < rhs.side;
        return id < rhs.id;
    }
};


struct TradeHash {
    size_t operator()(const Trade& t) const {
        return hash<int>()(t.qty) + hash<int>()(t.id) + hash<double>()(t.price) + hash<string>()(t.side);
    }
};

struct TradeEquality {
    bool operator()(const Trade& lhs, const Trade& rhs) const {
        return lhs.qty == rhs.qty and lhs.price == rhs.price and lhs.id == rhs.id and lhs.side == rhs.side;
    }
};

struct TradeComparator {
    bool operator()(const Trade& lhs, const Trade& rhs) const {
        if (lhs.qty != rhs.qty) return lhs.qty < rhs.qty;
        if (lhs.price != rhs.price) return lhs.price < rhs.price;
        if (lhs.id != rhs.id) return lhs.id < rhs.id;
        if (lhs.side != rhs.side) return lhs.side < rhs.side;
    }
};

using TradePtr = shared_ptr<Trade>;

template <typename K, typename V, typename H, typename E>
using HashMap = unordered_map<K, V, H, E>;

template<typename K, typename V, typename C=less<Trade> >
using TreeMap = map<K, V, C>;

struct TransactionInfo {
    TradePtr street;
    TradePtr mmT2T;
    TradePtr hybT2T;
};

int main()
{
    HashMap<Trade, bool, TradeHash, TradeEquality> hmap;
    TreeMap<Trade, bool, TradeComparator> tmap;

    Trade t1(100, 100, 1, "B");
    Trade t3(100, 100, 1, "S");
    Trade t2(100, 100, 1, "B");

    hmap[t1] = true; cout << "Hmap <" << hmap.size() << ">" << endl;
    hmap[t2] = true; cout << "Hmap <" << hmap.size() << ">" << endl;
    hmap[t3] = true; cout << "Hmap <" << hmap.size() << ">" << endl;
    cout << endl << endl;

    tmap[t1] = true; cout << "Tmap <" << tmap.size() << ">" << endl;
    tmap[t2] = true; cout << "Tmap <" << tmap.size() << ">" << endl;
    tmap[t3] = true; cout << "Tmap <" << tmap.size() << ">" << endl;

    TreeMap<Trade, bool> cksmap;
    cksmap[t1] = true; cksmap[t2] = true; cksmap[t3] = true;
    cout << endl << "CKS MAP <" << cksmap.size() << ">" << endl;
}
