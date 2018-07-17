package cdu.xeon.forum.dwr;

public interface IDwrService {
	
	public void addGroupChannel(int gid,int cid);
	
	
	public void deleteGroupChannel(int gid,int cid);
	
	public void updateIndexPic(int aid);
	
	public void updateAttachInfo(int aid);
	
	public void deleteAttach(int id);
	
	public void updatePicPos(int id, int oldPos, int newPos);
	
	public void updateLinkPos(int id,int oldPos,int newPos);
}
