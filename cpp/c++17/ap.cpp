// Example program
#include <bits/stdc++.h>
using namespace std;

struct AirRoutes {
    std::string source;
    std::unordered_set<std::string> connections;
};

std::unordered_map<std::string, AirRoutes> graph;

void recurse(const std::string& source, const std::string& destination, std::string path, std::unordered_set<std::string>& visited )
{
    if ( source == destination ) {
        std::cout << path << std::endl;
        return;
    }

    auto it = graph.find( source );
    if ( it != graph.end() ) {
        auto connections = it->second.connections;
        for( auto it1 = connections.begin(); it1 != connections.end(); ++it1 ) {
            if( visited.find( *it1 ) != connections.end() ) continue;
            visited.insert( *it1 );
            recurse( *it1, destination, path + "->" + *it1, visited );
            visited.erase( *it1 );
        }
    }
}

int main()
{
    std::unordered_set<std::string> visited;

    graph = { { "A", { "A", std::unordered_set<std::string>{ "B", "C", "D"} } },
              { "B", { "B", std::unordered_set<std::string>{"A", "C"} } },
              { "C", { "C", std::unordered_set<std::string>{"A", "B", "E"} } },
              { "E" ,{ "E", std::unordered_set<std::string>{"C"} } }
    };

    visited.insert( "A" );
    recurse( "A", "E", "A", visited );
}
