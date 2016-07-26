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
	
	/* +++++++++++��ҳ���ܶ��������++++++++++++++ */
	private int pageSize = 3; // ÿҳ��ʾ��������¼
	private int pageNow = 1; // ϣ����ʾ�ڼ�ҳ��Ĭ��Ϊ��һҳ��
	private int pageCount = 0; // һ���ж���ҳ���������ͨ�����㣬rowCount/pageSize����ʼֵΪ1��
	private int rowCount = 0; // һ���ж�������¼�����ݿ��в�ѯ�õ���
	
	private InputStream inputStream; // �����ɾ����ť���ж�data����ֵ��Ҫ���õ�InputStream

	
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
	 * ����(title+text)�б�(��̨)
	 * @return
	 * @throws Exception
	 */
	public String allUI() throws Exception {
		
		News listNews = newsService.getById(model.getId());
		
		ActionContext.getContext().put("listNews", listNews);
		
		return "allUI";
	}
	
	/**
	 * ��ѯҳ��(��̨)
	 * @return
	 * @throws Exception
	 */
	public String queryUI() throws Exception {
		
		return "queryUI";
	}
	
	/**
	 * ��ѯ���(��̨)
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		
		List<News> listNews = newsService.getByTitle(model.getTitle());
		
		ActionContext.getContext().put("listNews", listNews);
		
		return "query";
	}
	
	/**
	 * ɾ������(��̨)
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
	 * �������ҳ��(��̨)
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		
		return "saveUI";
	}
	
	/**
	 * �������(��̨)
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		
		newsService.save(model);
		
		return "toList";
	}
	
	/**
	 * �޸�����ҳ��(��̨)
	 * @return
	 * @throws Exception
	 */
	public String editUI() throws Exception {
		
		//׼����������
		News news = newsService.getById(model.getId());
		
		//��news����ֵջ��ջ��
		ActionContext.getContext().getValueStack().push(news);
		
		return "saveUI";
	}
	
	/**
	 * �޸�����(��̨)
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception {
		
		//�����ݴ����ݿ���ȡ����
		News news = newsService.getById(model.getId());
		
		//�޸���ص�����
		news.setTitle(model.getTitle());
		news.setText(model.getText());
		
		//���µ����ݿ���
		newsService.update(news);
		
		return "toList";
	}
	/*==========================================================*/
	
	/**
	 * ��վ��������顢����(ǰ̨)[main_right_one]
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
 * ��ʾ��������title(ǰ̨)
 * @return
 * @throws Exception
 *
public String showMore() throws Exception {
	
	List<News> listNews = newsService.findAllDesc();
	
	ActionContext.getContext().put("listNews", listNews);
	
	return "showMore";
}*/

/**
 * ��ǰ̨��ʾǰ�������ű���
 * @return
 * @throws Exception
 *
public String show1() throws Exception {
	
	List<News> list1 = newsService.queryById1();
	
	ActionContext.getContext().put("list1", list1);
	
	return "show1";
}*/

/**
 * ��ʾǰ�������ŵ�text(ǰ̨)
 * @return
 * @throws Exception
 *
public String showText() throws Exception {
	
	News news = newsService.getById(model.getId());
	
	ActionContext.getContext().put("news", news);
	
	return "showText";
}*/

/**
 * ��ʾ���е�����text(ǰ̨)
 * @return
 * @throws Exception
 *
public String show() throws Exception {
	
	News news = newsService.getById(model.getId());
	
	ActionContext.getContext().put("news", news);
	
	return "show";
}*/

/**
 * ������ҳ(ǰ̨)
 * @return
 * @throws Exception
 *
public String toIndex() throws Exception {
	
	return "toIndex";
}*/

/**
 * ��������(title)�б�(ǰ̨)
 * @return
 * @throws Exception
 *
public String toNewsList() throws Exception {
	
	return "toNewsList";
}*/

/**
 * ����(title)�б�(��̨)
 * @return
 * @throws Exception
 */