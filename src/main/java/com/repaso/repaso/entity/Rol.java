package com.repaso.repaso.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Rol {
    @Id
    @Column
    private long id;

    @Column
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
