class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
    private void mergeSort(int[] nums, int l, int r){
        if(l>=r) return;
        int m=(l+r)/2;
        mergeSort(nums, l, m);
        mergeSort(nums, m+1, r);
        merge(nums, l, m, r);
    }
    private void merge(int[] arr, int l, int m, int r){
        int[] temp=new int[arr.length];
        int k=l;
        int i=l;
        int j=m+1;
        while(i<=m && j<=r){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<=m){
            temp[k]=arr[i];
            i++;
            k++;
        }
        while(j<=r){
            temp[k]=arr[j];
            j++;
            k++;
        }
        for(int n=l;n<=r;n++){
            arr[n]=temp[n];
        }
    }
}