#include <bits/stdc++.h>

using namespace std;

#define all(x) (x).begin(), (x).end()
typedef long double ld;
typedef long long ll;

const int M = 1010;
const int N = M * M;
const int inf = 1e9;

struct Route {
    int u, v, r;

    bool operator <(const Route& to) const {
        return r < to.r;
    }
};

int n, m;
vector<int> g[M];
vector<int> w[M];
vector<int> h[M];
vector<int> p[M];
map<pair<int, int>, int> edge_id;
int cost[N], profit[N];
int s;
bool in[M];
vector<Route> rs;
set<int> ans;

int get_id(int u, int v) {
    return edge_id[make_pair(u, v)];
}

void add_edge(int u, int v, int cost, int profit, int id) {
    g[u].push_back(v);
    g[v].push_back(u);

    w[u].push_back(cost);
    w[v].push_back(cost);

    h[u].push_back(id);
    h[v].push_back(id);

    ::cost[id] = cost;
    ::profit[id] = profit;

    p[u].push_back(profit);
    p[v].push_back(profit);

    edge_id[make_pair(u, v)] = id;
    edge_id[make_pair(v, u)] = id;
}

void shortest(int v, vector<int> &d, vector<int> &from) {
    vector<bool> used(n, false);
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> q;

    d.resize(n);
    fill(all(d), inf);

    from.resize(n);

    d[v] = 0;
    from[v] = v;
    q.emplace(0, v);


    while (!q.empty()) {
        int u = q.top().second;
        q.pop();

        if (used[u])
            continue;
        used[u] = true;

        for (int i = 0; i < (int) g[u].size(); ++i) {
            int to = g[u][i];
            int len = w[u][i];
            if (d[to] > d[u] + len) {
                d[to] = d[u] + len;
                from[to] = u;
                q.emplace(d[to], to);
            }
        }
    }
}

bool add_edge(int u, int v) {
    int id = get_id(u, v);

    if (ans.count(id)) return true;
    if (s < cost[id]) return false;

    s -= cost[id];
    ans.insert(id);

    in[u] = in[v] = true;
    return true;
}

bool connect(int v) {
    vector<int> dist, from;
    shortest(v, dist, from);

    int best = -1;
    for (int u = 0; u < n; ++u)
        if (in[u] && (best == -1 || dist[best] > dist[u])) {
            best = u;
        }

    assert(best != -1);

    if (dist[best] > s) return false;

    while (best != v) {
        assert(add_edge(best, from[best]));
        best = from[best];
    }

    return true;
}



class RoadNetwork {
public:
    vector<int> findSolution(int s_, int n_, int m_, vector<string> edges, int r, vector<string> routes) {
        n = n_, m = m_, s = s_;

        //build connections until we run out of materials
        for (int i = 0; i < m; i++) {
            vector<string> temp = split(edges[i], " ");
            int cost = atoi(temp[2].c_str());
            int profit = atoi(temp[3].c_str());
            int u = atoi(temp[0].c_str());
            int v = atoi(temp[1].c_str());

            add_edge(u, v, cost, profit, i);
        }


        for (int i = 0; i < r; ++i) {
            vector<string> temp = split(routes[i], " ");
            int u = atoi(temp[0].c_str());
            int v = atoi(temp[1].c_str());
            int w = atoi(temp[2].c_str());
            rs.push_back(Route{u, v, w});
        }


        sort(rs.rbegin(), rs.rend());

        cerr << "Sorted.\n";

        in[rs[0].u] = true;

        for (Route r : rs) {
            int u = r.u;
            int v = r.v;
            connect(u);
            connect(v);
        }


        return vector<int>(all(ans));
    }

    vector<string> split(string s, string delimiter) {
        size_t pos_start = 0, pos_end, delim_len = delimiter.length();
        string token;
        vector<string> res;

        while ((pos_end = s.find (delimiter, pos_start)) != string::npos) {
            token = s.substr (pos_start, pos_end - pos_start);
            pos_start = pos_end + delim_len;
            res.push_back (token);
        }

        res.push_back (s.substr (pos_start));
        return res;
    }
};

// -------8<------- end of solution submitted to the website -------8<-------

template<class T> void getVector(vector<T>& v, int num) {
    T a;
    std::getline(std::cin, a);      //skip the first one
    for (int i = 0; i < num; ++i) {
        std::getline(std::cin, a);
        v.push_back(a);
    }
}

int main() {
    RoadNetwork rn;
    int NM;
    int N;
    int E;
    int R;
    cin >> NM;
    cin >> N;
    cin >> E;
    vector<string> edges;
    getVector(edges,E);
    cin >> R;
    vector<string> routes;
    getVector(routes,R);

    vector<int> ret = rn.findSolution(NM,N,E,edges,R,routes);
    cout << ret.size() << endl;
    for (int i = 0; i < (int)ret.size(); i++)
        cout << ret[i] << endl;
    cout.flush();
}