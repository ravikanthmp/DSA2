package DSA.leetcode;

public class Q287 {

    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = fast;
        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while (fast != slow);

        int outsideCyclePtr = 0;
        int insideCyclePtr = fast;
        do{
            insideCyclePtr = nums[insideCyclePtr];
            outsideCyclePtr = nums[outsideCyclePtr];
        }while (outsideCyclePtr != insideCyclePtr);

        return outsideCyclePtr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        Q287 test = new Q287();
        System.out.println(test.findDuplicate(arr));
    }
}
