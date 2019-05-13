#include <bits/stdc++.h>

class Order
{
  public:
   std::string ticker_;  // name of the company, e.g., MSFT, IBM, GOOG
   int userId_;          // id of the user working on the order
   std::string side_;    // "BUY" - order to buy, "SELL" - order to sell
   int qty_;             // number of shares to buy/sell
   double price_;

   Order( std::string ticker,
          int userId,
          std::string side,
          int qty, double price ) :
   ticker_(ticker), userId_(userId), side_(side), qty_(qty), price_(price) {}

    bool operator==(const Order& o1) const {
        return ticker_ == o1.ticker_ && userId_ == o1.userId_;
    }
};

std::ostream& operator<<(std::ostream& os, const Order& o1) {
    os << o1.ticker_ << ", " << o1.price_ << "\n" ;
    return os;
}


class Tuple {
  public:
    std::string ticker_;
    int userId_;
    Tuple(std::string ticker, int userId)
        : ticker_(ticker), userId_(userId) {}
};

namespace std {
    template<>
    struct hash<Order> {
        size_t operator()(const Order& order) const {
            return hash<string>()(order.ticker_) + order.userId_;
        }
    };
}

struct OrderHasher
{
    std::size_t operator()( const Order& order ) const {
        return std::hash<std::string>()( order.ticker_)
               + std::hash<int>()(order.userId_);
    }
};

struct OrderComparator
{
    bool operator()( const Order& order1, const Order& order2 ) {
        if( order1.ticker_ != order2.ticker_ ) return order1.ticker_ < order2.ticker_;
        return order1.price_ < order2.price_;
    }
};


//Q1) (Ticker, UserID) -> the list of orders with Order::ticker_ = Ticker that are worked by the user UserID (Order::userId_ == UserID)
void testInsertAndFetchO1()
{
    Order order1( "MSFT", 1234, "B", 100, 100);
    Order order2( "MSFT", 1234, "B", 100, 200);
    Order order3( "APPL", 1234, "B", 100, 300);
    Order order4( "MSFT", 1234, "B", 100, 400);
    Order order5( "GOOG", 1234, "B", 100, 500);

    Order order6( "GOOG", 1234, "B", 100, 600);
    Order order7( "XYZZ", 1234, "B", 100, 600);

    //std::set<Order, OrderComparator> uSet = {order1, order2, order3, order4, order5, order6 };
    std::set<Order, OrderComparator> uSet = {order1, order4, order6, order7 };

    std::cout << "USET size" << uSet.size() << std::endl;

    std::unordered_set<Order, OrderHasher> hSet;
    hSet.insert( order1 );
    hSet.insert( order1 );
    std::cout << "HASH" << std::endl;
    auto it = hSet.find(order1);
    if ( it != hSet.end() )
    {
        std::cout << *it << std::endl;
    }
    std::cout << "END" << std::endl;


    Order orderLimit( "MSFT", 1234, "B", 100, 400);

    for( auto k = uSet.begin(); k != uSet.end(); ++k) {
        std::cout << *k << std::endl;
    }


    auto it1 = uSet.upper_bound( orderLimit );
    if ( it1 != uSet.end() ) {
        std::cout << "SET" << std::endl;
        std::cout << *it1 << std::endl;
    } else {
        std::cout << "IMPOSSIBLE" << std::endl;
    }
}

//Q2) (Ticker, Price) -> the order with the given Ticker having the lowest Order::price_ >= Price



int main()
{
    testInsertAndFetchO1();
}