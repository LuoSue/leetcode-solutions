package dp;

/**
 * @author rj
 * @className JumpGame
 * @description leetcode 55. 跳跃游戏
 * @date 2025/3/26 9:34
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;

        for (int i = lastPos - 1; i >= 0; i--) {
            if(i+nums[i] >= lastPos){
                lastPos = i;
            }
        }

        return lastPos == 0;
    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();

        // 测试用例 1
        System.out.println("Test Case 1:");
        int[] nums1 = new int[]{2,3,1,1,4};
        System.out.println(solution.canJump(nums1)); // 输出true


        // 测试用例 2
        System.out.println("Test Case 2:");
        int[] nums2 = new int[]{3,2,1,0,4};
        System.out.println(solution.canJump(nums2)); // 输出false
    }
}
