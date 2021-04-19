package club.designpattern.structural.facade;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 16:00
 * @describe
 */
public class Facade {

    SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();

    public void allFunction(){
        subSystem1.system1Funciton();
        subSystem2.system2Funciton();
    }
}
