package pers.nbu.netcourse.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import pers.nbu.netcourse.entity.AnnShow;
import pers.nbu.netcourse.entity.AnnounInfo;
import pers.nbu.netcourse.service.AnnounInfoService;

import com.opensymphony.xwork2.ActionSupport;

public class AnnounInfoAction extends ActionSupport{
	
	/**
	 * ʵ��
	 */
	private Integer AnnNum;
	private String AnnTitle;
	private String AnnCon;
	private String AnnUrl;
	private String AnnTime;
	private Integer Treeid;
	private String TeachNum;
	private String key = ""; 
	
	/**
	 * ʵ����
	 */
	private AnnounInfo announInfo;
	private ArrayList<AnnShow> announInfoLists;
	
	/**
	 * service
	 */
	private AnnounInfoService announInfoService;
	
	/**
	 * Json����
	 */
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
//	private static final long serialVersionUID = 1L;
	  
    //���ᱻStruts2���л�ΪJSON�ַ����Ķ���  
    private Map<String, Object> dataMap;  
	
	/**
	 * getter  and setter
	 * @return
	 */
    
    /** 
     * Struts2���л�ָ������ʱ�������и����Ե�getter������ʵ���ϣ����û�����ԣ���ֻ��getter����Ҳ�ǿ��Ե� 
     * @return 
     */  
    public Map<String, Object> getDataMap() {  
        return dataMap;  
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
	

	public AnnounInfoService getAnnounInfoService() {
		return announInfoService;
	}

	public void setAnnounInfoService(AnnounInfoService announInfoService) {
		this.announInfoService = announInfoService;
	}

	public AnnounInfo getAnnounInfo() {
		return announInfo;
	}

	public void setAnnounInfo(AnnounInfo announInfo) {
		this.announInfo = announInfo;
	}

	public ArrayList<AnnShow> getAnnounInfoLists() {
		return announInfoLists;
	}

	public void setAnnounInfoLists(ArrayList<AnnShow> announInfoLists) {
		this.announInfoLists = announInfoLists;
	}

	/**
	 * ���з������£�
	 */
	
	/**
	 * ��ȡ���й�����Ϣ
	 * @return
	 */
	public String getAllAnnounInfo(){
		// dataMap�е����ݽ��ᱻStruts2ת����JSON�ַ�������������Ҫ��������е����� 
		//dataMap.clear();
		dataMap = new HashMap<String, Object>();
		announInfoLists = announInfoService.getAllAnnounInfo(0);
		dataMap.put("success", true);
		dataMap.put("returnData", announInfoLists);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAnnounInfoByNum(){
		dataMap = new HashMap<String, Object>();
		announInfoLists = announInfoService.getAllAnnounInfo(getAnnNum());
		dataMap.put("success", true);
		dataMap.put("returnData", announInfoLists);
		return SUCCESS;
	}
	
	
//	//����key���Բ���Ϊjson�����ݷ���  
//    @JSON(serialize=true)  
//    public String getKey() {  
//        return key;  
//    } 
	
	

}
