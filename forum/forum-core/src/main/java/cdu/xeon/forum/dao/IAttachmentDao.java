package cdu.xeon.forum.dao;

import java.util.List;

import cdu.xeon.basic.dao.IBaseDao;
import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.Attachment;

public interface IAttachmentDao extends IBaseDao<Attachment>{
	
	public Pager<Attachment> findNoUseAttachment();
	
	public long findNoUseAttachmentNum();
	
	public void clearNoUseAttachment();
	
	public void deleteByTopic(int tid);
	
	public List<Attachment> listByTopic(int tid);
	
	public List<Attachment> listIndexPic(int num);
	
	public Pager<Attachment> findChannelPic(int cid);
	
	public Pager<Attachment> listAllIndexPic();
	
	public List<Attachment> listAttachByTopic(int tid);
	
	
}
