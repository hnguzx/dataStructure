/**
 * 分治算法
 */
package club.algorithm.commonAlgorithm;

public class SeparateResolve {
    public static void main(String[] args) {
        towerOfHanoi(5,'A','B','C');
    }

    /**
     *
     * @param number 未排序圆盘数量
     */
    public static void towerOfHanoi(int number, char A, char B, char C) {
        if (number == 1) {
            System.out.println("从" + A + "-->到" + C);
        }else{
            towerOfHanoi(number-1,'A','C','B');
            System.out.println("从"+A+"-->到"+C);
            towerOfHanoi(number-1,'B','A','C');
        }
    }
}
