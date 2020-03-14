package cn.guzx.algorithm.sort;

public class Demo {
    public static void main(String[] args) {
        int[] orgin = new int[8];
        orgin[0] = 1;
        orgin[1] = 22;
        orgin[2] = 8;
        orgin[3] = 7;
        orgin[4] = 6;
        orgin[5] = 5;
        orgin[6] = 3;
        orgin[7] = 2;

        System.out.println("排序前：");
        for (int i : orgin) {
            System.out.print(i + " ");
        }
        System.out.println();

        // bubb(orgin);
        select(orgin);

        System.out.println("排序后：");
        for (int i : orgin) {
            System.out.print(i + " ");
        }

    }

    public static void bubb(int[] orgin) {
        int temp = 0;
        for (int i = 0; i < orgin.length; i++) {
            for (int j = i + 1; j < orgin.length; j++) {
                if (orgin[i] > orgin[j]) {
                    temp = orgin[i];
                    orgin[i] = orgin[j];
                    orgin[j] = temp;
                }
            }
        }
    }

    public static void select(int[] orgin) {
        int temp = 0;
        for (int i = 0; i < orgin.length; i++) {
            temp = orgin[i];
            for (int j = i; j < orgin.length; j++) {
                if (orgin[j] < temp) {
                    int  t = temp;
                    temp = orgin[j];
                    orgin[j] = t;
                }
            }
            orgin[i] = temp;
        }

    }

}