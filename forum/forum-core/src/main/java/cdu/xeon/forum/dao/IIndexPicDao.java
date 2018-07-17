package cdu.xeon.forum.dao;

import java.util.List;
import java.util.Map;

import cdu.xeon.basic.dao.IBaseDao;
import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.IndexPic;

public interface IIndexPicDao extends IBaseDao<IndexPic> {
	
	public List<IndexPic> listIndexPicByNum(int num);
	
	public Pager<IndexPic> findIndexPic();
	
	public List<String> listAllIndexPicName();
	
	public Map<String,Integer> getMinAdnMaxPos();
	
	public void updatePos(int id,int oldPos,int newPos);
}
