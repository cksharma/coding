#include <bits/stdc++.h>
struct Node {
    std::string tag;
    std::map< std::string, std::string> mm;
    std::vector<Node*> children;
    Node* parent;
    
    Node( const std::string& tag, 
          const std::string& vn, 
          const std::string& ct, 
          Node* parent) {
        this->tag = tag;
        this->mm[vn] = ct;
        this->parent = parent;
    }
};

void print(Node* head) {
    if(head == nullptr) return;
    std::cout << head->tag << "," ;
    for(auto& [key, val] : head->mm ) {
        std::cout << "[" << key << "," << val << "], " << std::endl;
    }
    for(Node* np : head->children) {
        //print(np);
    }
}

void solve( std::string& result, 
            const std::vector<std::string>& tokens, 
            Node* head, int index = 0 ) {
    if(head == nullptr || index + 1 >= tokens.size()) return;
    //print(head); std::cout << "index=" << index << std::endl;
    auto it = head->mm.find(tokens[index + 1]);
    if( it != head->mm.end()) {
        result = it->second;
        return;
    }
    if(head->tag == tokens[index]) {
        for(Node* node : head->children) {
            solve(result, tokens, node, index + 1);
        }
    }
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */ 
    int N, Q;
    std::cin >> N >> Q;
    auto NodeHash = [](const Node* node) {
        return std::hash<std::string>()(node->tag);  
    };
    auto NodeEqual = [](const Node* lhs, const Node* rhs) {
        return lhs->tag == rhs->tag && lhs->mm.size() == rhs->mm.size();  
    };
    
    std::unordered_set< Node*, decltype(NodeHash), decltype(NodeEqual) > st(5,
                                                                            NodeHash, 
                                                                           NodeEqual);
    std::unordered_map<std::string, Node*> cks;
    Node* head = nullptr; std::string ck; std::getline(std::cin, ck);
    for(int i = 0; i < N; ++i) {
        std::string str;
        getline(std::cin, str);
        
        if(str.at(1) == '/') {
            if( head->parent != nullptr )
                head = head->parent;
        } else {
            str = str.substr(1, str.length() - 1);
            std::stringstream tok(str);
            std::string tag, vn, eq, ct;
            tok >> tag >> vn >> eq >> ct;
            //std::cout << "CKS " << ct << std::endl;
            ct = ct.substr(1, ct.length() - 3 );

            Node* node = new Node( tag, vn, ct, head);
            if(head == nullptr) {
                head = node;
            } else {
                head->children.push_back(node);
            }
            st.insert(node);
            cks[tag] = node;
            head = node;
        }
    }
    std::stringstream ans;
    for(int i = 0; i < Q; ++i) {
        std::string str;
        std::cin >> str;
        //print(head);
        for(int j = 0; j < str.length(); ++j) {
            if(str[j] == '.') str[j] = ' ';
            else if (str[j] == '~') str[j] = ' ';
        }
        std::vector<std::string> tokens;
        std::string tok;
        std::stringstream ss(str);
        //std::cout << "\nTokens" << ss.str() << std::endl;
        while(ss>>tok) {
            tokens.push_back(tok);
            tok = "";
        }
        std::string result;
        solve( result, tokens, head );
        ans << ( ( result.empty()) ? "Not Found!" : result ) << "\n";
    }
    std::cout << ans.str() << std::endl;
    return 0;
}

