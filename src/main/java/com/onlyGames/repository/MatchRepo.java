package com.onlyGames.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlyGames.entity.Match;

public interface MatchRepo extends JpaRepository<Match, Integer>{
	Optional<Match> findByTeamHeading(String teamHeading);
}
