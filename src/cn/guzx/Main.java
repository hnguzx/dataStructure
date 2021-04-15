package cn.guzx;


public class Main {
    public static void main(String[] args) {
//        abc,ab,ac,bc
        System.out.println(code("time,bell,bell,timeout"));
    }

    public static int code(String words) {
        String[] word = words.split(",");
        int length = word.length;
        String resultString = word[0] + "#";
        if (words.length() == 0) {
            return 0;
        }

        for (int i = 1; i < length; i++) {
            boolean flag = false;
            for (int j = 0; j < length; j++) {
                if (word[j].indexOf(word[i]) == -1) {
                    continue;
                } else if (word[i] == word[j]) {
                    break;
                } else if (word[j].indexOf(word[i]) + word[i].length() == word[j].length() && i != j) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                resultString = resultString + word[i] + "#";
            }
        }
        System.out.println(resultString);

        return resultString.length();
    }
}