package com.org.opera.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.org.opera.domain.User;
import com.org.opera.service.CourseService;
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

	/*==========================ModelDriven<T>锟斤拷支锟斤拷==============================*/
	
	protected T model;
	
	@SuppressWarnings("unchecked")
	public BaseAction() {
	
		try {
			//通锟斤拷锟斤拷锟饺�odel锟斤拷锟斤拷实锟斤拷锟斤拷
			ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			
			//通锟斤拷锟戒创锟斤拷model锟斤拷实锟斤拷
			model = clazz.newInstance();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public T getModel() {
		
		return model;
	}
	
	/*=============================Service锟斤拷锟斤拷锟斤拷实锟斤拷===============================*/
	
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
	@Resource
	protected CourseService CourseService;
	/*=========================================*/
	
	/**
	 * �峰�褰���诲������
	 * 
	 * @return
	 */
	protected User getCurrentUser() {
		return (User) ActionContext.getContext().getSession().get("user");
	}
	
	// ============== ��〉�ㄧ���� =============

		protected int pageNum = 1; // 褰��椤�
		protected int pageSize = 10; // 姣�〉�剧ず澶���¤�褰�

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