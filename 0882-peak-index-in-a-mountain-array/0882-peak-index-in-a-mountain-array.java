class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int peakIndex = 0;
        int maxVal = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
                peakIndex = i;
            }
        }

        return peakIndex;
    }
}