public class TrieNode{
    TrieNode[] children;
    boolean isLeaf;

    public TrieNode(){
        children=new TrieNode[26];
        isLeaf=false;
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (current.children[i] == null) {
                current.children[i] = new TrieNode();
            }
            current = current.children[i];
        }
        current.isLeaf = true;
    }
    
    public boolean search(String word) {
        return dfs(word,0,root);
    }

    public boolean dfs(String word, int index, TrieNode node){
        if(node==null) return false;
        if(index==word.length()) return node.isLeaf;

        if(word.charAt(index)=='.'){
            for(TrieNode child : node.children){
                if(child!=null && dfs(word, index+1, child)){
                    return true;
                }
            }
            return false;

        }else{
            int i=word.charAt(index)-'a';
            return dfs(word,index+1, node.children[i]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */