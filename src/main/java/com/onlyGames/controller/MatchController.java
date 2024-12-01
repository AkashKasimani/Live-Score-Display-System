package com.onlyGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlyGames.entity.Match;
import com.onlyGames.service.MatchService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Controller
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/match")
public class MatchController {

	@Autowired
	private MatchService matchService;

	
	  @GetMapping("/lives")
	  public ResponseEntity<List<Match>> getLiveMatches(){
	  return new ResponseEntity<>(this.matchService.getLiveMatchScore(),HttpStatus.OK); }
	 

	@GetMapping("/live")
	public String getLiveMatches(Model model) {
		// ResponseEntity<List<Match>> scoreCard = new
		// ResponseEntity<>(this.matchService.getLiveMatchScore(),HttpStatus.OK);
		List<Match> score = this.matchService.getLiveMatchScore();
		model.addAttribute("scorebo", score);
		return "scoreCard";
	}

	@GetMapping("/points-table")
	public ResponseEntity<?> getPointsTable() {
		return new ResponseEntity<>(this.matchService.getPointsTable(), HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Match>> getAllMatches() {
		return new ResponseEntity<>(this.matchService.getAllMatches(), HttpStatus.OK);
	}
}
