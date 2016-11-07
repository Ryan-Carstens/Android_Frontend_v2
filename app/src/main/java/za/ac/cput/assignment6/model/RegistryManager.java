package za.ac.cput.assignment6.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanXion on 2016/09/02.
 */
public class RegistryManager {
    private Long resId;
    private String southAfricanID;
    private FullNameDetails fullNameDetails;
    private LoginDetails loginDetails;
    private List<RegistrationEntry> registrationEntries;

    public RegistryManager()
    {

    }

    public RegistryManager(Long resId, String southAfricanID, FullNameDetails fullNameDetails, LoginDetails loginDetails, List<RegistrationEntry> registrationEntries) {
        if(resId > 1)
        {
            this.resId = resId;
        }
        else
        {
         this.resId = getRandom9DigitId();
        }
        this.southAfricanID = southAfricanID;
        this.fullNameDetails = fullNameDetails;
        this.loginDetails = loginDetails;
        this.registrationEntries = registrationEntries;
    }

    public Long getResId() {
        return resId;
    }

    public void setResId(Long resId) {
        this.resId = resId;
    }

    public String getSouthAfricanID() {
        return southAfricanID;
    }

    public void setSouthAfricanID(String southAfricanID) {
        this.southAfricanID = southAfricanID;
    }

    public FullNameDetails getFullNameDetails() {
        return fullNameDetails;
    }

    public void setFullNameDetails(FullNameDetails fullNameDetails) {
        this.fullNameDetails = fullNameDetails;
    }

    public LoginDetails getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(LoginDetails loginDetails) {
        this.loginDetails = loginDetails;
    }

    public List<RegistrationEntry> getRegistrationEntries() {
        return registrationEntries;
    }

    public void setRegistrationEntries(List<RegistrationEntry> registrationEntries) {
        this.registrationEntries = registrationEntries;
    }

    public long getRandom9DigitId()
    {
        long number=0;
        int i=0;

        while(i<10000)
        {
            number = (long) (Math.floor(Math.random() * 999999999D) + 100000000L);
            System.out.println(number);
            i++;
        }

        return number;
    }
}