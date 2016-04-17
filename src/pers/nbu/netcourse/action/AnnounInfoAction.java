package pers.nbu.netcourse.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import pers.nbu.netcourse.entity.AnnShow;
import pers.nbu.netcourse.entity.AnnounInfo;
import pers.nbu.netcourse.entity.CourseShow;
import pers.nbu.netcourse.service.AnnounInfoService;

import com.opensymphony.xwork2.ActionSupport;

public class AnnounInfoAction extends ActionSupport{
	
	/**
	 * 实体
	 */
	private Integer AnnNum;
	private String AnnTitle;
	private String AnnCon;
	private String AnnUrl;
	private String AnnTime;
	private Integer Treeid;
	private String TeachNum;
	private String AnnType; 
	
	public String getAnnType() {
		return AnnType;
	}

	public void setAnnType(String annType) {
		AnnType = annType;
	}

	private String userNum;
	
	/**
	 * 实体类
	 */
	private AnnounInfo announInfo;
	private ArrayList<AnnShow> announInfoLists;
	private ArrayList<AnnounInfo> annLists;
	private ArrayList<CourseShow> courseLists;
	
	/**
	 * service
	 */
	private AnnounInfoService announInfoService;
	
	/**
	 * Json配置
	 */
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
//	private static final long serialVersionUID = 1L;
	  
    //将会被Struts2序列化为JSON字符串的对象  
    private Map<String, Object> dataMap;  
	
	/**
	 * getter  and setter
	 * @return
	 */
    
    /** 
     * Struts2序列化指定属性时，必须有该属性的getter方法，实际上，如果没有属性，而只有getter方法也是可以的 
     * @return 
     */  
    public Map<String, Object> getDataMap() {  
        return dataMap;  
    }  
    
	public Integer getAnnNum() {
		return AnnNum;
	}
	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public void setAnnNum(Integer annNum) {
		AnnNum = annNum;
	}
	public String getAnnTitle() {
		return AnnTitle;
	}
	public void setAnnTitle(String annTitle) {
		AnnTitle = annTitle;
	}
	public String getAnnCon() {
		return AnnCon;
	}
	public void setAnnCon(String annCon) {
		AnnCon = annCon;
	}
	public String getAnnUrl() {
		return AnnUrl;
	}
	public void setAnnUrl(String annUrl) {
		AnnUrl = annUrl;
	}
	public String getAnnTime() {
		return AnnTime;
	}
	public void setAnnTime(String annTime) {
		AnnTime = annTime;
	}
	public Integer getTreeid() {
		return Treeid;
	}
	public void setTreeid(Integer treeid) {
		Treeid = treeid;
	}
	public String getTeachNum() {
		return TeachNum;
	}
	public void setTeachNum(String teachNum) {
		TeachNum = teachNum;
	}
	

	public AnnounInfoService getAnnounInfoService() {
		return announInfoService;
	}

	public void setAnnounInfoService(AnnounInfoService announInfoService) {
		this.announInfoService = announInfoService;
	}

	public AnnounInfo getAnnounInfo() {
		return announInfo;
	}

	public void setAnnounInfo(AnnounInfo announInfo) {
		this.announInfo = announInfo;
	}

	public ArrayList<AnnShow> getAnnounInfoLists() {
		return announInfoLists;
	}

	public void setAnnounInfoLists(ArrayList<AnnShow> announInfoLists) {
		this.announInfoLists = announInfoLists;
	}

	/**
	 * 所有方法如下：
	 */
	
	/**
	 * 获取所有公告信息
	 * @return
	 */
	public String getAllAnnounInfo(){
		// dataMap中的数据将会被Struts2转换成JSON字符串，所以这里要先清空其中的数据 
		//dataMap.clear();
		dataMap = new HashMap<String, Object>();
		announInfoLists = announInfoService.getAllAnnounInfo(0);
		dataMap.put("success", true);
		dataMap.put("returnData", announInfoLists);
		return SUCCESS;
	}
	
	/**
	 * @return
	 */
	public String getAnnounInfoByNum(){
		dataMap = new HashMap<String, Object>();
		announInfoLists = announInfoService.getAllAnnounInfo(getAnnNum());
		dataMap.put("success", true);
		dataMap.put("returnData", announInfoLists);
		return SUCCESS;
	}
	
	/**
	 * @return 教师端获取公告
	 */
	public String getAnn(){
		dataMap = new HashMap<String, Object>();
		annLists= announInfoService.getAnn(getAnnNum(), getUserNum());
		dataMap.put("success", true);
		dataMap.put("returnData", annLists);
		return SUCCESS;
	}
	
	/**
	 * @return 教师端添加公告
	 * @throws UnsupportedEncodingException 
	 */
	public String addAnn() throws UnsupportedEncodingException{
		dataMap = new HashMap<String, Object>();
		//String t,c,ty;
		//t=new String(getAnnTitle().getBytes("ISO-8859-1"),"UTF-8");
		//c=new String(getAnnCon().getBytes("ISO-8859-1"),"UTF-8");
		//ty=new String(getAnnType().getBytes("ISO-8859-1"),"UTF-8");
		announInfo = new AnnounInfo(getAnnTitle(), getAnnCon(), getAnnTime(), getTeachNum(), getAnnType(), getTreeid());
		int n=announInfoService.addAnn(announInfo);
		dataMap.put("success", true);
		dataMap.put("AnnNum", n);
		return SUCCESS;
	}
	
	/**
	 * @return 教师端删除公告
	 */
	public String delAnn(){
		dataMap = new HashMap<String, Object>();
		if(announInfoService.delAnn(getAnnNum())){
			dataMap.put("success", true);
		}else
			dataMap.put("success", false);
		return SUCCESS;
	}
	
	/**
	 * @return 教师端更新公告
	 * @throws UnsupportedEncodingException 
	 */
	public String updateAnn() throws UnsupportedEncodingException{
		dataMap = new HashMap<String, Object>();
		//String t,c;
		//t=new String(getAnnTitle().getBytes("ISO-8859-1"),"UTF-8");
		//c=new String(getAnnCon().getBytes("ISO-8859-1"),"UTF-8");
		if(announInfoService.updateAnn(getAnnNum(),getAnnTitle(),getAnnCon(),getAnnTime())){
			dataMap.put("success", true);
		}else
			dataMap.put("success", false);
		return SUCCESS;
	}
	
	/**
	 * @return 教师端获取发布公告所需的课程信息
	 */
	public String getCourse(){
		dataMap = new HashMap<String, Object>();
		courseLists= announInfoService.getCourse(getUserNum(),getTreeid());
		dataMap.put("success", true);
		dataMap.put("returnData", courseLists);
		return SUCCESS;
	}
	
	
//	//设置key属性不作为json的内容返回  
//    @JSON(serialize=true)  
//    public String getKey() {  
//        return key;  
//    } 
	
	

}
