package cdu.xeon.forum.dao;

import java.util.List;

import cdu.xeon.basic.dao.IBaseDao;
import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.Answer;


public interface IAnswerDao extends IBaseDao<Answer> {
	
	public Pager<Answer> find(Integer qid);
	
	public Pager<Answer> findByUQ(Integer uid,Integer qid);
	public Pager<Answer> find(Integer qid,Integer chosen);
	public Pager<Answer> find(Integer uid,Integer qid,Integer chosen);
	
	public Pager<Answer> searchAnswer(String con);
	
	public Pager<Answer> findChosenAnswer(Integer qi);
	
	public List<Answer> listAnswerByQuestionAndNumber(int qid,int num);
	
	public List<Answer> listAnswersByQuestion(int qid);

	
	public Answer loadLastedAnswerByQuestion(int qid);
}
