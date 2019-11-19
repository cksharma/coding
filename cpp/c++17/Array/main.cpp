#include <bits/stdc++.h>
using namespace std;

/*struct Person {
    std::string name;
    int age;
    double salary;

    friend ostream& operator<<(ostream& os, const Person& p) {
        os << "[" << p.name << ", " << p.age << ", " << p.salary << "]";
        return os;
    }

    bool operator==(const Person rhs) {
        const Person& lhs = *this;
        return lhs.name == rhs.name && lhs.age == rhs.age && lhs.salary == rhs.salary;
    }
};*/

struct Person {
    string name;
    int age;
    double salary;

public:
    Person(string name, int age, double salary) : name(name), age(age), salary(salary) {}

    bool operator==(const Person& p) const {
        return this->name == p.name and this->age == p.age and this->salary == p.salary;
    }
    friend ostream& operator<<(ostream& os, const Person& p);
};

inline ostream& operator<<(ostream& os, const Person& p) {
    os << "[" << p.name << ", " << p.age << ", " << p.salary << "]";
    return os;
}

void array_test() {
    array<int, 4> myarray;

    //Pushing some stuffs in array
    myarray.fill(10);

    // Assigning some values to myarray;
    for (int i = 0; i < myarray.size(); i++) {
        myarray[i] = i + 2;
    }

    for (auto it = myarray.begin(); it < myarray.end(); it++) {
        cout << *it << endl;
    }

    for (auto rit = myarray.rbegin(); rit < myarray.rend(); rit++) {
        cout << *rit << endl;
    }

    //array::data
    cout << "=============================" << endl;
    array<char, 10> char_array;
    for (int i = 0; i < char_array.size(); i++) {
        char_array[i] = (char)('a' + i);
    }

    cout << char_array.data() << endl;

    std::vector<Person> v = { { "Chandra", 15, 20},
                              { "Shyam", 25, 30},
                              { "Ram", 35, 40}
    };

    std::sort(v.begin(), v.end(), []( const Person& p1, const Person& p2 ) {
        if( p1.name != p2.name ) return p1.name < p2.name;
        if(p1.age != p2.age) return p1.age < p2.age;
        return p1.salary < p2.salary;
    } );

    std::for_each( v.begin(), v.end(), [](const Person& p ) {
        std::cout << p << std::endl;
    } );

    auto itv = find( v.begin(), v.end(), Person{"Chandra", 15, 20});
    if( itv != v.end() ) {
        std::cout << "Found " << *itv << std::endl;
    }

    int index = 0;
    std::for_each(v.begin(), v.end(), [&index](const Person& p ) {
        std::cout << p << " Seq no=" << index++ << std::endl;
    });
}

struct Order {
    std::string ticker_;
    int userId_;
    std::string side;
    int qty;
    double price_;
};

inline
bool operator==(const Order& lhs, const Order& rhs) {
    return lhs.ticker_ == rhs.ticker_ && lhs.userId_ == rhs.userId_;
}

inline
std::ostream& operator<<(std::ostream& os, const Order& o) {
    os << "[" << o.ticker_ << ", " << o.userId_
       << o.price_ << "]";
    return os;
}

struct OrderHasher {
    std::size_t operator()(const Order& ord) const {
        return std::hash<std::string>()(ord.ticker_) << 1 +
               std::hash<int>()(ord.userId_) << 2;
    }
};

vector<Order> get_orders_list()
{
    Order order1{"APPL", 1, "B", 100, 1000 };
    Order order2{"APPL", 1, "B", 100, 2000 };
    Order order3{"GOOG", 1, "B", 100, 3000 };
    Order order4{"GOOG", 1, "B", 100, 7000 };
    Order order5{"MSFT", 1, "B", 100, 4000 };
    Order order6{"VOD",  1, "B", 100, 5000 };
    return std::vector<Order>{order1, order2, order3, order4, order5, order6};
}

void unordered_map_test()
{
    std:vector<Order> v = get_orders_list();


    std::unordered_map<Order, std::vector<Order>, OrderHasher> uMap;

    std::for_each( v.begin(), v.end(), [&uMap](const Order& o) {
        auto it = uMap.find( o );
        if ( it == uMap.end() ) {
            uMap.insert( std::make_pair(o, std::vector<Order>{o} ) );
        } else {
            it->second.push_back(o);
        }
    });

    std::cout << uMap.size() << std::endl;
    std::for_each(uMap.begin(), uMap.end(), [](auto& p) {
        std::cout << p.first << "\n";
        int cnt = 0;
        std::for_each( p.second.begin(), p.second.end(), [&cnt](auto& ord) {
            std::cout << "Cnt = " << ++cnt << ": " << ord << std::endl;
        });
        std::cout << "\n\n";
    });
}

struct OrderComparator {
    bool operator()(const Order& lhs, const Order& rhs)  {
        if( lhs.ticker_ != rhs.ticker_ )
            return lhs.ticker_ < rhs.ticker_;
        return lhs.price_ < rhs.price_;
    }
};

void ordered_map_test()
{
    std:vector<Order> v_temp = get_orders_list();
    std::vector<Order> v = v_temp;
    for(auto& ord : v_temp) v.push_back( ord );

    std::map<Order, bool, OrderComparator> oMap;
    std::for_each( v.begin(), v.end(), [&oMap](const Order& ord) {
        oMap.insert( std::make_pair(ord, true) );
    });
    std::for_each(oMap.begin(), oMap.end(), [](auto& p) {
        std::cout << p.first << ", " << p.second << std::endl;
    });
}

template <typename T, size_t N>
constexpr size_t arraySize(T (&)[N]) {
    return N;
}

void array_pass_param( int arr[] ) {
    cout << "First element " << arr[0] << endl;
}

void kk() {
    auto x1 = {1};
    auto x2 {1};
    auto x3 = {1, 2, 3, 4, 5};
    cout << typeid(x1).name() << endl;
    cout << typeid(x2).name() << endl;
    cout << typeid(x3).name() << endl;
}

void array_template() {
    cout << endl << " Array Template" << endl;
    int arr[] = {1, 2, 3, 4, 5, 6};
    array<int, arraySize( arr ) > myArr;
    cout << myArr.size() << endl;
    array_pass_param( arr );
    kk();
}

int main() {
    array_test();
    unordered_map_test();
    ordered_map_test();
    array_template();
    return 0;
}
