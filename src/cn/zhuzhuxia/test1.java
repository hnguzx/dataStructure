package cn.zhuzhuxia;

import sun.util.locale.provider.JRELocaleProviderAdapter;

import java.io.*;
import java.util.*;

public class test1 {
    public static void main(String[] args) throws IOException {
        setMain();
        String openDay = ("2019-09-01").substring(8,10);
        System.out.println(openDay);
        readTxt();
    }
    public static void readTxt() throws IOException {
        File file = new File("src/cn/files/test.txt");
        Scanner read =new Scanner(file);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String aaa = br.readLine();
        int position=0;
        String[] bufstring=new String[1024];
        String line=null;
        while((line=br.readLine())!=null) {
            bufstring[position]=line;
            position++;
        }
        System.out.println(bufstring);
        System.out.println(aaa);
        String regex = "\t|\r|\n|\"|\\,|\\.|\\:|\\?|\\’";
        aaa = aaa.replaceAll(regex," ");
        System.out.println(aaa);
        Map<String,Integer> result = new HashMap<String,Integer>();
        String[] b= aaa.split(" ");
        System.out.println(b);
        for (int i=0;i<b.length;i++){
            if(b[i].equals(" ")){
                continue;
            }else{
                if(result.containsKey(b[i])){
                    result.put(b[i],result.get(b[i])+1);
                }else{
                    result.put(b[i],1);
                }
            }
        }
        for(String key:result.keySet()){
            if(result.get(key).equals(1)){
                System.out.println(key);
            }
        }
        System.out.println(result);
    }
    public  static  void setMain(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            char[] c= sc.next().toCharArray();
            StringBuffer sb = new StringBuffer();
            Set<Character> sd = new HashSet<>();
            for(int i=0;i<c.length;i++){
                if(sd.add(c[i])){
                    sb.append(c[i]);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
