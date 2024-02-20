package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 2023/12/12
 * lamic
 **/
public class Lc228 {

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList();
        int right = 1;
        int left = 0;
        int currentHeadIndex = 0;
        while(left<nums.length){
            if(right == nums.length ){
                if(currentHeadIndex == right-1){
                    result.add(String.valueOf(nums[currentHeadIndex]));
                }else{
                    result.add(nums[currentHeadIndex] +"->"+ (nums[right-1] ));
                }
                return result;
            }

            if(nums[right] == nums[right-1]+1){
                right++;
            }else{
                result.add(nums[currentHeadIndex] +"->"+ (nums[right-1] ));
                currentHeadIndex = right;
                left = right;
                right = left+1;
            }
        }
        return result;

    }


    public static void main(String[] args){
        System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}
