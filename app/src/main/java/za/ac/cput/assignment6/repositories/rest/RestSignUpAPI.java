package za.ac.cput.assignment6.repositories.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import za.ac.cput.assignment6.model.RegistryManager;
import za.ac.cput.assignment6.repositories.RestAPISignup;

/**
 * Created by sanXion on 2016/09/02.
 */
public class RestSignUpAPI implements RestAPISignup {
    final String BASE_URL="";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public String signUp_RegistryManager(RegistryManager entity) {
        //DIRECT URL TO THIS SERVICE (API) ON BACKEND
        final String url = BASE_URL+"user/";
        //CREATES READ/WRITE OBJECT
        HttpEntity<RegistryManager> requestEntity = new HttpEntity<RegistryManager>(entity, requestHeaders);

        try {
            //WRITES TO THE BACKED
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
            //GETS RESPONSE FROM BACKED
            String result = responseEntity.getBody();
            return result;
        }catch (Exception e)
        {
            return "Exists";
        }
    }
}
