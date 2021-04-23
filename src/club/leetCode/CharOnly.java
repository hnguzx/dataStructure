package club.leetCode;

public class CharOnly {
    public static void main(String[] args) {
        System.out.println(isOnly("abcb"));
    }

    public static boolean isOnly(String astr) {
        char newS[] = astr.toCharArray();
        int lenght = newS.length;
        int increment = lenght / 2;
        int index = 0;
        int value =0;
        while (increment>0){
            for (int i=increment;i<lenght;i++){
                index = i;
                value = newS[i];
                if(index<lenght){
                    while (index-increment>=0&&newS[index-increment]>value){
                        newS[index] = newS[index - increment];
                        index -= increment;
                    }
                    if(index-increment>=0&&newS[index-increment]==value){
                        return false;
                    }
                    newS[index] = (char) value;
                }
            }
            increment = increment/2;
        }
        return true;
    }
}
