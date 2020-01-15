package test;

import java.util.*;

/**
 * Author: Zhang Yan
 * Date: 19-8-7 下午8:34
 * Content:
 */
public class Problem2 {

    public static int maxSum(int[] arr){
                int i = 0;
                int max = 0;//数组中所有的元素都是正数
                int addValue;
                for(int j = 1; j < arr.length; j++){
                        addValue = arr[i] + arr[j];
            if(addValue > max)
                               max = addValue;
                         if(arr[j] - arr[i] > 0)
                                 i = j;//记录更大的arr[i]
                     }
                 return max;
             }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x, y = 0;
        int flag = 0;
        List<Integer> list = new ArrayList<>();
        for( int i = 0; i < n; i++){
            x = in.nextInt();
            y = in.nextInt();
            for(int j  = 0; j < x; j ++){
                list.add(new Integer(y));
            }


        }
        for( Integer a :list){
            System.out.println(a);
        }
        int[] ids_int = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ids_int[i] = list.get(i);
        }

        System.out.println(maxSum(ids_int));



    }
}
