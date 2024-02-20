package lcr;

import java.util.HashMap;
import java.util.Map;

/**
 * 2024/2/7
 * lamic
 **/
public class LCR50 {
    int result;
    int targetSum;
    Map<TreeNode,Boolean> visited = new HashMap();

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        this.targetSum = targetSum;
        dfs(root,0);
        return result;
    }

    //每个节点只做两件事，判断当前积累累加值是否足够
    //判断从当前节点开始执行计算
    private void dfs(TreeNode node,int pathSum){
        if(node == null || visited.containsKey(node)){
            return ;
        }
        int cur = pathSum+node.val;
        if(cur == targetSum){
            result++;
        }
        dfs(node.left,cur);
        dfs(node.right,cur);
        //以下是从当前节点开始
        dfs(node.left,0);
        dfs(node.right,0);
//        visited.put(node,true);

    }

    public static void main(String[] args) {
        TreeNode firNode = new TreeNode(1);
        TreeNode node = firNode;
        node.right = new TreeNode(2);
        node = node.right;
        node.right = new TreeNode(3);
        node = node.right;
//        node.right = new TreeNode(4);
//        node = node.right;
//        node.right = new TreeNode(5);
        LCR50 lcr50 = new LCR50();
        System.out.println(lcr50.pathSum(firNode,3));
    }
}
