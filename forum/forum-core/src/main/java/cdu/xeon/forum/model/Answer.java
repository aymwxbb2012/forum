package cdu.xeon.forum.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="t_answer")
public class Answer {
	
	private int id;
	
	private int chosen;

	private String content;
	
	
	
	private Date createDate;
	
	private String author;
	
	private String qname;
	
	
	private Question question;
	
	private User user;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	

	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	@Column(name="create_date")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getChosen() {
		return chosen;
	}
	public void setChosen(int chosen) {
		this.chosen = chosen;
	}
	
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	
	@ManyToOne
	@JoinColumn(name="qid")
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	

	
	@ManyToOne
	@JoinColumn(name="uid")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

	


	public Answer(int id, int chosen,  String author, String qname) {
		super();
		
		this.id = id;
		this.chosen = chosen;
		this.author = author;
		this.qname = qname;
	}
	

	
	public Answer(int id,  int chosen, String author) {
		super();
		this.id = id;
		
	    this.chosen = chosen;
		this.author = author;
	}
	
	public Answer() {
	}
	

}
