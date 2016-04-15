package pers.nbu.netcourse.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import pers.nbu.netcourse.entity.AnnShow;
import pers.nbu.netcourse.entity.AnnounInfo;
import pers.nbu.netcourse.entity.AttendShow;
import pers.nbu.netcourse.entity.TaskShow;
import pers.nbu.netcourse.service.AnnounInfoService;

import com.opensymphony.xwork2.ActionSupport;

public class AttendAction extends ActionSupport{
	
	/**
	 * 实体
	 */
	private Integer AttendNum;
	private String UserNum;
	private String ip;
	
	/**
	 * 实体类
	 */
	private ArrayList<AttendShow> attendShowLists;
	
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
    public AnnounInfoService getAnnounInfoService() {
		return announInfoService;
	}

	public void setAnnounInfoService(AnnounInfoService announInfoService) {
		this.announInfoService = announInfoService;
	}
	
    public Integer getAttendNum() {
		return AttendNum;
	}

	public void setAttendNum(Integer attendNum) {
		AttendNum = attendNum;
	}

	public String getUserNum() {
		return UserNum;
	}

	public void setUserNum(String userNum) {
		UserNum = userNum;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public ArrayList<AttendShow> getAttendShowLists() {
		return attendShowLists;
	}

	public void setAttendShowLists(ArrayList<AttendShow> attendShowLists) {
		this.attendShowLists = attendShowLists;
	}

	/** 
     * Struts2序列化指定属性时，必须有该属性的getter方法，实际上，如果没有属性，而只有getter方法也是可以的 
     * @return 
     */  
    public Map<String, Object> getDataMap() {  
        return dataMap;  
    }  
    
	/**
	 * 所有方法如下：
	 */
	
	/**
	 * 获取考勤列表
	 * @return
	 */
	public String getAttend(){
		dataMap = new HashMap<String, Object>();
		attendShowLists = announInfoService.getAttend(getUserNum(),getAttendNum());
		dataMap.put("success", true);
		dataMap.put("returnData", attendShowLists);
		return SUCCESS;
	}
	
	/**
	 * 获取某条考勤信息
	 * @return
	 */
	public String updateAttend(){
		dataMap = new HashMap<String, Object>();
		attendShowLists = announInfoService.updateAttend(getUserNum(),getAttendNum());
		if(attendShowLists!=null && attendShowLists.size()>0){
			dataMap.put("success", true);
			dataMap.put("staName", attendShowLists.get(0).getStaName());
			dataMap.put("AttendNum", getAttendNum());
			dataMap.put("status", attendShowLists.get(0).getStatus());
		}else {
			dataMap.put("success", false);
		}
		return SUCCESS;
	}
	
	/**
	 * 更新服务器端考勤信息
	 * @return
	 */
	public String updateServerAttend(){
		dataMap = new HashMap<String, Object>();
		if(announInfoService.updateServerAttend(getUserNum(),getAttendNum(),getIp())){
			dataMap.put("success", true);
		}
		else {
			dataMap.put("success", false);
		}
		return SUCCESS;
	}
	
	
//	//设置key属性不作为json的内容返回  
//    @JSON(serialize=true)  
//    public String getKey() {  
//        return key;  
//    } 
	
}
