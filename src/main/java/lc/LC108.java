package lc;

/**
 * 2024/1/4
 * lamic
 **/
public class LC108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructNode(nums,0,nums.length-1);
    }


    private TreeNode constructNode(int []nums,int begin,int end){
        if(begin > end){
            return null;
        }
        int mid = begin+(end-begin)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructNode(nums,begin,mid-1);
        root.right = constructNode(nums,mid+1,end);
        return root;
    }

    public static void main(String[] args){
        System.out.println(new int[]{-10,-3,0,5,9});
    }
}
