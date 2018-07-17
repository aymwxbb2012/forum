package cdu.xeon.forum.dao;

import java.util.List;

import cdu.xeon.basic.dao.IBaseDao;
import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.Keyword;

public interface IKeywordDao extends IBaseDao<Keyword>{
	
	public void addOrUpdate(String name);
	
	public Pager<Keyword> findNoUseKeyword();
	
	public void clearNoUseKeyword();
	
	public List<Keyword> findUseKeyword();
	
	public List<Keyword> listKeywordByCon(String con);
	
	public List<String> listKeywordStringByCon(String con);
}
