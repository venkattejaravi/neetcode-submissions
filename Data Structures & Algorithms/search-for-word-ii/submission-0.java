class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfTheNode;

    TrieNode() {
        children = new HashMap<>();
        endOfTheNode = false;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void dfsInsert(int i, TrieNode node, String word) {
        if(i == word.length()) {
            node.endOfTheNode = true;
            return;
        }
        char c = word.charAt(i);
        if(! node.children.containsKey(c)) {
            node.children.put(c, new TrieNode());
        }
        dfsInsert(i+1, node.children.get(c), word);
    }

    public void insert(String word) {
        dfsInsert(0, root, word);
    }
}

class Solution {
    Set<String> result = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word: words) {
            trie.insert(word);
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                backTrack(i, j, trie.root, board, new StringBuilder());
            }
        }

        return new ArrayList<String>(result);
    }

    public void backTrack(int row, int col, TrieNode node, char[][] board, StringBuilder path) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '#') return;

        char c = board[row][col];

        if(! node.children.containsKey(c)) return;

        node = node.children.get(c);
        path.append(c);

        if(node.endOfTheNode){
            result.add(path.toString());
            node.endOfTheNode = false;
        }

        // Mark the visit
        board[row][col] = '#';
        backTrack(row, col + 1, node, board, path);
        backTrack(row, col - 1, node, board, path);
        backTrack(row + 1, col, node, board, path);
        backTrack(row - 1, col, node, board, path);

        // Restore the state
        board[row][col] = c;
        path.deleteCharAt(path.length() - 1);

    }


}
