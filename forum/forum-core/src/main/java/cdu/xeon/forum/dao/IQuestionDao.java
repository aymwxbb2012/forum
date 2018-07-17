package cdu.xeon.forum.dao;

import java.util.List;

import cdu.xeon.basic.dao.IBaseDao;
import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.Question;


public interface IQuestionDao extends IBaseDao<Question> {
	
	public Pager<Question> find(Integer cid,String title,Integer status);
	
	public Pager<Question> find(Integer uid,Integer cid,String title,Integer status);
	
	public Pager<Question> searchQuestionByKeyword(String keyword);
	
	public Pager<Question> searchQuestion(String con);
	
	public Pager<Question> findRecommendQuestion(Integer ci);
	
	public List<Question> listQuestionByChannelAndNumber(int cid,int num);
	
	public List<Question> listQuestionsByChannel(int cid);
	
	public boolean isUpdateIndex(int cid);
	
	public Question loadLastedQuestionByColumn(int cid);
}
