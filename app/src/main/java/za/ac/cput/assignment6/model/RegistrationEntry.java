package za.ac.cput.assignment6.model;

/**
 * Created by sanXion on 2016/09/02.
 */
public class RegistrationEntry {
    private Long resId;
    private String southAfricanID;
    private String gender;
    private String placementChoice;

    public RegistrationEntry() {

    }

    public RegistrationEntry(Long resId, String southAfricanID, String gender, String placementChoice) {
        this.resId = resId;
        this.southAfricanID = southAfricanID;
        this.gender = gender;
        this.placementChoice = placementChoice;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPlacementChoice() {
        return placementChoice;
    }

    public void setPlacementChoice(String placementChoice) {
        this.placementChoice = placementChoice;
    }
}
