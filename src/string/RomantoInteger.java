package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rj
 * @className RomantoInteger
 * @description leetcode 13. 罗马数字转整数
 * @date 2025/3/26 17:18
 */
public class RomantoInteger {
    public int romanToInt(String s) {
        // 创建罗马字符到数值的映射
        Map<Character,Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = romanMap.get(currentChar);

            // 如果当前值小于前一个值，则减去当前值（如IV=4，IX=9等情况）
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }

    public static void main(String[] args) {
        RomantoInteger solution = new RomantoInteger();

        String s1 = "III";
        System.out.println(s1 + ":" + solution.romanToInt(s1));

        String s2 = "IV";
        System.out.println(s2 + ":" + solution.romanToInt(s2));

        String s3 = "IX";
        System.out.println(s3 + ":" + solution.romanToInt(s3));

        String s4 = "LVIII";
        System.out.println(s4 + ":" + solution.romanToInt(s4));

        String s5 = "MCMXCIV";
        System.out.println(s5 + ":" + solution.romanToInt(s5));
    }
}
