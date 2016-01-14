package com.org.opera.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.org.opera.base.BaseAction;
import com.org.opera.domain.Forum;
import com.org.opera.domain.Reply;
import com.org.opera.domain.Topic;
import com.org.opera.util.QueryHelper;

@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> {

	private Long forumId;
	private Long topicId;
	private int key;
	
	public String delete() throws Exception{
		
		Topic topic = topicService.getById(topicId);
		topicService.delete(topic);
		
		
		return null;
	}

	
	public String editUI() throws Exception{
		Topic topic = topicService.getById(topicId);
		ActionContext.getContext().put("topic", topic);
		return "editUI";
	}
	
	public String edit() throws Exception{
		Topic topic = topicService.getById(topicId);
		String title = model.getTitle();
		String content = model.getContent();
		topicService.edit(topic,title,content);
		return "edit";
		
	}
	
	public String search() throws Exception{
		
		String content = model.getContent();
		List<Topic> searchList = topicService.search(content);
		
		if(searchList!=null){
		System.out.println(searchList+"!!!!!!!!!!!!!!!!!");
		ActionContext.getContext().put("searchList", searchList);
		
		}
		return "search";
	}

	public String changeType() throws Exception{
		
		Topic topic = topicService.getById(topicId);
		topicService.changeType(topic,key);
		
		return "changeType";
	}
	
	/** 显示单个主题（主帖+回帖列表） */
	public String show() throws Exception {
		// 准备数据：topic
		Topic topic = topicService.getById(model.getId());
		ActionContext.getContext().put("topic", topic);

		// // 准备数据：replyList
		// List<Reply> replyList = replyService.findByTopic(topic);
		// ActionContext.getContext().put("replyList", replyList);

		// // 准备分页信息 v1
		// PageBean pageBean = replyService.getPageBeanByTopic(pageNum, pageSize, topic);
		// ActionContext.getContext().getValueStack().push(pageBean);

		// // 准备分页信息 v2
		// String hql = "FROM Reply r WHERE r.topic=? ORDER BY r.postTime ASC";
		// List<Object> parameters = new ArrayList<Object>();
		// parameters.add(topic);
		//
		// PageBean pageBean = replyService.getPageBean(pageNum, pageSize, hql, parameters);
		// ActionContext.getContext().getValueStack().push(pageBean);

		// 准备分页信息, 最终版
		new QueryHelper(Reply.class, "r")//
				.addCondition("r.topic=?", topic)//
				.addOrderProperty("r.postTime", true)//
				.preparePageBean(replyService, pageNum, pageSize);

		return "show";
	}

	/** 发表新主题页面 */
	public String addUI() throws Exception {
		// 准备数据
		Forum forum = forumService.getById(forumId);
		ActionContext.getContext().put("forum", forum);
		return "addUI";
	}

	/** 发表新主题 */
	public String add() throws Exception {
		// 封装
		// >> 表单参数，已经封装了title, content
		// model.setTitle(title);
		// model.setContent(content);
		model.setForum(forumService.getById(forumId));
		// >> 当前直接获取的信息
		model.setAuthor(getCurrentUser()); // 当前登录用户
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr()); // 当前请求中的IP
		model.setPostTime(new Date()); // 当前时间

		// 保存
		topicService.save(model);

		return "toShow"; // 转到新主题的显示页面
	}

	// ---

	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	

}
