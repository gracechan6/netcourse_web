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

public class UserAction extends ActionSupport{
	
	/**
	 * ʵ��
	 */
	private String name;
	private String pwd;
	
	/**
	 * ʵ����
	 */
	private ArrayList<TaskShow> taskShowLists;
	
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
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
    public AnnounInfoService getAnnounInfoService() {
		return announInfoService;
	}

	public void setAnnounInfoService(AnnounInfoService announInfoService) {
		this.announInfoService = announInfoService;
	}
	
	
    /** 
     * Struts2���л�ָ������ʱ�������и����Ե�getter������ʵ���ϣ����û�����ԣ���ֻ��getter����Ҳ�ǿ��Ե� 
     * @return 
     */  
    public Map<String, Object> getDataMap() {  
        return dataMap;  
    }  
    
	/**
	 * ���з������£�
	 */
	
	/**
	 * ��ȡ��ҵ�б�
	 * @return
	 */
	public String loginVaild(){
		dataMap = new HashMap<String, Object>();
		String ret=announInfoService.loginVaild(getName(), getPwd());
		if(!ret.equals("false")){
			String sub[]=ret.split(";");
			dataMap.put("success", true);
			dataMap.put("stuName", sub[1]);
			dataMap.put("stuCla", sub[2]);
			dataMap.put("regDate", sub[3]);
			
		}
		else dataMap.put("success", false);
		return SUCCESS;
	}

	
	
	
//	//����key���Բ���Ϊjson�����ݷ���  
//    @JSON(serialize=true)  
//    public String getKey() {  
//        return key;  
//    } 
	
	

}
