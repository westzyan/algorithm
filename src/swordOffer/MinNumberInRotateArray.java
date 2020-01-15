package swordOffer;

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        int firstFlag = 0;
        int secondFlag = array.length - 1;
        int mid = 0;

        while (secondFlag - firstFlag != 1){
            mid = (secondFlag + firstFlag) / 2;
            if (array[ mid ] >= array[ firstFlag ]){
                firstFlag = mid;
            }else {
                secondFlag = mid;
            }

        }
        return array[ secondFlag ];
    }


    /**
     * 大佬的写法
     * @param array
     * @return
     */
    public int minNumberInRotateArray1(int[] array) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] < array[j]) {
                return array[i];
            }
            int mid = (i + j) >> 1;
            if (array[mid] > array[i]) {
                i = mid + 1;
            } else if (array[mid] < array[j]) {
                j = mid; // 如果是mid-1，则可能会错过最小值，因为找的就是最小值
            } else i++;  // 巧妙避免了offer书上说的坑点（1 0 1 1 1）
        }
        return array[i];
    }


    public static void main(String[] args) {
        int [] array = {4, 5, 6, 7, 8, 9, 1, 2, 3};
//        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(array));
//        System.out.println(10>>>1);

    }
}
