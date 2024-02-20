package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * 2023/12/12
 * lamic
 **/
public class LC128 {
    public static  int longestConsecutive(int[] nums) {
        //差点看错题整成dp了
        Map<Integer,Integer> elementToLength = new HashMap();
        int maxResult = 1;
        for (int num : nums) {
            if(elementToLength.containsKey(num)){
                continue;
            }
            int last = num-1;
            int next = num+1;
            int left = 0;
            int right = 0;
            if(elementToLength.containsKey(last)){
                left = elementToLength.get(last);
            }
            if(elementToLength.containsKey(next)){
                right = elementToLength.get(next);
            }
            int currentLength = left+right+1;
            elementToLength.put(num,currentLength);
            if(left !=0){
                elementToLength.put(num-left,currentLength);
            }
            if(right != 0){
                elementToLength.put(num+right,currentLength);
            }
            maxResult = Math.max(maxResult,currentLength);

        }
        return maxResult;

    }

    public static void main(String [] args){
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
