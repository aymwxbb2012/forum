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
@Table(name="t_question")
public class Question {

	
		private int id;
		private String title;
		
		private String keyword;
		
		private int status;
		
		private int recommend;

		private String content;
		
	
	
		
		private Date publishDate;
		
		private Date createDate;
		
		private String author;
		
		private String cname;
		
		
		private Channel channel;
		
		private User user;
		
		
		private int coins;
		
		public int getCoins() {
			return coins;
		}
		public void setCoins(int coins) {
			this.coins = coins;
		}
		@Id
		@GeneratedValue
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
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
		
		
		@Column(name="publish_date")
		public Date getPublishDate() {
			return publishDate;
		}
		public void setPublishDate(Date publishDate) {
			this.publishDate = publishDate;
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
		
		@ManyToOne
		@JoinColumn(name="cid")
		public Channel getChannel() {
			return channel;
		}
		public void setChannel(Channel channel) {
			this.channel = channel;
		}
		
		@ManyToOne
		@JoinColumn(name="uid")
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		
	
		
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
		@Override
		public String toString() {
			return "Topic [id=" + id + ", title=" + title + "]";
		}
		
		public Question(int id, String title,String keyword, int status,
				int recommend, Date publishDate, String author, String cname,int coins) {
			super();
			this.id = id;
			this.title = title;
			this.keyword = keyword;
			this.status = status;
			this.recommend = recommend;
			this.publishDate = publishDate;
			this.author = author;
			this.cname = cname;
			this.coins = coins;
		}
		

		
		public Question(int id, String title, String keyword, int status,
				int recommend, String author,int coins) {
			super();
			this.id = id;
			this.title = title;
			this.keyword = keyword;
			this.status = status;
			this.recommend = recommend;
			this.author = author;
			this.coins = coins;
		}
		
		public Question() {
		}
		
	
}
