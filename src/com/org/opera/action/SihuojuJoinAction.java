package com.org.opera.action;

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
public class SihuojuJoinAction extends BaseAction<SihuojuJoin> {
	
	private Long infoId;
	private Long typeId;
	private Long joinId;

	

	public String join() throws Exception{
		
		if(SihuojuJoinService.findCount(infoId,getCurrentUser().getId())==0){
		model.setUser(getCurrentUser());
		model.setType(2);
		SihuojuInfo info =  SihuojuInfoService.getById(infoId);
		info.setCount(info.getCount()+1);
		model.setSihuojuinfo(info);
		System.out.println(model.getId());
		SihuojuJoinService.save(model);
		}
		
		return "join";
	}
	
	public String peopleBack() throws Exception{
		List<SihuojuJoin> join = SihuojuJoinService.findPeople(infoId);
		ActionContext.getContext().put("joinList", join);
		ActionContext.getContext().put("count", SihuojuInfoService.getById(infoId).getCount());
		
		return "peopleBack";
	}

	public String joinType() throws Exception{
		SihuojuJoinService.changeType(typeId,joinId);
		System.out.println(typeId+"!!!"+joinId);
		ActionContext.getContext().put("testId", SihuojuJoinService.getInfoIdByJoinId(joinId));
		return "joinType";
	}
	
	
	public Long getInfoId() {
		return infoId;
	}

	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}
	
	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	

	public Long getJoinId() {
		return joinId;
	}

	public void setJoinId(Long joinId) {
		this.joinId = joinId;
	}

}
