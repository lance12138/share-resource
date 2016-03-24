package com.jxust.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jxust.bean.ACMuser;
import com.jxust.bean.Academy;
import com.jxust.bean.Course;
import com.jxust.bean.Tools;
import com.jxust.bean.User;
import com.jxust.service.AcademyService;
import com.jxust.service.CourseService;
import com.jxust.service.UserService;
import com.jxust.util.PageToolBar;
import com.jxust.util.sessionListener;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope("prototype")
@SuppressWarnings("unchecked")
public class UserAction extends ActionSupport implements ModelDriven<ACMuser>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ACMuser acmUser=new ACMuser();
	private User user;
	private String email;
	private String verCode;
	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVerCode() {
		return verCode;
	}

	public void setVerCode(String verCode) {
		this.verCode = verCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ACMuser getAcmUser() {
		return acmUser;
	}

	public void setAcmUser(ACMuser acmUser) {
		this.acmUser = acmUser;
	}
	Academy academy=new Academy();
	
	public Academy getAcademy() {
		return academy;
	}

	public void setAcademy(Academy academy) {
		this.academy = academy;
	}

	public ACMuser getModel() {
		// TODO Auto-generated method stub
		return acmUser;
	}
	Set<Tools> majorList=null;
 
public Set<Tools> getMajorList() {
		return majorList;
	}

	public void setMajorList(Set<Tools> majorList) {
		this.majorList = majorList;
	}
  @Resource
   UserService userService;
  @Resource
  AcademyService academyService;
  @Resource
  CourseService courseService;
 private File head;
  public File getHead() {
	return head;
}

public void setHead(File head) {
	this.head = head;
}

public String getHeadFileName() {
	return headFileName;
}

public void setHeadFileName(String headFileName) {
	this.headFileName = headFileName;
}

public String getHeadContentType() {
	return headContentType;
}

public void setHeadContentType(String headContentType) {
	this.headContentType = headContentType;
}
private String headFileName;
private String headContentType;
 private PageToolBar toolBar;
 public PageToolBar getToolBar() {
	return toolBar;
}

public void setToolBar(PageToolBar toolBar) {
	this.toolBar = toolBar;
}

public int getPageSize() {
	return pageSize;
}

public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

public int getCurrentPage() {
	return currentPage;
}

public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}
    private int pageSize = 8;
	private int currentPage = 1;
	
	private Long userId;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	private String contentType;
	private long contentLength;
	private String contentDisposition;
	private InputStream inputStream;
	public String getContentType() {
		return contentType;
	}
	public long getContentLength() {
		return contentLength;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public InputStream getInputStream() {
		return inputStream;
	}
	
	
	
	
	public String academyList()throws Exception{
		List<Course> courseList=courseService.findAll();//如果course的竞赛open字段设置为0则关闭报名入口
		if(courseList.get(0).getIsopen()==0){
			return "notOpen";
		}else{
	List academyList=academyService.findAll();
	ActionContext.getContext().put("academyList", academyList);
		return "academyList";
	 }
	}
	//acm注册二级联动
	public Set<Tools> getMajorList(String name)throws Exception{
		Academy academy=academyService.findByacademy(name);
		majorList=academy.getAcademyTools();
		return majorList;
	
		
		
		
	}
	//ACM竞赛报名校验
	public String validateACM()throws Exception{
		 HttpServletResponse response = ServletActionContext.getResponse();  
		 
		boolean value=userService.ajaxValidate(acmUser.getCardnumber());
		response.getWriter().print(value);
		return null;
	}
	
	//ACM竞赛注册
	public String studentLogin()throws Exception{
		List academyList=academyService.findAll();
		ActionContext.getContext().put("academyList", academyList);
		String userName = acmUser.getUserName();
		boolean errors=true;
		if(userName == null || userName.trim().isEmpty()||userName.equals("请输入中文或字母")) {
			errors=false;
			ActionContext.getContext().put("studentName", "用户名不能为空！");
			//errors.put("userName", );
		}
		/*
		 * 校验学院
		 * */
		String Academy=acmUser.getAcademy();
		if(Academy.equals("0")||Academy.trim().isEmpty()){
			errors=false;
			ActionContext.getContext().put("userAcademy", "学院不能为空！");
			//errors.put("userAcademy", "学院不能为空！");
		}
		/*
		 * 校验专业
		 * */
		String major=acmUser.getMajor();
		if(major==null||major.trim().isEmpty()){
			errors=false;
			ActionContext.getContext().put("usermajor", "专业不能为空！");
			//errors.put("usermajor", "专业不能为空！");
		}
		/*
		 * 校验班级
		 * */
		String userClass=acmUser.getUserClass();
		if(userClass==null){
			errors=false;
			ActionContext.getContext().put("studentClass", "班级不能为空！");
			//errors.put("userClass", "班级不能为空！");
		}else if(!isInteger(userClass)){
			errors=false;
			ActionContext.getContext().put("studentClass", "班级必须为三位数字！");
		}
		else if(userClass.length()!=3){
			errors=false;
			ActionContext.getContext().put("studentClass", "请填写三位数的班级，如’122‘");
		}
		/*
		 * 校验一卡通号
		 * */
		String e_card=acmUser.getCardnumber();
		if(e_card==null||major.trim().isEmpty()){
			errors=false;
			ActionContext.getContext().put("e_card", "一卡通号不能为空！");
		}else if(!isInteger(e_card)){
			errors=false;
			ActionContext.getContext().put("e_card", "一卡通号必须为数字！");
		}else if(e_card.length()!=10){
			errors=false;
			ActionContext.getContext().put("e_card", "一卡通号必须为10位数字！");
		}else if(!userService.ajaxValidate(e_card)){
			errors=false;
			ActionContext.getContext().put("e_card", "用户已报名请勿重复报名！");
		}
	
		/*
		 * 电话号码校验
		 * */
		String phone=acmUser.getPhone();
		if(phone==null||phone.trim().isEmpty()||phone.equals("请输入数字号码")){
			errors=false;
			ActionContext.getContext().put("userphone", "电话号码不能为空！");
			//errors.put("userphone", "电话号码不能为空！");
		}
		if(errors==false){
			return "toErrors";
		}
		userService.save(acmUser);
		return "toLogin";
	}
	
	public boolean isInteger(String str){
		try{
		//String e_card=acmUser.getCardnumber();
		Integer.parseInt(str);
		return true;
		}catch(Exception e){
			return false;
		}
	}
	//通过AJAX动态获取邮箱是否注册
	public String validateUser()throws Exception{
		
		 HttpServletResponse response = ServletActionContext.getResponse();  
		boolean value=userService.ValidateUser(email);
		response.getWriter().print(value);
		return null;
	}
	//通过AJAX动态获取邮箱是否注册
	public String validateUserName()throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();  
		boolean value=userService.ValidateUserName(name);
		response.getWriter().print(value);
		return null;
	}

	
	public String toModifyPwd() throws Exception{
		if(user.getId()==null){
		 throw new Exception("user id couldn't be null");
		}
		ActionContext.getContext().put("userId", user.getId());
		return "toModifyPwd";
	}
	
	public String modifyPwd()throws Exception{
		if(user.getId()==null){
			 throw new Exception("user id couldn't be null");
			}
		User old=userService.findById(user.getId());
		User checkUser=null;
		if(old.getGrade()==1){
		checkUser=userService.checkUser(old.getUserName(), user.getPassword(), 1);
		}else {
			checkUser=userService.checkUser(old.getUserName(), user.getPassword(), 0);
		}
		if(checkUser!=null){
			old.setPassword(DigestUtils.md5Hex(user.getRepassword()));
			userService.update(old);
			return "modifySuccess";
		}else {
			ActionContext.getContext().put("msg", "原密码错误，请重新输入！");
			return "toModifyPwd";
		}
	}
	
	/**
	 * 用户登录
	 * @return
	 * @throws Exception
	 */
	public String userLogin()throws Exception{
		
		if(user.getUserName()==null||user.getUserName().isEmpty()||user.getPassword()==null||user.getPassword().isEmpty()){
			ActionContext.getContext().put("loginError", 2);
			return"tologinError";
		}
		

		
	User u=userService.checkUser(user.getUserName(), user.getPassword(),0);
		if(u!=null){
			if((User)ActionContext.getContext().getSession().get("user")!=null){
				return "toUserLogin";
			}
			//判断用户是否重复登录，如果是则提醒
			if(!getRepeat(u.getId())){
				ActionContext.getContext().getSession().put("user", u);
			}else{
				ActionContext.getContext().put("loginError", 1);
				return"tologinError";
				
			}
		
			
			return "toUserLogin";
			
		}else{
			ActionContext.getContext().put("loginError", 2);
			return "tologinError";
		}
		
	}
	/**
	 * 在bbs页面的用户登录
	 * @return
	 * @throws Exception
	 */
	public String userbbsLogin()throws Exception{
		
		if(user.getUserName()==null||user.getUserName().isEmpty()||user.getPassword()==null||user.getPassword().isEmpty()){
			ActionContext.getContext().put("loginbssError", 2);
			return"tobbsloginError";
		}
		
		
		
		User u=userService.checkUser(user.getUserName(), user.getPassword(),0);
		if(u!=null){
			if((User)ActionContext.getContext().getSession().get("user")!=null){
				return "toUserLogin";
			}
			//判断用户是否重复登录，如果是则提醒
			if(!getRepeat(u.getId())){
				ActionContext.getContext().getSession().put("user", u);
			}else{
				ActionContext.getContext().put("loginbssError", 1);
				return"tobbsloginError";
				
			}
			
			
			return "tobbsUserLogin";
			
		}else{
			ActionContext.getContext().put("loginbssError", 2);
			return "tobbsloginError";
		}
		
	}
	 //是否重复登录的封闭方法  
    public static boolean getRepeat(Long userId) {  
        boolean flag = false;  
        List list = sessionListener.list;  
        for (int i = 0; i < list.size(); i++) {  
            User user = (User) (list.get(i));           
            if (userId.equals(user.getId())) {  
                flag = true;  
            }  
        }  
        return flag;  
    }  
	/**
	 * 校验验证码
	 * @return
	 * @throws IOException 
	 */
	public String validateCode() throws IOException{
		 HttpServletResponse response = ServletActionContext.getResponse();  
	
		String code=(String) ActionContext.getContext().getSession().get("vCode");
		System.out.println(code);
		boolean value=verCode.equalsIgnoreCase(code);
		
			response.getWriter().print(value);
		return null;
	}
	/**
	 * 后台管理员用户登录
	 * @return
	 */
	public String backStageLogin(){
		String code=(String) ActionContext.getContext().getSession().get("vCode");
		boolean value=verCode.equalsIgnoreCase(code);
		if(user.getUserName()==null||user.getUserName().isEmpty()||user.getPassword()==null||user.getPassword().isEmpty()){
			ActionContext.getContext().put("backError", "用户名或密码不可为空！");
			return"tobackError";
		}
		
		if(verCode==null||verCode.trim().isEmpty()){
			ActionContext.getContext().put("backError", "验证码不可为空！");
		}else if(!value){
			ActionContext.getContext().put("backError", "错误的验证码！");
		}
		User backUser=userService.checkUser(user.getUserName(), user.getPassword(),1);
		if(backUser==null){
			ActionContext.getContext().put("backError", "用户名或密码错误！");
			return"tobackError";
		}
		
		if(backUser!=null){
		
			ActionContext.getContext().getSession().put("backUser", backUser);
			
		}
	return"tobackStage";	
	}
	/**
	 * 前台用户退出
	 * @return
	 */
	public String Loginout(){
		ActionContext.getContext().getSession().remove("user");
		return "toLoginout";
	}
	public String backLoginout(){
		ActionContext.getContext().getSession().remove("backUser");
		return "tobackOut";
	}
	/**
	 * 前台用户注册
	 * @return
	 */
	public String userRigest(){
		if(user.getUserName()==null||user.getUserName().isEmpty()){
			ActionContext.getContext().put("userNameError", "用户名不可为空！");
			return"toRigestError";
		}
		if(user.getPassword()==null||user.getPassword().isEmpty()){
			ActionContext.getContext().put("passwordError", "密码不可为空！");
			return "toRigestError";
		}else if(user.getPassword().length()<6){
			ActionContext.getContext().put("passwordError", "密码不可小于六位！");
			return "toRigestError";
		}else if(user.getRepassword()==null||user.getRepassword().isEmpty()){
			ActionContext.getContext().put("repasswordError", "确认密码不可为空！");
			return "toRigestError";
		}else if(!user.getPassword().equals(user.getRepassword())){
			ActionContext.getContext().put("repasswordError", "两次输入密码不一致！");
			return "toRigestError";
		}
		if(user.getEmail()==null||user.getEmail().isEmpty()){
			ActionContext.getContext().put("emailError", "Email不可为空！");
			return "toRigestError";
		}else if(!emailFormat(user.getEmail())){
			
			ActionContext.getContext().put("emailError", "Email格式不对！");
			return "toRigestError";
		}
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		user.setGrade(0);
		userService.saveUser(user);
		return "toUserRigest";
	}
	/**
	 * 前台用户修改密码
	 * @return
	 */
	public String updatePassword(){
		User oldUser=(User) ActionContext.getContext().getSession().get("user");
		if(user.getPassword()==null||user.getPassword().isEmpty()){
			ActionContext.getContext().put("loginError", 3);
			return"tologinError";
		}else if(user.getPassword().length()<6){
			ActionContext.getContext().put("loginError", 3);
			return"tologinError";
		}
		else if(user.getRepassword()==null||user.getRepassword().isEmpty()){
			ActionContext.getContext().put("loginError", 3);
			return"tologinError";
		}
		else if(!user.getPassword().equals(user.getRepassword())){
			ActionContext.getContext().put("loginError", 4);
			return"tologinError";
		}
		oldUser.setPassword(DigestUtils.md5Hex(user.getPassword()));
		
		userService.update(oldUser);
		ActionContext.getContext().put("loginError", 5);//返回修改成功提示（命名不太规范）
		return"toupdatePassword";
	}
	public String changePhoto()throws Exception{
		if(head==null){
			return "changeCancel";}
		FileOutputStream fout=null;
		FileInputStream fin=null;
		 String path=ServletActionContext.getServletContext().getRealPath("/images/user/");
		 File file=new File(path);
		   if(!file.exists()&&!file.isDirectory()){
			   file.mkdir();
		   }
		   User ouser=(User) ActionContext.getContext().getSession().get("user");
		   try{
			   
			 fin=new FileInputStream(head);
			  fout=new FileOutputStream(path+"\\"+headFileName);
			  int length=0;
			  byte[] buffer=new byte[1024];
			  while((length = fin.read(buffer))!=-1){
				  fout.write(buffer, 0, length);
			  }
			  ouser.setPhoto(headFileName);
			  userService.update(ouser);
		   }catch(Exception e){
			   ActionContext.getContext().put("loginError", 6);
		   }
		   finally{
				if(fin!=null){
					fin.close();
				}
				if(fout!=null){
					fout.close();
				}
		   }
		return"changePhoto";
	}
	//验证email格式
	public static boolean emailFormat(String email)
    {
        boolean tag = true;
        final String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(email);
        if (!mat.find()) {
            tag = false;
        }
        return tag;
    }
	/*
	 * 
	 * 为进入竞赛报名表准备数据
	 * */
	public String competitionManage()throws Exception{
		if(acmUser==null){
			acmUser=new ACMuser();
		}
		String hql=userService.getHQL(acmUser);
		int userCount=userService.findByHQL(hql);
		if(getToolBar()==null){
			setToolBar(new PageToolBar(userCount,pageSize));
		}else{
			 getToolBar().setResultsetCount(userCount);
				getToolBar().setPageSize(pageSize);
			
		}
		List<ACMuser> acmUserList=userService.getListForPage(hql,toolBar.getStartRow(),toolBar.getEndRow());
		ActionContext.getContext().put("acmUserList", acmUserList);
		return "toCompetition";
	}
	/**
	 * 用户管理
	 * @return
	 */
	public String userManage(){
		if(user==null){
			user=new User();
		}
		String hql=userService.getUserHQL(user);
		int usercount=userService.findByHQL(hql);
		if(getToolBar()==null){
			setToolBar(new PageToolBar(usercount,pageSize));
		}else{
			getToolBar().setResultsetCount(usercount);
			getToolBar().setPageSize(pageSize);
			
		}
		List<User> userList=userService.getListForPage(hql, toolBar.getStartRow(), toolBar.getEndRow());
		ActionContext.getContext().put("userList", userList);
		return"userManage";
	}
	/**
	 * 初始化密码
	 * @return
	 */
	public String initPwd(){
		User u=userService.findById(user.getId());
		u.setPassword(DigestUtils.md5Hex("000000"));
		userService.update(u);
		return"toinit";
	}
	public String userDelete(){
		User u=userService.findById(user.getId());
		userService.deleteuser(u);
		return"userDelete";
	}
	/*
	 * 
	 *将报名表导出为Excel
	 * */
	public String exportExcel(){
		String path=ServletActionContext.getServletContext().getRealPath("images/user");
		List<ACMuser> userList=userService.findAll();
		try{
			File file=new File(path,"apply_users.xls");
			// 打开文件
			WritableWorkbook book = Workbook.createWorkbook(file);
			// 定义格式, 字体, 下划线, 斜体, 粗体, 颜色 
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, 
			    WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, 
			jxl.format.Colour.BLACK); 
			// 创建格式化对象实例    
			WritableCellFormat totalx2Format = new WritableCellFormat(wf);    
			// 垂直居中    
			totalx2Format.setVerticalAlignment(VerticalAlignment.CENTRE);    
			//自动换行
			totalx2Format.setWrap(true);
			// 水平居中    
			totalx2Format.setAlignment(Alignment.CENTRE); 
			// 生成名为“第一页”的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet(" 第一页 ", 0);
			// 在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
			Label label1 = new Label(0, 0, " 序号 ",totalx2Format);
			Label label2 = new Label(1, 0, " 姓名 ",totalx2Format);
			Label label3 = new Label(2, 0, " 学院 ",totalx2Format);
			Label label4 = new Label(3, 0, " 专业 ",totalx2Format);
			Label label5 = new Label(4, 0, " 班级 ",totalx2Format);
			Label label6 = new Label(5, 0, " 一卡通号 ",totalx2Format);
			Label label7 = new Label(6, 0, " 联系电话 ",totalx2Format);
			//给sheet电子版中所有的列设置默认的列的宽度;  
			 sheet.getSettings().setDefaultColumnWidth(20);  
			// 将定义好的单元格添加到工作表中
			sheet.addCell(label1);
			sheet.addCell(label2);
			sheet.addCell(label3);
			sheet.addCell(label4);
			sheet.addCell(label5);
			sheet.addCell(label6);
			sheet.addCell(label7);
			
			ACMuser user=new ACMuser();
			for (int i = 0; i < userList.size(); i++) {
				user=(ACMuser) userList.get(i);
				sheet.addCell(new Label(0, i+1, i+1+"",totalx2Format));
				sheet.addCell(new Label(1, i+1, user.getUserName(),totalx2Format));
				sheet.addCell(new Label(2, i+1, user.getAcademy(),totalx2Format));
				sheet.addCell(new Label(3, i+1, user.getMajor(),totalx2Format));
				sheet.addCell(new Label(4, i+1, user.getUserClass(),totalx2Format));
				sheet.addCell(new Label(5, i+1, user.getCardnumber(),totalx2Format));
				sheet.addCell(new Label(6, i+1, user.getPhone(),totalx2Format));
				
			}
			book.write();
			book.close();
			//生成后直接下载报名表
			contentType="application/excel";
			contentDisposition="attachment;filename=apply_users.xls";
			inputStream=new FileInputStream(file);
			contentLength=inputStream.available();
		}catch(Exception e){
			return "toError";
		}
		return "toExportExcel";
	}
	public String acmbatchDelete(){
		int size=userService.getSize();
		   if(size<=0){
			   return "acmdeleteError";
		   }else{
			   userService.batchDelete();
		   }
		   return"acmdelete";
	}
	/*
	 * 删除报名用户
	 * */
	public String delete(){
		userService.delete(userId);
		return "toDelete";
	}
}
