package pers.nbu.netcourse.serviceImpl;


import java.util.ArrayList;

import pers.nbu.netcourse.dao.AnnounInfoDao;
import pers.nbu.netcourse.entity.AnnShow;
import pers.nbu.netcourse.entity.AnnounInfo;
import pers.nbu.netcourse.entity.AttendShow;
import pers.nbu.netcourse.entity.TaskManageShow;
import pers.nbu.netcourse.entity.TaskShow;
import pers.nbu.netcourse.service.AnnounInfoService;

public class AnnounInfoServiceImpl implements AnnounInfoService{

	private AnnounInfoDao announInfoDao;
	
	public AnnounInfoDao getAnnounInfoDao() {
		return announInfoDao;
	}

	public void setAnnounInfoDao(AnnounInfoDao announInfoDao) {
		this.announInfoDao = announInfoDao;
	}

	public ArrayList<AnnShow> getAllAnnounInfo(int num) {
		return announInfoDao.getAllAnnounInfo(num);
	}

	public ArrayList<TaskShow> getAllTask(int num) {
		return announInfoDao.getAllTask(num);
	}

	public String loginVaild(String name, String pwd) {
		return announInfoDao.loginVaild(name, pwd);
	}

	public ArrayList<TaskManageShow> getAllTaskManage(String num,int tnum) {
		return announInfoDao.getAllTaskManage(num,tnum);
	}
	
	public int updateTaskManage(String num, int tnum) {
		return announInfoDao.updateTaskManage(num, tnum);
	}
	
	public ArrayList<AttendShow> getAttend(String num, int tnum) {
		return announInfoDao.getAttend(num, tnum);
	}
	
	public Boolean updateAttend(String num, int tnum) {
		return announInfoDao.updateAttend(num, tnum);
	}
	public Boolean updateServerAttend(String num, int tnum) {
		return announInfoDao.updateServerAttend(num, tnum);
	}
}
