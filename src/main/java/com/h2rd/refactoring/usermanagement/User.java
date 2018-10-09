package com.h2rd.refactoring.usermanagement;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
//Safe to use by different threads
@Immutable
public class User {

    private String name;

    private String email;

    private List<String> roles;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<String> getRoles() {
        return roles;
    }
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User inputUser = (User)o;
        return inputUser.getName().equals(this.getName()) && inputUser.getEmail().equals(this.getEmail()) && inputUser.getRoles().equals(this.getRoles());
    }

    @Override
    public int hashCode() {
        int result = 15;
        result = 31 * result + name.hashCode();
        return result;
    }


}
