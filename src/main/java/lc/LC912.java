package lc;

/**
 * 2024/1/31
 * lamic
 **/
public class LC912 {
    int total = 0;
    public int[] sortArray(int[] nums) {
        if(nums == null){
            return nums;
        }
        mergeSort(nums,0,nums.length-1);
        return nums;
    }


    private void mergeSort(int [] nums,int begin,int end){
        if(begin>=end){
            return;
        }
        int mid = begin+(end-begin)/2;
        mergeSort(nums,begin,mid);
        mergeSort(nums,mid+1,end);

        //merge
        int begin1 = begin;
        int begin2 = mid+1;
        int[] temp = new int[end-begin+1];
        int tempIdx = 0;
        int positive = 0;
        while(begin1<=mid && begin2<=end){
            if(nums[begin1]<=nums[begin2]){
                temp[tempIdx] = nums[begin1];

                begin1++;
            }else if(nums[begin1]>nums[begin2]){
                temp[tempIdx] = nums[begin2];
                total+=mid-begin1+1;
                begin2++;
            }
            tempIdx = tempIdx+1;
        }
        while(begin1<=mid){
            temp[tempIdx++] = nums[begin1++];
        }
        while(begin2<=end){
            temp[tempIdx++] = nums[begin2++];
        }
        tempIdx = tempIdx-1;
        while(tempIdx>=0){
            nums[end--] = temp[tempIdx--];
        }




    }

    public static void main(String[] args) {
        LC912 lc = new LC912();
//        System.out.println(lc.sortArray(new int[]{1,2,3,4,5,6,7,0,-1}));
//        lc.quickSort(new int[]{5,1,1,2,0,0},0,5);
        int[] array = {5,1,1,2,0,0};
        int low = 0,high = array.length-1;
        quickRow(array,low,high);
        for (int i : array){
            System.out.println(i);
        }
//        quickRow(array,0,5);
    }


    private void quickSort(int []nums,int start,int end){
        if(start>=end){
            return ;
        }
        int pivot = nums[start];
        int i = start;
        int j = end;
        while(i<j){
            while(i<j&&nums[j]>=pivot){
                j--;
            }
            while(i<j&&nums[i]<=pivot){
                i++;
            }
            //这是找到第一对可以交换的
            if(i < j){
                swap(nums,i,j);
                i++;
                j--;
            }
        }
        quickSort(nums,start,i-1);
        quickSort(nums,i+1,end);
//        System.out.println(nums);

    }
    private void swap(int[] nums,int i,int j){
        nums[i] = nums[i]+nums[j];
        nums[j] = nums[i]-nums[j];
        nums[i] = nums[i]-nums[j];
    }

    public static void quickRow(int[] array,int low,int high) {
        int i,j,pivot;
        //结束条件
        if(low >= high) {
            return;
        }
        i = low;
        j = high;
        //选择的节点，这里选择的数组的第一数作为节点
        pivot = array[low];
        while(i<j) {
            //从右往左找比节点小的数，循环结束要么找到了，要么i=j
            while(array[j] >= pivot && i<j) {
                j--;
            }
            //从左往右找比节点大的数，循环结束要么找到了，要么i=j
            while(array[i] <= pivot && i<j) {
                i++;
            }
            //如果i!=j说明都找到了，就交换这两个数
            if(i<j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        //i==j一轮循环结束，交换节点的数和相遇点的数
        array[low] = array[i];
        array[i] = pivot;
        //数组“分两半”,再重复上面的操作
        quickRow(array,low,i-1);
        quickRow(array,i+1,high);
    }
}
