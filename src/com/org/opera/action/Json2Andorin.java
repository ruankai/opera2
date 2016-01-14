package com.org.opera.action;


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
public class Json2Andorin extends BaseAction<News> {
	public void writeJson() throws Exception {
		
		//�����ݴ����ݿ���ȡ����
		List<News> news1 = newsService.getList(1, 8);
		JSONObject news = new JSONObject(); 
		String newsStr=null;
		for(int i=0;i<news1.size();i++)
		{
			//��news�е�title��text����JSONArray��
			JSONObject newsi =JSONObject.fromObject(news1.get(i));
			//ƥ���img��·�������Ҹ�ֵ��imgString
			JSONArray imgJson = new JSONArray(); 
			Pattern pattern = Pattern.compile(".*<img src=\"(.*png).*");
			String str=news1.get(i).getText();
			Matcher matcher = pattern.matcher(str);
			if(matcher.find()){
				  String imgString=matcher.group(1);
				  imgJson.add(imgJson);
			  }
//			����news��imgPath·������JSONArray��
			newsi.put("imgPath", imgJson);
			 newsStr=newsStr+newsi.toString();
		}
		 newsStr=toFormat(newsStr);
		 FileWriter fw1 = new FileWriter("D:\\news1.json");
         PrintWriter out1 = new PrintWriter(fw1);
         out1.write(newsStr);
         out1.println();
         fw1.close();
         out1.close();		
}
	public String  toFormat(String org1)
	{
		Pattern p = Pattern.compile("<\\\\/p>");
		Matcher m = p.matcher(org1);
		org1 = m.replaceAll("a");
		org1=org1.replaceAll("&nbsp;", " ");
		org1=org1.replaceAll("<p>", "\n");
		org1=org1.replaceAll("\\\\<p>|</p>","");
		org1=org1.replaceAll("</p>","");
		org1=org1.replaceAll("<\\/p>", "");
		org1=org1.replaceAll("��", "\"");
		org1=org1.replaceAll("��", "\"");
		org1=org1.replaceAll("\"", "\"");
		org1=org1.replaceAll("<br />", "");
		org1=org1.replaceAll("<br>", "\n");
		return org1;
	}

}
