package pers.nbu.netcourse.entity;

public class ActInfo {
	private Integer ActNum;
	private String CourNum;
	private String ClassName;
	
	
	public ActInfo(Integer actNum, String courNum, String className) {
		super();
		ActNum = actNum;
		CourNum = courNum;
		ClassName = className;
	}
	public Integer getActNum() {
		return ActNum;
	}
	public void setActNum(Integer actNum) {
		ActNum = actNum;
	}
	public String getCourNum() {
		return CourNum;
	}
	public void setCourNum(String courNum) {
		CourNum = courNum;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	
	

}
