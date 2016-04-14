package pers.nbu.netcourse.dao;

import java.util.ArrayList;

import pers.nbu.netcourse.entity.AnnShow;
import pers.nbu.netcourse.entity.AttendShow;
import pers.nbu.netcourse.entity.TaskManageShow;
import pers.nbu.netcourse.entity.TaskShow;

public interface AnnounInfoDao {
	
	public ArrayList<AnnShow> getAllAnnounInfo(int num);
	public ArrayList<TaskShow> getAllTask(int num);
	public String loginVaild(String name,String pwd);
	public ArrayList<TaskManageShow> getAllTaskManage(String num,int tnum);
	public int updateTaskManage(String num,int tnum);
	
	public ArrayList<AttendShow> getAttend(String num,int tnum);
	public Boolean updateAttend(String num,int tnum);//�ӷ�������ȡ���������±�������
	public Boolean updateServerAttend(String num,int tnum);//���·���������
}
