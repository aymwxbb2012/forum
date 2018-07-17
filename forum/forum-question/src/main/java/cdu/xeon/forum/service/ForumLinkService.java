package cdu.xeon.forum.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.dao.IForumLinkDao;
import cdu.xeon.forum.model.ForumLink;
import org.springframework.stereotype.Service;

@Service("forumLinkService")
public class ForumLinkService implements IForumLinkService {
	private IForumLinkDao forumLinkDao;
	
	

	public IForumLinkDao getForumLinkDao() {
		return forumLinkDao;
	}

	@Inject
	public void setforumLinkDao(IForumLinkDao forumLinkDao) {
		this.forumLinkDao = forumLinkDao;
	}

	@Override
	public void add(ForumLink cl) {
		forumLinkDao.add(cl);
	}

	@Override
	public void delete(int id) {
		forumLinkDao.delete(id);
	}

	@Override
	public void update(ForumLink cl) {
		forumLinkDao.update(cl);
	}

	@Override
	public ForumLink load(int id) {
		return forumLinkDao.load(id);
	}

	@Override
	public Pager<ForumLink> findByType(String type) {
		return forumLinkDao.findByType(type);
	}

	@Override
	public List<ForumLink> listByType(String type) {
		return forumLinkDao.listByType(type);
	}

	@Override
	public List<String> listAllType() {
		return forumLinkDao.listAllType();
	}

	@Override
	public Map<String, Integer> getMinAndMaxPos() {
		return forumLinkDao.getMinAndMaxPos();
	}

	@Override
	public void updatePos(int id, int oldPos, int newPos) {
		forumLinkDao.updatePos(id, oldPos, newPos);
	}

}
