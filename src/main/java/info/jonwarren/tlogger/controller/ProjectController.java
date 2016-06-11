package info.jonwarren.tlogger.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.simas.jtoggl.JToggl;
import ch.simas.jtoggl.Project;

@RestController
@RequestMapping("/projects")
public class ProjectController extends TloggerController {

	private List<Project> projects;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		loadProjects();

		StringBuilder result = new StringBuilder();

		if (projects == null || projects.isEmpty()) {
			result.append("There are no projects for any of your keys.");
		} else {
			for (Project proj : projects) {
				result.append(proj.getName()).append("<br/>\n");
			}
		}

		return result.toString();
	}

	private void loadProjects() {
		initJToggls();

		if (jToggls != null) {
			this.projects = new ArrayList<Project>();

			for (JToggl jt : jToggls) {
				List<Project> projects = jt.getProjects();
				if (projects != null) {
					this.projects.addAll(projects);
				}
			}
		}
	}

}