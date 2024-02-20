package lc;

/**
 * 2024/1/3
 * lamic
 **/
public class LC79 {

    boolean [][] visited;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        visited = new boolean[m][board[m-1].length];
        for(int i =0;i<m;i++){
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board,i,j,word,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private boolean dfs(char[][] board,int i,int j,String word,int wordIdx){
        if(wordIdx >= word.length()){ //单词走完了，成功的唯一标准
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>= board[0].length||visited[i][j]){ //说明走错路了,走不通了
            return false;
        }

        if(board[i][j] != word.charAt(wordIdx)){ //相等才会用上这个坐标，不想等就是下一个开始
            return false;

        }

        visited[i][j] = true;
        boolean first = dfs(board,i+1,j,word,wordIdx+1);
        if(first){
            return true;
        }
        first =dfs(board,i,j+1,word,wordIdx+1);
        if(first){
            return true;
        }
        first = dfs(board,i,j-1,word,wordIdx+1);
        if(first){
            return true;
        }
        first = dfs(board,i-1,j,word,wordIdx+1);
        //释放当前占用坐标，如果本来就是false也没关系
        visited[i][j] = false;
        return first;

    }

    public static void main(String[] args) {
        LC79 lc = new LC79();
        System.out.println(lc.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED"));
    }
}
