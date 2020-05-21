package leetcode;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public int missingNumberHashSet(int[] nums) {
        // HashSet
        // T.C: O(n)
        // S.C: O(n)
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        for(int i=0; i<nums.length+1; i++){
            if(!set.contains(i))
                return i;
        }
        return -1;
    }
    public int missingNumber(int[] nums) {
        // Gauss - Sum of Arithmetic sequence
        // T.C: O(n)
        // S.C: O(1)
        int expectedSum = (nums.length + 1) * nums.length / 2; // (n+1)*(0+n) / 2 // ***
        int actualSum = 0;
        for(int i=0; i<nums.length; i++){
            actualSum += nums[i];
        }
        return expectedSum - actualSum;
    }
}
