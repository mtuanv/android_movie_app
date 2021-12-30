package com.example.movie.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity {

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

    @OneToMany(mappedBy = "category")
    private List<MovieEntity> movies;

    public CategoryEntity(){
    }

    public CategoryEntity(String name, String createAt, String updateAt, String image) {
        this.name = name;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.image = image;
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

    public List<MovieEntity> getMovies() {
        return null;
    }

    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }
}
