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


    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        UF uf = new UF(nums);
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (set.contains(curr - 1)) {
                uf.union(curr, curr - 1);
            }

            if (set.contains(curr + 1)) {
                uf.union(curr, curr + 1);
            }
        }


        return uf.largestComponent();
    }


    public static void main(String[] args) {
        int[] arr = {0, 3, 7, 2, 5, 7, 4, 6, 0, 1};
        Q128 test = new Q128();
        System.out.println(test.longestConsecutive(arr));
    }

}
