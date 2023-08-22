public class HouseRobber {
    private Integer[] dp;
    public int rob(int[] nums) {
        dp = new Integer[nums.length];
        return robFrom(nums, 0);
    }
    private int robFrom(int[] wealth, int currentIndex) {
        if (currentIndex >= wealth.length)
            return 0;
        if (dp[currentIndex] != null)
            return dp[currentIndex];
        int stealCurrent = wealth[currentIndex] + robFrom(wealth, currentIndex + 2);
        int skipCurrent = robFrom(wealth, currentIndex + 1);
        return dp[currentIndex] = Math.max(stealCurrent, skipCurrent);
    }
    public static void main(String[] args) {
        HouseRobber solution = new HouseRobber();
        int[] nums = {2, 7, 9, 3, 1};
        int maxAmount = solution.rob(nums);
        System.out.println("Maximum amount that can be robbed: " + maxAmount);
    }
}
