package com.org.opera.action;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.org.opera.base.BaseAction;
import com.org.opera.domain.PageBean;
import com.org.opera.domain.Text;

@Controller
@Scope("prototype")
public class TextAction extends BaseAction<Text>{
	
	private static final long serialVersionUID = 1L;
	//接收的页面参数
	private String keyword="";
	private int currentPage=1;
	private int pageSize=1;	

	public String addUI(){
		return "addUI";
	}
	public String add(){// TODO
		Text text=new Text();
		text.setTitle(model.getTitle());
		text.setAuthor(model.getAuthor());
		text.setThemes(model.getThemes());
		text.setContent(model.getContent());
		text.setUrl(model.getUrl());
		text.setISSN(model.getISSN());
		textService.save(text);
		//重新计算页数，使显示页面跳转到最后一页以验证插入成功	
		return "toList";
	}
	public String editUI(){
		model=textService.getById(model.getTextId());
		//text需要压入对象栈，因为text没有get方法，不会自动存入
		ActionContext.getContext().getValueStack().push(model);
		return "editUI";
	}
	public String edit(){// TODO
		Text text=textService.getById(model.getTextId());
		text.setTitle(model.getTitle());
		text.setThemes(model.getThemes());
		text.setAuthor(model.getAuthor());
		text.setContent(model.getContent());
		text.setUrl(model.getUrl());
		text.setISSN(model.getISSN());
		textService.update(text);
		return "toList";
	}
	public String delete(){
		textService.delete(model.getTextId());
		return "toList";
	}
	public String detail(){
		Text text=textService.getById(model.getTextId());
		ActionContext.getContext().getValueStack().push(text);
		return "detail";
	}
	/**
	 * 根据关键词查询出所有的Text实例(添加分页功能)
	 */
	public String list(){// TODO
		if(keyword!=null&&!("".equals(keyword))){
			currentPage=1;	//用户可能在第几页时查询
			ActionContext.getContext().put("kw", keyword);//关键词回显
		}
		PageBean pageBean=textService.getPageBean(currentPage,pageSize,keyword);	
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}
	//生成get和set方法
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
