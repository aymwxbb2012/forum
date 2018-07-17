package cdu.xeon.forum.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cdu.xeon.basic.dao.BaseDao;
import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.Question;

@Repository("questionDao")
public class QuestionDao extends BaseDao<Question> implements IQuestionDao {

	@Override
	public Pager<Question> find(Integer cid, String title, Integer status) {
		return find(null,cid,title,status);
	}
	
	private String getQuestionSelect() {
		return "select new Question(q.id,q.title,q.keyword,q.status,"
				+ "q.recommend,q.publishDate,q.author,q.cname,q.coins)";
	}

	@Override
	public Pager<Question> find(Integer uid, Integer cid, String title,
			Integer status) {
		String hql = getQuestionSelect()+" from Question q where 1=1";
		if(status!=null) {
			hql+=" and q.status="+status;
		}
		if(title!=null&&!title.equals("")) {
			hql+=" and q.title like '%"+title+"%'";
		}
 		if(uid!=null&&uid>0) {
			hql+=" and q.user.id="+uid;
		}
		if(cid!=null&&cid>0) {
			hql+=" and q.channel.id="+cid;
		}
		return this.find(hql);
	}

	@Override
	public Pager<Question> searchQuestionByKeyword(String keyword) {
		String hql = getQuestionSelect()+" from Question q where q.status=1 and q.keyword like '%"+keyword+"%'";
		return this.find(hql);
	}

	@Override
	public Pager<Question> searchQuestion(String con) {
		String hql = getQuestionSelect()+" from Question q where q.status=1 and " +
				"(title like '%"+con+"%' or content like '%"+con+"%')";
		return this.find(hql);
	}

	@Override
	public Pager<Question> findRecommendQuestion(Integer cid) {
		String hql = getQuestionSelect()+" from Question q where q.status=1 and q.recommend=1";
		if(cid==null||cid==0) {
			return this.find(hql);
		} else {
			hql +=" and q.channel.id=?";
			return this.find(hql, cid);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> listQuestionByChannelAndNumber(int cid, int num) {
		String hql = getQuestionSelect()+" from Question q where q.status=1 and q.channel.id=? order by q.publishDate desc";
		return this.getSession().createQuery(hql).setParameter(0, cid)
				.setFirstResult(0).setMaxResults(num).list();
		
	}

	@Override
	public List<Question> listQuestionsByChannel(int cid) {
		String hql = "select q from Question q where q.channel.id=?";
		return this.list(hql,cid);
	}

	@Override
	public boolean isUpdateIndex(int cid) {
		String hql = "select count(*) from Channel c where c.isIndex=1 and c.status=0 and c.id=?";
		Long count = (Long)this.getSession().createQuery(hql).setParameter(0, cid).uniqueResult();
		if(count==null||count<=0) return false;
		return true;
	}

	@Override
	public Question loadLastedQuestionByColumn(int cid) {
		String s = "select new Question(q.id,q.title,q.keyword,q.status,q.recommend,q.publishDate,q.author,q.cname,q.coins)";
		String hql = s+" from Question q where q.status=1 and q.channel.id=? order by q.publishDate desc";
		Question Question = (Question)this.getSession()
				.createQuery(hql).setFirstResult(0).setMaxResults(1)
				.setParameter(0, cid).uniqueResult();
		return Question;
	}

}
