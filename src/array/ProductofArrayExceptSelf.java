package array;

import java.util.Arrays;

/**
 * @author rj
 * @className ProductofArrayExceptSelf
 * @description leetcode 238. 除自身以外数组的乘积
 * @date 2025/3/28 10:12
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // 返回数组、前缀积、后缀积初始化
        int[] ans = new int[n];
        int[] pre = new int[n];
        int[] suf = new int[n];

        Arrays.fill(pre, 1); // 填充数组初值为 1
        Arrays.fill(suf, 1);
        Arrays.fill(ans, 1);

        // 前缀积计算
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i - 1] * pre[i - 1];
        }

        // 后缀积计算
        for (int j = n - 2; j >= 0; j--) {
            suf[j] = nums[j + 1] * suf[j + 1];
        }

        // 答案数组计算
        for (int k = 0; k < n; k++) {
            ans[k] = pre[k] * suf[k];
        }

        return ans;
    }

    public int[] productExceptSelfOptimized(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // 初始化答案数组为1
        Arrays.fill(ans, 1);

        // 计算前缀积并存储在ans中
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = prefix;
            prefix *= nums[i];
        }

        // 计算后缀积并直接与ans中的前缀积相乘
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= suffix;
            suffix *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        ProductofArrayExceptSelf solution = new ProductofArrayExceptSelf();

        // 测试用例
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelf(nums1);
        System.out.println(Arrays.toString(result1)); // 预期输出: [24, 12, 8, 6]

        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = solution.productExceptSelf(nums2);
        System.out.println(Arrays.toString(result2)); // 预期输出: [0, 0, 9, 0, 0]

        int[] nums3 = {0, 0};
        int[] result3 = solution.productExceptSelf(nums3);
        System.out.println(Arrays.toString(result3)); // 预期输出: [0, 0]

        int[] nums4 = {1, 1};
        int[] result4 = solution.productExceptSelf(nums4);
        System.out.println(Arrays.toString(result4)); // 预期输出: [1, 1]
    }
}
