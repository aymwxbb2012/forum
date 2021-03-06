package cdu.xeon.forum.model;

public enum ChannelType {
	NAV_CHANNEL("navigation column"),TOPIC_LIST("List of articles"),
	TOPIC_CONTENT("content of articles"),TOPIC_IMG("Picture list"),
	QUESTION_LIST("list of questions"),QUESTION_CONTENT("content of questions");
	
	
	private String name;
	
	private ChannelType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

