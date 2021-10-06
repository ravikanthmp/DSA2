package DSA.leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class Q128 {

    class UF {
        Map<Integer, Integer> map = new HashMap<>();
        int[] comp;
        int[] size;
        private int[] arr;

        public UF(int[] arr) {
            this.arr = arr;

            int j = 0;
            for (int i = 0; i < arr.length; i++) {
                if (!map.containsKey(arr[i])){
                    map.put(arr[i], j++);
                }
            }

            comp = new int[map.size()];
            size = new int[map.size()];

            for (int i = 0; i < comp.length; i++) {
                comp[i] = i;
                size[i] = 1;
            }
        }

        public int find(int num) {
            int i = map.get(num);
            while (i != comp[i]) {
                comp[i] = comp[comp[i]];
                i = comp[i];
            }
            return i;
        }

        private int size(int idx) {
            return size[idx];
        }

        public void union(int i, int j) {
            int iComp = find(i);
            int jComp = find(j);
            if (iComp != jComp) {
                if (size(iComp) >= size(jComp)) {
                    comp[jComp] = iComp;
                    size[iComp] += size[jComp];
                } else {
                    comp[iComp] = jComp;
                    size[jComp] += size[iComp];
                }
            }
        }

        public int largestComponent() {

            int maxSoFar = 0;
            for (int i = 0; i < comp.length; i++) {
                if (comp[i] == i){
                    maxSoFar = Math.max(maxSoFar, size[i]);
                }
            }
            return maxSoFar;
        }
    }


    /*
    T(N) = O(N(lg*N))
    S(N) = O(N)
     */
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);
        int maxSoFar = 1;
        int currChainLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] == nums[i -1])){
                continue;
            }else if ((nums[i] == nums[i - 1] + 1)){
              currChainLength++;
            }
            else {
                currChainLength = 1;
            }
            maxSoFar = Math.max(maxSoFar, currChainLength);
        }
        return maxSoFar;
    }


    public static void main(String[] args) {
        int[] arr = {0, 3, 7, 2, 5, 7, 4, 6, 0, 1};
        Q128 test = new Q128();
        System.out.println(test.longestConsecutive(arr));
    }

}
