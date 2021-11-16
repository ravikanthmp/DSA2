package DSA.MicrosoftOA;

public class MinStep {

    public static int minStep(String str) {
        // WRITE YOUR BRILLIANT CODE HERE
        boolean seenX = false;
        int outOfPlaceY = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (!seenX){
                if (c == 'X'){
                    seenX = true;
                }

            }
            if (seenX && (c == 'Y')){
                outOfPlaceY++;
            }
        }
        return outOfPlaceY;
    }

    public static void main(String[] args) {
        System.out.println(minStep("YXXXYXY"));
    }
}
