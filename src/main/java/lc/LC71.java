package lc;

import java.util.Objects;
import java.util.Stack;

/**
 * 2023/12/14
 * lamic
 **/
public class LC71 {


    public  static String simplifyPath(String path) {
        //用栈记录当前有效路径，栈只保存每一个文件名不保存 / 以及.
        //遇见.不操作，遇见/不操作；遇见..出栈
        Stack<String> files = new Stack();
        String []splits = path.split("/");
        for (String split : splits) {
            if (split == null || Objects.equals(split, "")) {
                continue;
            }
            if (split.equals("..") ) {
                if(!files.isEmpty()){
                    files.pop();
                }
            } else if(!split.equals(".")) {
                files.push(split);
            }
        }
        if(files.isEmpty()){
            return "/";
        }

        StringBuilder result = new StringBuilder();
        for(String file:files){
            if(file == null || file.isEmpty()){
                continue;
            }
            result.append("/").append(file);
        }
        return result.toString();

    }


    public static void main(String [] args){
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
