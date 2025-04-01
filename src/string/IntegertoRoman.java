package string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author rj
 * @className IntegertoRoman
 * @description leetcode 12. 整数转罗马数字
 * @date 2025/4/1 10:06
 */
public class IntegertoRoman {
    public String intToRoman(int num) {
        // 使用 LinkedHashMap 保持插入顺序
        Map<Integer, String> romanMap = new LinkedHashMap<>();
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : romanMap.entrySet()) {
            int value = entry.getKey();
            String symbol = entry.getValue();
            while (num >= value) {
                result.append(symbol);
                num -= value;
            }
        }
        return result.toString();
    }
}
