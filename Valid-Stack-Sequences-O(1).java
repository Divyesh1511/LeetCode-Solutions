class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0; //pointer to pushed array
        int j = 0; //pointer to popped array

        for(int val : pushed){
            pushed[i++] = val;
            while(i > 0 && pushed[i-1] == popped[j]){
                i--;
                j++;
            }
        }

        return (i==0);
    }
}
