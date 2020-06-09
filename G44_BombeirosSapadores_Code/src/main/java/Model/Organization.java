package Model;

import Utils.Date;
import Utils.Time;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author paulomaio
 */
public class Organization implements Serializable {

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
     * The Address of the Organization
     */
    private Address address;
    /**
     * The manager of the Organization
     */
    private Manager manager;

    /**
     * The collaborator of the Organization
     */
    private Collaborator colab;

    private TaskList taskList;

    private DefinePayment definePayment;

    /**
     * import txt file
     */
    private ImportTxtFile itxt;

    /**
     * import csv file
     */
    private ImportCsvFile icsv;

    /**
     * register transaction
     */
    private RegisterTransaction rTrans;
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
     * @param address
     * @param colab the collaborator of the Organization
     * @param manager the Manager of the Organization
     */
    public Organization(String name, String NIF, String email, Address address,
            Collaborator colab, Manager manager) {
        if ((name == null) || (NIF == null) || (email == null) || (address == null) || (colab == null)
                || (manager == null) || (name.isEmpty()) || (NIF.isEmpty())
                || (email.isEmpty())) {
            throw new IllegalArgumentException("No argument can be null.");
        }

        this.name = name;
        this.NIF = NIF;
        this.email = email;
        this.address = address;
        this.colab = colab;
        this.manager = manager;
        this.taskList = new TaskList();
        this.definePayment = null;
        this.rTrans = new RegisterTransaction();

    }

    /**
     * Builds an instance of Address that is copy of the one passed by parameter
     *
     * @param otherOrganization organization that is copied
     */
    public Organization(Organization otherOrganization) {
        this.name = otherOrganization.name;
        this.NIF = otherOrganization.NIF;
        this.email = otherOrganization.email;
        this.colab = otherOrganization.colab;
        this.manager = otherOrganization.manager;
        this.taskList = otherOrganization.taskList;
        this.itxt = new ImportTxtFile();
        this.icsv = new ImportCsvFile();
    }

    public Organization() {
        this.name = NAME_BY_OMISSION;
        this.NIF = NIF_BY_OMISSION;
        this.email = EMAIL_BY_OMISSION;
        this.address = new Address();
        this.colab = new Collaborator();
        this.manager = new Manager();
        this.taskList = new TaskList();
    }

    //======================================================================================================================================================
    /**
     * method that creates an instance of address with the following parameters
     *
     * @param street
     * @param doorNumber
     * @param locality
     * @return
     */
    public Address newAddress(String street, String doorNumber, String locality) {
        return new Address(street, doorNumber, locality);
    }

    /**
     * method that creates an instance of collaborator with the following
     * parameters
     *
     * @param nameC
     * @param emailC
     * @param role
     * @return
     */
    public static Collaborator newCollaborator(String nameC, String emailC, String role) {
        return new Collaborator(nameC, emailC, role);
    }

    /**
     * method that creates an instance of manager with the following parameters
     *
     * @param nameM
     * @param emailM
     * @param role
     * @return
     */
    public static Manager newManager(String nameM, String emailM, String role) {
        return new Manager(nameM, emailM, role);
    }

    /**
     * creates a new payment definition
     *
     * @param time
     * @param date
     * @param rtp
     * @return
     */
    public DefinePayment newDefinePayment(Time time, Date date, int rtp) {
        return new DefinePayment(time, date, rtp);
    }

    /**
     * validates the payment definition created
     *
     * @param dp
     * @return
     */
    public boolean validatesDefinePayment(DefinePayment dp) {
        boolean bRet = true;

        if (dp == null) {
            bRet = false;
        }

        return bRet;
    }

    /**
     * method that loads and returns a list of transactions
     *
     * @param fileName
     * @return
     */
    public List<TransactionExecution> loadHistoricalTransaction(String fileName) {
        if (fileName.endsWith(".txt")) {
            rTrans = itxt.importFile(fileName);
            List<TransactionExecution> lt = rTrans.getTransactions();
            return lt;
        } else if (fileName.endsWith(".csv")) {
            rTrans = icsv.importFile(fileName);
            List<TransactionExecution> lt = getRTrans().getTransactions();
            if (getRTrans().validateHistoricalTransaction(lt)) {
                return lt;
            }

        }
        return null;
    }

    /**
     * method that "sends" and email to mean performance freelancers
     *
     * @throws FileNotFoundException
     */
    public void sendEmail() throws FileNotFoundException {
        ApplicationPOT ap = ApplicationPOT.getInstance();
        List<Freelancer> listFreelancers = ap.getPlatform().getRfree().getListFreelancers();
        double delayProb = ap.getPlatform().getRfree().getDelayProb();

        List<TransactionExecution> transList = rTrans.getTransactions();
        for (int i = 0; i < transList.size(); i++) {
            double taskDelay = transList.get(i).getTaskDelay();
            if (taskDelay > 3 && taskDelay > delayProb) {
                Freelancer free = transList.get(i).getFreel();
                Writer.sendEmail(free);
            }
        }
    }

    //======================================================================================================================================================
    /**
     * Compares 2 Organization objects through NIF and email with both objects
     * being considered equal only when these 2 parameteres are the same
     *
     * @param otherObject object to be compared with the object that calls the
     * method
     * @return true, if the references of both objects being compared are
     * pointing at the same object false, if the compared object is null or the
     * class of the objects are different true.
     */
    @Override
    public boolean equals(Object otherObject) {

        // self check
        if (this == otherObject) {
            return true;
        }
        // null check
        if (otherObject == null) {
            return false;
        }
        // type check and cast
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        // field comparison
        Organization otherOrganization = (Organization) otherObject;
        return (this.NIF.equalsIgnoreCase(otherOrganization.NIF)
                && this.email.equalsIgnoreCase(otherOrganization.email));
    }

    //======================================================================================================================================================
    
    /**
     * Writing method of the class Organization
     *
     * @return characteristics of the Organization
     */
    @Override
    public String toString() {
        String str = String.format("%s - %s - %s - %s - %s - %s - %s", this.name, this.NIF, this.email, this.manager.toString(), this.colab.toString());
        return str;
    }
    
    //======================================================================================================================================================

    /**
     * returns the task list of the organization
     *
     * @return the taskList
     */
    public TaskList getTaskList() {
        return taskList;
    }

    /**
     * Returns the name of the Organization
     *
     * @return name of the Organization
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the email of the Organization
     *
     * @return email of the Organization
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the NIF of the Organization
     *
     * @return NIF of the Organization
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * Returns the manager of the Organization
     *
     * @return Manager of the Organization
     */
    public Manager getManager() {
        return manager;
    }

    /**
     * Returns the Collaborator of the Organization
     *
     * @return collaborator of the Organization
     */
    public Collaborator getColab() {
        return colab;
    }

    /**
     * returns the address of the organization
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * returns the payment definition of the organization
     *
     * @return the definePayment
     */
    public DefinePayment getDefinePayment() {
        return definePayment;
    }

    /**
     * returns the register transaction
     *
     * @return the rTrans
     */
    public RegisterTransaction getRTrans() {
        return rTrans;
    }

    public RegisterTransaction getrTrans() {
        return rTrans;
    }

    //======================================================================================================================================================
    /**
     * modifies the task list of the organization
     *
     * @param taskList the taskList to set
     */
    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    /**
     * modifies the address of the organization
     *
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * modifies the payment definition of the organization
     *
     * @param definePayment the definePayment to set
     */
    public void setDefinePayment(DefinePayment definePayment) {
        this.definePayment = definePayment;
    }

}
