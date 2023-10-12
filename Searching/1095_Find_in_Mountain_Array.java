/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        if(mountainArr.length() < 3){
            return -1;
        }
        int pivot = findPeak(0, mountainArr.length()-1, mountainArr);
        if(mountainArr.get(pivot) == target){
            return pivot;
        }
        int searchInleft = binarySearch(target, mountainArr, 0, pivot-1, false);
        if(mountainArr.get(searchInleft) == target) return searchInleft;
        int searchInRight = binarySearch(target, mountainArr, pivot+1, mountainArr.length()-1, true);
        if(mountainArr.get(searchInRight) == target) return searchInRight;
        return -1;

    }

    public int findPeak(int start, int end, MountainArray mountainArr){
        while(start != end){
            int mid = start + (end - start) / 2;

            if(mountainArr.get(mid) < mountainArr.get(mid + 1)){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }

    public int binarySearch(int target, MountainArray mountainArr,int start, int end, boolean reverse){
        while(start != end){
            int mid = start + (end - start) / 2;
            if(reverse){
                if(mountainArr.get(mid) > target){
                    start = mid + 1;
                }else{
                    end = mid;
                }
            }else{
                if(mountainArr.get(mid) < target){
                    start = mid + 1;
                }else{
                    end = mid;
                }
            }
        }
        return start;
    }
}
