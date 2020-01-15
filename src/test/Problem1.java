package test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Author: Zhang Yan
 * Date: 19-8-7 下午7:10
 * Content:
 */
public class Problem1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String full = in.nextLine();
        String[] character = full.split("@");
        if (character.length == 1){
            System.out.println(full);
        } else {
            String[] left = character[0].split(",");
            String[] right  = character[1].split(",");
            Map<Character, Integer> leftMap = new LinkedHashMap<Character, Integer>();
            Map<Character, Integer> rightMap = new LinkedHashMap<Character, Integer>();
            for (int i = 0; i < left.length; i++){
                leftMap.put(left[i].charAt(0),Integer.parseInt("" +left[i].charAt(2)));
            }
            for (int i = 0; i < right.length; i++){
                rightMap.put(right[i].charAt(0),Integer.parseInt("" +right[i].charAt(2)));
            }
            int flag = 1;
            for (Map.Entry<Character, Integer> entry : leftMap.entrySet()) {
                char leftKey = entry.getKey();
                int leftValue = entry.getValue();
                if (rightMap.containsKey(entry.getKey())){
                    int rightValue = rightMap.get(leftKey);
                    if (leftValue >= rightValue){
                        leftMap.put(leftKey,leftValue - rightValue);
                    }else{
                        leftMap.put(leftKey,0);
                    }
                    flag = 0;
                }
            }

            StringBuilder out = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : leftMap.entrySet()){
                if (entry.getValue() != 0){
                    out.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
                }
            }
            out.deleteCharAt(out.length()-1);
            if (flag == 1){
                out.append("@");
            }

            System.out.println(out.toString());
        }
    }
}
