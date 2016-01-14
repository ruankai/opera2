package com.org.opera.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.opera.base.DaoSupportImpl;
import com.org.opera.domain.Forum;
import com.org.opera.domain.PageBean;
import com.org.opera.domain.Topic;
import com.org.opera.service.TopicService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class TopicServiceImpl extends DaoSupportImpl<Topic> implements TopicService {

	
	@Deprecated
	public List<Topic> findByForum(Forum forum) {
		return getSession().createQuery(//
				// 排序：所有置顶帖在最上面，并按最后更新时间排序，让新状态的在上面。
				"FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC")//
				.setParameter(0, forum)//
				.list();
	}

	@Override
	public void save(Topic topic) {
		// 1，设置属性并保存
		topic.setType(Topic.TYPE_NORMAL); // 默认为普通帖
		topic.setReplyCount(0);
		topic.setLastReply(null);
		topic.setLastUpdateTime(topic.getPostTime());
		getSession().save(topic); // 保存

		// 2，维护相关的特殊属性
		Forum forum = topic.getForum();
		forum.setTopicCount(forum.getTopicCount() + 1); // 主题数量
		forum.setArticleCount(forum.getArticleCount() + 1);// 文章数量（主题数+回复数）
		forum.setLastTopic(topic); // 最后发表的主题
		getSession().update(forum);
	}

	public PageBean getPageBeanByForum(int pageNum, int pageSize, Forum forum) {

		// 查询本页的数据列表
		List list = getSession().createQuery(//
				"FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC")//
				.setParameter(0, forum)//
				.setFirstResult((pageNum - 1) * pageSize)//
				.setMaxResults(pageSize)//
				.list();

		// 查询总记录数量
		Long count = (Long) getSession().createQuery(//
				"SELECT COUNT(*) FROM Topic t WHERE t.forum=?")//
				.setParameter(0, forum)//
				.uniqueResult();

		return new PageBean(pageNum, pageSize, count.intValue(), list);
	}

	
	//-------------------------------------------------------
	
	
	public void changeType(Topic topic,int key) {
		
		if(key==0)
		topic.setType(Topic.TYPE_NORMAL);
		else if(key==1)
		topic.setType(Topic.TYPE_BEST);
		else
		topic.setType(Topic.TYPE_TOP);
		
		getSession().save(topic); // 保存
		
	}
	
	public List<Topic> search(String content){
		System.out.println(content+"123");
		String hql = "FROM Topic WHERE title like '%"+content+"%'"+"ORDER BY lastUpdateTime DESC";
		return  getSession().createQuery(hql).list();
	}
	
	public void move(Forum forum/*新的*/, Topic topic/*旧的*/){
		
		if(topic!=null){
		//旧的
		topic.getForum().setTopicCount(topic.getForum().getTopicCount()-1);//主题数-1
		topic.getForum().setArticleCount(topic.getForum().getArticleCount()-topic.getReplyCount()-1);//文章数(评论数)-要更改的主题的评论数
		//新的
		forum.setTopicCount(forum.getTopicCount()+1);
		forum.setArticleCount(forum.getArticleCount()+topic.getReplyCount()+1);
		//保存更改
		topic.setForum(forum);
		getSession().save(topic);
		
		
		}
		else
			System.out.println("空！");
	}
	
	public void edit(Topic topic, String title, String content){
		
	
		topic.setTitle(title);
		topic.setContent(content);
		getSession().save(topic);
		
	}
	
	public void delete(Topic topic){
		
		//1.删除forum中的主题数和评论数
		topic.getForum().setTopicCount(topic.getForum().getTopicCount()-1);//主题数-1
		topic.getForum().setArticleCount(topic.getForum().getArticleCount()-topic.getReplyCount()-1);//文章数(评论数)-要更改的主题的评论数
		getSession().save(topic);
//		//2.删除评论
//		Long topicId=topic.getId();
//		String hql = "DELETE FROM Reply r WHERE r.topicId='"+topicId+"'";
//		getSession().createSQLQuery(hql);
		//3.删除主题
		getSession().delete(topic);
	}

}
