class Solution {
    public int integerBreak(int n) {
        if(n <= 3) return n-1;
        int q = n / 3;
        int r = n % 3;
        if(r == 1){
            return ((int)Math.pow(3, q-1) * 4);
        }
        if(r == 2){
            return ((int)Math.pow(3, q) * 2);
        }

        return (int)Math.pow(3, q);
    }
}
