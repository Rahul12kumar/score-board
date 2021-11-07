package com.phonepe.models;

import java.io.Serializable;
import java.util.Date;

public abstract class Auditable implements Serializable {

    private Long id;
    private Date createdAt=new Date();
    private Date updatedAt=new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
