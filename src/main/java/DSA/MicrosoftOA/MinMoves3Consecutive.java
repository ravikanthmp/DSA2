package DSA.MicrosoftOA;

public class MinMoves3Consecutive {

    public static int minMoves(String s) {
        // WRITE YOUR BRILLIANT CODE HERE

        int conseq3As = 0;
        int conseq3Bs = 0;
        int aCount = 0;
        int bCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a'){
                aCount++;
            }else {
                bCount++;
            }
            if (last3Same(s, i)){
                if (c == 'a'){
                    conseq3As++;
                }else {
                    conseq3Bs++;
                }
            }
        }

        int ans = 0;

        if (conseq3As > 0 && conseq3Bs > 0){
            int base = Math.min(conseq3As, conseq3Bs);
            ans += base;
            if (conseq3As >= conseq3Bs){
                conseq3As -= base;
                conseq3Bs = 0;
            }else {
                conseq3Bs -= base;
                conseq3As = 0;
            }
        }

        if (conseq3As > 0){

        }else if (conseq3Bs > 0){

        }
        return 0;
    }

    private static boolean last3Same(String s, int idx){
        char c = s.charAt(idx);
        for (int i = idx - 1; i >= Math.max(0, idx - 2) ; i--) {
            if (s.charAt(i) != c){
                return false;
            }
        }
        return true;
    }

}
