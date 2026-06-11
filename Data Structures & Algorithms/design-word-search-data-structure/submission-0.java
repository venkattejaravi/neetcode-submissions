class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfTheNode;

    public TrieNode() {
        children = new HashMap<>();
        endOfTheNode = false;
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        dfsAddWord(0, root, word);
    }

    public void dfsAddWord(int index, TrieNode node, String word) {
        if(index == word.length()) {
            node.endOfTheNode = true;
            return;
        }
        char c = word.charAt(index);
        if(! node.children.containsKey(c)) {
            node.children.put(c, new TrieNode());
        }
        dfsAddWord(index + 1, node.children.get(c), word);
    }

    public boolean search(String word) {
        return dfsSearch(0, root, word);
    }

    public boolean dfsSearch(int index, TrieNode node, String word) {
        if(index == word.length()) return node.endOfTheNode;

        char c = word.charAt(index);
        if(c == '.') {
            for(TrieNode child : node.children.values()) {
                if(dfsSearch(index + 1, child, word)) {
                    return true;
                }
            }
            return false;
        } else {
            if(! node.children.containsKey(c)) {
                return false;
            }
            return dfsSearch(index + 1, node.children.get(c), word);
        }
    }
}
