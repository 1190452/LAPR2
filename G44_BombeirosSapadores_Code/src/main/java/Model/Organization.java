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
    private String phone;
    private Manager manager;
    private Colaborator colab;
            
    
    public Organization(String strNome, String strNIF, String strWebsite, String strTelefone, 
            String strEmail, Colaborador oColaborador)
    {
        if ( (strNome == null) || (strNIF == null) || (strTelefone == null) ||
                (strEmail == null) || (oMorada == null) || (oColaborador == null) ||
                (strNome.isEmpty())|| (strNIF.isEmpty()) || (strTelefone.isEmpty()) || 
                (strEmail.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        
        this.name = strNome;
        this.NIF = strNIF;
        this.m_oEnderecoPostal = oMorada;
        this.m_strWebsite = strWebsite;
        this.phone = strTelefone;
        this.email = strEmail;
        this.m_oGestor = oColaborador;
        this.m_lstColaboradores.add(oColaborador);
       
    }
    
    public Colaborador getGestor()
    {
        return this.m_oGestor;
    }
   
    
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.NIF);
        return hash;
    }
    
    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/
        
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
