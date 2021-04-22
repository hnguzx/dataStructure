package club.designpattern.behavior.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 10:20
 * @describe
 */
public class SimpleMediator {

    private static SimpleMediator simpleMediator = new SimpleMediator();

    private List<SimpleColleague> simpleColleagues = new ArrayList<SimpleColleague>();

    private SimpleMediator() {
    }

    public static SimpleMediator getSimpleMediator() {
        return simpleMediator;
    }

    public void register(SimpleColleague simpleColleague) {
        if (!simpleColleagues.contains(simpleColleague)) {
            simpleColleagues.add(simpleColleague);
        }
    }

    public void relay(SimpleColleague simpleColleague) {
        for (SimpleColleague sc : simpleColleagues) {
            if (!simpleColleague.equals(sc)) {
                sc.receive();
            }
        }
    }
}
