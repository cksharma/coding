#include <bits/stdc++.h>
using namespace std;

struct Graph {
    int from;
    int to;
    double cost;
    
    Graph( int f, int t, int c) : from(f), to(t), cost(c) {}
    
    bool operator<(const Graph& graph) const {
        if( from < graph.from ) return true;
        if( from == graph.from && to < graph.to ) return true;
        return false;
    }
};

ostream& operator<<(ostream& os, const Graph& g) {
    os << "[from=" << g.from << ", to=" << g.to << ", cost=" << g.cost << "]";
    return os;
}

void recurse(const map<int, set<Graph>>& mp, int& ans, int runningCost, int source, int dest, int stops, set<Graph>& visited) {
    if( source == dest && stops <= -1) {
        ans = min(ans, runningCost );
        cout << "Setting min to " << ans << " source=" << source << ", dest=" << dest << ", stops=" << stops << endl; 
        return;
    }
    
    if(mp.find(source) == mp.end() || stops <= -1) return;
    
    Graph ck( source, dest,0 );
    if( visited.find(ck ) != visited.end()) return;
    
    auto it = mp.find( source );
    if( it == mp.end() ) return;

    const pair<int, set<Graph>>& pa = *it;
        for(const Graph& g : pa.second ) {
            cout << "CKS " << g << endl;
            Graph forward( pa.first, g.to, 0 );// backward( g.to, pa.first, 0 );
            //if( visited.find( forward ) == visited.end() && visited.find(backward) == visited.end() ) {
                cout << "Insert " << forward << endl;
                cout << "Ans=" << ans << ", runningCost=" << runningCost + g.cost << ", source=" << pa.first << ", dest=" << g.to << ", stops=" << stops << endl;
                //cout << endl;
                visited.insert( forward ); //visited.insert( backward );
                recurse( mp, ans, runningCost + g.cost, g.to, dest, stops - 1, visited );
                visited.erase( forward ); //visited.erase( backward );
                cout << "Delete " << forward << endl << endl;
            //}
        }
    
}

int minCost(const vector<Graph>& graphs, int source, int dest, int stops) {
    map<int, set<Graph> > mp;
    for( const Graph& g : graphs ) {
        mp[g.from].insert( g );
    }
    int ans = INT_MAX;
    set< Graph > visited;
    recurse( mp, ans, 0, source, dest, stops, visited );
    return ans;
}

int main()
{
    vector< Graph > graphs;
    graphs.emplace_back( 0, 1, 300 );
    graphs.emplace_back( 1, 0, 50 );
    graphs.emplace_back( 1, 2, 100 );
    graphs.emplace_back( 2, 1, 50 );
    graphs.emplace_back( 0, 2, 500 );
    
    int source = 0, dest = 1, stops = 1;
    int cost = minCost( graphs, source, dest, stops );
    cout << cost << endl;
    return 0;
}
