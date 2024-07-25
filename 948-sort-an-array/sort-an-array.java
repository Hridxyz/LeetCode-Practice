class Solution {
    
    public int[] sortArray(int[] arr) {
        divideSort(arr, 0, arr.length-1);
        return arr;

    }
    public static void divideSort(int[] arr, int si, int ei){
        if(si>=ei){
            return;
        }
        int mid = si + (ei-si) / 2;
        divideSort(arr, si, mid);
        divideSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }
    public static void merge(int arr[], int si, int mid, int ei){
        int temp[] = new int[ei - si +1];
        int i = si;
        int j = mid + 1;
        int k = 0;
        while(i<=mid && j<=ei){
            if(arr[i] > arr[j]){
                temp[k] = arr[j];
                j++;

            }else {
                temp[k] = arr[i];
                i++;
            }
            k++;
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=ei){
            temp[k++] = arr[j++];
        }
        for(k=0, i=si; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }
    
}