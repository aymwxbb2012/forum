package cdu.xeon.forum.service;

import java.util.List;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.Keyword;


public interface IKeywordService {
	public void addOrUpdate(String name);
	
	public List<Keyword> getKeywordByTimes(int num);
	
	public List<Keyword> getMaxTimesKeyword(int num);
	
	public Pager<Keyword> findNoUseKeyword();
	
	public void clearNoUseKeyword();
	
	public List<Keyword> findUseKeyword();
	
	public List<Keyword> listKeywordByCon(String con);
	
	public List<String> listKeywordStringByCon(String con);
}
