package com.org.opera.action;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.org.opera.base.BaseAction;
import com.org.opera.domain.Course;
import com.org.opera.service.CourseService;
import com.org.opera.util.Encrypter;

@Controller
@Scope("prototype")
public class CourseAction extends BaseAction<Course> {
	
	/*
	 * 这里定义的变量,一定要跟网页的<input type="file" name="file">中的name属性的值一致.
	 * 如果网页中定义的是<input type="file" name="img">,那么在这里就要定义File img;
	 */
	private File res;
	private File img;
	private File mov;
	/*
	 * 这里定义的fileFileName一定要是xxxFileName的形式,否则无法取到文件的文件名.
	 * 其中xxx必须与上面定义的File类型的变量一致,如果上面定义的是File img,那么这里就
	 * 定义为String imgFileName
	 */
	private String resFileName;
	private String imgFileName;
	private String movFileName;
	/*
	 * 这里定义的是文件的类型,如果不需要获取文件类型的话,可以不定义.
	 *  命名规则跟xxxFileName类似,这里一定要定义成xxxContentType形式.
	 */
	private String resContentType;
	private String imgContentType;
	private String movContentType;
	/*
	 * 这这个变量是重命名后的文件名
	 */
	private String newFileName;
	private Long courseId;
	
	//-------------开大招了------------
	
	public String list() throws Exception{
		List<Course> course8List = CourseService.find8();
		System.out.println(course8List+"!!!");
//		Collections.reverse(course8List);//倒序
		ActionContext.getContext().put("course8List",course8List);
		return "list";
	}
	
	public String show() throws Exception{
		Course course = CourseService.getById(courseId);
		ActionContext.getContext().put("course",course);
		return "show";
	}
	
	public String search() throws Exception{
		String name = model.getName();
		List<Course> courseList = CourseService.getByName(name);
		System.out.println(courseList+"!!!!!!!!!!!!!!!!!");
		ActionContext.getContext().put("courseList",courseList);
		return "search";
	}

	public String listMy(){
		List<Course> listMy = CourseService.listMy(getCurrentUser().getId());
		Collections.reverse(listMy);//倒序
		ActionContext.getContext().put("listMy",listMy);
		return "listMy";
	}

	public String addUI() throws Exception{
		
		String addUI_name = getCurrentUser().getName();
		Date addUI_time = new Date();
		ActionContext.getContext().put("addUI_name",addUI_name);
		ActionContext.getContext().put("addUI_time",addUI_time);
		
		return "addUI";
	}

	public String add(){
		model.setUser(getCurrentUser());
		model.setTime(new Date());
		addImg();
		addRes();
		addMov();
		model.setImgUrl("file/"+imgFileName);
		model.setResUrl("file/"+resFileName);
		model.setMovUrl("file/"+movFileName);
		CourseService.save(model);
		return "add";
	}

	public String auditUI(){
		Course auditUI = CourseService.getById(courseId);
		ActionContext.getContext().put("auditUI",auditUI);
		return "auditUI";
	}

	public String audit(){
		CourseService.save(model);
		return "audit";
	}

	public String delete(){
		CourseService.delete(courseId);
		return "delete";
	}
	
	public String random(){
		int randomCount = CourseService.getCount();
		Random random = new Random();
		randomCount = random.nextInt(randomCount)+1;
		ActionContext.getContext().put("randomCount",randomCount);
		return "random";
	}

	public String addMov(){

		System.out.println("文件名：" + movFileName);
		System.out.println("文件类型：" + movContentType);
		
		if (mov != null) {
			//文件的保存路径是WebContent/file目录下
			String realpath = ServletActionContext.getServletContext()
					.getRealPath("/file");
			System.out.println("文件的保存路径：" + realpath);
			
			//文件的后缀
			String suffix = movFileName.substring(movFileName
					.lastIndexOf("."));
			if (movFileName.lastIndexOf(".") == -1) {
			}
			
			//上传以后,会重命名文件的名称,将其命名为全部是数字的文件名,防止可能出现的乱码.
			//当然, 只是为了防止出现乱码,一般不会出现乱码
			newFileName = Encrypter.randFileName() + suffix; 
			movFileName = newFileName;
			File savefile = new File(new File(realpath), movFileName);
			//如果保存的路径不存在,则新建
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();

			try {
				//复制文件
				FileUtils.copyFile(img, savefile);
				System.out.println("文件上传成功!");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("文件上传失败");
			}
		}
		return "addMov";
	}

