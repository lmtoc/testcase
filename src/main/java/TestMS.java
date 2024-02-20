import java.util.ArrayList;
import java.util.List;

/**
 * 2024/2/19
 * lamic
 **/


//解析器 解析csv转化为二为字符串数组 "i,r,t,kk""k,l,\",\""
// input : 1,2,3,4,5\n6,7,8,9,10 作为一行内容 \n换行
//[1,2,3,4,5],[6,7,8,9,10]  empty可以存在，如果是empty就用空字符串填入 eg：连续换行[""]
// ,可以存在，会用""包裹=》","，
// 值会存在双引号""=>"
 public class TestMS {

     public List<List<String>> parseCSV(String csvFileContent){
         List<List<String>> result = new ArrayList<>();
         //边界和判空排除
         if(csvFileContent == null || csvFileContent.length() == 0){
             return result;
         }
         //处理当前字符串内容，遍历char。
         // 遇到,不处理
         //常规字符则将当前字符append进当前累积字符串中
         //遇到"判断下一个字符是否n，实则将当前累积字符串添加进答案
         boolean inQuote =false; //记录当前解析内容是否在双引号中，在非时遇到，则该值为true同时开启解析特殊字符；在true时遇到则解析特殊字符完成病添加进答案；
         StringBuilder current = new StringBuilder();
         List<String> curResult = new ArrayList<>();
         for(int i = 0;i<csvFileContent.length();i++){
             char cur = csvFileContent.charAt(i);
             if(cur !=',' &&cur !='\n' &&cur != '"'){
                 current.append(cur);
             }else if(cur =='\n'){
                 result.add(curResult);
                 current = new StringBuilder();
             }else if(cur == ','){ //判断,
                 if(!inQuote){
                     //一组字符
                     curResult.add(current.toString());
                     //开启新的字符串累积
                     current = new StringBuilder();
                 } else if (inQuote) {
                     current.append(cur);
                 }
             }else if(cur == '"'){
                 if(!inQuote){
                     inQuote = true;//"hello,""world"=>[hello],[]
                 }else if(inQuote){ //已经在双引号的范围内，当前问题如何区分""和""""
                     current.append(cur);
                     inQuote = false;
                 }

             }
         }
         return result;
     }



     //
    //二叉树 随机数字（不重复正整数），找到最大值与最小值，
    //打印树节点

    class TreeNode{
         int value;

         TreeNode left;

         TreeNode right;

         TreeNode parent;

         TreeNode(int value){

         }

         TreeNode biggest = null;
         TreeNode smallest = null;

         public List<Integer> findPathFor(TreeNode root){
             //寻找最大值与最小值
             find(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
             List<Integer> result = new ArrayList<>();
             if(biggest == null || smallest == null){
                 return result;
             }
             //find path 固定biggest节点，三个方向找smallest
             findSmallest(root,result);
             return result;

         }

         private boolean findSmallest(TreeNode root,List<Integer> result ){
             if(root == null){
                 return false;
             }
             if(root == smallest){
                 return true;
             }
             boolean parentFind = findSmallest(root.parent,result);
             if(parentFind){
                 result.add(root.parent.value);
             }
             boolean leftFind = findSmallest(root.left,result);
             if(leftFind){
                 result.add(root.left.value);
             }
             boolean rightFind = findSmallest(root.right,result);
             if(rightFind){
                 result.add(root.right.value);
             }
             return parentFind|| leftFind || rightFind;
         }


         private void find(TreeNode root,int max,int min){
             if(root == null){
                 return ;
             }
             if(root.value >  max){
                 biggest = root;
                 max = root.value;
             }
             if(root.value < min){
                 smallest = root;
                 min = root.value;
             }
             find(root.right,max,min);
             find(root.left,max,min);
         }

    }








}
