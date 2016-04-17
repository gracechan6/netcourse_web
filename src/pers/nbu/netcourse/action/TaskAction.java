package pers.nbu.netcourse.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import pers.nbu.netcourse.entity.AnnShow;
import pers.nbu.netcourse.entity.AnnounInfo;
import pers.nbu.netcourse.entity.TaskInfo;
import pers.nbu.netcourse.entity.TaskManageShow;
import pers.nbu.netcourse.entity.TaskShow;
import pers.nbu.netcourse.entity.TreeInfo;
import pers.nbu.netcourse.service.AnnounInfoService;

import com.opensymphony.xwork2.ActionSupport;

public class TaskAction extends ActionSupport{
	

	private Integer TaskNum;
	private String UserNum;
	
	private String TeachNum;
	private String TaskTitle;
	private String TaskRequire;
	private String YorNSub;
	private String YorNVis;
	private String TaskUrl;
	private String FileOn;
	private String  Video;
	private String Annex;
	private String TaskTime;
	private String EndTime;
	private Integer Treeid;
	private String IsStuDown;
	private String IsShowResult;
	

	private ArrayList<TaskShow> taskShowLists;
	private ArrayList<TaskManageShow> taskMShowLists;
	private ArrayList<TaskInfo> taskInfoLists;
	private TaskInfo taskInfo;
	
	private ArrayList<TreeInfo> treeInfos;
	
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
    public String getTeachNum() {
		return TeachNum;
	}
	public void setTeachNum(String teachNum) {
		TeachNum = teachNum;
	}
	public String getTaskTitle() {
		return TaskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		TaskTitle = taskTitle;
	}
	public String getTaskRequire() {
		return TaskRequire;
	}
	public void setTaskRequire(String taskRequire) {
		TaskRequire = taskRequire;
	}
	public String getYorNSub() {
		return YorNSub;
	}
	public void setYorNSub(String yorNSub) {
		YorNSub = yorNSub;
	}
	public String getYorNVis() {
		return YorNVis;
	}
	public void setYorNVis(String yorNVis) {
		YorNVis = yorNVis;
	}
	public String getTaskUrl() {
		return TaskUrl;
	}
	public void setTaskUrl(String taskUrl) {
		TaskUrl = taskUrl;
	}
	public String getFileOn() {
		return FileOn;
	}
	public void setFileOn(String fileOn) {
		FileOn = fileOn;
	}
	public String getVideo() {
		return Video;
	}
	public void setVideo(String video) {
		Video = video;
	}
	public String getAnnex() {
		return Annex;
	}
	public void setAnnex(String annex) {
		Annex = annex;
	}
	public String getTaskTime() {
		return TaskTime;
	}
	public void setTaskTime(String taskTime) {
		TaskTime = taskTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public Integer getTreeid() {
		return Treeid;
	}
	public void setTreeid(Integer treeid) {
		Treeid = treeid;
	}
	public String getIsStuDown() {
		return IsStuDown;
	}
	public void setIsStuDown(String isStuDown) {
		IsStuDown = isStuDown;
	}
	public String getIsShowResult() {
		return IsShowResult;
	}
	public void setIsShowResult(String isShowResult) {
		IsShowResult = isShowResult;
	}
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
	
	
	/**
	 * @return 教师端获取公告
	 */
	public String getTaskInfo(){
		dataMap = new HashMap<String, Object>();
		taskInfoLists= announInfoService.getTaskInfo(getTaskNum(), getUserNum());
		dataMap.put("success", true);
		dataMap.put("returnData", taskInfoLists);
		return SUCCESS;
	}
	
	/**
	 * @return 教师端添加公告
	 * @throws UnsupportedEncodingException 
	 */
	public String addTaskInfo() throws UnsupportedEncodingException{
		dataMap = new HashMap<String, Object>();
//teachNum=171123&taskTitle=gracesadasd&taskRequire=fadhhgyyy&yorNSub=True&yorNVis=False&fileOn=True&video=False&annex=False&taskTime=2015-10-12 10:33:31&endTime=2015-10-19 10:33:31&treeid=632&isStuDown=False&isShowResult=False 
		taskInfo = new TaskInfo(getTeachNum(),getTaskTitle(),getTaskRequire(),getYorNSub(),getYorNVis(),
				getFileOn(),getVideo(),getAnnex(),getTaskTime(),getEndTime(),getTreeid(),getIsStuDown(),getIsShowResult());
		int n=announInfoService.addTaskInfo(taskInfo);
		dataMap.put("success", true);
		dataMap.put("AnnNum", n);
		return SUCCESS;
	}
	
	/**
	 * @return 教师端删除公告
	 */
	public String delTaskInfo(){
		dataMap = new HashMap<String, Object>();
		if(announInfoService.delTaskInfo(getTaskNum())){
			dataMap.put("success", true);
		}else
			dataMap.put("success", false);
		return SUCCESS;
	}
	
	/**
	 * @return 教师端更新公告
	 * @throws UnsupportedEncodingException 
	 */
	public String updateTaskInfo() throws UnsupportedEncodingException{
		dataMap = new HashMap<String, Object>();
//		(Integer taskNum, String taskTitle, String taskRequire,
//				String yorNSub, String yorNVis, String fileOn, String video,
//				String annex, String endTime, String isStuDown, String isShowResult)
		taskInfo = new TaskInfo(getTaskNum(),getTaskTitle(),getTaskRequire(),getYorNSub(),getYorNVis(),
				getFileOn(),getVideo(),getAnnex(),getEndTime(),getIsStuDown(),getIsShowResult());
		if(announInfoService.updateTaskInfo(taskInfo)){
			dataMap.put("success", true);
		}else
			dataMap.put("success", false);
		return SUCCESS;
	}
	
	/**
	 * @return 教师端获取发布任务所需的章节信息
	 */
	public String getTree(){
		dataMap = new HashMap<String, Object>();
		treeInfos= announInfoService.getTree(getUserNum(),getTreeid());
		dataMap.put("success", true);
		dataMap.put("returnData", treeInfos);
		return SUCCESS;
	}
	
	

}
