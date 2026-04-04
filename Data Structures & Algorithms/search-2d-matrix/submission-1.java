class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top=0;
        int bottom=matrix.length-1;
        while(top<=bottom){
            int row=(top+bottom)/2;
            if(target>matrix[row][matrix[0].length-1]){
                top=row+1;
            }else if(target<matrix[row][0]){
                bottom=row-1;
            }else{
                break;
            }
        }
        if(top>bottom){
            return false;
        }
        int row=(top+bottom)/2;
        int start=0;
        int end=matrix[0].length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target==matrix[row][mid]){
                return true;
            } else if(target>matrix[row][mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return false;
    }
}
