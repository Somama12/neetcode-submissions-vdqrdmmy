class Solution {
    public List<List<String>> solveNQueens(int n) {
       boolean[][] board=new boolean[n][n];
       return totalWay(board,0); 
    }

    static List<List<String>> totalWay(boolean[][] board, int row){
        if(row==board.length){
            ArrayList<String> str=display(board);
            List<List<String>> list=new ArrayList<>();
            list.add(new ArrayList<>(str));
            return list;
        }
        List<List<String>> result=new ArrayList<>();
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]=true;
                result.addAll(totalWay(board,row+1));
                board[row][col]=false;
            }
        }
        return result;
    }
    static boolean isSafe(boolean[][] board, int row, int col){
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }
        int maxLeft=Math.min(row,col);
        for(int i=1;i<=maxLeft;i++){
            if(board[row-i][col-i]){
                return false;
            }
        }

        int maxRight=Math.min(row,board.length-col-1);
        for(int i=1;i<=maxRight;i++){
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    static ArrayList<String> display(boolean[][] board){
       
        ArrayList<String> ans=new ArrayList<>();
        for(boolean[] row:board){
             StringBuilder sb=new StringBuilder();
            for(boolean elements:row){
                if(elements){
                    sb.append('Q');
                }else{
                    sb.append('.');
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }

}