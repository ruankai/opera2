package com.org.opera.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.org.opera.action.SongAction;
import com.org.opera.domain.User;
import com.org.opera.service.ForumService;
import com.org.opera.service.ManagerService;
import com.org.opera.service.MinrenInfoService;
import com.org.opera.service.NewsService;
import com.org.opera.service.PhotoService;
import com.org.opera.service.ReplyService;
import com.org.opera.service.SihuojuInfoService;
import com.org.opera.service.SihuojuJoinService;
import com.org.opera.service.SongService;
import com.org.opera.service.TextService;
import com.org.opera.service.TopicService;
import com.org.opera.service.UserService;
import com.org.opera.service.VideoService;
import com.org.opera.service.VipService;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	private static final long serialVersionUID = 1L;

	/*==========================ModelDriven<T>��֧��==============================*/
	
	protected T model;
	
	@SuppressWarnings("unchecked")
	public BaseAction() {
	
		try {
			//ͨ�����ȡmodel����ʵ����
			ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			
			//ͨ���䴴��model��ʵ��
			model = clazz.newInstance();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public T getModel() {
		
		return model;
	}
	
	/*=============================Service������ʵ��===============================*/
	
	@Resource
	protected UserService userService;
	
	@Resource
	protected ManagerService managerService;
	
	@Resource
	protected VipService vipService;
	
	@Resource
	protected NewsService newsService;
	
	@Resource
	protected TextService textService;
	
	@Resource
	protected PhotoService photoService;
	
	@Resource
	protected SongService songService;
	
	@Resource
	protected VideoService videoService;
	@Resource
	protected ForumService forumService;
	@Resource
	protected TopicService topicService;
	@Resource
	protected ReplyService replyService;
	@Resource
	protected SihuojuInfoService SihuojuInfoService;
	@Resource
	protected SihuojuJoinService SihuojuJoinService;
	@Resource
	protected MinrenInfoService MinrenInfoService;
	/*=========================================*/
	
	/**
	 * 获取当前登录的用户
	 * 
	 * @return
	 */
	protected User getCurrentUser() {
		return (User) ActionContext.getContext().getSession().get("user");
	}
	
	// ============== 分页用的参数 =============

		protected int pageNum = 1; // 当前页
		protected int pageSize = 10; // 每页显示多少条记录

		public int getPageNum() {
			return pageNum;
		}

		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}

		public int getPageSize() {
			return pageSize;
		}

		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
	
}