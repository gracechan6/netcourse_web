package pers.nbu.netcourse.entity;

public class TreeInfo {
	private Integer Treeid;
	private String CourNum;
	private String TreeName;
	
	
	
	public TreeInfo(Integer treeid, String courNum, String treeName) {
		super();
		Treeid = treeid;
		CourNum = courNum;
		TreeName = treeName;
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
	public String getTreeName() {
		return TreeName;
	}
	public void setTreeName(String treeName) {
		TreeName = treeName;
	}
	
}
