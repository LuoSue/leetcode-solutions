package binarysearch;

/**
 * @author rj
 * @className MoTSA
 * @description leetcode 4. 寻找两个正序数组的中位数
 * @date 2025/4/2 9:44
 */
public class MoTSA {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 1) {
            // 如果总长度为奇数，返回第 (totalLength / 2 + 1) 小的元素
            return getKthElement(nums1, nums2, totalLength / 2 + 1);
        } else {
            // 如果总长度为偶数，返回第 (totalLength / 2) 和第 (totalLength / 2 + 1) 小的元素的平均值
            return (getKthElement(nums1, nums2, totalLength / 2) +
                    getKthElement(nums1, nums2, totalLength / 2 + 1)) / 2.0;
        }
    }

    private int getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // 边界情况：一个数组为空
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }
            // 如果 k=1，返回两个数组中剩余部分的最小值
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况：比较两个数组中第 k/2 小的元素
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];

            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1); // 排除 nums1 中的部分
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1); // 排除 nums2 中的部分
                index2 = newIndex2 + 1;
            }
        }
    }
}
