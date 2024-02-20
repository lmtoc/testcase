package lc;

/**
 * 2023/12/26
 * lamic
 **/
public class lc139 {


    public static void solve(char[][] board) {
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j] == 'O'){
                    dfs(board,i,j);
                }
            }
        }


    }

    private static boolean dfs(char[][] board,int i,int j){
        if(inAboard(board,i,j)){
            return false;
        }
        if(!inArea(board,i,j)){
            return true;
        }
        char origin = board[i][j];
        board[i][j] = 'G';
        if(dfs(board,i-1,j) && dfs(board,i+1,j) && dfs(board,i,j-1) && dfs(board,i,j+1)){
            board[i][j] = 'X';
            return true;
        }else{
            board[i][j] = origin;
            return false;
        }
    }

    private static boolean inArea(char[][] board,int i,int j){
        return i>=0 && i< board.length && j>=0 && j< board[i].length && board[i][j] == 'O';
    }


    private static boolean inAboard(char[][] board,int i,int j){
        return (i==0 || i== board.length-1 || j==0 || j == board[i].length-1) && board[i][j] == 'O';
    }



    public static void main(String [] args){
        solve(new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}});
    }
}
