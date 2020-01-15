package test;

public class Test8{
    public static void main(String[] args) {
        String str = "a,b,c,,";
        if (str.charAt(str.length()-1) == ','){
            System.out.println(true);
        }
        String[] ary = str.split(",");
        // 预期大于 3，结果是 3
        System.out.println(ary.length);
    }
}