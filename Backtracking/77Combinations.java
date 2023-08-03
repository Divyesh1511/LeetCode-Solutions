class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if(n < k) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        combine(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void combine(int i, int n, int k, List<Integer> comb, List<List<Integer>> res){
        if(k == 0){
            res.add(new ArrayList<>(comb));
            return;
        }

        for(int x = i; x <= n; x++){
            comb.add(x);
            combine(x+1, n, k-1, comb, res);
            comb.remove(comb.size()-1);
        }
    }
}
