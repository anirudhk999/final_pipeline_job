package sortingalgo;
import java.io.FileWriter;
import java.io.IOException;
import java.math.*;
import java.lang.reflect.Array;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void bubbleSort(int[] arr, boolean reverse) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((!reverse && arr[j] > arr[j + 1]) || (reverse && arr[j] < arr[j + 1])) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
 
    public static void selectionSort(int[] arr, boolean reverse) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int extremeIndex = i;
            for (int j = i + 1; j < n; j++) {
                if ((!reverse && arr[j] < arr[extremeIndex]) || (reverse && arr[j] > arr[extremeIndex])) {
                    extremeIndex = j;
                }
            }
            int temp = arr[extremeIndex];
            arr[extremeIndex] = arr[i];
            arr[i] = temp;
        }
    }
 
    public static void insertionSort(int[] arr, boolean reverse) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && ((!reverse && arr[j] > key) || (reverse && arr[j] < key))) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
 
    public static void mergeSort(int[] arr, boolean reverse) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
 
            mergeSort(left, reverse);
            mergeSort(right, reverse);
 
            merge(arr, left, right, reverse);
        }
    }
 
    private static void merge(int[] arr, int[] left, int[] right, boolean reverse) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if ((!reverse && left[i] <= right[j]) || (reverse && left[i] >= right[j])) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void quickSort(int[] arr, boolean reverse) {
        quickSort(arr, 0, arr.length - 1, reverse);
    }
 
    private static void quickSort(int[] arr, int low, int high, boolean reverse) {
        if (low < high) {
            int pi = partition(arr, low, high, reverse);
            quickSort(arr, low, pi - 1, reverse);
            quickSort(arr, pi + 1, high, reverse);
        }
    }
 
    private static int partition(int[] arr, int low, int high, boolean reverse) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if ((!reverse && arr[j] < pivot) || (reverse && arr[j] > pivot)) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void sortAlgoStats()
    {
        List<Double> mergeSortAnalytics = new ArrayList<Double>();
        List<Double> quickSortAnalytics = new ArrayList<Double>();
        List<Double> bubbleSortAnalytics = new ArrayList<Double>();
        List<Double> selectionSortAnalytics = new ArrayList<Double>();
        List<Double> insertionSortAnalytics = new ArrayList<Double>();

        int MIN_LIST_LENGTH = 1000;
        int MAX_LIST_LENGTH = 10000;

        //mergeSort
        for(int i = MIN_LIST_LENGTH; i < MAX_LIST_LENGTH; i = i + 1000)
        {
            List<Integer> numbers = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                numbers.add(j);
            }

            Collections.shuffle(numbers);
            int[] nums = new int[numbers.size()];
            for(int k = 0; k < numbers.size(); k++)
            {
                nums[k] = numbers.get(k);
            }
            
            double start = (System.nanoTime()) / 1000 ;
            mergeSort(nums, false);
            double end = (System.nanoTime()) / 1000 ;
            double elapsedTime = end - start;
            mergeSortAnalytics.add(elapsedTime);
        }

        System.out.println(mergeSortAnalytics);

        //quickSort
        for(int i = MIN_LIST_LENGTH; i < MAX_LIST_LENGTH; i = i + 1000)
        {
            List<Integer> numbers = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                numbers.add(j);
            }

            Collections.shuffle(numbers);
            int[] nums = new int[numbers.size()];
            for(int k = 0; k < numbers.size(); k++)
            {
                nums[k] = numbers.get(k);
            }
            
            double start = (System.nanoTime()) / 1000 ;
            quickSort(nums, false);
            double end = (System.nanoTime()) / 1000 ;
            double elapsedTime = end - start;
            quickSortAnalytics.add(elapsedTime);
        }

        System.out.println(quickSortAnalytics);

        //bubbleSort
        for(int i = MIN_LIST_LENGTH; i < MAX_LIST_LENGTH; i = i + 1000)
        {
            List<Integer> numbers = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                numbers.add(j);
            }

            Collections.shuffle(numbers);
            int[] nums = new int[numbers.size()];
            for(int k = 0; k < numbers.size(); k++)
            {
                nums[k] = numbers.get(k);
            }
            
            double start = (System.nanoTime()) / 1000 ;
            bubbleSort(nums, false);
            double end = (System.nanoTime()) / 1000 ;
            double elapsedTime = end - start;
            bubbleSortAnalytics.add(elapsedTime);
        }

        System.out.println(bubbleSortAnalytics);

        //selection sort
        for(int i = MIN_LIST_LENGTH; i < MAX_LIST_LENGTH; i = i + 1000)
        {
            List<Integer> numbers = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                numbers.add(j);
            }

            Collections.shuffle(numbers);
            int[] nums = new int[numbers.size()];
            for(int k = 0; k < numbers.size(); k++)
            {
                nums[k] = numbers.get(k);
            }
            
            double start = (System.nanoTime()) / 1000 ;
            selectionSort(nums, false);
            double end = (System.nanoTime()) / 1000 ;
            double elapsedTime = end - start;
            selectionSortAnalytics.add(elapsedTime);
        }

        System.out.println(selectionSortAnalytics);

        //insertion sort
        for(int i = MIN_LIST_LENGTH; i < MAX_LIST_LENGTH; i = i + 1000)
        {
            List<Integer> numbers = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                numbers.add(j);
            }

            Collections.shuffle(numbers);
            int[] nums = new int[numbers.size()];
            for(int k = 0; k < numbers.size(); k++)
            {
                nums[k] = numbers.get(k);
            }
            
            double start = (System.nanoTime()) / 1000 ;
            insertionSort(nums, false);
            double end = (System.nanoTime()) / 1000 ;
            double elapsedTime = end - start;
            insertionSortAnalytics.add(elapsedTime);
        }

        System.out.println(insertionSortAnalytics);
    }
  
    public static void main(String[] args) {
        sortAlgoStats();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the numbers to sort (space-separated):");
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
        int[] arr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }
 
        System.out.println("Choose sorting algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Quick Sort");
        int choice = scanner.nextInt();
 
        System.out.println("Sort in descending order? (true/false):");
        boolean reverse = scanner.nextBoolean();
 
        long startTime = System.nanoTime();
 
        switch (choice) {
            case 1:
                bubbleSort(arr, reverse);
                break;
            case 2:
                selectionSort(arr, reverse);
                break;
            case 3:
                insertionSort(arr, reverse);
                break;
            case 4:
                mergeSort(arr, reverse);
                break;
            case 5:
                quickSort(arr, reverse);
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }
 
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;  // Convert to milliseconds
 
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Time taken: " + duration + " ms");
 
        scanner.close();
    }
}
