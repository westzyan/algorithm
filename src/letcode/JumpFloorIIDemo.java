package letcode;

import java.util.Arrays;

public class JumpFloorIIDemo {



    int jumpFloorII(int number) {
        return number == 0 ? 0 : (1 << number - 1);
    }



    public int JumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }

/**    跳上 n-1 级台阶，可以从 n-2 级跳 1 级上去，也可以从 n-3 级跳 2 级上去...，那么

    f(n-1) = f(n-2) + f(n-3) + ... + f(0)
    同样，跳上 n 级台阶，可以从 n-1 级跳 1 级上去，也可以从 n-2 级跳 2 级上去... ，那么

    f(n) = f(n-1) + f(n-2) + ... + f(0)
    综上可得

    f(n) - f(n-1) = f(n-1)
    即

    f(n) = 2*f(n-1)
    所以 f(n) 是一个等比数列

    public int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }*/



public int minNumberInRotateArray(int[] nums) {
    if (nums.length == 0)
        return 0;
    int l = 0, h = nums.length - 1;
    while (l < h) {
        int m = l + (h - l) / 2;
        if (nums[l] == nums[m] && nums[m] == nums[h])
            return minNumber(nums, l, h);
        else if (nums[m] <= nums[h])
            h = m;
        else
            l = m + 1;
    }
    return nums[l];
}

    private int minNumber(int[] nums, int l, int h) {
        for (int i = l; i < h; i++)
            if (nums[i] > nums[i + 1])
                return nums[i + 1];
        return nums[l];
    }

    public static void main(String[] args) {
        int[] a ={1,1,1,1,1,0,1};
        JumpFloorIIDemo j = new JumpFloorIIDemo();
        int b = j.minNumberInRotateArray(a);
        System.out.println(b);
    }
}
