package mx.christez.sla.configuration;

public class EmailConfiguration {
	private String activateUrl;
	private Integer id;
	private String notificationFrom;
	private String notificationHost;
	private String notificationPassword;
	private String notificationPort;
	private String notificationUsername;
	private String restoreUrl;
	
	public EmailConfiguration() {}

	public String getActivateUrl() {
		return activateUrl;
	}

	public void setActivateUrl(String activateUrl) {
		this.activateUrl = activateUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNotificationFrom() {
		return notificationFrom;
	}

	public void setNotificationFrom(String notificationFrom) {
		this.notificationFrom = notificationFrom;
	}

	public String getNotificationHost() {
		return notificationHost;
	}

	public void setNotificationHost(String notificationHost) {
		this.notificationHost = notificationHost;
	}

	public String getNotificationPassword() {
		return notificationPassword;
	}

	public void setNotificationPassword(String notificationPassword) {
		this.notificationPassword = notificationPassword;
	}

	public String getNotificationPort() {
		return notificationPort;
	}

	public void setNotificationPort(String notificationPort) {
		this.notificationPort = notificationPort;
	}

	public String getNotificationUsername() {
		return notificationUsername;
	}

	public void setNotificationUsername(String notificationUsername) {
		this.notificationUsername = notificationUsername;
	}

	public String getRestoreUrl() {
		return restoreUrl;
	}

	public void setRestoreUrl(String restoreUrl) {
		this.restoreUrl = restoreUrl;
	}
}
