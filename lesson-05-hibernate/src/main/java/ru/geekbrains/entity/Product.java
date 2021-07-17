package ru.geekbrains.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private BigDecimal price;

    @OneToMany(mappedBy = "product")
    private List<LineItem> lineItems;

//    @ManyToMany
//    @JoinTable(
//            name = "line_item",
//            joinColumns = { @JoinColumn(name = "product_id",
//                    foreignKey = @ForeignKey(name = "fk_line_item_product"))},
//            inverseJoinColumns = { @JoinColumn(name = "user_id",
//                    foreignKey = @ForeignKey(name = "fk_line_item_user"))}
//    )
//    private List<User> users;

    public Product() {
    }

    public Product(Long id, String title, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }


    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
}
