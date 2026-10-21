class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int top = 0;
        int bottom = row - 1;

        while(top < bottom){
            int mid = top + (bottom - top)/2;

            if(matrix[mid][col-1] == target){
                return true;
            }else if(target > matrix[mid][col-1]){
                top = mid +1;
            }else{
                bottom = mid;
            }
        }

        int left = 0;
        int right = col - 1;
        while(left <= right){
            int mid = left + ( right - left)/2;

            if(matrix[top][mid] == target){
                return true;
            }else if(target > matrix[top][mid]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }
}
