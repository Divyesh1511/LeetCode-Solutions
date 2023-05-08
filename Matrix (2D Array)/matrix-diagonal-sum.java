class Solution {
    public int diagonalSum(int[][] mat) {
        int i = 0, j = 0, n = mat.length, m = mat[0].length;
        int sum = 0;
        while(i < n && j < m){
            sum += mat[i][j] + mat[i][m-1-j];
            i++;
            j++;
        }
        if(n % 2 != 0){
            sum -= mat[n/2][m/2];
        }

        return sum;
    }
}
