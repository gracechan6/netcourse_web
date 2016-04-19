package pers.nbu.netcourse.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import pers.nbu.netcourse.entity.ActInfo;
import pers.nbu.netcourse.entity.AnnShow;
import pers.nbu.netcourse.entity.AnnounInfo;
import pers.nbu.netcourse.entity.AttendInfo;
import pers.nbu.netcourse.entity.AttendShow;
import pers.nbu.netcourse.entity.TaskInfo;
import pers.nbu.netcourse.entity.TaskShow;
import pers.nbu.netcourse.service.AnnounInfoService;

import com.opensymphony.xwork2.ActionSupport;

public class AttendAction extends ActionSupport{
	

	private Integer AttendNum;
	private String UserNum;
	private String ip;
	private String ActNum;
	
	private String AttdenceNum;
	private String StatusTime;
	private String TeachNum;
	private Integer AttOpen;
	private String AttdenceClass;
	private String AttdenceWeek;
	private String PlaceName;
	private String Remark;
	

	private ArrayList<AttendShow> attendShowLists;
	private ArrayList<ActInfo> actInfos ;
	private ArrayList<AttendInfo> attendInfos ;
	private AttendInfo attendInfo;
	
	/**
	 * service
	 */
	private AnnounInfoService announInfoService;
	

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
//	private static final long serialVersionUID = 1L;
	  

    private Map<String, Object> dataMap;  
	
	/**
	 * getter  and setter
	 * @return
	 */
    
    public String getAttdenceNum() {
		return AttdenceNum;
	}
	public void setAttdenceNum(String attdenceNum) {
		AttdenceNum = attdenceNum;
	}
	public String getStatusTime() {
		return StatusTime;
	}
	public void setStatusTime(String statusTime) {
		StatusTime = statusTime;
	}
	public String getTeachNum() {
		return TeachNum;
	}
	public void setTeachNum(String teachNum) {
		TeachNum = teachNum;
	}
	public String getActNum() {
		return ActNum;
	}
	public void setActNum(String actNum) {
		ActNum = actNum;
	}
	public String getAttdenceClass() {
		return AttdenceClass;
	}
	public void setAttdenceClass(String attdenceClass) {
		AttdenceClass = attdenceClass;
	}
	public String getAttdenceWeek() {
		return AttdenceWeek;
	}
	public void setAttdenceWeek(String attdenceWeek) {
		AttdenceWeek = attdenceWeek;
	}
	public String getPlaceName() {
		return PlaceName;
	}
	public void setPlaceName(String placeName) {
		PlaceName = placeName;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public Integer getAttOpen() {
		return AttOpen;
	}
	public void setAttOpen(Integer attOpen) {
		AttOpen = attOpen;
	}
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

 
    public Map<String, Object> getDataMap() {  
        return dataMap;  
    }  
    


	public String getAttend(){
		dataMap = new HashMap<String, Object>();
		attendShowLists = announInfoService.getAttend(getUserNum(),getAttendNum());
		dataMap.put("success", true);
		dataMap.put("returnData", attendShowLists);
		return SUCCESS;
	}
	

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
	
	
	/**
	 * @return 教师端获取发布考勤所需的教学班信息
	 */
	public String getAct(){
		dataMap = new HashMap<String, Object>();
		actInfos= announInfoService.getAct(getUserNum(),getActNum());
		dataMap.put("success", true);
		dataMap.put("returnData", actInfos);
		return SUCCESS;
	}
	
	/**
	 * @return 教师端获取考勤信息
	 */
	public String getAttendInfo(){
		dataMap = new HashMap<String, Object>();
		attendInfos= announInfoService.getAttendInfo(getAttdenceNum(), getUserNum());
		dataMap.put("success", true);
		dataMap.put("returnData", attendInfos);
		return SUCCESS;
	}
	
	/**
	 * @return 教师端添加考勤信息
	 */
	public String addAttendInfo(){
		dataMap = new HashMap<String, Object>();
		attendInfo = new AttendInfo(getStatusTime(),getUserNum(),getActNum(),getAttOpen(),getAttdenceClass(),getAttdenceWeek(),
				getPlaceName(),getRemark());
		int n=announInfoService.addAttendInfo(attendInfo);
		dataMap.put("success", true);
		dataMap.put("AttdenceNum", n);
		return SUCCESS;
	}
	
	/**
	 * @return 教师端删除考勤信息
	 */
	public String delAttendInfo(){
		dataMap = new HashMap<String, Object>();
		if(announInfoService.delAttendInfo(getAttdenceNum())){
			dataMap.put("success", true);
		}else
			dataMap.put("success", false);
		return SUCCESS;
	}
	
	/**
	 * @return 教师端更新考勤信息
	 */
	public String updateAttendInfo() throws UnsupportedEncodingException{
		dataMap = new HashMap<String, Object>();
		attendInfo = new AttendInfo(getAttdenceNum(),getStatusTime(),getAttOpen(),getAttdenceClass(),getAttdenceWeek(),
				getPlaceName(),getRemark());
		if(announInfoService.updateAttendInfo(attendInfo)){
			dataMap.put("success", true);
		}else
			dataMap.put("success", false);
		return SUCCESS;
	}
	/**
	 * 更新手机端本地 未结束的考勤信息
	 * @return
	 */
	public String updateAndroidAttendInfo(){
		dataMap = new HashMap<String, Object>();
		int v=announInfoService.updateAndroidAttendInfo(getAttdenceNum());
		if(v!=-1){
			dataMap.put("success", true);
			dataMap.put("AttOpen", v);
			dataMap.put("AttdenceNum",getAttdenceNum());
		}else {
			dataMap.put("success", false);
		}
		return SUCCESS;
	}
	
	

}
