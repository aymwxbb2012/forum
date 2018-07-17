package cdu.xeon.forum.service;

import java.util.List;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.Topic;

public interface ITopicService {
	
	public void add(Topic topic,int cid,int uid,Integer[] aids);
	
	public void add(Topic topic,int cid,int uid);
	
	
	public void delete(int id);
	
	public void update(Topic topic,int cid,Integer[] aids);
	
	public void update(Topic topic,int cid);
	
	public void updateStatus(int tid);
	
	public Topic load(int id);
	
	
	public Pager<Topic> find(Integer cid,String title,Integer status);
	
	public Pager<Topic> find(Integer uid,Integer cid,String title,Integer status);
	
	public Pager<Topic> searchTopicByKeyword(String keyword);
	
	public Pager<Topic> searchTopic(String con);
	
	public Pager<Topic> findRecommendTopic(Integer ci);
	
	public List<Topic> listTopicByChannelAndNumber(int cid,int num);
	
	public List<Topic> listTopicByChannel(int cid);
	
	
	public boolean isUpdateIndex(int cid);
	
	public Topic loadLastedTopicByColumn(int cid);
}
