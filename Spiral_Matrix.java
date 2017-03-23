/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 */

public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
            return rst;
       
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;
        while(count * 2 < rows && count * 2 < cols){
            for(int i = count; i < cols-count; i++)
                rst.add(matrix[count][i]);
           
           
            for(int i = count+1; i< rows-count; i++)
                rst.add(matrix[i][cols-count-1]);
           
            if(rows - 2 * count == 1 || cols - 2 * count == 1)  // if only one row /col remains
                break;
               
            for(int i = cols-count-2; i>=count; i--)
                rst.add(matrix[rows-count-1][i]);
               
            for(int i = rows-count-2; i>= count+1; i--)
                rst.add(matrix[i][count]);
           
            count++;
        }
        return rst;
    }
}

// v2
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 11:29 - 11:47
        List<Integer> res = new ArrayList();
        if(matrix.length == 0 || matrix[0].length == 0) return res;
         
        int m = matrix.length, n = matrix[0].length;
         
        int nLvl = (Math.min(m, n) + 1) / 2;
         
        for(int ilvl = 0; ilvl < nLvl; ilvl++) {
            int lastRow = m - 1 - ilvl;
            int lastCol = n - 1 - ilvl;
            if(lastRow == ilvl) {
                for(int j = ilvl; j <= lastCol; j++) {
                    res.add(matrix[ilvl][j]);
                }  
            } else if(lastCol == ilvl) {
                for(int i = ilvl; i <= lastRow; i++) {
                    res.add(matrix[i][ilvl]);
                }
            } else {
                for(int j = ilvl; j < lastCol; j++) {
                    res.add(matrix[ilvl][j]);
                }
                for(int i = ilvl; i < lastRow; i++) {
                    res.add(matrix[i][lastCol]);
                }
                for(int j = lastCol; j > ilvl; j--) {
                    res.add(matrix[lastRow][j]);
                }
                for(int i = lastRow; i > ilvl; i--) {
                    res.add(matrix[i][ilvl]);
                }
            }
        }
         
        return res;
    }
}

// v3
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 11:53 - 12:01
        List<Integer> res = new ArrayList();
        if(matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        if(n == 0) return res;
        
        int nLvl = (Math.min(m, n) + 1) / 2;
        for(int ilvl = 0; ilvl < nLvl; ilvl++) {
            int lastRow = m - 1 - ilvl;
            int lastCol = n - 1 - ilvl;
            if(lastRow == ilvl) {
                for(int j = ilvl; j <= lastCol; j++) {
                    res.add(matrix[ilvl][j]);
                }
            } else if(lastCol == ilvl) {
                for(int i = ilvl; i <= lastRow; i++) {
                    res.add(matrix[i][ilvl]);
                }
            } else {
                for(int j = ilvl; j < lastCol; j++) {
                    res.add(matrix[ilvl][j]);
                }
                for(int i = ilvl; i < lastRow; i++) {
                    res.add(matrix[i][lastCol]);
                }
                for(int j = lastCol; j > ilvl; j--) {
                    res.add(matrix[lastRow][j]);
                }
                for(int i = lastRow; i > ilvl; i--) {
                    res.add(matrix[i][ilvl]);
                }
            }
        }
        
        return res;
    }
}
