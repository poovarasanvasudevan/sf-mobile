package com.caretech.servicefocus.mobile.model;

import com.caretech.servicefocus.mobile.core.jpa.HStoreType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "SYS_ELEMENTS")
@Where(clause = "isActive ='true'")
@TypeDef(name = "hstore", typeClass = HStoreType.class)
public class Elements {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(unique = true)
    private UUID elementId;

    @Column
    private String elementName;

    @Column
    private String elementDescription;

    @Column(name = "attrs")
    @Type(type = "hstore")
    private Map<String, Object> attributes;

    @LastModifiedDate
    private ZonedDateTime modifiedDate;

    @Column
    private Boolean isActive = true;

    @CreatedDate
    private ZonedDateTime createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getElementId() {
        return elementId;
    }

    public void setElementId(UUID elementId) {
        this.elementId = elementId;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementDescription() {
        return elementDescription;
    }

    public void setElementDescription(String elementDescription) {
        this.elementDescription = elementDescription;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public ZonedDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(ZonedDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
