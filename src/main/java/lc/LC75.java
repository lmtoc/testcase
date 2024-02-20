package lc;

/**
 * 2024/1/22
 * lamic
 **/
public class LC75 {
    private void quickSort(int [] nums){
        quickSort(nums,0,nums.length-1);
    }
    private void swap(int [] nums,int i,int j){
        nums[i] = nums[i]+nums[j];
        nums[j] = nums[i]-nums[j];
        nums[i] = nums[i] - nums[j];
    }

    private void quickSort(int [] nums,int start,int end){
        if(start > end){
            return;
        }
        //假设在1的范围里面刨除0和2，遇到不是1的就丢出去，0往前丢，2往后丢
        int oneBegin = start;
        int oneEnd = end;
        for(int i = 0;i<= oneEnd;){
            if(nums[i] == 0){ // 当前元素是0，要往前丢，对方丢过来的是1，也就是被缓过来的也是1
                swap(nums,oneBegin,i);
                oneBegin++;
                i++;
            }else if(nums[i] == 1){ //顺利通过
                i++;
            }else if(nums[i] == 2){ //不确定换过来的是什么，可能是1也可能是0也可能是2，所以要多一轮检查
                oneEnd--;
                swap(nums,i,oneEnd+1);

            }
        }
    }


    public static void main(String[] args) {
        LC75 lc = new LC75();
        lc.quickSort(new int[]{2,2});
    }
}
