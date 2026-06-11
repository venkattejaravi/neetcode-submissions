class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        
        int start = 0;
        int end = matrix.length - 1;
        int row = -1;
        while(start <= end){
            int mid = (int)((end + start) / 2);
            if(target < matrix[mid][0]) {
                end = mid - 1;
            } else if (target > matrix[mid][matrix[mid].length - 1]) {
                start = mid + 1;
            } else {
                row = mid;
                break;
            }

        }
        if(row == -1) return false;

        int[] arr = matrix[row];
        start = 0;
        end = arr.length - 1;
        while(start <= end) {
            int mid = (int)((end + start) / 2);
            if(target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
        
    }
}
