// 🧑‍💻 Intern (0–1 Years Experience) 
// Given an integer array nums, return the length of the longest strictly increasing subsequence. Come up with an algorithm that runs in O(n log(n)) time complexity

// Example 1:
// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

// Example 2:
// Input: nums = [0,1,0,3,2,3]
// Output: 4

// Example 3:
// Input: nums = [7,7,7,7,7,7,7]
// Output: 1
 
// Constraints:
// •	1 <= nums.length <= 2500
// •	-104 <= nums[i] <= 104
// Focus Areas:
// •	Dynamic Programming
// •	Binary Search
// •	Time and space optimisation

import java.util.*;
public class LongestIncreasing{
    public static int answer = 0;
    public static void helper(int[] nums,int n,int idx,List<Integer> temp){
        if(idx==n){
            answer = Math.max(answer,temp.size());
            return;
        }
        for(int i=idx;i<n;i++){
            if(temp.size()==0 || nums[i]>temp.get(temp.size()-1)){
                temp.add(nums[i]);
                helper(nums,n,i+1,temp);
                temp.remove(temp.size()-1);
            }
            helper(nums,n,i+1,temp);
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n = str.length;;
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(str[i]);
        }
        List<Integer> temp = new ArrayList<>();
        helper(nums,n,0,temp);
        System.out.println(answer);
        sc.close();
    }
}
