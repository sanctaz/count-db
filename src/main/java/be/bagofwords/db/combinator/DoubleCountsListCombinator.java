package be.bagofwords.db.combinator;

import be.bagofwords.db.data.DoubleCountsList;
import be.bagofwords.exec.RemoteClass;

import java.io.Serializable;

@RemoteClass
public class DoubleCountsListCombinator implements Combinator<DoubleCountsList>, Serializable {

    @Override
    public DoubleCountsList combine(DoubleCountsList first, DoubleCountsList second) {
        DoubleCountsList result = new DoubleCountsList(first);
        result.addAll(second);
        result.compact();
        return result;
    }

}
