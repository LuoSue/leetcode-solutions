package sort;

/**
 * 插入排序算法实现类
 * @author rj
 * @className InsertionSort
 * @description 该类实现了插入排序算法，适用于小规模或基本有序的数据排序
 * @date 2025/3/25 15:46
 */
public class InsertionSort {

    /**
     * 插入排序方法
     * @param arr 待排序的数组
     */
    public void insertionSort(int[] arr) {
        // 获取数组长度
        int n = arr.length;

        // 从第二个元素开始遍历（因为第一个元素默认是已排序的）
        for (int i = 1; i < n; i++) {
            // 当前需要插入的元素（称为key）
            int key = arr[i];
            // key前一个元素的索引
            int j = i - 1;

            /*
             * 将当前元素key与前面已排序的元素比较
             * 条件1：j >= 0 确保不越界
             * 条件2：arr[j] > key 当前面的元素比key大时，需要移动
             */
            while (j >= 0 && arr[j] > key) {
                // 将比key大的元素向右移动一位
                arr[j + 1] = arr[j];
                // 继续向左比较
                j--;
            }
            // 找到key的正确位置（j+1），插入key
            arr[j + 1] = key;
        }
    }

    /**
     * 主方法，用于测试插入排序
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        // 测试数组
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("原始数组:");
        printArray(arr);

        // 创建InsertionSort实例并调用排序方法
        InsertionSort solution = new InsertionSort();
        solution.insertionSort(arr);

        System.out.println("排序后数组:");
        printArray(arr);
    }

    /**
     * 打印数组的辅助方法
     * @param arr 需要打印的数组
     */
    public static void printArray(int[] arr) {
        // 遍历数组并打印每个元素
        for (int num : arr) {
            System.out.print(num + " ");
        }
        // 换行
        System.out.println();
    }
}
