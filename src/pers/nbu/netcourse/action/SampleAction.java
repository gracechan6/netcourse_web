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
	 * 实体
	 */
	private Integer TaskNum;
	
	/**
	 * 实体类
	 */
	private ArrayList<TaskShow> taskShowLists;
	
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
	 * 获取作业列表
	 * @return
	 */
	public String getAllTask(){
		dataMap = new HashMap<String, Object>();
		taskShowLists = announInfoService.getAllTask(getTaskNum());
		dataMap.put("success", true);
		dataMap.put("returnData", taskShowLists);
		return SUCCESS;
	}
	
	
//	//设置key属性不作为json的内容返回  
//    @JSON(serialize=true)  
//    public String getKey() {  
//        return key;  
//    } 
	
	

}
