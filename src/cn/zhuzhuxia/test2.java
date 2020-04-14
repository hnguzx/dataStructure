package cn.zhuzhuxia;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        sum();
    }
    public static void sum(){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int n = sc.nextInt();
            int result = 0;
            if(n>0){
                while(n>1) {
                    result += n / 3;
                    n = n % 3 + n / 3;
                    if (n == 2) {
                        n++;
                    }
                }
            }
            System.out.println(result);
        }
        sc.close();
    }
}
