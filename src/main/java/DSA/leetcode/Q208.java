package DSA.leetcode;


import java.util.Arrays;
import java.util.Objects;

public class Q208 {

    static class Node{
        Node[] children = new Node[26];
        boolean val;
    }

    static class Trie {

        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {

            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null){
                    curr.children[c - 'a'] = new Node();
                }
                curr = curr.children[c - 'a'];
            }
            curr.val = true;
        }

        public boolean search(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null){
                    return false;
                }else {
                    curr = curr.children[c - 'a'];
                }
            }
            return curr.val;
        }

        public boolean startsWith(String prefix) {
            Node curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (curr.children[c - 'a'] == null){
                    return false;
                }else{
                    curr = curr.children[c - 'a'];
                }
            }

            return curr.val ||
                    Arrays.stream(curr.children).anyMatch(Objects::nonNull);

        }
    }


    public static void main(String[] args) {
        Q208 test = new Q208();
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        trie.startsWith("app"); // return True
        trie.insert("app");
        trie.search("app");
    }
}
