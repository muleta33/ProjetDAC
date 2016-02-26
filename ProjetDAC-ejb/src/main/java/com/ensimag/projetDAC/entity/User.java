/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import com.ensimag.projetDAC.entity.Role.ROLE;


/**
 *
 * @author margotj
 */
@Entity(name = "USERS")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "EMAIL")
    private String email;
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    protected User() {
    }

    public User(String email, String name, String firstName, char[] password, ROLE role, Basket basket) {
        this.email = email;
        this.name = name;
        this.firstName = firstName;
        this.password = hashPassword(password);
        this.role = new Role(role, this);
        this.basket = basket;
    }

    
    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    private String firstName;

    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    
    @Column(name = "PASSWORD", length = 32, 
            columnDefinition = "VARCHAR(32)")
    private char[] password;

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = hashPassword(password);
    }


    @OneToOne(fetch = FetchType.EAGER, 
      cascade = CascadeType.ALL, mappedBy = "user")
    private Role role;
    
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
        role.setUser(this);
    }
    
    
    private Basket basket;

    /**
     * Get the value of basket
     *
     * @return the value of basket
     */
    public Basket getBasket() {
        return basket;
    }

    /**
     * Set the value of basket
     *
     * @param basket new value of basket
     */
    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    
    private char[] hashPassword(char[] password) {
        char[] encoded = null;
        try {
            ByteBuffer passwdBuffer = 
              Charset.defaultCharset().encode(CharBuffer.wrap(password));
            byte[] passwdBytes = passwdBuffer.array();
            MessageDigest mdEnc = MessageDigest.getInstance("MD5");
            mdEnc.update(passwdBytes, 0, password.length);
            encoded = new BigInteger(1, mdEnc.digest()).toString(16).toCharArray();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

        return encoded;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.email != null ? this.email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if ((this.email == null) ? (other.email != null) : 
                    !this.email.equals(other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ensimag.projetDAC.entity.User[ name=" + email + " ]";
    }
    
}
