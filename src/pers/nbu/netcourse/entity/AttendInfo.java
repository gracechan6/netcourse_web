package pers.nbu.netcourse.entity;

public class AttendInfo {
	
	private String AttdenceNum;
	private String StatusTime;
	private String TeachNum;
	private String ActNum;
	private Integer AttOpen;
	private String AttdenceClass;
	private String AttdenceWeek;
	private String PlaceName;
	private String Remark;
	
	public AttendInfo( String statusTime, String teachNum,
			String actNum, Integer attOpen, String attdenceClass, String attdenceWeek,
			String placeName, String remark) {
		super();
		StatusTime = statusTime;
		TeachNum = teachNum;
		ActNum = actNum;
		AttdenceClass = attdenceClass;
		AttdenceWeek = attdenceWeek;
		PlaceName = placeName;
		Remark = remark;
		AttOpen = attOpen;
	}
	
	public AttendInfo(String attdenceNum, String statusTime, Integer attOpen, String attdenceClass, String attdenceWeek,
			String placeName, String remark) {
		super();
		AttdenceNum = attdenceNum;
		StatusTime = statusTime;
		AttdenceClass = attdenceClass;
		AttdenceWeek = attdenceWeek;
		PlaceName = placeName;
		Remark = remark;
		AttOpen = attOpen;
	}
		
	public AttendInfo(String attdenceNum, String statusTime, String teachNum,
			String actNum, Integer attOpen, String attdenceClass, String attdenceWeek,
			String placeName, String remark) {
		super();
		AttdenceNum = attdenceNum;
		StatusTime = statusTime;
		TeachNum = teachNum;
		ActNum = actNum;
		AttdenceClass = attdenceClass;
		AttdenceWeek = attdenceWeek;
		PlaceName = placeName;
		Remark = remark;
		AttOpen = attOpen;
	}
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
	
	
	

}
