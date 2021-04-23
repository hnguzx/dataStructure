package club.leetCode;

public class StringCompress {
    public static void main(String[] args) {
        // a2b1c5a3
        System.out.println("结果是：" + compress("aabcccccaaa"));
        System.out.println("结果是：" + compress2("aabcccccaaa"));
    }

    public static String compress(String S) {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int count = 1;
        char array[]=S.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int value = array[i];
            int j = i + 1;
            while (j < length) {
                if (value == array[j]) {
                    count++;
                    i++;
                    j++;
                } else {
                    break;
                }
            }

            temp.append((char) value + "" + count);
            result.append(temp);
            temp.delete(0,temp.length());
            count = 1;
        }
        return result.length() >= length ? S : result.toString();
    }

    public static String compress2(String S) {
        char array[] = S.toCharArray();
        int length = array.length;
        if (length < 3) {
            return S;
        }
        // 字符串变动频繁，推荐用StringBuffer或者StringBuilder
        StringBuilder result = new StringBuilder().append(array[0]);
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (array[i] == array[i-1]) {
                count++;
            } else {
                result.append(count).append(array[i]);
                count = 1;
            }
        }
        return result.length() >= length ? S : result.append(count).toString();
    }
}