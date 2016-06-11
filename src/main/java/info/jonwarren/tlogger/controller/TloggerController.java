package info.jonwarren.tlogger.controller;

import javax.annotation.Resource;

import info.jonwarren.tlogger.config.ApplicationSetup;

public abstract class TloggerController {

	@Resource
	protected ApplicationSetup applicationSetup;

}
