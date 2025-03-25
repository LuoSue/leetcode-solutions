package sort;

import java.util.Arrays;

/**
 * @author rj
 * @className MergeSort
 * @description 归并排序（Merge Sort） - 采用分治法（Divide and Conquer）的稳定排序算法
 * @date 2025/3/25 15:10
 */
public class MergeSort {

    /**
     * 归并排序入口方法
     * @param arr 待排序数组
     */
    public void mergeSort(int[] arr) {
        // 边界检查：数组为空或长度小于2时无需排序
        if (arr == null || arr.length < 2) {
            return;
        }
        // 调用递归排序方法，初始范围为整个数组
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归拆分和排序
     * @param arr   待排序数组
     * @param left  当前子数组左边界
     * @param right 当前子数组右边界
     */
    private void mergeSort(int[] arr, int left, int right) {
        // 递归终止条件：子数组长度为1（left == right）
        if (left >= right) {
            return;
        }
        // 计算中点（防止整数溢出）
        int mid = left + (right - left) / 2;
        // 递归排序左半部分
        mergeSort(arr, left, mid);
        // 递归排序右半部分
        mergeSort(arr, mid + 1, right);
        // 合并两个有序子数组
        merge(arr, left, mid, right);
    }

    /**
     * 合并两个有序子数组
     * @param arr   原数组
     * @param left  左子数组起始索引
     * @param mid   左子数组结束索引（右子数组起始为 mid+1）
     * @param right 右子数组结束索引
     */
    private void merge(int[] arr, int left, int mid, int right) {
        // 创建临时数组存储合并结果
        int[] temp = new int[right - left + 1];
        // 定义指针：i（左子数组）、j（右子数组）、k（临时数组）
        int i = left, j = mid + 1, k = 0;

        // 核心归并操作：选择较小的元素放入临时数组
        while (i <= mid && j <= right) {
            // 注意：使用 <= 保证稳定性（相等时左子数组元素优先）
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        // 处理左子数组剩余元素（如果有）
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 处理右子数组剩余元素（如果有）
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 将合并后的数据从临时数组拷贝回原数组
        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("排序前: " + Arrays.toString(arr));

        MergeSort solution = new MergeSort();
        solution.mergeSort(arr);

        System.out.println("排序后: " + Arrays.toString(arr));
        // 输出示例：
        // 排序前: [12, 11, 13, 5, 6, 7]
        // 排序后: [5, 6, 7, 11, 12, 13]
    }
}
