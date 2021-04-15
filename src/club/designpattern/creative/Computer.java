package club.designpattern.creative;

import lombok.Data;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/15 15:27
 * @describe
 */
@Data
public class Computer {
    String partA;
    String partB;
    String partC;

    public void show(){
        System.out.println(partA+partB+partC);
    }
}
