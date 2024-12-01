package com.onlyGames.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlyGames.entity.Account;
public interface AccountRepo extends JpaRepository<Account, Long>{
	Optional<Account> findOneByEmailIgnoreCase(String email);
}
