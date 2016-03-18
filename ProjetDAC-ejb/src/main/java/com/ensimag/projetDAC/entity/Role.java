/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensimag.projetDAC.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author ensimag
 */
@Entity(name = "ROLES")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    public static enum ROLE {

        MANAGER, USER
    }

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    @Id
    @Column(name = "ROLE_NAME")
    @Enumerated(EnumType.STRING)
    private ROLE role;

    protected Role() {
    }

    public Role(ROLE role) {
        this.role = role;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean addUser(User userToAdd) {
        if (users == null) {
            this.users = new ArrayList<>();
        }
        return this.users.add(userToAdd);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Role other = (Role) obj;
        if (this.role != other.role) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.role != null ? this.role.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "com.ensimag.projetDAC.entity.Role[ name=" + role + " ]";
    }

}
