package info.jonwarren.tlogger.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectController extends TloggerController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "List of projects will go here";
	}

}
