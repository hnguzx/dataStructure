package cn.guzx.algorithm.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        int origin[] = new int[10];
        for(int i=0;i<10;i++){
            origin[i] = i*2;
        }
        origin[7] = 15;
        System.out.println(Arrays.toString(origin));
//        int index = linearFind(origin,2);
//        int index = halfFind(origin,0,origin.length-1,2);
//        List<Integer> index = halfFind2(origin,0,origin.length-1,2);
        int index = interpolationFind(origin,0,origin.length-1,15);
        System.out.println(index);
    }

    // 线性查找
    public static int linearFind(int[] origin,int value){
        for(int i=0;i<origin.length;i++){
            if(origin[i]==value){
                return i;
            }
        }
        return -1;
    }

    // 二分查找，查找单值
    public static int halfFind(int[] origin,int left,int right,int value){
        int mid = (left+right)/2;
        if(left>right){
            return -1;
        }
        if (value<origin[mid]){
            return halfFind(origin,left,mid-1,value);
        }else if(value>origin[mid]){
            return halfFind(origin,mid+1,right,value);
        }else{
            return mid;
        }
    }

    // 二分查找，查找多值
    public static List<Integer> halfFind2(int[] origin, int left, int right, int value){
        int mid = (left+right)/2;
        if(left>right){
            return new ArrayList<Integer>();
        }
        if (value<origin[mid]){
            return halfFind2(origin,left,mid-1,value);
        }else if(value>origin[mid]){
            return halfFind2(origin,mid+1,right,value);
        }else{
            List<Integer> results = new ArrayList<Integer>();

            int temp = mid-1;
            while (true){
                if(temp<0|| origin[temp] != value){
                    break;
                }
                results.add(temp);
                temp--;
            }

            results.add(mid);

            temp = mid+1;
            while (true){
                if(temp>origin.length-1|| origin[temp] != value){
                    break;
                }
                results.add(temp);
                temp++;
            }

            return results;
        }
    }

    // 插值查找
    public static int interpolationFind(int[] origin,int left,int right, int value){
        System.out.println("查找");
        if(left>right || value>origin[origin.length-1] || value<origin[0]){
            return -1;
        }
        int sign = left+ (right-left)*(value-origin[left])/(origin[right]-origin[left]);

        if (value>origin[sign]){
            return interpolationFind(origin,sign+1,right,value);
        }else if(value<origin[sign]){
            return interpolationFind(origin,left,sign-1,value);
        }else{
            return sign;
        }
    }

}
