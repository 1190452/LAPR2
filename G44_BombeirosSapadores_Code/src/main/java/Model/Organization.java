package Model;

/**
 *
 * @author paulomaio
 */
public class Organization
{

    public static Collaborator newCollaborator(String nameC, String funcaoC, String telefoneC, String emailC) {
          return new Collaborator(nameC, funcaoC, telefoneC, emailC);
    }

    public static Manager newManager(String nameM, String funcaoM, String telefoneM, String emailM) {
       return new Manager(nameM, funcaoM, telefoneM, emailM);
    }

    /**
     * The name of the Organization
     */
    private String name;
    
    /**
     * The email of the Organization
     */
    private String email;
    
    /**
     * The NIF of the Organization
     */
    private String NIF;
    
    /**
     * The manager of the Organization
     */
    private Manager manager;
    
    /**
     * The collaborator of the Organization
     */
    private Collaborator colab;
    
    /**
     * The name of the Organization by omission
     */
    private static String NAME_BY_OMISSION = "no name provided";
    
    /**
     * The email of the Organization by omission
     */
    private static String EMAIL_BY_OMISSION = "no email provided";
    
    /**
     * The NIF of the Organization by omission
     */
    private static String NIF_BY_OMISSION = "no NIF provided";
    
    
    
    /**
     * Builds an instance of Organization that receives the name, the NIF, the 
     * email, the collaborator and the manager
     * 
     * @param name the name of the Organization
     * @param NIF the NIF of the Organization
     * @param email the email of the Organization
     * @param colab the collaborator of the Organization
     * @param manager the Manager of the Organization
     */
    public Organization(String name, String NIF, String email, 
            Collaborator colab, Manager manager)
    {
        if ( (name == null) || (NIF == null) || (email == null) || (colab == null) 
                || (manager == null) ||(name.isEmpty()) || (NIF.isEmpty()) || 
                (email.isEmpty()))
            throw new IllegalArgumentException("No argument can be null.");
       
        this.name = name;
        this.NIF = NIF;
        this.email = email;
        this.colab = colab;
        this.manager = manager;
       
    }
    
    /**
     * Builds an instance of Address that is copy of the one passed by parameter
     * @param otherOrganization organization that is copied
     */
    public Organization(Organization otherOrganization) {
        this.name = otherOrganization.name;
        this.NIF = otherOrganization.NIF;
        this.email = otherOrganization.email;
        this.colab = otherOrganization.colab;
        this.manager = otherOrganization.manager;
    }
    

    /**
     * Builds an instance of Organization with the omission values
     */
    public Organization() {
        name = NAME_BY_OMISSION;
        NIF = NIF_BY_OMISSION;
        email = EMAIL_BY_OMISSION;
        colab = new Collaborator();
        manager = new Manager();
    }
    
    

    /**
     * Returns the name of the Organization
     * @return name of the Organization
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the email of the Organization
     * @return email of the Organization
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the NIF of the Organization
     * @return NIF of the Organization
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * Returns the manager of the Organization
     * @return Manager of the Organization
     */
    public Manager getManager() {
        return manager;
    }

    /**
     * Returns the Collaborator of the Organization
     * @return collaborator of the Organization
     */
    public Collaborator getColab() {
        return colab;
    }
    
    
    /**
     * Compares 2 Organization objects through NIF and email with both objects being considered equal only when these 2 parameteres are the same
     *
     * @param otherObject object to be compared with the object that calls the method
     * @return true, if the references of both objects being compared are pointing at the same object false, if the compared object is null or the class of the objects are different true, if address, locality and postCode of both objects are the same
     */
    @Override
    public boolean equals(Object otherObject) {
        
        // self check
        if (this == otherObject)
            return true;
        // null check
        if (otherObject == null)
            return false;
        // type check and cast
        if (getClass() != otherObject.getClass())
            return false;
        // field comparison
        Organization otherOrganization = (Organization) otherObject;
        return (this.NIF.equalsIgnoreCase(otherOrganization.NIF) &&
                this.email.equalsIgnoreCase(otherOrganization.email));
    }
    
    /**
     * Returns the characteristics of the Organization
     * 
     * @return characteristics of the Organization 
     */
    @Override
    public String toString()
    {
        String str = String.format("%s - %s - %s - %s - %s - %s - %s", this.name, this.NIF, this.email, this.manager.toString(),this.colab.toString());
        return str;
    }
   
}
