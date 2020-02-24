#include <bits/stdc++.h>
using namespace std;

struct Tree {
    int id;
    int weight;
    int height;
    vector< Tree* > children;
    Tree* parent;

    Tree( int id, int weight, int height,
          const vector<Tree *> &children,
          Tree *parent) : id(id),
                          weight(weight),
                          height(height),
                          children(children),
                          parent(parent) {}

};

map< int, Tree*> tree; // id -> Tree* mappings

bool validateTreeWeight(Tree* root, int cumuSum )
{
    if( root == nullptr ) return true;
    if( cumuSum > root->weight && root->height % 2 == 1 ) return false;

    bool ok = true;
    for(Tree* child : root->children) {
        ok = ok & validateTreeWeight(child, cumuSum + root->weight );
        if( ok == false ) break;
    }
    return ok;
}

int getTreeWeight(Tree* root, int& myVal )
{
    if( root == nullptr ) return 0;

    for(Tree* child : root->children) {

    }
    return myVal;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);

    int n; cin >> n;
    vector<int> parents(n - 1); for(int i = 0; i < n - 1; ++i) cin >> parents[i];
    vector<int> sum( n ); for(int i = 0; i < n; ++i ) cin >> sum[i];

    Tree* root = new Tree(1, sum[0], 1, {}, nullptr );
    tree[1] = root;

    for(int i = 0; i < parents.size(); ++i) {
        int myId = i + 2;
        Tree* parent = tree[ parents[i] ];
        int height = parent->height + 1;
        Tree* me = new Tree(myId, sum[i + 1], height, {}, parent );
        parent->children.push_back(me);
        tree[myId] = me;
    }

    int ans = 0;
    bool ok = validateTreeWeight(root, 0);
    if( ok == false ) cout << -1 << endl;
    else cout << getTreeWeight(root, ans) << endl;
}
