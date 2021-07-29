package DSA.practise;

import DSA.util.URLReader;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Util {
    public static String[] readInputStringArray(String url) throws Exception{

        BufferedReader bufferedReader = URLReader.readURL(url);
        List<String> stringList = new ArrayList<>();
        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null){
            String[] s = inputLine.split(" ");
            stringList.addAll(Arrays.asList(s));
        }

        bufferedReader.close();

        String[] arr = new String[stringList.size()];
        return stringList.toArray(arr);
    }

    public static boolean isSorted(String[] words){
        String prev = null;
        String curr;
        for (int i = 0; i < words.length; i++) {
            curr = words[i];
            if (Objects.nonNull(prev)){
                if (curr.compareTo(prev) < 0){
                    return false;
                }
            }
            prev = curr;
        }
        return true;
    }
}
