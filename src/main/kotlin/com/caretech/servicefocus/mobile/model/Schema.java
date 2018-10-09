package com.caretech.servicefocus.mobile.model;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "SYS_SCHEMA")
@Where(clause = "isActive ='true'")
public class Schema extends Base{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(unique = true)
    private
    String schemaName;

    @Column
    private
    String tableName;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb",name = "attrs")
    private Map<String, Object> attributes=  new HashMap<String, Object>();

    @Column
    private
    Boolean isActive = true;

    @LastModifiedBy
    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id", nullable = true)
    private User modifiedBy;

    @CreatedBy
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private User createdBy;

    @LastModifiedDate
    private Date modifiedOn;

    @CreatedDate
    private
    Date createdOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public User getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @PrePersist
    public void beforeInsert() {
        this.tableName = this.schemaName.replaceAll("[^A-Za-z0-9]", "_");
        this.createdOn = new Date();
    }
}
