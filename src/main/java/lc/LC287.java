package lc;

/**
 * 2024/1/20
 * lamic
 **/
public class LC287 {
    public int findDuplicate(int[] nums) {
        //nums 中的值[1,n]; 那么任意nums[i] 其实可以放进 nums[i] 所在的index 那也就是 nums[nums[i]-1] = nums[i];如果有重复那就回放不进去，依然待在原本的nums[i]的位置
        for(int i = 0;i<nums.length;i++){
            int j = i;
            while(nums[nums[j]-1] != nums[j]){
                swap(nums,j,nums[j]-1);

            }
        }

        for(int i = 0;i<nums.length;i++){
            if(nums[i] != i+1){
                return nums[i];
            }
        }
        return -1;
    }


    private void swap(int [] nums,int i,int j){
        nums[i] = nums[i]+nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

    public static void main(String[] args) {
        LC287 lc = new LC287();
        System.out.println(lc.findDuplicate(new int[]{1,3,4,2,2}));
    }
}
