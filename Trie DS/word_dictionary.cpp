// Trie Data STructure
// Problem Link: https://leetcode.com/problems/design-add-and-search-words-data-structure/

class WordDictionary {
public:
  
    static const int ALPHABET = 26;
    struct TrieNode {
        TrieNode *children[ALPHABET];
        bool is_word;
        
        TrieNode() {
            for (int i = 0; i < ALPHABET; i++)
                children[i] = NULL;
            is_word = false;
        }
    };

    TrieNode *root;  
    WordDictionary() {
        root = new TrieNode();
    }
    
    void addWord(string word) {
        TrieNode *cur = root;
        for (char ch : word) {
            int index = ch - 'a';
            if (!cur->children[index])
                cur->children[index] = new TrieNode();
            cur = cur->children[index];
        }
        cur->is_word = true;
    }
    
    bool search(string word) {
        return dfs(word, 0, root);
    }
    
    bool dfs(string s, int index, TrieNode *node) {
        TrieNode *cur = node;
        for (int i = index; i < s.size(); i++) {
            int index = s[i] - 'a';
            if (s[i] == '.') {
                for (int j = 0; j < ALPHABET; j++)
                    if (cur->children[j] && dfs(s, i + 1, cur->children[j]))
                        return true;
                return false;
            } else {
                if (!cur->children[index])
                    return false;
                cur = cur->children[index];
            }
        }
        return cur->is_word;
    }
};
