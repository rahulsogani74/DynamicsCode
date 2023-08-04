public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int dp [][] = new int[nums.length][nums.length];
        return rec (-1,0,nums,dp);
    }
    private static int rec(int pre, int curr, int[] nums, int[][] dp){
        if (curr == nums.length) return 0;

        if (pre != -1 && dp[pre][curr] != 0) return dp[pre][curr];

        int op1 = 0;
        if (pre == -1 || nums[pre] < nums[curr]) {
            op1 = 1 + rec(curr,curr+1,nums,dp);
        }
        int op2 = rec(pre,curr+1,nums,dp);
        if (pre != -1) dp[pre][curr] = Math.max(op1,op2);
        return Math.max(op1,op2);
    }
    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] nums = {1,2,5,3,4};
        int length = lis.lengthOfLIS(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + length);
    }
}
