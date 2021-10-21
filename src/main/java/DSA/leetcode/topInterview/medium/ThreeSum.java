package DSA.leetcode.topInterview.medium;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    static class Triplet{
        Triplet(int i, int j, int k) {
            int[] arr = new int[3];
            arr[0] = i;
            arr[1] = j;
            arr[2] = k;
            Arrays.sort(arr);
            this.i = arr[0];
            this.j = arr[1];
            this.k = arr[2];
        }

        int i;
        int j;
        int k;

        static Triplet of(int i, int j, int k){
            return new Triplet(i, j, k);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triplet triplet = (Triplet) o;
            return i == triplet.i && j == triplet.j && k == triplet.k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j, k);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Set<Triplet> set = new HashSet<>();

        if (nums == null || nums.length < 3){
            return Collections.EMPTY_LIST;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int required = -(nums[i] + nums[j]);

                int k = map.getOrDefault(required, i);

                if ( (k != i) && (k != j)){
                    set.add(Triplet.of(nums[i], nums[j], nums[k]));
                }
            }
        }

        return set.stream().map(triplet -> List.of(triplet.i, triplet.j, triplet.k))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();

    }
}
