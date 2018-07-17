package cdu.xeon.forum.service;

import java.util.List;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.Question;

public interface IQuestionService {

	
	
	public void add(Question question,int cid,int uid);
	
	
	public void delete(int id);
	
	
	public void update(Question question,int cid);
	
	public void updateStatus(int qid);
	
	public Question load(int id);
	
	
	public Pager<Question> find(Integer cid,String title,Integer status);
	
	public Pager<Question> find(Integer uid,Integer cid,String title,Integer status);
	
	public Pager<Question> searchQuestionByKeyword(String keyword);
	
	public Pager<Question> searchQuestion(String con);
	
	public Pager<Question> findRecommendQuestion(Integer ci);
	
	public List<Question> listQuestionByChannelAndNumber(int cid,int num);
	
	public List<Question> listQuestionByChannel(int cid);
	
	
	public boolean isUpdateIndex(int cid);
	
	public Question loadLastedQuestionByColumn(int cid);
	
}
