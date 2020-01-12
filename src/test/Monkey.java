package test;

/**
 * Author: Zhang Yan
 * Date: 19-8-14 下午9:05
 * Content:
 */

//a,,1,"b,"""
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Monkey{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        List<String> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        if(s!=null){
            boolean flag=false;
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(c==','){
                    if(flag){
                        sb.append(',');
                    }else{
                        if(sb.length()==0){
                            list.add("--");
                        }else{
                            list.add(sb.toString());
                        }
                        sb=new StringBuilder();
                    }
                }else if(c=='"'){
                    if(i+1<s.length() && s.charAt(i+1)=='"'){
                        sb.append('"');
                        i++;
                    }else if(flag){
                        list.add(sb.toString());
                        sb=new StringBuilder();
                        flag=false;
                    }else{
                        flag=true;
                    }
                }else{
                    sb.append(c);
                }
            }
            if(sb.length()!=0){
                list.add(sb.toString());
            }
            if(flag){
                System.out.println("ERROR");
            }else{
                System.out.println(list.size());
                for(String str:list){
                    System.out.println(str);
                }
            }
        }
    }
}