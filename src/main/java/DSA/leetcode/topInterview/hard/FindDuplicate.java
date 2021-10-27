package DSA.leetcode.topInterview.hard;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {

        int fast = 0;
        int slow = fast;
        while(true){

            fast = nums[nums[fast]];
            slow = nums[slow];
            if(fast == slow){
                break;
            }
        }

        int outside = 0;
        int inside = fast;
        while (outside != inside){
            outside = nums[outside];
            inside = nums[inside];
        }
        return inside;

    }

    public static void main(String[] args) {
        FindDuplicate test = new FindDuplicate();
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println(test.findDuplicate(arr));
    }

}
