package com.onlyGames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.onlyGames.entity.Account;
import com.onlyGames.service.AccountService;



@Controller
public class HomeController {
	@Autowired
	AccountService accountService;

	@GetMapping("/")
	public String home(Model model) {
		Account account = new Account();
		model.addAttribute("account", account);
		return "register";
	}
	
	@PostMapping("/register")
	public String register_user( @ModelAttribute Account account, BindingResult result) {
		accountService.save(account);
		return "mainmenu";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/mainMenu")
	public String mainMenu() {
		return "mainMenu";
	}
	@GetMapping("/players")
	public String players() {
		return "players";

}
	@GetMapping("/player3")
	public String player3() {
		return "player3";

}
	@GetMapping("/players2")
	public String players2() {
		return "players2";

}
}