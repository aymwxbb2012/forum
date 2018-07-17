package cdu.xeon.forum.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cdu.xeon.basic.dao.BaseDao;
import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.Answer;

@Repository("answerDao")
public class AnswerDao extends BaseDao<Answer> implements IAnswerDao {


	private String getAnswerSelect() {
		return "select new Answer(a.id,a.chosen,a.author,a.qname)";
	}




	@Override
	public Pager<Answer> searchAnswer(String con) {
		String hql = getAnswerSelect()+" from Answer a where " +
				"(content like '%"+con+"%')";
		return this.find(hql);
	}

	@Override
	public Pager<Answer> findChosenAnswer(Integer qid) {
		String hql = getAnswerSelect()+" from Answer a where a.chosen=1";
		if(qid==null||qid==0) {
			return this.find(hql);
		} else {
			hql +=" and a.question.id=?";
			return this.find(hql, qid);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> listAnswerByQuestionAndNumber(int qid, int num) {
		String hql = getAnswerSelect()+" from Answer a where a.question.id=? order by a.createDate desc";
		
		return this.getSession().createQuery(hql).setParameter(0, qid)
				.setFirstResult(0).setMaxResults(num).list();
		
	}

	
	@Override
	public List<Answer> listAnswersByQuestion(int qid) {
		String hql = "select a from Answer a where a.question.id=?";
		return this.list(hql,qid);
	}



	@Override
	public Answer loadLastedAnswerByQuestion(int qid) {
		String s = "select new Answer(a.id,a.chosen,a.createDate,a.author,a.qname)";
		String hql = s+" from Answer a where a.question.id=? order by a.createDate desc";
		Answer Answer = (Answer)this.getSession()
				.createQuery(hql).setFirstResult(0).setMaxResults(1)
				.setParameter(0, qid).uniqueResult();
		return Answer;
	}




	@Override
	public Pager<Answer> find(Integer qid) {
		String hql = getAnswerSelect()+" from Answer a where 1=1";
		if(qid!=null&&qid>0) {
			hql+=" and a.question.id="+qid;
		}
		System.out.println("axxxxxxxxxxxxxxxxxxxxxx"+qid+"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		Pager<Answer> as =	this.find(hql);
		System.out.println("azzzzzzzzzzzzzzzzzzzzzzzzzzzzz"+as+"zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
		List<Answer> as1=as.getDatas();
		for(Answer a:as1) {
			System.out.println("axxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+a+"axxxxxxxxxxxxxx");
			
		}

		return as;
	

	}




	@Override
	public Pager<Answer> findByUQ(Integer uid, Integer qid) {
		String hql = getAnswerSelect()+" from Answer a where 1=1";
 		if(uid!=null&&uid>0) {
			hql+=" and a.user.id="+uid;
		}
		if(qid!=null&&qid>0) {
			hql+=" and a.question.id="+qid;
		}
		
		
		return this.find(hql);
	}

	@Override
	public Pager<Answer> find(Integer qid,Integer chosen) {
		String hql = getAnswerSelect()+" from Answer a where 1=1";
 		if(qid!=null&&qid>0) {
			hql+=" and a.question.id="+qid;
		}
		if(chosen!=null) {
			hql+=" and a.chosen="+chosen;
		}
		
		
		return this.find(hql);
	}
	
	@Override
	public Pager<Answer> find(Integer uid, Integer qid,Integer chosen) {
		String hql = getAnswerSelect()+" from Answer a where 1=1";
 		if(uid!=null&&uid>0) {
			hql+=" and a.user.id="+uid;
		}
		if(qid!=null&&qid>0) {
			hql+=" and a.question.id="+qid;
		}
		if(chosen!=null) {
			hql+=" and a.chosen="+chosen;
		}
		
		return this.find(hql);
	}
}
