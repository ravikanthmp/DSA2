package DSA.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Q212 {

    private char[][] board;

    class Node{
        Node[] children = new Node[26];
        int val;

        boolean hasValue(){
            return val != 0;
        }
    }

    class Trie {

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
            curr.val++;
        }

        public boolean search(String word) {
            if (root == null){
                return false;
            }
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null){
                    return false;
                }else {
                    curr = curr.children[c - 'a'];
                }
            }
            return curr.hasValue();
        }

        public boolean startsWith(String prefix) {
            if (root == null){
                return false;
            }
            Node curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (curr.children[c - 'a'] == null){
                    return false;
                }else{
                    curr = curr.children[c - 'a'];
                }
            }

            return curr.hasValue() ||
                    Arrays.stream(curr.children).anyMatch(Objects::nonNull);

        }

        public void remove(String word){
            if (search(word)){
                root = remove(root, word, 0);
            }
        }

        private Node remove(Node root, String word, int idx) {
            if (idx < word.length()){
                char ch = word.charAt(idx);
                root.children[ch - 'a'] = remove(root.children[ch - 'a'], word, idx + 1);
                if (root.hasValue() || Arrays.stream(root.children).anyMatch(Objects::nonNull)){
                    return root;
                }else {
                    return null;
                }

            }else {
                root.val--;
                if (root.val == 0 && Arrays.stream(root.children).noneMatch(Objects::nonNull)){
                    return null;
                }else {
                    return root;
                }
            }
        }
    }

    Trie trie;
    List<String> wordsRemaining;
    Set<String> wordsFound;
    boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.visited = new boolean[board.length][board[0].length];
        trie = new Trie();

        // init words in trie
        for (String word : words) {
            trie.insert(word);
        }

        wordsRemaining = new ArrayList<>();
        wordsRemaining.addAll(Arrays.asList(words));

        wordsFound = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                find(i, j, new StringBuilder());
            }
        }

        return new ArrayList<>(wordsFound);
    }

    private void find(int i, int j, StringBuilder wordSoFarBuilder) {
        if (wordsRemaining.isEmpty()){
            return;
        }else {

            visited[i][j] = true;
            wordSoFarBuilder.append(board[i][j]);

            String wordSoFar = wordSoFarBuilder.toString();
            // is the the end of some word ?
            if (trie.search(wordSoFar)){
                wordsFound.add(wordSoFar);
                wordsRemaining.remove(wordSoFar);
                trie.remove(wordSoFar);
            }
            // should we backtrack ?
            if (trie.startsWith(wordSoFar)){
                for (int[] neighbour : neighbours(i, j)) {
                    if (isValid(neighbour[0], neighbour[1]) && !visited[neighbour[0]][neighbour[1]]){
                        find(neighbour[0], neighbour[1], wordSoFarBuilder);
                    }

                }

            }
            wordSoFarBuilder.deleteCharAt(wordSoFarBuilder.length() - 1);
            visited[i][j] = false;

        }
    }

    int[][] neighbours(int i, int j){
        int[][] neighbours = new int[4][];
        int k = 0;
        int[][] dir = {{-1,0}, {1,0}, {0, -1}, {0,1}};
        for (int[] delta : dir) {
            neighbours[k++] = new int[]{i + delta[0], j + delta[1]};
        }
        return neighbours;
    }

    private boolean isValid(int i, int j){
        return (i >= 0 && i < board.length && j >= 0 && j < board[0].length);
    }

    public static void main(String[] args) {
        Q212 test = new Q212();
//        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {{'a'}};
        String[] words = {"a"};
        System.out.println(test.findWords(board, words));
        
    }
}
