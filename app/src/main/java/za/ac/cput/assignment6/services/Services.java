package za.ac.cput.assignment6.services;

import java.util.List;

/**
 * Created by sanXion on 2016/09/02.
 */
public interface Services<S, ID> {
    public S findById(ID id);

    public String save(S entity);

    public String update(S entity);

    public String delete(S entity);

    public List<S> findAll();
}
