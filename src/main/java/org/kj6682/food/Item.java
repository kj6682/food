package org.kj6682.food;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by luigi on 19/04/16.
 */
@Entity
class Item {

    static enum Category {
        BISCUITS, MEAT, VEGETABLES, DRINKS, EGGS, BREAD, DAIRIES, SNACKS, CAKES, SALAMI
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;
    private String name;
    private Category category;
    private LocalDate begin;
    private LocalDate end;
    private Integer quantity;

    public Item() {
        super();
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
