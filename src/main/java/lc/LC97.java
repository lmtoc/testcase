package lc;

/**
 * 2024/1/16
 * lamic
 **/
public class LC97 {
    //这个我们尝试用dp做 定义dp[i][j]含义是当前i到j是由两个字符交错组成
    //对应的是 s1l,s1r;s2l,s2r
    //s1从左边匹配，s2从右边匹配（s1开头与s3开头相等，s2结尾与s3结尾相等）
    String s1;
    String s2;
    String s3;
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        if(s3.length() != s1.length()+s2.length()){
            return false;
        }
        return dfs(0,s2.length()-1,0,s3.length()-1);
    }

    private boolean dfs(int s1x,int s2x,int s1l,int s2r){
        if(s1l >= s2r){
            return true;
        }
        if(s1x >= s1.length() || s2x < 0 ){ //边界判断
            return false;
        }
        if(s3.charAt(s1l) != s1.charAt(s1x)&&s3.charAt(s2r) != s2.charAt(s2x)){
            return false;
        }
        if(s3.charAt(s1l) == s1.charAt(s1x)){
            s1l++;
            s1x++;
        }
        if(s3.charAt(s2r) == s1.charAt(s2x)){
            s2r--;
            s2x--;
        }

        return dfs(s1x,s2x,s1l,s2r);
    }


    public static void main(String[] args) {
        LC97 lc = new LC97();
        System.out.println(lc.isInterleave("aabcc","dbbca","aadbbcbcac"));
    }
}
