package club.designpattern.behavior.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 11:37
 * @describe
 */
public class ObjectStructure {

    private List<Element> elements = new ArrayList<Element>();

    public void accept(Visitor visitor) {
        Iterator<Element> iterator = elements.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(visitor);
        }
    }

    public void add(Element element) {
        elements.add(element);
    }

    public void remove(Element element) {
        elements.remove(element);
    }
}
