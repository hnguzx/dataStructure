package club.designpattern.creative.builder;

import club.designpattern.creative.builder.Builder;
import club.designpattern.creative.builder.Computer;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/15 15:31
 * @describe
 */
public class Director {
    private Builder builder;

    public Director(){}

    public Director(Builder builder){
        this.builder = builder;
    }

    public Computer construct(){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
