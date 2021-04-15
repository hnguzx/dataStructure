package club.designpattern.creative;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/15 15:11
 * @describe
 */
public abstract class Builder {

    protected Computer computer = new Computer();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    public Computer getResult(){
        return computer;
    }
}
