public class MergeSortedList {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        for (int k = m + n - 1; i >= 0 && j >= 0; k--) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }
        for (int k = j; k >= 0; k--, j--) {
            nums1[k] = nums2[j];
        }
    }
}
