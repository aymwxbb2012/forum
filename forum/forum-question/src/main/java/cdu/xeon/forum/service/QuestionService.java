package cdu.xeon.forum.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.dao.IChannelDao;
import cdu.xeon.forum.dao.IQuestionDao;
import cdu.xeon.forum.dao.IUserDao;
import cdu.xeon.forum.model.Channel;
import cdu.xeon.forum.model.ForumException;
import cdu.xeon.forum.model.Question;
import cdu.xeon.forum.model.User;

@Service("questionService")
public class QuestionService implements IQuestionService {

	private IChannelDao channelDao;
	private IUserDao userDao;
	private IQuestionDao questionDao;
	
	public IChannelDao getChannelDao() {
		return channelDao;
	}
	
    @Inject
	public void setChannelDao(IChannelDao channelDao) {
		this.channelDao = channelDao;
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
	public void add(Question question, int cid, int uid) {
		Channel c = channelDao.load(cid);
		User u = userDao.load(uid);
		if(c==null||u==null)throw new ForumException("Questions to be added must have users and columns");
		question.setAuthor(u.getNickname());
		question.setCname(c.getName());
		question.setCreateDate(new Date());
		question.setChannel(c);
		question.setUser(u);
		questionDao.add(question);

	}



	@Override
	public void delete(int id) {
		questionDao.delete(id);

	}

	
	@Override
	public void update(Question question, int cid) {
		Channel c = channelDao.load(cid);
		if(c==null)throw new ForumException("Questions to be updated must have users and columns");
		question.setCname(c.getName());
		question.setChannel(c);
		questionDao.update(question);

	}

	@Override
	public void updateStatus(int qid) {
		Question q = questionDao.load(qid);
		if(q.getStatus()==0) q.setStatus(1);
		else q.setStatus(0);
		questionDao.update(q);
	}

	@Override
	public Question load(int id) {
		
		return questionDao.load(id);
	}

	@Override
	public Pager<Question> find(Integer cid, String title, Integer status) {
		return questionDao.find(cid, title, status);
	}

	@Override
	public Pager<Question> find(Integer uid, Integer cid, String title, Integer status) {
		return questionDao.find(uid, cid, title, status);
	}

	@Override
	public Pager<Question> searchQuestionByKeyword(String keyword) {
		
		return questionDao.searchQuestionByKeyword(keyword);
	}

	@Override
	public Pager<Question> searchQuestion(String con) {
		
		return questionDao.searchQuestion(con);
	}

	@Override
	public Pager<Question> findRecommendQuestion(Integer ci) {
		
		return questionDao.findRecommendQuestion(ci);
	}

	@Override
	public List<Question> listQuestionByChannelAndNumber(int cid, int num) {
		return questionDao.listQuestionByChannelAndNumber(cid, num);
	}

	@Override
	public List<Question> listQuestionByChannel(int cid) {
		return questionDao.listQuestionsByChannel(cid);
	}

	@Override
	public boolean isUpdateIndex(int cid) {
		return questionDao.isUpdateIndex(cid);
	}

	@Override
	public Question loadLastedQuestionByColumn(int cid) {
		
		return questionDao.loadLastedQuestionByColumn(cid);
	}

}
