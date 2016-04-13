package pers.nbu.netcourse.serviceImpl;


import java.util.ArrayList;

import pers.nbu.netcourse.dao.AnnounInfoDao;
import pers.nbu.netcourse.entity.AnnShow;
import pers.nbu.netcourse.entity.AnnounInfo;
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
		// TODO Auto-generated method stub
		return announInfoDao.loginVaild(name, pwd);
	}


	
}
