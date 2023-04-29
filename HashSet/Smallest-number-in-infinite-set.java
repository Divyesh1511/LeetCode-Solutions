class SmallestInfiniteSet {
    Set<Integer> s;
    int curr;
    public SmallestInfiniteSet() {
        s = new HashSet<>();
        curr = 1;
    }
    
    public int popSmallest() {
        if(!s.isEmpty()){
            int res = Collections.min(s);
            s.remove(res);
            return res;
        }else{
            curr++;
            return curr-1;
        }
    }
    
    public void addBack(int num) {
        if(curr > num){
            s.add(num);
        }
    }
}
