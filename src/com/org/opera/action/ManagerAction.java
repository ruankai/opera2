package com.org.opera.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.org.opera.base.BaseAction;
import com.org.opera.domain.Manager;

@Controller
@Scope("prototype")
public class ManagerAction extends BaseAction<Manager> {

	private static final long serialVersionUID = 1L;
	
	/*+++++++++++��ҳ���ܶ��������++++++++++++++*/
	private int pageSize = 10; //ÿҳ��ʾ��������¼
	private int pageNow = 1; //ϣ����ʾ�ڼ�ҳ��Ĭ��Ϊ��һҳ��
	private int pageCount = 0; //һ���ж���ҳ���������ͨ����㣬rowCount/pageSize����ʼֵΪ1��
	private int rowCount = 0; //һ���ж�������¼����ݿ��в�ѯ�õ���
	
	private InputStream inputStream; // �����ɾ��ť���ж�data����ֵ��Ҫ���õ�InputStream
	
	private String newPwdOne;
	private String newPwdTwo;
	/*++++++++++++++++++++++++++++++++++++++*/

	/**
	 * ����Ա��¼
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		
		Manager manager = managerService.findByLoginNameAndPassword(model.getName(), model.getPassword());

		if(manager == null) {
			this.addActionError("用户名或用户密码出错，请重新输入");
			return "loginError";
		}
		else {
			ActionContext.getContext().getSession().put("manager", manager);
			
			return "loginSuccess";
		}
	}
	
	/**
	 * ��ʾ���й���Ա�Ĳ�����Ϣ(��ӷ�ҳ����)
	 * @return 
	 * @throws Exception
	 */
	public String listpart() throws Exception {

		rowCount = managerService.getRowCount();

		if (rowCount % pageSize == 0) {
			pageCount = rowCount / pageSize;
		}
		else {
			pageCount = rowCount / pageSize + 1;
		}

		ActionContext.getContext().put("managerpart", managerService.getList(pageNow, pageSize));

		ActionContext.getContext().put("pageNow", pageNow);

		ActionContext.getContext().put("pageCount", pageCount);

		return "listpart";
	}
	
	/**
	 * ��ѯ����ĳ������Ա��ȫ����Ϣ
	 * @return 
	 * @throws Exception
	 */
	public String listall() throws Exception {

		ActionContext.getContext().put("managerall", managerService.getById(model.getId()));

		ActionContext.getContext().put("pageNow", pageNow);

		return "listall";
	}
	
	/**
	 * action��ɾ��ĳ������Ա����Ϣ
	 * @return 
	 * @throws Exception
	 */
	public String delete() throws Exception {

		try {
			managerService.delete(model.getId());
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
	 * ����޸ĵĳ����ӣ������޸ĵĽ���
	 * @return 
	 * @throws Exception
	 */
	public String editUI() throws Exception {
		
		//׼���������
		Manager manager = managerService.getById(model.getId());

		//��manager����ֵջ��ջ��
		ActionContext.getContext().getValueStack().push(manager);
		
		return "saveUI";
	}
	
	/**
	 * �޸Ĺ���Ա��Ϣ
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception {
		
		//����ݴ���ݿ���ȡ����
		Manager manager = managerService.getById(model.getId());
		
		//�޸���ص�����
		manager.setPassword(model.getPassword());
		manager.setName(model.getName());
		manager.setTrueName(model.getTrueName());
		manager.setGender(model.getGender());
		manager.setBirthday(model.getBirthday());
		manager.setPlace(model.getPlace());
		manager.setTel(model.getTel());
		manager.setEmail(model.getEmail());
		manager.setWechat(model.getWechat());
		manager.setLevel(model.getLevel());
		
		//���µ���ݿ���
		managerService.update(manager);
		
		return "toList";
	}
	
	/**
	 * ��ӹ���Ա�û�ҳ��
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		
		return "saveUI";
	}
	
	/**
	 * ��ӹ���Ա�û�
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		
		managerService.save(model);
		
		return "toList";
	}
	
	/**
	 * �������ѯ����Ա�û�������ת����ͨ�û��Ĳ�ѯҳ��
	 * @return
	 * @throws Exception
	 */
	public String querypage() throws Exception {
		
		return "querypage";
	}
	
	/**
	 * �����ʵ�����ѯ
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		
		ActionContext.getContext().put("managerByTrueName", managerService.queryByTrueName(model.getTrueName()));
		
		return "query";
	}
	
	/**
	 * ��ת���޸ĵ������ҳ��
	 * @return
	 * @throws Exception
	 */
	public String updatepwd() throws Exception {
		
		Manager managerOne = (Manager)ActionContext.getContext().getSession().get("manager");
		Manager managerTwo = managerService.getById(managerOne.getId());
		
		ActionContext.getContext().getValueStack().push(managerTwo);
		
		return "updatepwd";
	}
	
	/**
	 * ����Ա�޸��Լ�������
	 * @return
	 * @throws Exception
	 */
	public String savepwd() throws Exception {
		
		String newPwd = "";
		
		if(newPwdOne.length() != 0 && newPwdTwo.length() != 0 && newPwdOne.equals(newPwdTwo)) {
			
			newPwd = newPwdOne;
			
			if(managerService.updatePwd(model.getName(), model.getPassword(), newPwd) != 0) {
				
				return "updatePwdSuccess";
			}
			else {
				
				return "updatePwdError";
			}
		}
		
		return "updatePwdError";
	}
	
	/**
	 * �˳���¼
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception {
		
		return "toLogin";
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
	
	public String getNewPwdOne() {
		return newPwdOne;
	}

	public void setNewPwdOne(String newPwdOne) {
		this.newPwdOne = newPwdOne;
	}

	public String getNewPwdTwo() {
		return newPwdTwo;
	}

	public void setNewPwdTwo(String newPwdTwo) {
		this.newPwdTwo = newPwdTwo;
	}
}
