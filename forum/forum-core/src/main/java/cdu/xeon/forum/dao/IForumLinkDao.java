package cdu.xeon.forum.dao;

import java.util.List;
import java.util.Map;

import cdu.xeon.basic.dao.IBaseDao;
import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.ForumLink;


public interface IForumLinkDao extends IBaseDao<ForumLink>{
	
	public Pager<ForumLink> findByType(String type);
	
	public List<ForumLink> listByType(String type);
	
	public List<String> listAllType();
	
	public Map<String,Integer> getMinAndMaxPos();
	
	public void updatePos(int id,int oldPos,int newPos);
}
