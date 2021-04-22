package club.designpattern.behavior.iterator;

import java.util.List;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 11:05
 * @describe
 */
public class Concretelterator implements Iterator {

    private List<Object> list = null;
    private int index = -1;

    public Concretelterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public Object first() {
        return list.get(0);
    }

    @Override
    public Object next() {
        Object object = null;
        if (this.hasNext()) {
            object = list.get(++index);
        }
        return object;
    }

    @Override
    public boolean hasNext() {
        if (index < list.size() - 1) {
            return true;
        }
        return false;
    }
}
