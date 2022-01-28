package co.micol.prj.movie.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;

import co.micol.prj.api.MovieAPI;

@Controller
public class MovieController {
	
	@GetMapping("/restMovieList")
	@ResponseBody
	public JsonNode restMovieList() throws Exception {
		return MovieAPI.restMovieList();
	}
	
	@GetMapping("/movieList")
	@ResponseBody
	public JsonNode movieList() throws Exception {
		return MovieAPI.movieList();
	}

}
