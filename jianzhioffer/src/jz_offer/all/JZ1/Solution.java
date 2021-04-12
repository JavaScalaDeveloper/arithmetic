package jz_offer.all.JZ1;

public class Solution {
    //暴力法
    /*public boolean Find(int target, int [][] array) {
        if(array.length==0)
            return false;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                if(array[i][j]==target)
                    return true;
            }
        }
        return false;
    }*/

    //时间复杂度相比暴力法较低
    public boolean Find(int target, int[][] array) {
        int row = array.length;
        if (row == 0)
            return false;
        int col = array[0].length;
        if (col == 0)
            return false;
        int rows = row - 1;
        int cols = 0;
        while (rows >= 0 && cols < col) {
            if (target < array[rows][cols])
                rows--;
            else if (target > array[rows][cols])
                cols++;
            else
                return true;
        }
        return false;
    }
}
