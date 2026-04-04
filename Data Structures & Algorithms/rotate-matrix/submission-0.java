class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);
        int r=matrix.length;
        int c=matrix[0].length;
        for(int i=0;i<r;i++){
            for(int j=i+1;j<c;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

    }
    public void reverse(int[][] matrix){
        int n=matrix.length;
        for(int i=0;i<n/2;i++){
            int[] temp=matrix[i];
            matrix[i]=matrix[n-i-1];
            matrix[n-i-1]=temp;
        }
    }
}
