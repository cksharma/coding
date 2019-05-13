#include <bits/stdc++.h>
using namespace std;

struct Order {
	string ticker;
	int userId;
	string side;
	double price;
	int qty;
};

ostream& operator<<(ostream& os, const Order& order) {
	os << "[" << order.ticker << ", " << order.userId << ", " << order.side 
	   << ", " << order.price << ", " << order.qty << "]";
	return os;
}

struct Key1 {
	string ticker;
	int userId;
};

struct Key2 {
	string ticker;
	double price;
};

struct Key1Hash {
	size_t operator()(const Key1& k1) const {
		return hash<string>()(k1.ticker) + hash<int>()(k1.userId);
	}
};

struct Key1Equals {
	bool operator()(const Key1& lhs, const Key1& rhs) const {
		return lhs.ticker == rhs.ticker && lhs.userId == rhs.userId;
	}
};

struct Key2Comparator{
	bool operator()(const Key2& lhs, const Key2& rhs) const {
		if(lhs.ticker != rhs.ticker) return lhs.ticker < rhs.ticker;
		return lhs.price < rhs.price;
	}
};

unordered_map< Key1, vector<Order>, Key1Hash, Key1Equals > userTickerHashMap;
map< Key2, Order, Key2Comparator > tickerPriceMap;

vector<Order> orders  {  Order{"MSFT", 123, "B", 100.50, 100 },
						 Order{"GOOG", 123, "B", 200.50, 100 },
						 Order{"IBM", 124, "B", 300.50, 100 },
						 Order{"GOOG", 124, "B", 400.50, 100 },
						 Order{"FB", 125, "B", 500.50, 100 },
						 Order{"AAPL", 125, "B", 600.50, 100 },
						 Order{"AAPL", 126, "B", 700.50, 100 },
						 Order{"MSFT", 123, "S", 700.50, 100 }
					  };

vector<Order> getAllOrders(string ticker, int userId) {
	Key1 key1 { ticker, userId };
	auto it = userTickerHashMap.find(key1);
	if( it == userTickerHashMap.end()) {
		return vector<Order>();
	}
	else {
		return it->second;
	}
}

using OrderPtr = shared_ptr<Order>;

OrderPtr getClosestOrder(string ticker, double price) {
	Key2 key2 { ticker, price };
	auto it = tickerPriceMap.lower_bound( key2 );
	if(it == tickerPriceMap.end()) return nullptr;
	if( it->first.ticker == ticker) {
		const Order& ord = it->second;
		return OrderPtr( make_shared<Order>(ord) );
	}
	return nullptr;
}

void preProcess() {
	for( const auto& item : orders ) {
		Key1 k1 { item.ticker, item.userId };
		userTickerHashMap[ k1 ].push_back( item );
		
		Key2 k2 { item.ticker, item.price };
		tickerPriceMap[ k2 ] = item;
	}
}

int main() {
	preProcess();	
	vector<Order> myOrders = getAllOrders( "MSFT", 123 );
	for(auto& item : myOrders) {
		cout << item << endl;
	}

	cout << endl << endl;
	OrderPtr ordPtr = getClosestOrder("MSFT", 130);
	if( ordPtr != nullptr ) {
		cout << "FOUND = ";
		cout << *ordPtr << endl;
	} else {
		cout << "NULL Order" << endl;
	}
}
