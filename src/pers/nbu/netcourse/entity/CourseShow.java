package pers.nbu.netcourse.entity;

public class CourseShow {
	private Integer Treeid;
	private String CourNum;
	private String CourName;
	
	
	public CourseShow(Integer treeid, String courNum, String courName) {
		Treeid = treeid;
		CourNum = courNum;
		CourName = courName;
	}
	
	public Integer getTreeid() {
		return Treeid;
	}
	public void setTreeid(Integer treeid) {
		Treeid = treeid;
	}
	public String getCourNum() {
		return CourNum;
	}
	public void setCourNum(String courNum) {
		CourNum = courNum;
	}
	public String getCourName() {
		return CourName;
	}
	public void setCourName(String courName) {
		CourName = courName;
	}
	
	
}
