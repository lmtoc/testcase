package lcr;

import java.util.HashMap;
import java.util.Map;

/**
 * 2024/2/7
 * lamic
 **/
public class LCR048 {
    Map<Integer,Integer> valueToIndex = new HashMap();

    public TreeNode deserialize(String data) {
        if(data == null || data == ""){
            return null;
        }
        System.out.println("data:["+data+"]");
        String[] preAndIn = data.split("/");
        for(int i = 0;i<preAndIn[1].length();i++){
            valueToIndex.put(preAndIn[1].charAt(i)-'0',i);
        }
        System.out.println();
        return rebuild(preAndIn[0],preAndIn[1],0,preAndIn[0].length()-1,0,preAndIn[1].length()-1);

    }
    private TreeNode rebuild(String preOrder,String inOrder,int preStart,int preEnd,int inStart,int inEnd){
        if(preStart>preEnd || preStart >=preOrder.length()){
            return null;
        }
        int rootVal = preOrder.charAt(preStart)-'0';
        int inRootIndex = valueToIndex.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftEnd = inRootIndex-inStart+preStart;
        root.left = rebuild(preOrder,inOrder,preStart+1,leftEnd,inStart,inRootIndex-1);
        root.right = rebuild(preOrder,inOrder,leftEnd+1,preEnd,inRootIndex+1,inEnd);
        return root;

    }

    public static void main(String[] args) {
        LCR048 lcr048 = new LCR048();
        lcr048.deserialize("122/212");
    }
}
