package cn.guzx;
public class temp {
    static int count =0;
    static int fib(int n){
        count++;
        if(n==0)
            return 1;
        else if(n==1)
            return 2;
        else
            return fib(n-1)+fib(n-2);
    }
    public static void main(String argv[]){

        fib(10);
        System.out.println(count);
    }
}
