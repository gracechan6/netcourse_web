package pers.nbu.netcourse.entity;

public class TaskShow {
	private Integer TaskNum;
	private String TaskTitle;
	private String CourName;
	private String TeachName;
	private String TaskTime;
	private String EndTime;
	private String TaskRequire;
	
	
	
	public TaskShow(Integer taskNum, String taskTitle, String courName,
			String teachName, String taskTime, String endTime,String taskRequire) {
		super();
		TaskNum = taskNum;
		TaskTitle = taskTitle;
		CourName = courName;
		TeachName = teachName;
		TaskTime = taskTime;
		EndTime = endTime;
		TaskRequire = taskRequire;
	}
	public Integer getTaskNum() {
		return TaskNum;
	}
	public void setTaskNum(Integer taskNum) {
		TaskNum = taskNum;
	}
	public String getTaskTitle() {
		return TaskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		TaskTitle = taskTitle;
	}
	public String getCourName() {
		return CourName;
	}
	public void setCourName(String courName) {
		CourName = courName;
	}
	public String getTeachName() {
		return TeachName;
	}
	public void setTeachName(String teachName) {
		TeachName = teachName;
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
	public String getTaskRequire() {
		return TaskRequire;
	}
	public void setTaskRequire(String taskRequire) {
		TaskRequire = taskRequire;
	}
	
	
}
