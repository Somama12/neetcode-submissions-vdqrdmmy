class Solution {
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        
        int row=board.length;
        int col=board[0].length;
        visited=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(word.charAt(0)==board[i][j] && findWord(i,j,board, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean findWord(int i, int j,char[][] board, String word, int index){
        if(index==word.length()){
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || word.charAt(index)!=board[i][j] || visited[i][j]){
            return false;
        }
        visited[i][j]=true;
        boolean ans=findWord(i+1,j, board, word, index+1)
                    || findWord(i-1,j, board, word, index+1)
                    || findWord(i,j+1, board, word, index+1)
                    || findWord(i,j-1, board, word, index+1);
        visited[i][j]=false;
        return ans;
    }
}
