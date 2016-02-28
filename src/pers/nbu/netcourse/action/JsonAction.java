package pers.nbu.netcourse.action;

import java.util.ArrayList;
import java.util.HashMap;  
import java.util.Map; 

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.json.annotations.JSON;



public class JsonAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;  
    
    private Map<String,Object> dataMap;  
    private String key = "HEHEDA";  
    
	public String json() {  
        // dataMap�е����ݽ��ᱻStruts2ת����JSON�ַ�������������Ҫ��������е�����  
        dataMap = new HashMap<String, Object>();  
       
       // dataMap.put("user", user);  
        // ����һ���Ƿ�����ɹ��ı�ʶ  
        dataMap.put("success", true);  
        // ���ؽ��  
        return SUCCESS;  
    }  
  
    public Map<String, Object> getDataMap() {  
        return dataMap;  
    }
   
  
    //����key���Բ���Ϊjson�����ݷ���  
    @JSON(serialize=true)  
    public String getKey() {  
        return key;  
    } 
}
