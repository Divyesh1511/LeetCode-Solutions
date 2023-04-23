//   Memoization method

class Solution {
    public int minInsertions(String s) {
        String s2 = "";
        for(int i = 0; i < s.length(); i++){
            s2 = s.charAt(i) + s2;
        }

        int[][] dp  = new int[s.length()][s.length()];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        int n = lcs(s, s2, s.length()-1, s.length()-1, dp);

        return s.length() - n;
    }

    private int lcs(String s1, String s2, int n1, int n2, int[][] dp){
        if(n1 < 0 || n2 < 0) return 0;

        if(dp[n1][n2] != -1) return dp[n1][n2];

        if(s1.charAt(n1) == s2.charAt(n2)){
            return dp[n1][n2] = 1 + lcs(s1, s2, n1-1, n2-1, dp);
        }

        return dp[n1][n2] = Math.max(lcs(s1, s2, n1-1, n2, dp), lcs(s1, s2, n1, n2-1, dp));
    }
}




//  Tabulation method

class Solution {
    public int minInsertions(String s) {
        String s1 = "";
        for(int i = 0; i < s.length(); i++){
            s1 = s.charAt(i) + s1;
        }

        int[][] dp= new int[s.length()+1][s.length()+1];
        for(int i = 0; i <= s.length(); i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j <= s.length(); j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= s.length(); j++){
                if(s.charAt(i-1) == s1.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return s.length() - dp[s.length()][s.length()];
    }
}
