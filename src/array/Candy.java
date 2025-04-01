package array;

import java.util.Arrays;

/**
 * @author rj
 * @className Candy
 * @description leetcode 135. 分发糖果
 * @date 2025/4/1 9:52
 */
public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); // 每个孩子至少 1 个糖果

        // 从左到右遍历，确保右边比左边高时糖果多
        for (int i = 1; i < n; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // 从右到左遍历，确保左边比右边高时糖果多
        for (int i = n - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // 计算总糖果数
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }
        return total;
    }
}
