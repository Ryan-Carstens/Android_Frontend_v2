package za.ac.cput.assignment6.repositories.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import za.ac.cput.assignment6.model.RegistryManager;
import za.ac.cput.assignment6.repositories.RestAPILogin;

/**
 * Created by sanXion on 2016/09/02.
 */
public class RestLoginAPI implements RestAPILogin{
    final String BASE_URL="";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();
    @Override
    public boolean loginRegistryManager(String username, String password) {
        final String url = BASE_URL+"user/"+username.toString() +"/"+password.toString();
        HttpEntity<RegistryManager> requestEntity = new HttpEntity<RegistryManager>(requestHeaders);
        try {
            ResponseEntity<RegistryManager> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, RegistryManager.class);
            RegistryManager registryManager = responseEntity.getBody();

            if (registryManager != null)
                return false;
            else
                return true;
        }catch(Exception e)
        {
            return false;
        }
    }
}
