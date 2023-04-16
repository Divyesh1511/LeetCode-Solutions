 // Memoization method 

class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1 = "";
        int[][] dp  = new int[s.length()][s.length()];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        for(int i = 0; i < s.length(); i++){
            s1 = s.charAt(i) + s1;
        }

        return LCS(s, s1, s.length()-1, s1.length()-1, dp);
    }

    private int LCS(String s1, String s2, int index1, int index2, int[][] dp){
        if(index1 < 0 || index2 < 0) return 0;

        if(dp[index1][index2] != -1) return dp[index1][index2];

        if(s1.charAt(index1) == s2.charAt(index2)){
            return dp[index1][index2] = 1 + LCS(s1, s2, index1-1, index2-1, dp);
        }

        return dp[index1][index2] = Math.max(LCS(s1, s2, index1-1, index2, dp), LCS(s1, s2, index1, index2-1, dp));
    }
}



// Tabulation Method 

class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2 = "";
        for(int k = 0; k < s.length(); k++){
            s2 = s.charAt(k) + s2;
        }
        int n = s.length();
        int m = s.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0;  i <= n; i++) dp[i][0] = 0;
        for(int j = 0;  j <= m; j++) dp[0][j] = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
}
