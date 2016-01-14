package com.org.opera.service;

import java.util.List;

import com.org.opera.base.DaoSupport;
import com.org.opera.domain.Forum;
import com.org.opera.domain.PageBean;
import com.org.opera.domain.Topic;

public interface TopicService extends DaoSupport<Topic> {

	/**
	 * 查询指定版块中的所有主题，排序：所有置顶帖在最上面，并按最后更新时间排序，让新状态的在上面。
	 * 
	 * @param forum
	 * @return
	 */
	@Deprecated
	List<Topic> findByForum(Forum forum);

	/**
	 * 查询分页信息
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param forum
	 * @return
	 */
	@Deprecated
	PageBean getPageBeanByForum(int pageNum, int pageSize, Forum forum);
	
	/**
	 * 更改主题的置顶、精华、普通的属性
	 * @param topic
	 */
	void changeType(Topic topic,int key);
	
	List<Topic> search(String content);

	void move(Forum forum, Topic topic);

	void edit(Topic topic, String title, String content);

	void delete(Topic topic);



}
