package DSA.leetcode;

public class Q211 {

    static class Node{
        Node[] children = new Node[26];
        boolean hasValue;
    }

    static class WordDictionary {

        Node root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null){
                    curr.children[c - 'a'] = new Node();
                }
                curr = curr.children[c - 'a'];
            }
            curr.hasValue = true;
        }

        public boolean search(String word) {
            return search(root, word, 0);
        }

        private boolean search(Node root, String word, int idx) {
            if (root == null){
                return false;
            }else {
                if (idx == word.length()){
                    return root.hasValue;
                }else {
                    char ch = word.charAt(idx);
                    boolean ans = false;
                    if (ch == '.'){
                        for (int i = 0; i < root.children.length; i++) {
                            if (root.children[i] != null){
                                ans = search(root.children[i], word, idx + 1);
                                if (ans){
                                    return true;
                                }
                            }

                        }
                        return false;
                    }else {
                        return search(root.children[ch - 'a'], word, idx + 1);
                    }
                }


            }
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary= new WordDictionary();
        wordDictionary.addWord("bad");
    }
}
