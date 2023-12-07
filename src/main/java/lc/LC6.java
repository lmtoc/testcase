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


    public static void main(String [] args){
        System.out.println(convert("AB",1));
    }
}
