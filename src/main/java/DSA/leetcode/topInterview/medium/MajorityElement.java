package DSA.leetcode.topInterview.medium;

public class MajorityElement {

    class Element{
        int el;
        int count;

        public Element(int el){
            this.el = el;
            this.count = 1;
        }

        public void reset(int newEl){
            count = 1;
            el = newEl;
        }
    }
    public int majorityElement(int[] nums) {

        Element currMajority = new Element(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == currMajority.el){
                currMajority.count++;
            }else {
                currMajority.count--;
                if (currMajority.count == 0){
                    currMajority.reset(nums[i]);
                }
            }
        }
        return currMajority.el;
    }

}
