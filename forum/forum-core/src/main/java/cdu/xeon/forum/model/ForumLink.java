package cdu.xeon.forum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="t_forum_link")
public class ForumLink {
	
	private int id;
	
	private String title;
	
	private String url;
	
	private String type;
	
	private int newWin;
	
	private String urlId;
	
	private String urlClass;
	
	private int pos;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@NotEmpty(message="title cannot be empty")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="new_win")
	public int getNewWin() {
		return newWin;
	}
	public void setNewWin(int newWin) {
		this.newWin = newWin;
	}
	
	@Column(name="url_id")
	public String getUrlId() {
		return urlId;
	}
	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}
	@Column(name="url_class")
	public String getUrlClass() {
		return urlClass;
	}
	public void setUrlClass(String urlClass) {
		this.urlClass = urlClass;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
}
