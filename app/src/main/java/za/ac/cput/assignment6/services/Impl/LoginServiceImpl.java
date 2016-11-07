package za.ac.cput.assignment6.services.Impl;

import za.ac.cput.assignment6.repositories.RestAPILogin;
import za.ac.cput.assignment6.repositories.rest.RestLoginAPI;
import za.ac.cput.assignment6.services.LoginService;

/**
 * Created by sanXion on 2016/09/03.
 */
public class LoginServiceImpl implements LoginService {
    final RestAPILogin rest = new RestLoginAPI();

    @Override
    public boolean loginRegistryManager(String username, String password) {
        return rest.loginRegistryManager(username, password);
    }
}