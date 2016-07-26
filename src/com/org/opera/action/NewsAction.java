package com.org.opera.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.org.opera.base.BaseAction;
import com.org.opera.domain.News;

@Controller
@Scope("prototype")
public class NewsAction extends BaseAction<News> {

	private static final long serialVersionUID = 1L;
	
	/* +++++++++++分页功能定义的属性++++++++++++++ */
	private int pageSize = 3; // 每页显示多少条记录
	private int pageNow = 1; // 希望显示第几页（默认为第一页）
	private int pageCount = 0; // 一共有多少页（这个可以通过计算，rowCount/pageSize，初始值为1）
	private int rowCount = 0; // 一共有多少条记录（数据库中查询得到）
	
	private InputStream inputStream; // 当点击删除按钮，判断data的数值需要调用的InputStream

	
	public String listNewsBack() throws Exception {
		
		rowCount = newsService.getRowCount();
		
		if (rowCount % pageSize == 0) {
			pageCount = rowCount / pageSize;
		}
		else {
			pageCount = rowCount / pageSize + 1;
		}
		
		List<News> listNews = newsService.getList(pageNow, pageSize);
		
		ActionContext.getContext().put("listNews", listNews);
		
		ActionContext.getContext().put("pageNow", pageNow);
		
		ActionContext.getContext().put("pageCount", pageCount);
		
		return "listNewsBack";
	}
	
	/**
	 * 新闻(title+text)列表(后台)
	 * @return
	 * @throws Exception
	 */
	public String allUI() throws Exception {
		
		News listNews = newsService.getById(model.getId());
		
		ActionContext.getContext().put("listNews", listNews);
		
		return "allUI";
	}
	
	/**
	 * 查询页面(后台)
	 * @return
	 * @throws Exception
	 */
	public String queryUI() throws Exception {
		
		return "queryUI";
	}
	
	/**
	 * 查询结果(后台)
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		
		List<News> listNews = newsService.getByTitle(model.getTitle());
		
		ActionContext.getContext().put("listNews", listNews);
		
		return "query";
	}
	
	/**
	 * 删除新闻(后台)
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		
		try {
			newsService.delete(model.getId());
			inputStream = new ByteArrayInputStream("1".getBytes("utf-8"));
		}
		catch (Exception e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("utf-8"));
			}
			catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "ajax-success";
		
		/*newsService.delete(model.getId());
		
		return "toList";*/
	}
	
	/**
	 * 添加新闻页面(后台)
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		
		return "saveUI";
	}
	
	/**
	 * 添加新闻(后台)
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		
		newsService.save(model);
		
		return "toList";
	}
	
	/**
	 * 修改新闻页面(后台)
	 * @return
	 * @throws Exception
	 */
	public String editUI() throws Exception {
		
		//准备回显数据
		News news = newsService.getById(model.getId());
		
		//将news放在值栈的栈顶
		ActionContext.getContext().getValueStack().push(news);
		
		return "saveUI";
	}
	
	/**
	 * 修改新闻(后台)
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception {
		
		//把数据从数据库中取出来
		News news = newsService.getById(model.getId());
		
		//修改相关的属性
		news.setTitle(model.getTitle());
		news.setText(model.getText());
		
		//更新到数据库中
		newsService.update(news);
		
		return "toList";
	}
	/*==========================================================*/
	
	/**
	 * 网站建设的提议、倡导(前台)[main_right_one]
	 * @return
	 * @throws Exception
	 */
	public String proposeText() throws Exception {
		
		return "proposeText";
	}
	
	/*******************************************/
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

}
/**
 * 显示所有新闻title(前台)
 * @return
 * @throws Exception
 *
public String showMore() throws Exception {
	
	List<News> listNews = newsService.findAllDesc();
	
	ActionContext.getContext().put("listNews", listNews);
	
	return "showMore";
}*/

/**
 * 在前台显示前两条新闻标题
 * @return
 * @throws Exception
 *
public String show1() throws Exception {
	
	List<News> list1 = newsService.queryById1();
	
	ActionContext.getContext().put("list1", list1);
	
	return "show1";
}*/

/**
 * 显示前两条新闻的text(前台)
 * @return
 * @throws Exception
 *
public String showText() throws Exception {
	
	News news = newsService.getById(model.getId());
	
	ActionContext.getContext().put("news", news);
	
	return "showText";
}*/

/**
 * 显示所有的新闻text(前台)
 * @return
 * @throws Exception
 *
public String show() throws Exception {
	
	News news = newsService.getById(model.getId());
	
	ActionContext.getContext().put("news", news);
	
	return "show";
}*/

/**
 * 返回首页(前台)
 * @return
 * @throws Exception
 *
public String toIndex() throws Exception {
	
	return "toIndex";
}*/

/**
 * 返回新闻(title)列表(前台)
 * @return
 * @throws Exception
 *
public String toNewsList() throws Exception {
	
	return "toNewsList";
}*/

/**
 * 新闻(title)列表(后台)
 * @return
 * @throws Exception
 */