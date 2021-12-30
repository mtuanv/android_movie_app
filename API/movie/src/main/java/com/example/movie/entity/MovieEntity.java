package com.example.movie.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "movie")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "create_at")
    private String createAt;

    @Column(name = "update_at")
    private String updateAt;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "view")
    private Integer view;

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "categoryid", insertable = false, updatable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "directorid", insertable = false, updatable = false)
    private DirectorEntity director;

    @ManyToMany
    @JoinTable(name = "movie_cast",
            joinColumns = @JoinColumn(name = "movieid"),
            inverseJoinColumns = @JoinColumn(name = "castid"))
    private Collection<CastEntity> casts;

    public MovieEntity(){
    }

    public MovieEntity(String name, String createAt, String updateAt, String thumbnail, String description, Integer duration, Integer view, String url, CategoryEntity category, DirectorEntity directorid, List<CastEntity> casts) {
        this.name = name;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.thumbnail = thumbnail;
        this.description = description;
        this.duration = duration;
        this.view = view;
        this.url = url;
        this.category = category;
        this.director = director;
        this.casts = casts;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public DirectorEntity getDirector() {
        return director;
    }

    public void setDirector(DirectorEntity director) {
        this.director = director;
    }

    public Collection<CastEntity> getCasts() {
        return casts;
    }

    public void setCasts(Collection<CastEntity> casts) {
        this.casts = casts;
    }
}
