package swordOffer;

/**
 * @author zyan
 * @version 1.0
 * @date 20-1-6 下午2:38
 */
public class SpaceToAscii {
    
    public String replaceSpace(StringBuffer str){
        int numberOfBlank = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                numberOfBlank++;
            }
        }
        int newLength = str.length() + numberOfBlank * 2;
        int indexOld = str.length() - 1;
        int indexNew = newLength - 1;
        str.setLength(newLength);
        while (indexOld >= 0 && indexOld < newLength){
            if (str.charAt(indexOld) == ' '){
                str.setCharAt(indexNew, '0');
                indexNew--;
                str.setCharAt(indexNew, '2');
                indexNew--;
                str.setCharAt(indexNew, '%');
                indexNew--;
            }else {
                str.setCharAt(indexNew, str.charAt(indexOld));
                indexNew--;
            }
            indexOld--;
        }

        return str.toString();

    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("hello world");
        System.out.println(new SpaceToAscii().replaceSpace(stringBuffer));
    }
}
