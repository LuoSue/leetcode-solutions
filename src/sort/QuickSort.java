package sort;

/**
 * @author rj
 * @className QuickSort
 * @description 快速排序
 * @date 2025/3/25 11:31
 */
public class QuickSort {
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 使用快速排序算法对数组进行排序
     * @param nums 待排序的数组
     * @param left 当前子数组的左边界
     * @param right 当前子数组的右边界
     */
    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex);
        quickSort(nums, pivotIndex + 1, right);
    }

    /**
     * 对数组进行分区操作，返回分区点的索引
     * @param nums 待分区的数组
     * @param left 分区的左边界
     * @param right 分区的右边界
     * @return 分区点的索引
     */
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left + (right - left) / 2]; // 选择中间元素作为基准值
        int i = left - 1;
        int j = right + 1;

        while (i < j) {
            // 从左向右找到第一个大于等于基准值的元素
            do {
                i++;
            } while (nums[i] < pivot);

            // 从右向左找到第一个小于等于基准值的元素
            do {
                j--;
            } while (nums[j] > pivot);

            // 交换这两个元素
            if (i < j) {
                swap(nums, i, j);
            }
        }

        return j;
    }

    /**
     * 交换数组中两个元素的位置
     * @param nums 数组
     * @param i 第一个元素的索引
     * @param j 第二个元素的索引
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 打印数组的辅助方法
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("原始数组:");
        printArray(arr);

        QuickSort solution = new QuickSort();

        solution.quickSort(arr);

        System.out.println("排序后数组:");
        printArray(arr);
    }
}
