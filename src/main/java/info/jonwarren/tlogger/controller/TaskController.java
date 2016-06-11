package info.jonwarren.tlogger.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController extends TloggerController {

	@RequestMapping( value = "/", method = RequestMethod.GET )
	public String home(Model model) {
		return "List of tasks will go here";
	}

}
