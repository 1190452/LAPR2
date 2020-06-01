package Model;


import java.util.Objects;

/**
 *
 * @author paulomaio
 */
public class Organization
{
    private String name;
    private String email;
    private String NIF;
    private Manager manager;
    private Collaborator colab;
            
    
    /**
     * Builds an instance of Organization that receives the name, the NIF, the 
     * email, the colaborator and the manager
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
     * @param otherObject
     * @return 
     */
    @Override
    public boolean equals(Object otherObject) {
        
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        Organization obj = (Organization) o;
        return (Objects.equals(NIF, obj.NIF));
    }
    
    @Override
    public String toString()
    {
        String str = String.format("%s - %s - %s - %s - %s - %s - %s", this.name, this.NIF, this.m_strWebsite, this.phone, this.email, this.m_oEnderecoPostal.toString(),this.m_oGestor.toString());
        return str;
    }
    
    public static Colaborador novoColaborador(String strNome, String strFuncao, String strTelefone, String strEmail)
    {
        return new Colaborador(strNome,strFuncao,strTelefone,strEmail);
    }
    
    public static EnderecoPostal novoEnderecoPostal(String strLocal, String strCodPostal, String strLocalidade)
    {
        return new EnderecoPostal(strLocal,strCodPostal,strLocalidade);
    }

    
}
