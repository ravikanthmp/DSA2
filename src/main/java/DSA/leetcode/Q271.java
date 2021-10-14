package DSA.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q271 {


    public static class Codec {

        private final char ESCAPE = '/';
        private final char DELIMITER = '#';

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {

            StringBuilder sb = new StringBuilder();
            for (String str : strs) {
                sb.append(encode(str)).append('#');
            }
            return sb.substring(0, sb.length() - 1);
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {

            if (s == null){
                return new ArrayList<>();
            }else if(s.isEmpty()){
                List list = new ArrayList<>();
                list.add("");
                return list;
            }
            else {
                List<String> list = new ArrayList<>();

                StringBuilder sb = new StringBuilder("");
                for (int i = 0; i < s.length(); ) {
                    char ch = s.charAt(i);
                    if (ch == ESCAPE){
                        sb.append(s.charAt(i + 1));
                        i = i + 2;
                    }else if (ch == DELIMITER){
                        list.add(sb.toString());
                        sb = new StringBuilder();
                        i++;
                    }else {
                        sb.append(s.charAt(i));
                        i++;
                    }
                }
                list.add(sb.toString());
                return list;
            }
        }

        private String encode(String s){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == ESCAPE || ch == DELIMITER){
                    sb.append(ESCAPE).append(ch);
                }else {
                    sb.append(ch);
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        List<String> list = List.of("","");
        String encode = codec.encode(list);
        System.out.println(encode);

        List<String> decode = codec.decode(encode);
        System.out.println(decode);
    }

}
