package pers.nbu.netcourse.service;

import java.util.ArrayList;

import pers.nbu.netcourse.entity.AnnShow;
import pers.nbu.netcourse.entity.AnnounInfo;
import pers.nbu.netcourse.entity.TaskManageShow;
import pers.nbu.netcourse.entity.TaskShow;


public interface AnnounInfoService {
	public ArrayList<AnnShow> getAllAnnounInfo(int num);
	public ArrayList<TaskShow> getAllTask(int num);
	public String loginVaild(String name,String pwd);
	public ArrayList<TaskManageShow> getAllTaskManage(String num,int tnum);
	public int updateTaskManage(String num,int tnum);
}
