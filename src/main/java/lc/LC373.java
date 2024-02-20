package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 2024/1/9
 * lamic
 **/
public class LC373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList();
        if(k <=0){
            return result;
        }
        for(int i = 0;i<nums1.length;i++){
            for(int j = 0;j<nums2.length;j++){
                if(result.size() >= k){
                    return result;
                }
                result.add(Arrays.asList(nums1[i],nums2[j]));
            }
        }
        return result;

    }

    public static void main(String []args){
        LC373 lc = new LC373();
//        PriorityQueue<List<Integer>> result = new PriorityQueue<>((a, b)->(a.get(0)-b.get(0),a.get(1)-b.get(1)));
        System.out.println(lc.kSmallestPairs(new int[]{1,1,2},new int[]{1,2,3},2));
    }
}
