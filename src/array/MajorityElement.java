package array;

/**
 * @author rj
 * @className MajorityElement
 * @description leetcode 169. 多数元素
 * @date 2025/4/1 9:58
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int ans = 0, count = 0;
        for(int num: nums){
            if(count == 0){
                ans = num;
            }
            if(ans == num){
                count++;
            }else{
                count--;
            }
        }
        return ans;
    }
}
