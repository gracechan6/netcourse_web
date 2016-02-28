package pers.nbu.netcourse.entity;

public class AnnShow {
	
	private Integer AnnNum;
	private String AnnTitle;
	private String AnnCon;
	private String AnnUrl;
	private String AnnTime;
	private String TeachName;
	private String CourName;
	
	
	public AnnShow(Integer annNum, String annTitle, String annCon,String annTime, 
			String annUrl, String teachName, String courName) {
		super();
		AnnNum = annNum;
		AnnTitle = annTitle;
		AnnCon = annCon;
		AnnUrl = annUrl;
		AnnTime = annTime;
		TeachName = teachName;
		CourName = courName;
	}
	public Integer getAnnNum() {
		return AnnNum;
	}
	public void setAnnNum(Integer annNum) {
		AnnNum = annNum;
	}
	public String getAnnTitle() {
		return AnnTitle;
	}
	public void setAnnTitle(String annTitle) {
		AnnTitle = annTitle;
	}
	public String getAnnCon() {
		return AnnCon;
	}
	public void setAnnCon(String annCon) {
		AnnCon = annCon;
	}
	public String getAnnUrl() {
		return AnnUrl;
	}
	public void setAnnUrl(String annUrl) {
		AnnUrl = annUrl;
	}
	public String getAnnTime() {
		return AnnTime;
	}
	public void setAnnTime(String annTime) {
		AnnTime = annTime;
	}
	public String getTeachName() {
		return TeachName;
	}
	public void setTeachName(String teachName) {
		TeachName = teachName;
	}
	public String getCourName() {
		return CourName;
	}
	public void setCourName(String courName) {
		CourName = courName;
	}
	
	

}