	public void addImg(){
		System.out.println("文件名：" + imgFileName);
		System.out.println("文件类型：" + imgContentType);
		
		if (img != null) {
			//文件的保存路径是WebContent/file目录下
			String realpath = ServletActionContext.getServletContext()
					.getRealPath("/file");
			System.out.println("文件的保存路径：" + realpath);
			
			//文件的后缀
			String suffix = imgFileName.substring(imgFileName
					.lastIndexOf("."));
			if (imgFileName.lastIndexOf(".") == -1) {
			}
			
			//上传以后,会重命名文件的名称,将其命名为全部是数字的文件名,防止可能出现的乱码.
			//当然, 只是为了防止出现乱码,一般不会出现乱码
			newFileName = Encrypter.randFileName() + suffix; 
			imgFileName = newFileName;
			File savefile = new File(new File(realpath), imgFileName);
			//如果保存的路径不存在,则新建
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();

			try {
				//复制文件
				FileUtils.copyFile(img, savefile);
//				ActionContext.getContext().put("res_result","成功了！");
				System.out.println("文件上传成功!"+realpath+"\\"+imgFileName);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("文件上传失败");
			}
		}
	}	
	
	//-----------------------------------------
	public void addRes() {
		System.out.println("文件名：" + resFileName);
		System.out.println("文件类型：" + resContentType);
		
		if (res != null) {
			//文件的保存路径是WebContent/file目录下
			String realpath = ServletActionContext.getServletContext()
					.getRealPath("/file");
			System.out.println("文件的保存路径：" + realpath);
			
			//文件的后缀
			String suffix = resFileName.substring(resFileName
					.lastIndexOf("."));
			if (resFileName.lastIndexOf(".") == -1) {
			}
			
			//上传以后,会重命名文件的名称,将其命名为全部是数字的文件名,防止可能出现的乱码.
			//当然, 只是为了防止出现乱码,一般不会出现乱码
			newFileName = Encrypter.randFileName() + suffix; 
			resFileName = newFileName;
			File savefile = new File(new File(realpath), resFileName);
			//如果保存的路径不存在,则新建
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();

			try {
				//复制文件
				FileUtils.copyFile(res, savefile);
				System.out.println("文件上传成功!");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("文件上传失败");
			}
		}
	}
		
	//-----------------------------------------
	
	
	public String searchBack(){
		return "searchBack";
	}

	public String listBack(){
		
		List<Course> listBack = CourseService.findAll();
		Collections.reverse(listBack);//倒序
		ActionContext.getContext().put("listBack",listBack);
		
		return "listBack";
	}

	public String deleteBack(){
		CourseService.delete(courseId);
		return "deleteBack";
	}	
	
	public String test(){
		return "test";
	}	
	//---------------------get set

	public File getRes() {
		return res;
	}

	public void setRes(File res) {
		this.res = res;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public File getMov() {
		return mov;
	}

	public void setMov(File mov) {
		this.mov = mov;
	}

	public String getResFileName() {
		return resFileName;
	}

	public void setResFileName(String resFileName) {
		this.resFileName = resFileName;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getMovFileName() {
		return movFileName;
	}

	public void setMovFileName(String movFileName) {
		this.movFileName = movFileName;
	}

	public String getResContentType() {
		return resContentType;
	}

	public void setResContentType(String resContentType) {
		this.resContentType = resContentType;
	}

	public String getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}

	public String getMovContentType() {
		return movContentType;
	}

	public void setMovContentType(String movContentType) {
		this.movContentType = movContentType;
	}

	public String getNewFileName() {
		return newFileName;
	}

	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	
	
}
