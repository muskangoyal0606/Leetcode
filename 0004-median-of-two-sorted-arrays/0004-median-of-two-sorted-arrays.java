class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int n = nums1.length;        // Length of first array  
        int m = nums2.length;        // Length of second array  
        int[] result = new int[n + m];  // Resultant array of size n + m  

        // Merge the arrays
        System.arraycopy(nums1, 0, result, 0, n);  
        System.arraycopy(nums2, 0, result, n, m); 
        
        // Sort the merged array using merge sort
        mergeSort(result, 0, result.length - 1);
        
        // Calculate the median
        int length = result.length;
        if (length % 2 == 0) {
            // Even number of elements: take the average of two middle elements
            return (result[length / 2 - 1] + result[length / 2]) / 2.0;
        } else {
            // Odd number of elements: take the middle element
            return result[length / 2];
        }
    }

    // Merge sort implementation
    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively sort the two halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1; // Size of left subarray
        int n2 = right - mid;    // Size of right subarray

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Merge the temp arrays back into the original array
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements of leftArray, if any
        while (i < n1) {
            array[k++] = leftArray[i++];
        }

        // Copy remaining elements of rightArray, if any
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }
    
    
}