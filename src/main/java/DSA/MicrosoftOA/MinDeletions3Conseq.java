package DSA.MicrosoftOA;

public class MinDeletions3Conseq {

    public static String filterString(String s) {
        // WRITE YOUR BRILLIANT CODE HERE
        int i = 0;
        int deletionsRequired = 0;

        StringBuilder sb = new StringBuilder();

        for (; i < s.length();) {
            char c = s.charAt(i);

            int j = i + 1;
            int sameCount = 1;
            // runlength
            while (j < s.length() && s.charAt(j) == c){
                sameCount++;
                j++;
            }

            if (sameCount > 2){
                deletionsRequired += (sameCount - 2);
            }

            for (int k = 0; k < Math.min(2, sameCount); k++) {
                sb.append(c);
            }

            i = j;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(filterString("uuuuxaaaaxum"));
    }

}
