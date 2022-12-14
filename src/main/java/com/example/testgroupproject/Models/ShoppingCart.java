package com.example.testgroupproject.Models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "shoppingCart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Transient
    private Double totalPrice;
    @Transient
    private int itemsNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<CartItem> items = new HashSet<>();
    private String sessionToken;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalPrice() {
        double sum = 0.0;
        for(CartItem item : this.items){
            sum = sum + item.getProduct().getProductPrice();
        }
        return sum;
    }

    public ShoppingCart() {

    }

    public int getItemsNumber() {
        return this.items.size();
    }

    public Set<CartItem> getItems() {
        return items;
    }

    public void setItems(Set<CartItem> items) {
        this.items = items;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
