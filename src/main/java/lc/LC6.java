package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 2023/12/7
 * lamic
 **/
public class LC6 {




    public static String convert(String s, int numRows) {
        //这道题看了题解才知道是N字形变换，而且有一个题解很巧妙，看得我破防了
        //题解的思路是，不关注每个char应该被放的(i,j)里面，更关注于每个char应该add在哪一行，也就是i上
        //因为规律告诉我们，char放在哪里更取决于i到了什么位置，
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;

        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }

    public static String convert2(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        //根据题目，numsRow行数固定
        //接下来找规律 每一个字符在哪一行其实已经根据一个条件约定了：
        //从0往下的是单个的，但是从底部往上的字符要往上的句子之后添加
        List<StringBuilder> result = new ArrayList(numRows);
        for(int i = 0;i<numRows;i++){
            result.add(new StringBuilder());
        }
        int flag = -1;//flag代表是否往下走,正数就是往下递增
        int i = 0;
        int row = 0;
        while(i < s.length()){
            char currentChar = s.charAt(i);
            result.get(row).append(currentChar);
            if(row == numRows - 1 || row == 0){
                flag = -flag;
            }
            i++;
            row = row+flag;
        }

        for(int j = 0;j<numRows;j++){
            result.get(1).append(result.get(j));
        }
        return result.get(1).toString();
    }


    public static void main(String [] args){
        System.out.println(convert2("PAYPALISHIRING",4));
    }
}
