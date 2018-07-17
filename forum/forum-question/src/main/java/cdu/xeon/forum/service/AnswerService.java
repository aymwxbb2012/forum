package cdu.xeon.forum.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.dao.IAnswerDao;
import cdu.xeon.forum.dao.IQuestionDao;
import cdu.xeon.forum.dao.IUserDao;
import cdu.xeon.forum.model.Answer;
import cdu.xeon.forum.model.ForumException;
import cdu.xeon.forum.model.Question;
import cdu.xeon.forum.model.User;
@Service("answerService")
public class AnswerService implements IAnswerService {

	private IAnswerDao answerDao;
	private IUserDao userDao;
	private IQuestionDao questionDao;
	
	public IAnswerDao getAnswerDao() {
		return answerDao;
	}


    @Inject
	public void setAnswerDao(IAnswerDao answerDao) {
		this.answerDao = answerDao;
	}



	public IUserDao getUserDao() {
		return userDao;
	}


	@Inject
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}



	public IQuestionDao getQuestionDao() {
		return questionDao;
	}


	@Inject
	public void setQuestionDao(IQuestionDao questionDao) {
		this.questionDao = questionDao;
	}



	@Override
	public void add(Answer answer, int qid, int uid) {
		Question q = questionDao.load(qid);
		User u = userDao.load(uid);
		if(q==null||u==null)throw new ForumException("answers to be added must have users and columns");
		answer.setAuthor(u.getNickname());
		answer.setQname(q.getTitle());
		answer.setCreateDate(new Date());
		answer.setQuestion(q);
		answer.setUser(u);
		answerDao.add(answer);

	}



	@Override
	public void delete(int id) {
		answerDao.delete(id);

	}

	
	@Override
	public void update(Answer answer, int qid) {
		Question q = questionDao.load(qid);
		if(q==null)throw new ForumException("answers to be updated must have users and columns");
		answer.setQname(q.getTitle());
		answer.setQuestion(q);
		answerDao.update(answer);

	}


	@Override
	public Answer load(int id) {
		
		return answerDao.load(id);
	}

	@Override
	public Pager<Answer> find(Integer qid) {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxx"+qid+"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	Pager<Answer> as =	answerDao.find(qid);
	System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzz"+as+"zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
	List<Answer> as1=as.getDatas();
	for(Answer a:as1) {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+a+"xxxxxxxxxxxxxx");
		
	}
		return answerDao.find(qid);
		
	}

	@Override
	public Pager<Answer> findByUQ(Integer uid, Integer qid) {
		return answerDao.findByUQ(uid, qid);
	}

	@Override
	public Pager<Answer> find(Integer uid, Integer chosen) {
		return answerDao.find(uid, chosen);
	}
	
	@Override
	public Pager<Answer> find(Integer uid, Integer qid,Integer chosen) {
		return answerDao.find(uid, qid,chosen);
	}

	@Override
	public Pager<Answer> searchAnswer(String con) {
		
		return answerDao.searchAnswer(con);
	}

	@Override
	public Pager<Answer> findChosenAnswer(Integer qi) {
		
		return answerDao.findChosenAnswer(qi);
	}

	@Override
	public List<Answer> listAnswerByQuestionAndNumber(int qid, int num) {
		return answerDao.listAnswerByQuestionAndNumber(qid, num);
	}

	@Override
	public List<Answer> listAnswerByQuestion(int qid) {
		return answerDao.listAnswersByQuestion(qid);
	}

	

	@Override
	public Answer loadLastedAnswerByQuestion(int qid) {
		
		return answerDao.loadLastedAnswerByQuestion(qid);
	}





}
