package pers.nbu.netcourse.entity;

public class AnnounInfo {
	private Integer AnnNum;
	private String AnnTitle;
	private String AnnCon;
	private String AnnTime;
	private String AnnUrl;
	private String TeachNum;
	private String AnnType; 
	private Integer Treeid;
	
	public AnnounInfo(String annTitle, String annCon,
			String annTime, String annUrl, String teachNum, String annType,
			Integer treeid) {
		AnnTitle = annTitle;
		AnnCon = annCon;
		AnnTime = annTime;
		AnnUrl = annUrl;
		TeachNum = teachNum;
		AnnType = annType;
		Treeid = treeid;
	}
	
	public AnnounInfo(String annTitle, String annCon,
			String annTime,String teachNum, String annType,
			Integer treeid) {
		AnnTitle = annTitle;
		AnnCon = annCon;
		AnnTime = annTime;
		TeachNum = teachNum;
		AnnType = annType;
		Treeid = treeid;
	}
	
	public AnnounInfo(Integer annNum, String annTitle, String annCon,
			String annTime, String annUrl, String teachNum, String annType,
			Integer treeid) {
		AnnNum = annNum;
		AnnTitle = annTitle;
		AnnCon = annCon;
		AnnTime = annTime;
		AnnUrl = annUrl;
		TeachNum = teachNum;
		AnnType = annType;
		Treeid = treeid;
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
	public Integer getTreeid() {
		return Treeid;
	}
	public void setTreeid(Integer treeid) {
		Treeid = treeid;
	}
	public String getTeachNum() {
		return TeachNum;
	}
	public void setTeachNum(String teachNum) {
		TeachNum = teachNum;
	}
	public String getAnnType() {
		return AnnType;
	}
	public void setAnnType(String annType) {
		AnnType = annType;
	}
	
	
}
