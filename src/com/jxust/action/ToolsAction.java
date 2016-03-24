package com.jxust.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jxust.bean.Tools;
import com.jxust.service.ToolsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class ToolsAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Tools tool;
	private File other;
	private String otherFileName;
	@Resource
	private ToolsService toolsService;
	private Long id;
	private String uclass;
	public String getUclass() {
		return uclass;
	}

	public void setUclass(String uclass) {
		this.uclass = uclass;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public File getOther() {
		return other;
	}

	public void setOther(File other) {
		this.other = other;
	}

	public String getOtherFileName() {
		return otherFileName;
	}

	public void setOtherFileName(String otherFileName) {
		this.otherFileName = otherFileName;
	}

	public String getOtherContentType() {
		return otherContentType;
	}

	public void setOtherContentType(String otherContentType) {
		this.otherContentType = otherContentType;
	}

	private String otherContentType;
	public Tools getTool() {
		return tool;
	}

	public void setTool(Tools tool) {
		this.tool = tool;
	}
	//添加其他资源
	public String othersUpload(){
		int len=0;
		FileOutputStream fos=null;
		FileInputStream fis=null;
		if(other==null){
			ActionContext.getContext().put("otherError", "文件不可为空，请先上传文件");
			return "toError";
		}
		String path=ServletActionContext.getServletContext().getRealPath("/images/download");
		try {
			fis=new FileInputStream(other);
			fos=new FileOutputStream(path+"\\"+otherFileName);
			len=fis.available();
			byte[] buffer=new byte[1024];
			int length=0;
			while((length=fis.read(buffer))!=-1){
				fos.write(buffer, 0, length);
			}
			fis.close();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ActionContext.getContext().put("otherError", "文件上传失败，请重新上传");
			return "toError";
		}
		tool=new Tools();
		if(uclass!=null){
			tool.setGrade(0);
		}
		
		tool.setLength(convertFileSize(len));
		tool.setTime(new Date());
		tool.setOtherName(otherFileName);
		toolsService.save(tool);
		
		return "toupload";
	}
	/**
	 * 文件大小转换
	 * @param size
	 * @return
	 */
	public static String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;
 
        if (size >= gb) {
            return String.format("%.1f GB", (float) size / gb);
        } else if (size >= mb) {
            float f = (float) size / mb;
            return String.format(f > 100 ? "%.0f MB" : "%.1f MB", f);
        } else if (size >= kb) {
            float f = (float) size / kb;
            return String.format(f > 100 ? "%.0f KB" : "%.1f KB", f);
        } else
            return String.format("%d B", size);
    }
	public String otherManage(){
		List<Tools> toolList=toolsService.findother();
		ActionContext.getContext().put("toolList", toolList);
		return"tomanage";
	}
	public String delete(){
		toolsService.delete(id);
		return"todelete";
	}
	
	/**
	 * 添加教学教改
	 * @return
	 */
	public String addTeachChange(){
		if(tool.getTeachChange()==null||tool.getTeachChange().isEmpty()){
			ActionContext.getContext().put("Error", "教学教改不可为空！");
			return"addchangeError";
		}
		tool.setGrade(15);
		toolsService.save(tool);
		return"addTeachChange";
	}
	public String showTeachChange(){
		Tools tool=toolsService.findTeachChange(15);
		ActionContext.getContext().put("teachTool", tool);
		return"showTeachChange";
	}
}
