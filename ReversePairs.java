package leetCodeJava;

public class ReversePairs {
    public long reversePairs(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] temp = new int [A.length];
        return mergeSort(A, 0, A.length - 1, temp);
    }
    private int mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return 0;
        }
        int count = 0;
        count += mergeSort(A, start, (start + end) / 2, temp);
        count += mergeSort(A, (start + end) / 2 + 1, end, temp);
        count += merge(A, start, end, temp);
        return count;
    }
    private int merge(int[] A, int start, int end, int[] temp) {
        int mid = (start + end) / 2;
        int i = start, j = mid + 1, index = start;
        int count = 0;
        while (i <= mid && j <= end) {
            if (A[i] <= A[j]) {
                temp[index++] = A[i++];
            } else {
                count += mid - i + 1;
                System.out.println("reverse pair " + A[i] + " " + A[j] + " count = " + count);
                temp[index++] = A[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = A[i++];
        }
        while (j <= end) {
            temp[index++] = A[j++];
        }
        for (int k = start; k <= end; k++) {
            A[k] = temp[k];
        }
        return count;
    }
}
