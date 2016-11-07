package za.ac.cput.assignment6.services.Impl;

import za.ac.cput.assignment6.model.RegistryManager;
import za.ac.cput.assignment6.repositories.RestAPISignup;
import za.ac.cput.assignment6.repositories.rest.RestSignUpAPI;
import za.ac.cput.assignment6.services.SignupService;

/**
 * Created by sanXion on 9/26/2015.
 */
public class SignUpServiceImpl implements SignupService {
    final RestAPISignup rest = new RestSignUpAPI();

    @Override
    public String signUp_RegistryManager(RegistryManager entity) {
        return rest.signUp_RegistryManager(entity);
    }
}
