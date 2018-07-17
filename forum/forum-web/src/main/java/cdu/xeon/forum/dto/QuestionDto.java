package cdu.xeon.forum.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import cdu.xeon.forum.model.Question;


public class QuestionDto {

	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
	private int id;
	private String title;
	
	private String keyword;
	

	
	private int status;
	
	private int recommend;
	
	private String content;
	
	private int coins;
	
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
	
	public int getCoins() {
		return coins;
	}
	public void setCoins(int coins) {
		this.coins = coins;
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
	
	public QuestionDto() {
	}
	
	public Question getquestion() {
		Question t = new Question();
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
		t.setTitle(this.getTitle());
		return t;
	}
	
	public QuestionDto(Question question) {
		this.setContent(question.getContent());
		this.setId(question.getId());
		this.setKeyword(question.getKeyword());
		this.setPublishDate(sdf.format(question.getPublishDate()));
		this.setRecommend(question.getRecommend());
		this.setStatus(question.getStatus());
		this.setTitle(question.getTitle());
	}
	
	public QuestionDto(Question question,Integer cid) {
		this.setContent(question.getContent());
		this.setId(question.getId());
		this.setCid(cid);
		this.setKeyword(question.getKeyword());
		this.setPublishDate(sdf.format(question.getPublishDate()));
		this.setRecommend(question.getRecommend());
		this.setStatus(question.getStatus());
		this.setTitle(question.getTitle());
		this.setCoins(question.getCoins());
	}
	
	
}
