package Model;

/**
 *
 * @author jorge
 */
public class Address {
    
    /**
     * Street of the Address
     */
    private String street;
    
    /**
     * Door number of the Address
     */
    private int doorNumber;
    
    /**
     * Locality of the Address
     */
    private String locality;

    /**
     * Address of the Postal Address by omission
     */
    private static final String STREET_BY_OMISSION = "no street";
    
    /**
     * Door number of the Address by omission
     */
    private static final int DOORNUMBER_BY_OMISSION = 0;
    
    /**
     * Locality of the Postal Address by omission
     */
    private static final String LOCALITY_BY_OMISSION = "no locality";

    
    /**
     * Builds an instance of Address that receives the street, the door number
     * and the locality
     * 
     * @param street the street of the Address
     * @param doorNumber the door number of the Address
     * @param locality the locality of the Address
     */
    public Address(String street, int doorNumber, String locality) {
        this.street = street;
        this.doorNumber = doorNumber;
        this.locality = locality;
    }

    /**
     * Builds and instance of Address with the omission values
     */
    public Address() {
        street = STREET_BY_OMISSION;
        doorNumber = DOORNUMBER_BY_OMISSION;
        locality = LOCALITY_BY_OMISSION;
    }
    
    /**
     * Builds an instance of Address that is copy of the one passed by parameter
     * @param otherAddress Address that is copied
     */
    public Address(Address otherAddress) {
        this.street = otherAddress.street;
        this.doorNumber = otherAddress.doorNumber;
        this.locality = otherAddress.locality;
    }

    /**
     * Returns the street of the Address
     * @return street of the Address
     */
    public String getStreet() {
        return street;
    }

    /**
     * Returns the doorNumber of the Address
     * @return door number of the Address
     */
    public int getDoorNumber() {
        return doorNumber;
    }

    /**
     * Returns the locality of the Address
     * @return 
     */
    public String getLocality() {
        return locality;
    }
    
    
    
    
    
    
}
