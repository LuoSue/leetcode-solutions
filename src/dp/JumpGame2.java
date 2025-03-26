package dp;

/**
 * @author rj
 * @className JumpGame2
 * @description leetcode 45. 跳跃游戏 II
 * @date 2025/3/26 9:50
 */
public class JumpGame2 {
    public int jump(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                ans++;
                currentEnd = farthest;
                if (currentEnd >= n - 1) {
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        JumpGame2 solution = new JumpGame2();

        // 测试用例 1
        System.out.println("Test Case 1:");
        int[] nums1 = new int[]{2,3,1,1,4};
        System.out.println(solution.jump(nums1)); // 输出2


        // 测试用例 2
        System.out.println("Test Case 2:");
        int[] nums2 = new int[]{2,3,1,0,4};
        System.out.println(solution.jump(nums2)); // 输出2
    }
}
