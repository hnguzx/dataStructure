package cn.zhuzhuxia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n= sc.nextInt();
            if(n>1000){
                n=999;
            }
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<n;i++){
                list.add(i);
            }
            int j=0;
            while(list.size()>1){
                j=(j+2)%list.size();
                list.remove(j);
            }
            System.out.println(list.get(0));
        }
    }
}
