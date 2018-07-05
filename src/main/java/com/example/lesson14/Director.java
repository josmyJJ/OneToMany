package com.example.lesson14;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String genr;

    @OneToMany(mappedBy = "director",
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER)

    public Set<Movie> movies;


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

    public String getGenr() {
        return genr;
    }

    public void setGenr(String genr) {
        this.genr = genr;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
