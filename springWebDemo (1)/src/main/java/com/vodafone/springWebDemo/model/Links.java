package com.vodafone.springWebDemo.model;


import javax.persistence.*;

@Entity
@Table(
        name = "Links"
)
public class Links {

    @Id
    @Column(
            name = "id",
            updatable = false
    )
    private Integer id;
    @Column(
            name = "rel",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String rel;

    @Column(
            name = "href",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String href;


    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
