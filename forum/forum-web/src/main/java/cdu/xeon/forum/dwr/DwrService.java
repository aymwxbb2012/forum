package cdu.xeon.forum.dwr;

import javax.inject.Inject;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import cdu.xeon.forum.service.IAttachmentService;
import cdu.xeon.forum.service.IForumLinkService;
import cdu.xeon.forum.service.IGroupService;
import cdu.xeon.forum.service.IIndexPicService;

@RemoteProxy(name="dwrService")
public class DwrService implements IDwrService{
	private IGroupService groupService;
	private IAttachmentService attachmentService;
	private IIndexPicService indexPicService;
	private IForumLinkService forumLinkService;
	
	
	
	
	public IForumLinkService getForumLinkService() {
		return forumLinkService;
	}
	@Inject
	public void setCmsLinkService(IForumLinkService forumLinkService) {
		this.forumLinkService = forumLinkService;
	}
	public IIndexPicService getIndexPicService() {
		return indexPicService;
	}
	@Inject
	public void setIndexPicService(IIndexPicService indexPicService) {
		this.indexPicService = indexPicService;
	}
	public IAttachmentService getAttachmentService() {
		return attachmentService;
	}
	@Inject
	public void setAttachmentService(IAttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}
	public IGroupService getGroupService() {
		return groupService;
	}
	@Inject
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}

	@Override
	@RemoteMethod
	public void addGroupChannel(int gid, int cid) {
		groupService.addGroupChannel(gid, cid);
	}

	@Override
	@RemoteMethod
	public void deleteGroupChannel(int gid, int cid) {
		groupService.deleteGroupChannel(gid, cid);
	}
	@Override
	@RemoteMethod
	public void updateIndexPic(int aid) {
		System.out.println("dwrservice:"+aid);
		attachmentService.updateIndexPic(aid);
	}
	@Override
	@RemoteMethod
	public void updateAttachInfo(int aid) {
		attachmentService.updateAttachInfo(aid);
	}
	@Override
	@RemoteMethod
	public void deleteAttach(int id) {
		attachmentService.delete(id);
	}
	@Override
	@RemoteMethod
	public void updatePicPos(int id, int oldPos, int newPos) {
		indexPicService.updatePos(id, oldPos, newPos);
	}
	@Override
	@RemoteMethod
	public void updateLinkPos(int id, int oldPos, int newPos) {
		forumLinkService.updatePos(id, oldPos, newPos);
	}

}
