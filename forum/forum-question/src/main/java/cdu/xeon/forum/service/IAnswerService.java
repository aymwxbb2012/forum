package cdu.xeon.forum.service;

import java.util.List;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.Answer;

public interface IAnswerService {
	
	public void add(Answer answer,int qid,int uid);
	
	
	
	public void delete(int id);
	
	public void update(Answer answer,int qid);
	
	
	
	public Answer load(int id);
	
	
	public Pager<Answer> find(Integer qid);
	
	public Pager<Answer> findByUQ(Integer uid,Integer qid);
	public Pager<Answer> find(Integer qid,Integer chosen);
	public Pager<Answer> find(Integer uid,Integer qid,Integer chosen);
	public Pager<Answer> searchAnswer(String con);
	
	public Pager<Answer> findChosenAnswer(Integer qi);
	
	public List<Answer> listAnswerByQuestionAndNumber(int qid,int num);
	
	public List<Answer> listAnswerByQuestion(int qid);
	
	public Answer loadLastedAnswerByQuestion(int qid);
}
