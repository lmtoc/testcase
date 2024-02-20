package lc;

/**
 * 2023/12/11
 * lamic
 **/
public class LC289 {
    public static void gameOfLife(int[][] board) {

        //难点：原地更新的同时每个格子受入参状态下的相邻细胞状态影响，不能拿变化值判断该值，也就是要有快照
        boolean [][] needAlive = new boolean[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j] == 0 && needAliveForDead(board,i,j)){
                    needAlive[i][j] = true;
                }else if(board[i][j] == 1 && needDieForAlive(board,i,j)){
                    needAlive[i][j] = false;
                }else if(board[i][j] == 0){
                    needAlive[i][j] = false;
                }else if(board[i][j] == 0){
                    needAlive[i][j] = true;
                }
            }
        }

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                board[i][j] = needAlive[i][j]?1:0;
            }
        }
    }


    private  static boolean needDieForAlive (int[][] board,int i,int j){
        int aliveCnt = 0;

        for(int iBegin = i-1;iBegin<=i+1;iBegin++){
            if(iBegin < 0 || iBegin>=board.length ){
                continue;
            }
            for(int jBegin = j-1;jBegin <= j+1;jBegin++){
                if(jBegin <0 || jBegin >=board[0].length){
                    continue;
                }
                if(iBegin == i && jBegin == j){
                    continue;
                }
                aliveCnt+=board[iBegin][jBegin];
            }

        }
        System.out.println("i:["+i+"];j:["+j+"];aliveCnt:["+aliveCnt);
        if(aliveCnt<2 || aliveCnt>3){
            return true;
        }
        return false;


    }


    private static boolean needAliveForDead(int[][] board,int i,int j){
        int aliveCnt = 0;

        for(int iBegin = i-1;iBegin<=i+1;iBegin++){
            if(iBegin < 0 || iBegin>=board.length ){
                continue;
            }
            for(int jBegin = j-1;jBegin <= j+1;jBegin++){
                if(jBegin <0 || jBegin >=board[0].length){
                    continue;
                }
                if(iBegin == i && jBegin == j){
                    continue;
                }
                aliveCnt+=board[iBegin][jBegin];
            }

        }
        System.out.println("i:["+i+"];j:["+j+"];aliveCnt:["+aliveCnt);

        if(aliveCnt == 3){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        gameOfLife(new int [][]{{1,1},{1,0}});
    }
}
