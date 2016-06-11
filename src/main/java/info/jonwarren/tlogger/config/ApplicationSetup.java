package info.jonwarren.tlogger.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "toggl")
public class ApplicationSetup {

	private List<String> keys = new ArrayList<String>();
	private Long throttlePeriod;
	private Integer workspaceLimit;

	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

	public Long getThrottlePeriod() {
		return throttlePeriod;
	}

	public void setThrottlePeriod(Long throttlePeriod) {
		this.throttlePeriod = throttlePeriod;
	}

	public Integer getWorkspaceLimit() {
		return workspaceLimit;
	}

	public void setWorkspaceLimit(Integer workspaceLimit) {
		this.workspaceLimit = workspaceLimit;
	}

}
