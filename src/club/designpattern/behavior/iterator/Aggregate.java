package club.designpattern.behavior.iterator;

import java.util.Objects;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 11:05
 * @describe
 */
public interface Aggregate {

    public void add(Object o);

    public void remove(Object o);

    public Iterator getIterator();
}
