class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int i = 0;
        for(; i < k; i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }

        int res = count;

        for(; i < s.length(); i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
            if(isVowel(s.charAt(i-k))){
                count--;
            }

            res = Math.max(res, count);
        }

        return res;
        
    }

    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
