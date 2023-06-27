public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2; //此时sum就相当于背包问题中的背包容量
        //1.确认dp数组以及下标的含义 dp[j]表示背包容量为j时能获得的最大子集和
        int[] dp = new int[sum + 1];
        //3.初始化dp数组
        dp[0] = 0;
        //4.确认遍历顺序
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[sum] == sum;
    }
