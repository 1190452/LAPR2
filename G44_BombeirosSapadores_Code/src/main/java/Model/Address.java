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
    private String doorNumber;
    
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
    private static final String DOORNUMBER_BY_OMISSION = "0";
    
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
    public Address(String street, String doorNumber, String locality) {
        setStreet(street);
        setDoorNumber(doorNumber);
        setLocality(locality);
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
    public String getDoorNumber() {
        return doorNumber;
    }

    /**
     * Returns the locality of the Address
     * @return locality of the Address
     */
    public String getLocality() {
        return locality;
    }
    
    /**
     * Changes the street of the Address
     * @param street the new Street of the Address
     */
    public final void setStreet(String street) {
        if (street == null || street.isEmpty())
            throw new IllegalArgumentException("The street should not be empty or null.");
        this.street = street;
    }

    /**
     * Changes the door number of the Address
     * @param doorNumber the new Door Number of the Address
     */
    public final void setDoorNumber(String doorNumber) {
        if (Integer.parseInt(doorNumber) < 0)
            throw new IllegalArgumentException("The door number is invalid.");
        this.doorNumber = doorNumber;
    }

    /**
     * Changes the locality of the Address
     * @param locality the new Locality of the Address
     */
    public final void setLocality(String locality) {
        if (locality == null || locality.isEmpty()) 
            throw new IllegalArgumentException("The locality should not be empty or null");
        this.locality = locality;
    }
    
    
    /**
     * Compares 2 Address objects through street, door number and locality with both objects being considered equal only when these 3 parameteres are the same
     *
     * @param otherObject object to be compared with the object that calls the method
     * @return true, if the references of both objects being compared are pointing at the same object false, if the compared object is null or the class of the objects are different true, if address, locality and postCode of both objects are the same
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        Address otherAddress = (Address) otherObject;
        return this.street.equalsIgnoreCase(otherAddress.street)
                && this.doorNumber.equals(otherAddress.doorNumber) 
                && this.locality.equalsIgnoreCase(otherAddress.locality);
    }
    
    /**
     * Returns the characteristics of the Address
     * 
     * @return characteristics of the Address 
     */
    @Override
    public String toString() {
        return String.format("Street: %s, Door number: %s, Locality: %s\n", street, doorNumber, locality);
    } 
    
    
}
