package C02GettingStarted;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    public static int[] randomNumber(int n){
        int randomNumberArray[] = new int[n];
        for(int i = 0; i < n ; i++){
            randomNumberArray[ i ] = new Random().nextInt(15);
        }
        return randomNumberArray;
    }

    public static int[] insert(int[] a){
        int i, j ,key;
        for(j = 1; j < a.length; j++){
            key = a[j];
            i = j - 1;
            while (i >= 0 && a[ i ] < key){
                a[ i + 1] = a[ i ];
                i--;
            }
            a[i + 1] = key;
        }
        return a;
    }

    public static void main(String[] args) {
        int a[] = randomNumber(10);
        System.out.println(Arrays.toString(a));
        insert(a);
        System.out.println(Arrays.toString(a));

    }
}
