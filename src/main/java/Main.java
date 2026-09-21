import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // methods / functions declaration
    public static void printMenu(){
        System.out.println("What action do you want to do with created array?\n1)Bubble sort \n2) Merge sort\n3) Linear Search \n4) Binary Search");
    }
    public static void printOriginalArray(int[] array){
        System.out.println("\nOriginal array\n"+Arrays.toString(array));
    }
    public static int[] createRNGArray(int size){
        int[] array = new int[size];
        for( int i =0;i<size;i++) {
            int random = (int) ((Math.random() * 100) + 1);//getting random number
            array[i] = random;
        }
        return array;
    }
    public static int[] bubbleSort(int[] array){
        for (int i = 0;i<array.length-1;i++){
            for (int j = i+1;j<array.length;j++){
                if (array[i]>array[j]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }
    public static void mergeSort(int[] array,int left , int right){

    }
    public static void merge(){

    }
    public static int linearSearch(int[] array,int goal){
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
        return binarySearch(array,goal,0,mid-1);
    }
    public static int binarySearch(int[] array, int goal){
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
                case 1 : {
                    printOriginalArray(ranArray);
                    bubbleSortedArray = bubbleSort(ranArray.clone());
                    System.out.println("\nbubble sorted array\n"+Arrays.toString(bubbleSortedArray));
                    isBubbleSorted = true;
                    break;
                }
                case 2 :{

                    break;
                }
                case 3 : {
                    printOriginalArray(ranArray);
                    System.out.println("\nDo you want to search 1) original or 2) bubbleSorted array?");
                    choice = input.nextInt();
                    switch (choice){
                        case 1:{
                            System.out.println("\nEnter number that you want to search for");
                            int goal = input.nextInt();
                            int result = linearSearch(ranArray,goal);
                            if (result==-1){
                                System.out.println("\nThe number does not belong to the given array");
                            }
                            else {
                                System.out.println("\nYour number is on position " +(result+1)+" or index "+result);
                            }
                            break;
                        }
                        case 2:{
                            if (bubbleSortedArray==null){
                                System.out.println("\nPlease bubble sort array first");
                                break;
                            }
                            else {
                                System.out.println("\nBubble sorted array " + Arrays.toString(bubbleSortedArray));
                                System.out.println("\nEnter number that you want to search for");
                                int goal = input.nextInt();
                                int result = linearSearch(bubbleSortedArray, goal);
                                if (result == -1) {
                                    System.out.println("\nThe number does not belong to the given array");
                                } else {
                                    System.out.println("\nYour number is on position " +(result+1)+" or index "+result);
                                }

                            }
                            break;
                          }
                        }
                    }
                    break;
                case 4 :{
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
                            System.out.println("\nsort array first");
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