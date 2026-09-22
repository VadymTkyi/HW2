import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // methods / functions declaration
    public static void printMenu(){
        System.out.println("What action do you want to do with created array?\n1) Bubble sort \n2) Merge sort\n3) Linear Search \n4) Binary Search");
    }
    public static void printOriginalArray(int[] array){
        System.out.println("\nOriginal array\n"+Arrays.toString(array));
    }
    public static int[] createRNGArray(int size){//creating data set
        int[] array = new int[size];
        for( int i =0;i<size;i++) {
            int random = (int) ((Math.random() * 100) + 1);//getting random number
            array[i] = random;
        }
        return array;
    }
    public static int[] bubbleSort(int[] array){//bubble sort
        for (int i = 0;i<array.length-1;i++){
            for (int j = 0;j<array.length-1-i;j++){
                if (array[j]>array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
    public static int[] runMergeSort(int[] array){//so user does not need to manually enter starting and ending value
       return mergeSort(array,0,array.length-1);
    }
    private static int[] mergeSort(int[] array,int start , int end){//mergeSort
        if(start>=end){
            return null;
        }
        int mid = start+(end-start)/2;

        mergeSort(array,start,mid);
        mergeSort(array,mid+1,end);

        merge(array,start,mid,end);
        return array;
    }
    private static void merge(int[] array, int start,int mid,int end){
        int[] temp = new int[end-start+1];

        int left = start;
        int right = mid +1;
        int  tempIndex = 0;

        while (left <= mid && right <= end){
            if (array[left]<=array[right]){
                temp[tempIndex] = array[left];
                left++;
            }
            else {
                temp[tempIndex] = array[right];
                right++;
            }
            tempIndex++;
        }
        while (left<=mid){
            temp[tempIndex] = array[left];
            left++;
            tempIndex++;
        }
        while (right<=end){
            temp[tempIndex] = array[right];
            right++;
            tempIndex++;
        }
        for (int i = 0; i < temp.length;i++){
            array[start+i]= temp[i];
        }
    }
    public static int linearSearch(int[] array,int goal){//linear search
        for (int i = 0;i<array.length;i++){
            if (array[i]==goal) {
                return i;
            }
        }
        return -1;
    }
    private static int  binarySearch(int[] array,int goal,int start,int end){
            if (start>end){
                return -1;
            }
        int mid = start+(end-(start))/2;
        if (array[mid] == goal){
            return mid;
        }
        if (goal>array[mid]){
            return binarySearch(array,goal,mid+1,end);
        }
        return binarySearch(array,goal,start,mid-1);
    }
    public static int binarySearch(int[] array, int goal){//hardcoding some values that are necessary to run the binarySearch, and to not bother asking user for beginning and end each time
        return binarySearch(array,goal,0,array.length-1);
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the best Sorting/Searching program in the world\nLets Start with creating a data set for our tests\n" +
                "--Enter the amount of elements you want an array to contain");

        int size = input.nextInt();

        int[] ranArray = createRNGArray(size);//decided to make a random array since it will be more practical ? I guess
        System.out.println("\nYour array is "+Arrays.toString(ranArray));
        boolean inSystem = true;
        boolean isBubbleSorted = false;
        boolean isMergeSorted = false;
        int[] bubbleSortedArray = null;//temporaryContainers
        int[] mergeSortedArray = null;//temporaryContainers
        while (inSystem){

            printMenu();
            int choice = input.nextInt();
            switch (choice){
                case 1 : {//Bubble sort
                    printOriginalArray(ranArray);
                    bubbleSortedArray = bubbleSort(ranArray.clone());
                    System.out.println("\nbubble sorted array\n"+Arrays.toString(bubbleSortedArray));
                    isBubbleSorted = true;
                    break;
                }
                case 2 :{//merge sort
                    printOriginalArray(ranArray);
                    mergeSortedArray = runMergeSort(ranArray.clone());
                    System.out.println("\nmerge sorted array\n"+Arrays.toString(mergeSortedArray));
                    isMergeSorted = true;
                    break;
                }
                case 3 : {//linear search (with options)
                    printOriginalArray(ranArray);
                    System.out.println("\nDo you want to search 1) original 2) bubbleSorted array or 3) mergeSorted array?");
                    choice = input.nextInt();
                    switch (choice) {
                        case 1: {//linear search on unsorted array
                            System.out.println("\nEnter number that you want to search for");
                            int goal = input.nextInt();
                            int result = linearSearch(ranArray, goal);
                            if (result == -1) {
                                System.out.println("\nThe number does not belong to the given array");
                            } else {
                                System.out.println("\nYour number is on position " + (result + 1) + " or index " + result);
                            }
                            break;
                        }
                        case 2: {//linear search on sorted (bubble)
                            if (bubbleSortedArray == null) {
                                System.out.println("\nPlease bubble sort array first");
                                break;
                            } else {
                                System.out.println("\nBubble sorted array " + Arrays.toString(bubbleSortedArray));
                                System.out.println("\nEnter number that you want to search for");
                                int goal = input.nextInt();
                                int result = linearSearch(bubbleSortedArray, goal);
                                if (result == -1) {
                                    System.out.println("\nThe number does not belong to the given array");
                                } else {
                                    System.out.println("\nYour number is on position " + (result + 1) + " or index " + result);
                                }

                            }
                            break;
                        }
                        case 3: {
                            if (mergeSortedArray == null) {//linear search on sorted (merge)
                                System.out.println("\nPlease merge sort array first");
                                break;
                            } else {
                                System.out.println("\nMerge sorted array " + Arrays.toString(mergeSortedArray));
                                System.out.println("\nEnter number that you want to search for");
                                int goal = input.nextInt();
                                int result = linearSearch(mergeSortedArray, goal);
                                if (result == -1) {
                                    System.out.println("\nThe number does not belong to the given array");
                                } else {
                                    System.out.println("\nYour number is on position " + (result + 1) + " or index " + result);
                                }

                            }
                            break;
                            }
                        default:{
                            System.out.println("\nWrong choice try again");
                            break;
                          }
                        }
                    }
                    break;
                case 4 :{//binary search with options
                    System.out.println("\nDo you want to search 1) original 2) bubbleSorted array or 3) mergeSorted array?");
                        choice = input.nextInt();
                        switch (choice){
                            case 1:{
                                System.out.println("\nYou can't binary search unsorted array");
                                break;
                            }
                            case 2:{
                                if (isBubbleSorted){
                                    System.out.println("\nsorted array is " + Arrays.toString(bubbleSortedArray));
                                    System.out.println("\n What number are you looking for?");
                                    int goal = input.nextInt();
                                    int result = binarySearch(bubbleSortedArray,goal);
                                    if (result == -1) {
                                        System.out.println("\nThe number does not belong to the given array");
                                    } else {
                                        System.out.println("\nYour number is on position " +(result+1)+" or index "+result);
                                    }
                                }
                                else {
                                    System.out.println("\nBubble sort array first");
                                }
                                break;
                            }
                            case 3:{
                                if (isMergeSorted) {
                                    System.out.println("\nsorted array is " + Arrays.toString(mergeSortedArray));
                                    System.out.println("\n What number are you looking for?");
                                    int goal = input.nextInt();
                                    int result = binarySearch(mergeSortedArray, goal);
                                    if (result == -1) {
                                        System.out.println("\nThe number does not belong to the given array");
                                    } else {
                                        System.out.println("\nYour number is on position " + (result + 1) + " or index " + result);
                                    }
                                }else {
                                    System.out.println("\nMerge Sort array first");
                                }
                                break;
                            }

                        }
                        break;
                }
                default:{
                    System.out.println("\nEnter valid choice");
                    break;
                }
            }
        }
    }
}