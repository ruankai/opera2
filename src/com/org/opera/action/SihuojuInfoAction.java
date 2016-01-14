package com.org.opera.action;

import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.org.opera.base.BaseAction;
import com.org.opera.domain.SihuojuInfo;
import com.org.opera.domain.SihuojuJoin;
import com.org.opera.service.SihuojuInfoService;
import com.org.opera.service.SihuojuJoinService;

@Controller
@Scope("prototype")
public class SihuojuInfoAction extends BaseAction<SihuojuInfo> {
	
	private Long userId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	private Long infoId;
	
	public Long getInfoId() {
		return infoId;
	}
	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}
	/**
	 * 显示首页
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		
		List<SihuojuInfo> infoList = SihuojuInfoService.findAll();
		Collections.reverse(infoList);
		ActionContext.getContext().put("infoList",infoList);
		
		return "list";		
	}
	/**
	 * 显示活动详细
	 * @return
	 * @throws Exception
	 */
	public String show() throws Exception{
		
		SihuojuInfo info = SihuojuInfoService.getById(infoId); 
		if(info!=null)
		ActionContext.getContext().put("info",info);
		
		return "show";
	}
	
	public String addUI() throws Exception{
		
		return "addUI";
	}
	
	public String add() throws Exception{
		model.setUser(getCurrentUser());
		SihuojuInfoService.save(model);
		return "add";
	}

	public String auditList() throws Exception{
		//------
		userId  = getCurrentUser().getId();
		System.out.println(userId+"!!!");
		List<SihuojuInfo> auditList= SihuojuInfoService.getIdByUser(userId);
		Collections.reverse(auditList);
		ActionContext.getContext().put("auditList", auditList);
		return "auditList";
	}
	
	public String auditShow() throws Exception{
		System.out.println("infoId:"+infoId);
		List<SihuojuJoin> auditShowList = SihuojuJoinService.getType(infoId);
		ActionContext.getContext().put("auditShowList", auditShowList);
		ActionContext.getContext().put("joinCount", SihuojuInfoService.getById(infoId).getCount());
		return "auditShow";
	}
	
	
	public String listBack() throws Exception{
		List<SihuojuInfo> infoList = SihuojuInfoService.findAll();
		Collections.reverse(infoList);
		ActionContext.getContext().put("infoList",infoList);
		return "listBack";
	}
	
	public String showBack() throws Exception{
		SihuojuInfo info = SihuojuInfoService.getById(infoId); 
		if(info!=null)
		ActionContext.getContext().put("info",info);
		return "showBack";
	}
	
	public String deleteBack() throws Exception{
		SihuojuInfoService.delete(infoId);
		System.out.println(infoId);
		return "deleteBack";
	}
	
	/**
	 * 显示用户的活动
	 * @return
	 * @throws Exception
	 */
	public String showJoin() throws Exception{
		List<SihuojuJoin> myList=SihuojuJoinService.showJoin(getCurrentUser().getId());
		List<SihuojuInfo> myList2=SihuojuInfoService.getIdByUser(getCurrentUser().getId());
		Collections.reverse(myList);
		Collections.reverse(myList2);
		ActionContext.getContext().put("myList",myList);
		ActionContext.getContext().put("myList2",myList2);
		return "showJoin";
	}

	

}
