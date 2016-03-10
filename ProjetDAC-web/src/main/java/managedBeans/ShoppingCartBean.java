/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author ensimag
 */
@Named(value = "shoppingCartBean")
@SessionScoped
public class ShoppingCartBean implements Serializable {
    
    private List<String> content = null;

    /**
     * Creates a new instance of ShoppingCartBean
     */
    public ShoppingCartBean() {
    }
    
    @PostConstruct
    public void init() {
        content = new ArrayList<>();
    }
    
    public List<String> getContent() {
        return content;
    }
    
    public void addPerfume(String perfumeName) {
        content.add(perfumeName);
    }
    
    public void removePerfume(String perfumeName) {
        content.remove(perfumeName);
    }
    
    public boolean containsPerfume(String perfumeName) {
        return content.contains(perfumeName);
    }
    
    public boolean isEmpty() {
        return content.isEmpty();
    }
    
}
