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
	 * ʵ��
	 */
	private Integer AttendNum;
	private String UserNum;
	private String ip;
	
	/**
	 * ʵ����
	 */
	private ArrayList<AttendShow> attendShowLists;
	
	/**
	 * service
	 */
	private AnnounInfoService announInfoService;
	
	/**
	 * Json����
	 */
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
//	private static final long serialVersionUID = 1L;
	  
    //���ᱻStruts2���л�ΪJSON�ַ����Ķ���  
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
     * Struts2���л�ָ������ʱ�������и����Ե�getter������ʵ���ϣ����û�����ԣ���ֻ��getter����Ҳ�ǿ��Ե� 
     * @return 
     */  
    public Map<String, Object> getDataMap() {  
        return dataMap;  
    }  
    
	/**
	 * ���з������£�
	 */
	
	/**
	 * ��ȡ�����б�
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
	 * ��ȡĳ��������Ϣ
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
	 * ���·������˿�����Ϣ
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
	
	
//	//����key���Բ���Ϊjson�����ݷ���  
//    @JSON(serialize=true)  
//    public String getKey() {  
//        return key;  
//    } 
	
}
