package com.org.opera.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.org.opera.base.BaseAction;
import com.org.opera.domain.MinrenInfo;
import com.org.opera.service.MinrenInfoService;

@Controller
@Scope("prototype")
public class MinrenInfoAction extends BaseAction<MinrenInfo> {
	
	private Long minrenId;
	
	public Long getMinrenId() {
		return minrenId;
	}

	public void setMinrenId(Long minrenId) {
		this.minrenId = minrenId;
	}

	public String list() throws Exception{
		List<MinrenInfo> minrenList=MinrenInfoService.findAll();
		ActionContext.getContext().put("minrenList", minrenList);
		return "list";
	}
	
	public String show() throws Exception{
		MinrenInfo minren=MinrenInfoService.getById(minrenId);
		if(minren!=null)
		ActionContext.getContext().put("minren", minren);
		return "show";
	}
	
	public String love() throws Exception{
		MinrenInfoService.love(minrenId);
		list();
		return "list";
	}
	
	public String listBack() throws Exception{
		List<MinrenInfo> minrenList=MinrenInfoService.findAll();
		ActionContext.getContext().put("minrenList", minrenList);
		return "listBack";
	}
	
	public String showBack() throws Exception{
		show();
		return "show";
	}
	
	public String addUI() throws Exception{
		
		return "addUI";
	}
	
	public String add() throws Exception{
		MinrenInfoService.save(model);
		return "add";
	}
	
	public String deleteBack() throws Exception{
		MinrenInfoService.delete(minrenId);
		return "deleteBack";
	}
}
