package DSA.leetcode.topInterview.easy;

import java.util.Arrays;
import java.util.Objects;

/**
 * T(N) = O(m*n) + O(prefix)
 * S(N) = O(m*n)
 */
public class LongestCommonPrefix {

    static class Node<V>{
        Node[] children ;
        V val;

        public Node() {
            this.children = new Node[26];
        }

        public Node(V val) {
            this();
            this.val = val;
        }

    }

    static class Trie{

        Node<Integer> root;

        public void insert(String key, Integer val){
            root = insert(root, key, val ,0);
        }

        private Node insert(Node root, String key, Integer val, int idx){
            if (root == null){
                root = new Node();
            }
            if (idx == key.length()){
                root.val = val;
            }else {
                char ch = key.charAt(idx);
                root.children[ch - 'a'] = insert(root.children[ch - 'a'], key, val, idx + 1);
            }
            return root;

        }

        public Integer search(String s){
            Node<Integer> curr = root;
            if (curr == null){
                return null;
            }else {

                for (int i = 0; i < s.length(); i++) {
                    if (curr == null){
                        return null;
                    }else {
                        curr = curr.children[s.charAt(i) - 'a'];
                    }
                }

                return curr == null ? null : curr.val;
            }
        }

        public boolean contains(String s){
            return search(s) != null;
        }

        public boolean startsWith(String s){
            if (root == null){
                return false;
            }else {

                int idx = 0;
                Node curr = root;

                while (curr != null){
                    if (idx == s.length()){
                        return curr.val != null;
                    }else {
                        char c = s.charAt(idx);
                        if (curr.children[c - 'a'] == null){
                            return false;
                        }else {
                            curr = curr.children[c - 'a'];
                            idx++;
                        }
                    }
                }

                return false;
            }
        }

    }

    static class LCP{
        Trie trie;

        public LCP(Trie trie) {
            this.trie = trie;
        }

        public int lcp(){
            Node curr = trie.root;
            StringBuilder sb = new StringBuilder();
            while (hasOneChild(curr) && (curr.val == null)){
                for (int i = 0; i < curr.children.length; i++) {
                    if (curr.children[i] != null){
                        sb.append((char) ('a' + i) );
                        curr = curr.children[i];
                        break;
                    }
                }
            }
            return sb.toString().length();
        }

        private boolean hasOneChild(Node curr){
            if (curr == null){
                return false;
            }

            return Arrays.stream(curr.children)
                    .filter(Objects::nonNull)
                    .count() == 1;

        }

    }
    
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String str : strs) {
            if (str.isEmpty()){
                return "";
            }
            trie.insert(str, 0);
        }

        LCP lcp = new LCP(trie);
        int length = lcp.lcp();
        if (length == 0){
            return "";
        }else {
            return strs[0].substring(0, length);
        }
    }


    public static void main(String[] args) {

        String[] s = {"flower","flow","flight"};
        LongestCommonPrefix test = new LongestCommonPrefix();
        System.out.println(test.longestCommonPrefix(s));
    }
}
