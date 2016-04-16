package pers.nbu.netcourse.service;

import java.util.ArrayList;

import pers.nbu.netcourse.entity.AnnShow;
import pers.nbu.netcourse.entity.AnnounInfo;
import pers.nbu.netcourse.entity.AttendShow;
import pers.nbu.netcourse.entity.TaskManageShow;
import pers.nbu.netcourse.entity.TaskShow;


public interface AnnounInfoService {
	public ArrayList<AnnShow> getAllAnnounInfo(int num);
	public ArrayList<TaskShow> getAllTask(int num);
	public String loginVaild(String name,String pwd);
	public ArrayList<TaskManageShow> getAllTaskManage(String num,int tnum);
	public int updateTaskManage(String num,int tnum);
	
	public ArrayList<AttendShow> getAttend(String num,int tnum);
	public ArrayList<AttendShow> updateAttend(String num,int tnum);
	public Boolean updateServerAttend(String num,int tnum,String ip);
	
	
	public String loginVaildT(String name,String pwd);
	public ArrayList<AnnounInfo> getAnn(int num,String tnum);
	public Boolean delAnn(int num);
	public Boolean updateAnn(int num,String title,String con,String time);
	public int addAnn(AnnounInfo announInfo);
}
