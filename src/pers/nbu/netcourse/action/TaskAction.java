package pers.nbu.netcourse.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import pers.nbu.netcourse.entity.AnnShow;
import pers.nbu.netcourse.entity.AnnounInfo;
import pers.nbu.netcourse.entity.TaskManageShow;
import pers.nbu.netcourse.entity.TaskShow;
import pers.nbu.netcourse.service.AnnounInfoService;

import com.opensymphony.xwork2.ActionSupport;

public class TaskAction extends ActionSupport{
	

	private Integer TaskNum;
	private String UserNum;
	

	private ArrayList<TaskShow> taskShowLists;
	private ArrayList<TaskManageShow> taskMShowLists;
	
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

	public String getUserNum() {
		return UserNum;
	}

	public void setUserNum(String userNum) {
		UserNum = userNum;
	}

	public ArrayList<TaskShow> getTaskShowLists() {
		return taskShowLists;
	}

	public void setTaskShowLists(ArrayList<TaskShow> taskShowLists) {
		this.taskShowLists = taskShowLists;
	}
	
    public ArrayList<TaskManageShow> getTaskMShowLists() {
		return taskMShowLists;
	}

	public void setTaskMShowLists(ArrayList<TaskManageShow> taskMShowLists) {
		this.taskMShowLists = taskMShowLists;
	}

    public Map<String, Object> getDataMap() {  
        return dataMap;  
    }  
    


	public String getAllTask(){
		dataMap = new HashMap<String, Object>();
		taskShowLists = announInfoService.getAllTask(getTaskNum());
		dataMap.put("success", true);
		dataMap.put("returnData", taskShowLists);
		return SUCCESS;
	}
	

	public String getAllTaskManage(){
		dataMap = new HashMap<String, Object>();
		taskMShowLists = announInfoService.getAllTaskManage(getUserNum(),getTaskNum());
		dataMap.put("success", true);
		dataMap.put("returnData", taskMShowLists);
		return SUCCESS;
	}
	

	public String updateTaskManage(){
		dataMap = new HashMap<String, Object>();
		int n=announInfoService.updateTaskManage(getUserNum(),getTaskNum());
		if(n>0){
			dataMap.put("success", true);
			dataMap.put("OptNum", n);
			dataMap.put("TaskNum", getTaskNum());
		}
		else{
			dataMap.put("success", false);
		}
		return SUCCESS;
	}
	
	

}
