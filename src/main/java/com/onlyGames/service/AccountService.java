package com.onlyGames.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.onlyGames.entity.Account;
import com.onlyGames.repository.AccountRepo;

@Service
public class AccountService  implements UserDetailsService{
	@Autowired
	AccountRepo accountRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void save(Account a) {
		a.setPassword(passwordEncoder.encode(a.getPassword()));
		accountRepo.save(a);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Account> optionalAccount = accountRepo.findOneByEmailIgnoreCase(email);
		if(!optionalAccount.isPresent()) {
			throw new UsernameNotFoundException("Account Not Found");
		}
		Account account = optionalAccount.get();
		List<GrantedAuthority> grantedAuthority = new ArrayList<>();
		grantedAuthority.add(new SimpleGrantedAuthority("Allow"));
		return new User(account.getEmail(),account.getPassword(),grantedAuthority);
		// TODO Auto-generated method stub
	}
	
	public Optional<Account> findOneByEmail(String email){
		return accountRepo.findOneByEmailIgnoreCase(email);
	}
	
}
