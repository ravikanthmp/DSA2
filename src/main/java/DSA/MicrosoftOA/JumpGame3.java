package DSA.MicrosoftOA;

import java.util.*;
import java.util.stream.Collectors;

public class JumpGame3 {

    public static boolean jumpGame(List<Integer> arr, int start) {
        // WRITE YOUR BRILLIANT CODE HERE
        int[] nums = new int[arr.size()];
        int i = 0;
        for(int num : arr){
            nums[i++] = num;
        }

        return canReach(nums, start);
    }


    public static boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[arr.length];

        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            Integer idx = queue.remove();
            if (arr[idx] == 0){
                return true;
            }

            int leftJump = idx - arr[idx];
            int rightJump = idx + arr[idx];
            if (leftJump >= 0 && !visited[leftJump]){
                queue.add(leftJump);
                visited[leftJump] = true;
            }
            if (rightJump < arr.length && !visited[rightJump]){
                queue.add(rightJump);
                visited[rightJump] = true;
            }
        }

        return false;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int start = Integer.parseInt(scanner.nextLine());
        scanner.close();
        boolean res = jumpGame(arr, start);
        System.out.println(res);
    }


}
