public class CoinChange {
    public int change(int amount, int[] coins) {
        return helper(amount, coins, 0);
    }

    private int helper(int amount, int[] coins, int index) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || index == coins.length) {
            return 0;
        }
        int result = 0;
        for (int i = index; i < coins.length; i++) {
            if (amount >= coins[i]) {
                result += helper(amount - coins[i], coins, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int amount = 5;
        int[] coins = {1, 2, 3};
        int result = coinChange.change(amount, coins);
        System.out.println("Number of combinations: " + result);
    }
}

