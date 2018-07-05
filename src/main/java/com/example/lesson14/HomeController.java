package com.example.lesson14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    DirectorRepository directorRepository;

    @RequestMapping("/")
    public String index(Model model){
        // First let's create a director
        Director director = new Director();
        director.setName("James Cameron");
        director.setGenr("Sci Fi");

        // Now let's create a movie
        Movie movie = new Movie();
        movie.setTitle("Titanic");
        movie.setYear(2017);
        movie.setDescription("About titanic...");

        // Add moive to an empty list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        movie = new Movie();
        movie.setTitle("The Terminator");
        movie.setYear(2000);
        movie.setDescription("About mechine and stuff...");

        // Add the list of movies to the director's movie lis
        director.setMovies(movies);

        // Save the director to the database
        directorRepository.save(director);

        // Grad all the directors from the database and send them to the template
        model.addAttribute("directors", directorRepository.findAll());

        return "index";
    }
}
