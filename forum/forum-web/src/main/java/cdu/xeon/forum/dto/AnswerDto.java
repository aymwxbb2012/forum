package cdu.xeon.forum.dto;


import javax.validation.constraints.Min;


import cdu.xeon.forum.model.Answer;

public class AnswerDto {
	private int id;
	
	private int chosen;

	

	
	private String content;
	
	
	private int qid;
	
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
	
	public int getChosen() {
		return chosen;
	}
	public void setChosen(int chosen) {
		this.chosen = chosen;
	}
	
	@Min(value=1,message="You must select a question id")
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	
	public AnswerDto() {
	}
	
	public Answer getAnswer() {
		Answer t = new Answer();
		t.setContent(this.getContent());
		t.setId(this.getId());
		t.setChosen(this.getChosen());
		return t;
	}
	
	public AnswerDto(Answer answer) {
		this.setContent(answer.getContent());
		this.setId(answer.getId());
		this.setChosen(answer.getChosen());
	}
	
	public AnswerDto(Answer answer,Integer qid) {
		this.setContent(answer.getContent());
		this.setId(answer.getId());
		this.setQid(qid);
		this.setChosen(answer.getChosen());
	}
}
