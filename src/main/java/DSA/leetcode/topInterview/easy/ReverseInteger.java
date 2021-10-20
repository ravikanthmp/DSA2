package DSA.leetcode.topInterview.easy;

public class ReverseInteger {

    public int reverse(int x)  {
        boolean isNegative = (x < 0);
        if (x == Integer.MIN_VALUE){
            return 0;
        }
        System.out.println(Integer.MAX_VALUE);
        x = Math.abs(x);
       int currTotal = 0;
       int limit = Integer.MAX_VALUE / 10;
       while (x != 0){
           int curr = Math.abs(x% 10);

           if (currTotal == limit){
               if (curr > Integer.MAX_VALUE % 10){
                   return 0;
               }else {
                   currTotal = (currTotal * 10) + curr;
               }
           }else if (currTotal > limit){
               return 0;
           }else {
               currTotal = (currTotal * 10) + curr;
           }

           x = x/10;
       }

       return isNegative ? -1 * currTotal : currTotal;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(-2147483648));
    }
}
