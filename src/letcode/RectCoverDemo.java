package letcode;


/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCoverDemo {


    /**
     * 当 n 为 1 时，只有一种覆盖方法：
     *
     *
     *
     * 当 n 为 2 时，有两种覆盖方法：
     *
     *
     *
     * 要覆盖 2*n 的大矩形，可以先覆盖 2*1 的矩形，再覆盖 2*(n-1) 的矩形；或者先覆盖 2*2 的矩形，再覆盖 2*(n-2) 的矩形。而覆盖 2*(n-1) 和 2*(n-2) 的矩形可以看成子问题。该问题的递推公式如下：
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if( target <= 2){
            return target;
        }
        int pre1 = 1, pre2 = 2,result = 0;
        for (int i = 3; i <= target; i++){
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;

        }
        return result;
    }
}
