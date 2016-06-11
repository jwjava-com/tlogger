package info.jonwarren.tlogger.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.simas.jtoggl.JToggl;
import ch.simas.jtoggl.Project;
import ch.simas.jtoggl.TimeEntry;

@RestController
@RequestMapping("/tasks")
public class TaskController extends TloggerController {

	private List<TimeEntry> tasks;  // JToggl library and Toggl call what I think of as "tasks" as "TimeEntries" so renaming here

	public TaskController() {
		super();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		loadTasks();

		StringBuilder result = new StringBuilder();

		if (this.tasks == null || this.tasks.isEmpty()) {
			result.append("There are no tasks for any of your keys.");
		} else {
			for (TimeEntry task : this.tasks) {
				result.append(task.getDescription());
				Project taskProj = task.getProject(); // TODO: this doesn't seem to be working, as I have a project on a task yet get null here
				if (taskProj != null) {
					result.append(" (Project: ").append(taskProj.getName()).append(")");
				} else {
					result.append(" (no project assigned)");
				}
				result.append("<br/>\n");
			}
		}

		return result.toString();
	}

	private void loadTasks() {
		initJToggls();

		if (jToggls != null) {
			this.tasks = new ArrayList<TimeEntry>();

			for (JToggl jt : jToggls) {
				List<TimeEntry> entries = jt.getTimeEntries();
				
				if (entries != null) {
					this.tasks.addAll(entries);
				}
			}
		}
	}

}
