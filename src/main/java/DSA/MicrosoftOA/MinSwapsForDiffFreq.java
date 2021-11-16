package DSA.MicrosoftOA;

import java.util.Arrays;
import java.util.Comparator;

public class MinSwapsForDiffFreq {

    public int minDeletions(String s) {
        int[] freq = new int[26];
        s.chars().forEach(c -> freq[c - 'a']++);

        Arrays.sort(freq);

        // process from most freq
        int deletions = 0;

        if (freq[freq.length - 1] <= 0){
            return 0;
        }

        int expected = freq[freq.length - 1] - 1;
        for (int i = freq.length - 2; i >= 0 && freq[i] > 0; i--) {

            int actual = freq[i];
            if (actual == expected){
                expected--;
            }else if (actual > expected){
                deletions = deletions + (actual - expected);
                expected--;
            }else {
                expected = actual - 1;
            }
            expected = Math.max(0, expected);
        }


        return deletions;
    }

    public static void main(String[] args) {
        MinSwapsForDiffFreq test = new MinSwapsForDiffFreq();
        System.out.println(test.minDeletions("bbcebab"));;
    }
}
