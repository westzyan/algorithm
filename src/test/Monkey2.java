package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
 * Author: Zhang Yan
 * Date: 19-8-14 下午7:34
 * Content:
 */
public class Monkey2 {

    public static ArrayList<Integer> searchAllIndex(String str, String key) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int a = str.indexOf(key);//*第一个出现的索引位置
        list.add(a);
        while (a != -1) {
//            System.out.print(a + "\t");
            a = str.indexOf(key, a + 1);//*从这个索引往后开始第一个出现的位置
            if (a != -1)
                list.add(a);

        }
        return list;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String input = in.nextLine();
            int count = 0;
            int index = 0;

            while ((index = input.indexOf("\"", index)) != -1) {
                count++;
                index = index + 1;
            }
            if (count % 2 == 1){
                System.out.println("ERROR");
            }else {
                ArrayList list = searchAllIndex(input, "\"");
                //System.out.println(list.size());


                for (int i = 0; i < list.size(); i ++){

                    if (input.charAt(Integer.parseInt(""+list.get(i))) == '"'){

                    }
                }
            }
            String[] subString = in.nextLine().split(",");

            System.out.println(subString.length);
        }

        String a = "a,,b,\"b,\"\"\"";

        List b = searchAllIndex(a ,"\"");
        for (int i = 0 ; i < b.size(); i++){
            System.out.println(b.get(i));
        }
    }
}
