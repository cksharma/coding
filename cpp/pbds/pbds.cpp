#include<bits/stdc++.h>
#include<ext/pb_ds/assoc_container.hpp>
#include<ext/pb_ds/tree_policy.hpp>
#include <functional> // for less 
using namespace __gnu_pbds; 
using namespace std; 

template<class Key,class Value,class Cmp=less<Key> >using ordered_map=tree<Key,Value,Cmp,rb_tree_tag,tree_order_statistics_node_update>;
template<class Key, class Cmp=less<Key>>using ordered_set = ordered_map<Key,null_type,Cmp>;

ostream& operator<<(ostream& os, const vector<int>& v) {
    os << "[";
    for (int item : v) os <<  item << ", ";
    os << "]";
    return os;
}

void ordered_map_test()
{
    ordered_map<int, vector<int>> omp;
    omp.insert({1, {1, 2, 3}});
    
    const auto& p = *omp.find_by_order(0);
    cout << "key=" << p.first << ", value=" << p.second << endl;
    
    const auto& index = omp.order_of_key(1);
    cout << "Order of key " << index << endl;
    
    const auto& non_exist_index = omp.order_of_key(10);
    cout << "Order of non-existant key " << non_exist_index << endl;
}

void ordered_set_test()
{
    ordered_set<int> ost;
    ost.insert(100);
    ost.insert(200);
    ost.insert(300);
    
    cout << "Elem at 1st index ===> " << *ost.find_by_order(1) << endl;
    cout << "Index of elem 200 ===> " << ost.order_of_key(200) << endl;
    cout << "Index of non-exist-elem 600 ===> " << ost.order_of_key(600) << endl;
    
}

int main() 
{
    ordered_map_test();
    ordered_set_test();
}
