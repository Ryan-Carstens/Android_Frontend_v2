package za.ac.cput.assignment6.model;

/**
 * Created by sanXion on 2016/09/02.
 */
public class FullNameDetails {
    private String firstname;
    private String lastname;

    public FullNameDetails()
    {

    }

    public FullNameDetails(String firstname, String lastname)
    {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
