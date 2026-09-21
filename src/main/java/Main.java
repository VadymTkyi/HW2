import java.util.Arrays;

public class Main {
    // methods / functions declaration
    public static int[] createRNGArray(int size){
        int[] array = new int[size];
        for( int i =0;i<size;i++) {
            int random = (int) ((Math.random() * 100) + 1);//getting a random numbers
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
    public static void mergeSort(int[] array){

    }
    public static void main(String[] args){

        int[] ranArray = createRNGArray(10);//decided to make a random array since it will be more practical ? I guess

        System.out.println(Arrays.toString(ranArray));
        int[] bubbleSortedArray = bubbleSort(ranArray.clone());
        System.out.println(Arrays.toString(bubbleSortedArray));

    }
}