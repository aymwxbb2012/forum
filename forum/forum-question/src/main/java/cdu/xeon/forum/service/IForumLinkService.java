package cdu.xeon.forum.service;

import java.util.List;
import java.util.Map;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.ForumLink;

public interface IForumLinkService {
	public void add(ForumLink cl);
	public void delete(int id);
	public void update(ForumLink cl);
	public ForumLink load(int id);
	
	public Pager<ForumLink> findByType(String type);
	
	public List<ForumLink> listByType(String type);
	
	public List<String> listAllType();
	
	public Map<String,Integer> getMinAndMaxPos();
	
	public void updatePos(int id,int oldPos,int newPos);
	
}
