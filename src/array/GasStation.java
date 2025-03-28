package array;

/**
 * @author rj
 * @className GasStation
 * @description leetcode 134. 加油站问题
 * @date 2025/3/28 11:28
 */
public class GasStation {

    /**
     * 判断能否环绕加油站行驶一圈并返回起始加油站索引
     *
     * @param gas  数组，gas[i]表示第i个加油站的油量
     * @param cost 数组，cost[i]表示从第i个加油站到第i+1个加油站的耗油量
     * @return 如果可以完成一圈行驶则返回起始加油站索引，否则返回-1
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;      // 记录总油量减去总消耗
        int currentTank = 0;    // 记录当前油箱中的油量
        int startingStation = 0; // 记录可能的起始加油站

        for (int i = 0; i < gas.length; i++) {
            // 计算每个加油站的净获得油量（加油量减去消耗量）
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];

            // 如果当前油量不足以到达下一站
            if (currentTank < 0) {
                // 尝试以下一站作为起点
                startingStation = i + 1;
                // 重置当前油箱油量
                currentTank = 0;
            }
        }

        // 如果总油量足够完成一圈，返回起始站；否则返回-1
        return totalTank >= 0 ? startingStation : -1;
    }

    public static void main(String[] args) {
        GasStation solution = new GasStation();

        // 测试用例1: 可以从索引3处完成一圈
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println("测试用例1: " + solution.canCompleteCircuit(gas1, cost1)); // 预期输出: 3

        // 测试用例2: 无法完成一圈
        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println("测试用例2: " + solution.canCompleteCircuit(gas2, cost2)); // 预期输出: -1

        // 测试用例3: 只有一个加油站且油量足够
        int[] gas3 = {5};
        int[] cost3 = {4};
        System.out.println("测试用例3: " + solution.canCompleteCircuit(gas3, cost3)); // 预期输出: 0

        // 测试用例4: 只有一个加油站但油量不足
        int[] gas4 = {3};
        int[] cost4 = {4};
        System.out.println("测试用例4: " + solution.canCompleteCircuit(gas4, cost4)); // 预期输出: -1

        // 测试用例5: 从第一个加油站开始可以完成一圈
        int[] gas5 = {5, 1, 2, 3, 4};
        int[] cost5 = {4, 4, 1, 5, 1};
        System.out.println("测试用例5: " + solution.canCompleteCircuit(gas5, cost5)); // 预期输出: 4

        // 测试用例6: 较大输入的情况
        int[] gas6 = {5, 8, 2, 8};
        int[] cost6 = {6, 5, 6, 6};
        System.out.println("测试用例6: " + solution.canCompleteCircuit(gas6, cost6)); // 预期输出: 3
    }
}
