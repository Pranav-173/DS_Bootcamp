/*
// Bubble Sort :
import java.util.Scanner;
import java.util.Arrays;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : "+ Arrays.toString(arr));
        bubblesort(arr);
        System.out.println("Sorted array : "+ Arrays.toString(arr));
    }
    public static void bubblesort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
*//*
// Insertion sort :
import java.util.Scanner;
import java.util.Arrays;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : "+ Arrays.toString(arr));
        insertionsort(arr);
        System.out.println("Sorted array : "+ Arrays.toString(arr));
    }
    public static void insertionsort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
*//*
// Selection sort:
import java.util.Scanner;
import java.util.Arrays;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : "+ Arrays.toString(arr));
        selectionsort(arr);
        System.out.println("Sorted array : "+ Arrays.toString(arr));
    }
    public static void selectionsort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1;i++){
            int min_index = i;
            for(int j = i + 1;j < n;j++){
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
    }
}
*//*
// Quick Sort:
import java.util.Scanner;
import java.util.Arrays;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : "+ Arrays.toString(arr));
        quicksortrecursion(arr,0,n-1);
        System.out.println("Sorted Array : "+Arrays.toString(arr));
    }
    public static int partition(int[] arr, int low,int high){
        int pivot = arr[(low + high)/2];
        while(low <= high){
            while(arr[low] < pivot){
                low++;
            }
            while(arr[high] > pivot){
                high--;
            }
            if(low <= high){
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        return low;
    }
    public static void quicksortrecursion(int[] arr, int low, int high){
        int pi = partition(arr,low,high);
        if(low < pi-1){
            quicksortrecursion(arr,low,pi-1);
        }
        if(high > pi){
            quicksortrecursion(arr,pi,high);
        }
    }
}
*//*
// Merge Sort : 
import java.util.Scanner;
import java.util.Arrays;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : "+ Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array   : " + Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
*//*
// Radix Sort :
import java.util.Scanner;
import java.util.Arrays;
public class Bootcamp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements : ");
        int[] arr = new int[n];
        for(int i = 0 ; i<n;i++ ){
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : "+Arrays.toString(arr));
        radixsort(arr);
        System.out.println("Sorted array : "+Arrays.toString(arr));     
    }
    public static void radixsort(int[] arr){
        int n = arr.length;
        int next;
        for i : arr{
            int next = arr[i]%10;
        }
    }
}
*/