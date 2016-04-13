package pers.nbu.netcourse.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import pers.nbu.netcourse.entity.AnnShow;
import pers.nbu.netcourse.entity.AnnounInfo;
import pers.nbu.netcourse.entity.TaskShow;
import pers.nbu.netcourse.service.AnnounInfoService;

import com.opensymphony.xwork2.ActionSupport;

public class SampleAction extends ActionSupport{
	
	/**
	 * ʵ��
	 */
	private Integer TaskNum;
	
	/**
	 * ʵ����
	 */
	private ArrayList<TaskShow> taskShowLists;
	
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
	
	public Integer getTaskNum() {
		return TaskNum;
	}

	public void setTaskNum(Integer taskNum) {
		TaskNum = taskNum;
	}

	public ArrayList<TaskShow> getTaskShowLists() {
		return taskShowLists;
	}

	public void setTaskShowLists(ArrayList<TaskShow> taskShowLists) {
		this.taskShowLists = taskShowLists;
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
	 * ��ȡ��ҵ�б�
	 * @return
	 */
	public String getAllTask(){
		dataMap = new HashMap<String, Object>();
		taskShowLists = announInfoService.getAllTask(getTaskNum());
		dataMap.put("success", true);
		dataMap.put("returnData", taskShowLists);
		return SUCCESS;
	}
	
	
//	//����key���Բ���Ϊjson�����ݷ���  
//    @JSON(serialize=true)  
//    public String getKey() {  
//        return key;  
//    } 
	
	

}
