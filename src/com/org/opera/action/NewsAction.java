package com.org.opera.action;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
		 writeJson1();
		
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
	
	public void writeJson() throws Exception {
	
		//�����ݴ����ݿ���ȡ����
		List<News> news1 = newsService.getList(1, 3);
		JSONArray jsonArray = JSONArray.fromObject(news1);
		String newsJson1=jsonArray.toString();
		newsJson1=toFormat(newsJson1);
		newsJson1=newsJson1+"more"+":"+"D:/news2.json";
		 FileWriter fw1 = new FileWriter("D:\\news1.json");
         PrintWriter out1 = new PrintWriter(fw1);
         out1.write(newsJson1);
         out1.println();
         fw1.close();
         out1.close();		
           
         System.out.print("hello,word");
         List<News> news2 = newsService.getList(2, 3);
 		JSONArray jsonArray2 = JSONArray.fromObject(news2);
 		 String newsJson2=jsonArray2.toString();
 		System.out.println("newsJsonǰ:" + newsJson2);
 		newsJson2=toFormat(newsJson2);
 		 System.out.println("newsJson��:" + newsJson2);
 		 FileWriter fw2 = new FileWriter("D:\\news7.json");
          PrintWriter out2 = new PrintWriter(fw2);
          out2.write(newsJson2);
          out2.println();
          fw2.close();
          out2.close();
       
	}
	
	public String  toFormat(String org1)
	{
		Pattern patternImg = Pattern.compile("<img src=.+?>");
		Matcher matcherImg = patternImg.matcher(org1);
		org1=matcherImg.replaceAll("");
		org1=org1.replaceAll("null", "");
		org1=org1.replaceAll("&nbsp;", " ");
		org1=org1.replaceAll("<p>", "\n");
		org1=org1.replaceAll("\\\\<p>|</p>","");
		org1=org1.replaceAll("</p>","");
		org1=org1.replaceAll("<\\/p>", "");
		org1=org1.replaceAll("\"", "\"");
		org1=org1.replaceAll("<br />", "");
		org1=org1.replaceAll("<br>", "\n");
		return org1;
	}
	
	public void testJson() throws Exception {
		
		//�����ݴ����ݿ���ȡ����
		String news11=null;
		List<News> news1 = newsService.getList(1, 8);
		for(int i=0;i<=news1.size();i++)
		{	
		  String photoPath=news1.get(0).getText();
		  Pattern pattern = Pattern.compile(".*<img src=\"(.*png).*");
		  Matcher matcher = pattern.matcher(photoPath);
		  if(matcher.find()){
			  photoPath=matcher.group(1);
		  }
//		  photoPath=JSONObject.fromObject(photoPath);
		  news11=news11+photoPath;
		}
		  System.out.println(news11);
			 FileWriter fw2 = new FileWriter("D:\\news8.json");
	          PrintWriter out2 = new PrintWriter(fw2);
	          out2.write(news11);
	          out2.println();
	          fw2.close();
	          out2.close();
   
	}
	public void writeJson1() throws Exception {
			
			//�����ݴ����ݿ���ȡ����
			List<News> news1 = newsService.getList(1, 8);
			JSONObject news = new JSONObject(); 
			String newsStr=null;
			String imgPath1 = null;
			String imgPath2 = null;
			for(int i=0;i<1;i++)
			{
				//��news�е�title��text����JSONArray��
				JSONObject newsi =JSONObject.fromObject(news1.get(i));
				//ƥ���img��·�������Ҹ�ֵ��imgString
				JSONArray imgJson = new JSONArray(); 
//				Pattern pattern = Pattern.compile(".*<img src=\"(.*png).*");
//				String str=news1.get(i).getText();
//				Matcher matcher = pattern.matcher(str);
				String orgStr=news1.get(i).getText();
				Pattern pattern1 = Pattern.compile("<img src=.+?>");
				Matcher matcher1 = pattern1.matcher(orgStr);
		        Pattern pattern2 = Pattern.compile("/.+?\\.[\\w]*[pgf]");
				while (matcher1.find()) {
					imgPath1 = matcher1.group();
					System.out.println("imgPath1="+imgPath1);
					Matcher matcher2 = pattern2.matcher(imgPath1);
					if(matcher2.find()){
						imgPath2 = matcher2.group();
					}
					System.out.println("imgPath2="+imgPath2);
					imgJson.add(imgPath1);
					imgJson.add(imgPath2);
				}
				
				newsi.put("imgPath", imgJson);
				System.out.println(imgJson.toString());
				newsStr=newsStr+newsi.toString();
			}
//				if(matcher.find()){
//					  String imgString=matcher.group(1);
//					  System.out.println(imgString);
//					  imgJson.add(imgString);
//				  }
////				����news��imgPath·������JSONArray��
//				newsi.put("imgPath", imgJson);
//				 newsStr=newsStr+newsi.toString();
//			}
//			
//			System.out.println("newsJson:" + newsStr);
			 newsStr=toFormat(newsStr);
			 FileWriter fw1 = new FileWriter("D:\\news3.json");
	         PrintWriter out1 = new PrintWriter(fw1);
	         out1.write(newsStr);
	         out1.println();
	         fw1.close();
	         out1.close();
			
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
