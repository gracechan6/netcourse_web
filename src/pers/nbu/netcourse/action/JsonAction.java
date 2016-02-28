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
        // dataMap中的数据将会被Struts2转换成JSON字符串，所以这里要先清空其中的数据  
        dataMap = new HashMap<String, Object>();  
       
       // dataMap.put("user", user);  
        // 放入一个是否操作成功的标识  
        dataMap.put("success", true);  
        // 返回结果  
        return SUCCESS;  
    }  
  
    public Map<String, Object> getDataMap() {  
        return dataMap;  
    }
   
  
    //设置key属性不作为json的内容返回  
    @JSON(serialize=true)  
    public String getKey() {  
        return key;  
    } 
}
