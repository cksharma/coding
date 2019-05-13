#include <bits/stdc++.h>
#include <cstring>
using namespace std;

struct Node {
	string tag;
	map<string, string> attributes;
	map<string, Node*> children;
	Node* parent;
};

unordered_map<string, Node*> tree; // tag <-> Node mapping

void printNode(Node* node);

Node* root = new Node{ "MAHA_PARENT", {}, {}, nullptr };
Node* parentRoot = root;

void parseTag(string& line) {
	string tag;
	map<string, string> attr;
	//cout << "LINE" << line << endl;
		bool isEnd = false;
		for_each(line.begin(), line.end(), [&isEnd](char& ch) {
			if( ch == '/' ) isEnd = true;
			if(ch == '<' || ch == '>' || ch == '=' || ch == '/' || ch == '"') ch = ' ';			
		});
		stringstream ss(line);
		ss >> tag; string key, value;
		while(ss >> key >> value) {
			attr[key] = value;
		}
	
	if( attr.size() == 0 && isEnd ) {
		auto it = tree.find( tag );
		if( it == tree.end() ) {
			throw runtime_error("Unexpected : This cannot happen");
		}
		root = it->second->parent;
		return;
	}
	Node* node = new Node{tag, attr, {}, nullptr};
	tree[tag] = node;
	root->children.insert( make_pair(tag, node ) );
	node->parent = root;
	root = node;
	//cout << "CKS Open tag" << tag << endl;
	/*cout << "Tag=[" << tag << "]";
	for(auto& p : attr) {
		cout << "(" << p.first << ", " << p.second << "), "; 
	}
	cout << endl;*/
}

void printNode(Node* node) {
	cout << "Tag=[" << node->tag << "]";
	for(auto& p : node->attributes) {
		cout << "(" << p.first << ", " << p.second << "), "; 
	}
	for(auto& child : node->children) {
		printNode( child.second );
	}
}

void printResult(string& query) {
//	printNode( root ); cout << endl;
	auto LambdaCondition = [](char c) { return c == '.' || c == '~' || c == ' '; };
	/*for_each( query.begin(), query.end(), [](char& c) {
		if(c == '.' || c == '~') c = ' ';
	});*/
	replace_if( query.begin(), query.end(), LambdaCondition, ' ');
	vector<string> tokens;
	stringstream ss(query);
	string tk;
	//cout << "Tokens=";
	while( ss >> tk) {
		tokens.push_back( tk );
		//cout << tk << ", ";
	}
	//cout << endl;
	
	int index = 0;
	string ans;
	while( index < tokens.size() -1 ) {
		auto treeChildren = root->children;
		auto it = treeChildren.find(tokens[index]);
		if(it == treeChildren.end()) {
			cout << "Not Found!" << endl;
			root = parentRoot; // RESET the root
			return;
		} else {
			root = it->second;
		}
		index++;
	}
	
	auto it = root->attributes.find( tokens[tokens.size() - 1] );
	if( it == root->attributes.end()) {
		ans = "Not Found!";
	} else {
		ans = it->second;
	}
	cout << ans << endl;
	root = parentRoot; // RESET the root
}

int main() {
	int N, Q;
	cin >> N >> Q;
	for(int i = 0; i < N ; ++i) {
		string line;
		cin.ignore();
		getline(cin, line);
		parseTag(line);
	}
	//printNode(root);
	for(int i = 0; i < Q; ++i) {
		string query;
		cin >> query;
		printResult(query);
	}
	return 0;
}