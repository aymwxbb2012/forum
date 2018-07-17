package cdu.xeon.forum.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import cdu.xeon.forum.model.Topic;


public class TopicDto {
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
	private int id;
	private String title;
	
	private String keyword;
	
	private int status;
	
	private int recommend;
	
	private String content;
	
	private String summary;
	
	private int channelPicId;
	
	private String publishDate;
	
	private int cid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@NotEmpty(message="The article title cannot be empty")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getChannelPicId() {
		return channelPicId;
	}
	public void setChannelPicId(int channelPicId) {
		this.channelPicId = channelPicId;
	}
	
	public String getPublishDate() {
		return publishDate;
	}
	
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	@Min(value=1,message="You must select a column id")
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public TopicDto() {
	}
	
	public Topic getTopic() {
		Topic t = new Topic();
		t.setChannelPicId(this.getChannelPicId());
		t.setContent(this.getContent());
		t.setId(this.getId());
		t.setKeyword(this.getKeyword());
		try {
			Date d = sdf.parse(this.getPublishDate());
			Calendar cd = Calendar.getInstance();
			cd.setTime(d);
			Calendar ca = Calendar.getInstance();
			ca.setTime(new Date());
			ca.set(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH), cd.get(Calendar.DATE));
			t.setPublishDate(ca.getTime());
		} catch (ParseException e) {
			t.setPublishDate(new Date());
		}
		t.setRecommend(this.getRecommend());
		t.setStatus(this.getStatus());
		t.setSummary(this.getSummary());
		t.setTitle(this.getTitle());
		return t;
	}
	
	public TopicDto(Topic topic) {
		this.setChannelPicId(topic.getChannelPicId());
		this.setContent(topic.getContent());
		this.setId(topic.getId());
		this.setKeyword(topic.getKeyword());
		this.setPublishDate(sdf.format(topic.getPublishDate()));
		this.setRecommend(topic.getRecommend());
		this.setStatus(topic.getStatus());
		this.setSummary(topic.getSummary());
		this.setTitle(topic.getTitle());
	}
	
	public TopicDto(Topic topic,Integer cid) {
		this.setChannelPicId(topic.getChannelPicId());
		this.setContent(topic.getContent());
		this.setId(topic.getId());
		this.setCid(cid);
		this.setKeyword(topic.getKeyword());
		this.setPublishDate(sdf.format(topic.getPublishDate()));
		this.setRecommend(topic.getRecommend());
		this.setStatus(topic.getStatus());
		this.setSummary(topic.getSummary());
		this.setTitle(topic.getTitle());
	}
	
}
