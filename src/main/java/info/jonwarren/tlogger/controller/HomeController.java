package info.jonwarren.tlogger.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController extends TloggerController {

	@RequestMapping("/")
	public String home(Model model) {
		return "You are home... or... well... at the start of this whole app, at least. You might be at work for all I know.";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		if (applicationSetup.getKeys() != null && !applicationSetup.getKeys().isEmpty()) {
			return "It appears that you actually have keys. I should probably let you in.";
		} else {
			return "What? You wanna log in to this or something? Good luck with that!";
		}
	}

}
