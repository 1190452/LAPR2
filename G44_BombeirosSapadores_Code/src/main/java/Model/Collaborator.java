/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import pt.ipp.isep.dei.esoft.autorizacao.model.User;

/**
 *
 * @author OMEN X
 */
<<<<<<< HEAD
public class Collaborator extends User {

    /**
     * Builds an instance of Collaborator that receives name, email and password
     *
     * @param name
     * @param email
     * @param password
     */
    public Collaborator(String name, String email, String password) {
        super(name, email, password, "COLLABORATOR");
    }

    /**
     * Builds an instance of Collaborator that is copy of another passed by
     * parameter
     *
     * @param otherCollaborator
     */
    public Collaborator(Collaborator otherCollaborator) {
        super(otherCollaborator.getName(), otherCollaborator.getEmail(), otherCollaborator.getPassword(), otherCollaborator.getRole());
=======
public class Collaborator {

    private String m_strNome;
    private String m_strFuncao;
    private String m_strTelefone;
    private String m_strEmail;

    public Collaborator(String strNome, String strFuncao, String strTelefone, String strEmail) {
        if ((strNome == null) || (strFuncao == null) || (strTelefone == null) || (strEmail == null)
                || (strNome.isEmpty()) || (strFuncao.isEmpty()) || (strTelefone.isEmpty()) || (strEmail.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }

        this.m_strNome = strNome;
        this.m_strFuncao = strFuncao;
        this.m_strTelefone = strTelefone;
        this.m_strEmail = strEmail;
    }

    public Collaborator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean hasId(String strId) {
        return this.m_strEmail.equalsIgnoreCase(strId);
    }

    public String getNome() {
        return this.m_strNome;
    }

    public String getEmail() {
        return this.m_strEmail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strEmail);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o) {
            return true;
        }
        // null check
        if (o == null) {
            return false;
        }
        // type check and cast
        if (getClass() != o.getClass()) {
            return false;
        }
        // field comparison
        Collaborator obj = (Collaborator) o;
        return (Objects.equals(m_strEmail, obj.m_strEmail));
>>>>>>> f56a1201a581dbc8f358d5ee77461ea79d323221
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return super.toString();
=======
        return String.format("%s - %s - %s - %s", this.m_strNome, this.m_strFuncao, this.m_strTelefone, this.m_strEmail);
>>>>>>> f56a1201a581dbc8f358d5ee77461ea79d323221
    }
}
