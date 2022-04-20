// THE SOLUTION IS A DISAASTER
// DON'T EVEN WASTE YOUR TIME READING IT :)
// + IT TOOK ABOUT SEVEN HOURS, THAT'S EXPLAIN WHY I FEEL ENVY

import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isWord = false;
    }

    public void insert(String word) {
        // To insert into Trie DS
        TrieNode cur = this;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            if (!cur.children.containsKey(ch))
                cur.children.put(ch, new TrieNode());
            cur = cur.children.get(ch);
        }
        cur.isWord = true;
    }
}

public class WordSearchII {

    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private boolean[][] visited;
    int rows, columns;

    private boolean valid(int i, int j) {
        //
        return (i >= 0 && i < rows && j >= 0 && j < columns);
    }

    private void dfs(char[][] board, int i, int j, String temp, Set<String> res, TrieNode node) {

        if (!valid(i, j) || visited[i][j] || !node.children.containsKey(board[i][j])) return;
        visited[i][j] = true;

        node = node.children.get(board[i][j]);
        temp += board[i][j];
        if (node.isWord) res.add(temp);

        for (int w = 0; w < 4; w++) {
            int new_x = i + dy[w], new_y = j + dx[w];
            dfs(board, new_x, new_y, temp, res, node);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        // Constructing Trie
        TrieNode trie = new TrieNode();
        for (String word : words) {
            trie.insert(word);
        }

        this.rows = board.length;
        this.columns = board[0].length;

        Set<String> res = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                visited = new boolean[rows][columns];
                dfs(board, i, j, "", res, trie);
            }
        }
        return new LinkedList<>(res);
    }
}

// Problem Link: https://leetcode.com/problems/word-search-ii/
