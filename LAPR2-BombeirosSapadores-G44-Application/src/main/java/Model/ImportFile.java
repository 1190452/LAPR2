
package Model;

/**
 *
 * @author
 */
public interface ImportFile {
    
    /**
     * method that reads a file and loads a set of historical transactions
     * @param fileName
     * @return 
     */
    public RegisterTransaction importFile(String fileName);
    
}
