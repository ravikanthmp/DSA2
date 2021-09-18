package DSA.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q208 {

    class Node{
        Map<Character, Node> children = new HashMap<>();
        boolean hasWord;

        public void setHasWord(boolean val){
            this.hasWord = val;
        }

        public boolean hasChild(char c){
            return children.containsKey(c);
        }

        public Node getChild(char c){
            return children.get(c);
        }
    }

    class Trie {

        Node root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node curr =  root;
            for (int i = 0; i < word.length(); i++) {
                char currChar = word.charAt(i);
                if (!curr.hasChild(currChar)){
                    curr.children.put(currChar, new Node());
                }
                curr = curr.getChild(currChar);
            }
            curr.hasWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char currChar = word.charAt(i);
                if (!curr.hasChild(currChar)){
                    return false;
                }else {
                    curr = curr.getChild(currChar);
                }
            }
           return curr.hasWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                char currChar = prefix.charAt(i);
                if (!curr.hasChild(currChar)){
                    return false;
                }else {
                    curr = curr.getChild(currChar);
                }
            }
            if (curr.hasWord){
                return true;
            }else {
                return curr.children.keySet().size() != 0;
            }
        }
    }

}
