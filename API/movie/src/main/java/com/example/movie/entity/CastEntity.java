package com.example.movie.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "cast")
public class CastEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="create_at")
    private String createAt;

    @Column(name="update_at")
    private String updateAt;

    @Column(name="image")
    private String image;

    @Column(name="description")
    private String description;

    @ManyToMany(mappedBy = "casts")
    private Collection<MovieEntity> movies;

    public CastEntity() {
    }

    public CastEntity(String name, String createAt, String updateAt, String image, String description) {
        this.name = name;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.image = image;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
