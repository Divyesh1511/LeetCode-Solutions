class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        res[0] = binarySearch(nums, target, true);
        if(res[0] != -1){
            res[1] = binarySearch(nums, target, false);
        }
        return res;
    }

    private int binarySearch(int[] nums, int target, boolean isFirst){
        int s = 0;
        int e = nums.length-1;
        int res = -1;
        while(s <= e){
            int m = s + (e - s) / 2;
            if(nums[m] < target){
                s = m  + 1;
            }else if(nums[m] > target){
                e = m - 1;
            }else{
                res = m;
                if(isFirst){
                    e = m - 1;
                }else{
                    s = m + 1;
                }
            }
        }
        return res;
    }
}
