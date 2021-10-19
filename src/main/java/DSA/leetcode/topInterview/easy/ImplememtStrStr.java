package DSA.leetcode.topInterview.easy;

public class ImplememtStrStr {

    class Node<V>{
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

    class Trie{

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


    public int strStr(String haystack, String needle) {
        Trie trie = new Trie();

        for (int idx = haystack.length() - 1; idx >= 0; idx--) {
            String subStr = haystack.substring(idx);
            trie.insert(subStr, idx);
        }

        return haystack.indexOf(needle);

//        return trie.startsWith(needle) ? ;
    }

}
