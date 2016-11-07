package za.ac.cput.assignment6.repositories;

import java.util.List;

/**
 * Created by sanXion on 2016/09/02.
 */
public interface RestAPI<S, ID> {
    S get(ID id);

    String post(S entity);

    String put(S entity);

    String delete(S entity);

    List<S> getAll();
}
