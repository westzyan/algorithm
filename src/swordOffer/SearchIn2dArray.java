package swordOffer;

/**
 * @author zyan
 * @version 1.0
 * @date 19-12-17 下午3:36
 */
public class SearchIn2dArray {

    int mid = 0;
    public boolean Find(int target, int [][] array) {
        for(int i = 0; i < array.length; i++){
            int low = 0;
            int high = array[0].length - 1;
            while(low <= high){
                mid = (low + high)/2;
                if(target > array[i][mid]){
                    low = mid + 1;
                }else if(target < array[i][mid]){
                    high = mid - 1;
                }else{
                    return true;
                }
            }
        }
        return false;
    }


    public boolean Find1(int target, int[][] array){
        int rows = array.length;
        int cols = array[0].length;
        if (rows == 0 || cols == 0){
            return false;
        }
        int row = rows - 1;
        int col = 0;
        while (row >= 0 && col <= cols){
            if (target > array[row][col]){
                row--;
            }else if (target < array[row][col]){
                col++;
            }else {
                return true;
            }
        }
        return false;
    }


}
