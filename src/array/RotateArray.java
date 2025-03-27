package array;

/**
 * @author rj
 * @className RotateArray
 * @description leetcode 189. 轮转数组
 * @date 2025/3/27 11:42
 */
public class RotateArray {
    /**
     * 三次反转法：时间 O(n)，空间 O(1)
     */
    public void rotateByReverse(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        k = k % n;
        if (k == 0) return;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    /**
     * 使用额外数组：时间 O(n)，空间 O(n)
     */
    public void rotateWithExtraArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        k = k % n;
        if (k == 0) return;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[(i + k) % n] = nums[i];
        }
        System.arraycopy(arr, 0, nums, 0, n);
    }

    /**
     * 环状替换法：时间 O(n)，空间 O(1)
     */
    public void rotateInPlace(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k %= nums.length;
        if (k == 0) return;

        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        RotateArray rotator = new RotateArray();
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        rotator.rotateByReverse(nums1, 3);
        System.out.println(java.util.Arrays.toString(nums1)); // [5, 6, 7, 1, 2, 3, 4]

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        rotator.rotateWithExtraArray(nums2, 3);
        System.out.println(java.util.Arrays.toString(nums2)); // [5, 6, 7, 1, 2, 3, 4]

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7};
        rotator.rotateInPlace(nums3, 3);
        System.out.println(java.util.Arrays.toString(nums3)); // [5, 6, 7, 1, 2, 3, 4]
    }
}
