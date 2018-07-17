package cdu.xeon.forum.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.IndexPic;

public interface IIndexPicService {
	public void add(IndexPic indexPic);
	public void update(IndexPic indexPic);
	public void delete(int id);
	public void updateStatus(int id);
	public IndexPic load(int id);
	
	public List<IndexPic> listIndexPicByNum(int num);
	
	public Pager<IndexPic> findIndexPic();
	
	public List<String> listAllIndexPicName();
	
	public void cleanNoUseIndexPic(List<String> pics) throws IOException;
	
	public Map<String,Integer> getMinAdnMaxPos();
	
	public void updatePos(int id, int oldPos, int newPos);
}
