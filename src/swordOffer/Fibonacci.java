package swordOffer;

import java.util.Date;

public class Fibonacci {
    public int fibonacci(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(new Fibonacci().fibonacci1(40));
        System.out.println(new Date());
    }

    public int fibonacci1(int target){
        int[] result = {0, 1};
        if (target < 2){
            return result[ target ];
        }
        int fibNMinusOne = 1;
        int fibNMinusTwo = 0;
        int fibN = 0;
        for (int i = 2; i <= target; i++) {
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }


}
