package C02GettingStarted;

import java.util.Arrays;

public class MergeSort {

    public static final int MAX = 65535;

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+"  ");
        }
    }

    public static void merge(int[] A, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q ;
        //System.out.println("n1"+n1+"n2"+n2);
        int L[] = new int[n1 + 1];
        int R[] = new int[n2 + 1];
        L[n1] = MAX;
        R[n2] = MAX;
        int i, j, k;
        for (i = 0; i < n1; i++){
            L[i] = A[p + i];
            //System.out.println("Li"+L[i]);
        }
        for (j = 0; j < n2; j++){
            R[j] = A[q + j];
        }
        i = 0;
        j = 0;
        for (k = p; p <= r; p++){
            if (L[i] <= R[j]){
                A[k] = L[i];
                i++;
            }else {
                A[k] = R[j];
                j++;
            }
        }
    }

    public static int[] merge_sort(int[] A, int p, int r){
        int q;
        if(p < r){
            q = (p + r)/2;
            merge_sort(A, p, q);
            merge_sort(A, q+1, r);
            merge(A, p, q, r);
        }
        return A;
    }

    public static void main(String[] args) {
        int[] a = {2,3,9,6,5,1,0,5,4,8};
        System.out.println(Arrays.toString(a));
        merge_sort(a, 0, 9);
        System.out.println(Arrays.toString(a));
    }
}
