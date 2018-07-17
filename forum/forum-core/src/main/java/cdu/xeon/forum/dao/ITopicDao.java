package cdu.xeon.forum.dao;


import java.util.List;

import cdu.xeon.basic.dao.IBaseDao;
import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.Topic;

public interface ITopicDao extends IBaseDao<Topic>{
	
	public Pager<Topic> find(Integer cid,String title,Integer status);
	
	public Pager<Topic> find(Integer uid,Integer cid,String title,Integer status);
	
	public Pager<Topic> searchTopicByKeyword(String keyword);
	
	public Pager<Topic> searchTopic(String con);
	
	public Pager<Topic> findRecommendTopic(Integer ci);
	
	public List<Topic> listTopicByChannelAndNumber(int cid,int num);
	
	public List<Topic> listTopicsByChannel(int cid);
	
	public boolean isUpdateIndex(int cid);
	
	public Topic loadLastedTopicByColumn(int cid);
}
