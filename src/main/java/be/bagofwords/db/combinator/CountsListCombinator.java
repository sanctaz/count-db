package be.bagofwords.db.combinator;

import be.bagofwords.db.data.CountsList;
import be.bagofwords.exec.RemoteClass;

import java.io.Serializable;

@RemoteClass
public class CountsListCombinator implements Combinator<CountsList>, Serializable {

    @Override
    public CountsList combine(CountsList first, CountsList second) {
        CountsList result = new CountsList(first);
        result.addAll(second);
        result.compact();
        return result;
    }

}

