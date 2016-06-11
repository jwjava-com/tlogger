package info.jonwarren.tlogger.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import ch.simas.jtoggl.JToggl;
import info.jonwarren.tlogger.config.ApplicationSetup;

public class TloggerController {

	@Resource
	protected ApplicationSetup applicationSetup;

	protected List<JToggl> jToggls;

	public TloggerController() {
		initJToggls();
	}

	protected void initJToggls() {
		if (this.jToggls == null && applicationSetup != null && applicationSetup.getKeys() != null) {

			List<String> keys = applicationSetup.getKeys();
			this.jToggls = new ArrayList<JToggl>(keys.size());

			for (String key : keys) {
				JToggl jToggl = new JToggl(key, "api_token");
				jToggl.setThrottlePeriod(applicationSetup.getThrottlePeriod());

				this.jToggls.add(jToggl);
			}
		}
	}

}
