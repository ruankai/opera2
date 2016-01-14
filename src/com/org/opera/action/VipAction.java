package com.org.opera.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.org.opera.base.BaseAction;
import com.org.opera.domain.Vip;

@Controller
@Scope("prototype")
public class VipAction extends BaseAction<Vip>{

	private static final long serialVersionUID = 1L; 
	
	/*+++++++++++��ҳ���ܶ��������++++++++++++++*/
	private int pageSize = 10; //ÿҳ��ʾ��������¼
	private int pageNow = 1; //ϣ����ʾ�ڼ�ҳ��Ĭ��Ϊ��һҳ��
	private int pageCount = 0; //һ���ж���ҳ���������ͨ����㣬rowCount/pageSize����ʼֵΪ1��
	private int rowCount = 0; //һ���ж�������¼����ݿ��в�ѯ�õ���
	
	private InputStream inputStream; // �����ɾ��ť���ж�data����ֵ��Ҫ���õ�InputStream
	/*++++++++++++++++++++++++++++++++++++++*/
	
	/**
	 * ��ʾ����VIP�û��Ĳ�����Ϣ(��ӷ�ҳ����)
	 * @return 
	 * @throws Exception
	 */
	public String listpart() throws Exception {

		rowCount = vipService.getRowCount();

		if (rowCount % pageSize == 0) {
			pageCount = rowCount / pageSize;
		}
		else {
			pageCount = rowCount / pageSize + 1;
		}

		ActionContext.getContext().put("vippart", vipService.getList(pageNow, pageSize));

		ActionContext.getContext().put("pageNow", pageNow);

		ActionContext.getContext().put("pageCount", pageCount);

		return "listpart";
	}

	/**
	 * ��ʾ����ĳ��VIP�û���ȫ����Ϣ
	 * @return
	 * @throws Exception
	 */
	public String listall() throws Exception {
		
		ActionContext.getContext().put("vipall", vipService.getById(model.getId()));

		ActionContext.getContext().put("pageNow", pageNow);

		return "listall";
	}
	
	/**
	 * ɾ��ĳ����ͨ�û�����Ϣ
	 * @return 
	 * @throws Exception
	 */
	public String delete() throws Exception {
		
		try {
			vipService.delete(model.getId());
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
	}
	
	/**
	 * �������ѯVIP�û�������ת��VIP�û��Ĳ�ѯҳ��
	 * @return 
	 * @throws Exception
	 */
	public String querypage() throws Exception {
		
		return "querypage";
	}
	
	/**
	 * ��ѯVIP�û�����Ϣ
	 * @return 
	 * @throws Exception
	 */
	public String query() throws Exception {
		
		ActionContext.getContext().put("vipByTrueName", vipService.queryByTrueName(model.getTrueName()));
		
		return "query";
	}
	
	/*=================================================================================*/
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	
	public int getPageNow() {
		return pageNow;
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public int getPageCount() {
		return pageCount;
	}
	
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	
	public int getRowCount() {
		return rowCount;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

}
