class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m - 1;
        int ptr2 = n - 1;
        int index = m + n - 1;
        while(ptr2 >= 0){
            if(ptr1 >= 0 && nums1[ptr1] > nums2[ptr2]){
                nums1[index] = nums1[ptr1];
                ptr1--;
                index--;
            }else{
                nums1[index] = nums2[ptr2];
                ptr2--;
                index--;
            }
        }
    }
}
