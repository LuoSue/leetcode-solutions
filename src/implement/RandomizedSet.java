package implement;

import java.util.*;

/**
 * @author rj
 * @className RandomizedSet
 * @description 380. O(1) 时间插入、删除和获取随机元素
 * 实现RandomizedSet 类：
 * <p>
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 *
 * @date 2025/3/28 11:20
 */
public class RandomizedSet {
    // 使用HashMap存储值到索引的映射
    private Map<Integer, Integer> valToIndex;
    // 使用ArrayList存储实际的值
    private List<Integer> values;
    // 随机数生成器
    private Random rand;

    public RandomizedSet() {
        valToIndex = new HashMap<>();
        values = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        // 如果值已存在，返回false
        if (valToIndex.containsKey(val)) {
            return false;
        }
        // 将值添加到ArrayList末尾
        values.add(val);
        // 记录值对应的索引
        valToIndex.put(val, values.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        // 如果值不存在，返回false
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        // 获取要删除值的位置
        int index = valToIndex.get(val);
        // 获取最后一个元素
        int lastVal = values.get(values.size() - 1);

        // 如果要删除的不是最后一个元素
        // 将最后一个元素移动到要删除的位置
        if (index != values.size() - 1) {
            values.set(index, lastVal);
            valToIndex.put(lastVal, index);
        }

        // 删除最后一个元素
        values.remove(values.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        // 从ArrayList中随机返回一个元素
        return values.get(rand.nextInt(values.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));  // true
        System.out.println(randomizedSet.remove(2));  // false
        System.out.println(randomizedSet.insert(2));  // true
        System.out.println(randomizedSet.getRandom()); // 1 or 2
        System.out.println(randomizedSet.remove(1));  // true
        System.out.println(randomizedSet.insert(2));  // false
        System.out.println(randomizedSet.getRandom()); // 2
    }
}
