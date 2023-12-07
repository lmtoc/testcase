package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2023/12/7
 * lamic
 **/
public class LC15 {


    public static  List<List<Integer>> threeSum(int[] nums) {
        //排序之后操作，排序是为了避免重复，也方便二分查找
        int numsLength= nums.length;
        List<List<Integer>> result = new ArrayList();
        if(numsLength<3){
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0;i<numsLength-2;i++){
            int currentNum = nums[i];
            if(currentNum > 0){
                break;
            }
            if(i>0 && currentNum == nums[i-1]){ //避免重复结果集
                continue;
            }
            int left = i+1;
            int right = numsLength-1;
            while(left<right){

                while(left+1>i+1 && nums[left] == nums[left-1]  ){
                    left++;
                    continue;
                }

                int currentSum = currentNum + nums[right]+nums[left];
                if(currentSum == 0){
                    List<Integer> currentResult = new ArrayList();
                    currentResult.add(currentNum);
                    currentResult.add(nums[left]);
                    currentResult.add(nums[right]);
                    result.add(currentResult);
                    left++;
                    continue;
                } else if(currentSum < 0){
                    left++;
                }else{
                    right--;
                }
            }

        }
        return result;

    }


    public  static void main(String[] args){
        System.out.println(threeSum(new int[]{-2,0,1,1,2}));
    }
}
