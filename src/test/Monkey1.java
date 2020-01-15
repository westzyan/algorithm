package test;

import java.util.Scanner;

/**
 * Author: Zhang Yan
 * Date: 19-8-14 下午7:07
 * Content:
 */
public class Monkey1 {

    public static String binaryToDecimal(int n){
        String str = "";
        while(n!=0){
            str = n%2+str;
            n = n/2;
        }
//        System.out.println(str);
        return str;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String inputString = in.nextLine();
            int input = Integer.parseInt(inputString);
            String bin = binaryToDecimal(input);
            String des = "101";
            int index = 0;
            int count = 0;
            int a = 0, b = -1;
            while ((index = bin.indexOf(des, index)) != -1){
                count++;
                index = index + 1;
            }
            if (count == 0){
                System.out.println(a + " " + b);
            }else {
                bin = new StringBuffer(bin).reverse().toString();

                index = bin.indexOf(des);
            System.out.println(index);
                System.out.println(count + " " + index);
            }
        }

    }
}
