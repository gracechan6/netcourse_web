package pers.nbu.netcourse.serviceImpl;


import java.util.ArrayList;


import pers.nbu.netcourse.dao.AnnounInfoDao;
import pers.nbu.netcourse.entity.ActInfo;
import pers.nbu.netcourse.entity.AnnShow;
import pers.nbu.netcourse.entity.AnnounInfo;
import pers.nbu.netcourse.entity.AttendInfo;
import pers.nbu.netcourse.entity.AttendShow;
import pers.nbu.netcourse.entity.CourseShow;
import pers.nbu.netcourse.entity.TaskInfo;
import pers.nbu.netcourse.entity.TaskManageShow;
import pers.nbu.netcourse.entity.TaskShow;
import pers.nbu.netcourse.entity.TreeInfo;
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
	
	public ArrayList<AttendShow> updateAttend(String num, int tnum) {
		return announInfoDao.updateAttend(num, tnum);
	}
	public Boolean updateServerAttend(String num, int tnum,String ip) {
		return announInfoDao.updateServerAttend(num, tnum,ip);
	}
	
	
	public String loginVaildT(String name, String pwd) {
		return announInfoDao.loginVaildT(name, pwd);
	}
	
	public ArrayList<AnnounInfo> getAnn(int num,String tnum) {
		return announInfoDao.getAnn(num,tnum);
	}
	
	public int addAnn(AnnounInfo announInfo) {
		return announInfoDao.addAnn(announInfo);
	}
	
	public Boolean delAnn(int num) {
		return announInfoDao.delAnn(num);
	}
	public Boolean updateAnn(int num, String title, String con, String time) {
		return announInfoDao.updateAnn(num, title, con, time);
	}
	
	public ArrayList<CourseShow> getCourse(String tnum,int id) {
		return announInfoDao.getCourse(tnum,id);
	}
	
	public int addTaskInfo(TaskInfo taskInfo) {
		return announInfoDao.addTaskInfo(taskInfo);
	}
	
	public Boolean delTaskInfo(int num) {
		return announInfoDao.delTaskInfo(num);
	}
	
	public ArrayList<TaskInfo> getTaskInfo(int num, String tnum) {
		return announInfoDao.getTaskInfo(num, tnum);
	}
	
	public Boolean updateTaskInfo(TaskInfo taskInfo) {
		return announInfoDao.updateTaskInfo(taskInfo);
	}	
	
	public ArrayList<ActInfo> getAct(String tnum, String id) {
		return announInfoDao.getAct(tnum, id);
	}
	
	public ArrayList<TreeInfo> getTree(String tnum, int id) {
		return announInfoDao.getTree(tnum, id);
	}
	
	public int addAttendInfo(AttendInfo attendInfo) {
		return announInfoDao.addAttendInfo(attendInfo);
	}
	
	public Boolean delAttendInfo(String num) {
		return announInfoDao.delAttendInfo(num);
	}
	
	public ArrayList<AttendInfo> getAttendInfo(String num, String tnum) {
		return announInfoDao.getAttendInfo(num, tnum);
	}
	
	public Boolean updateAttendInfo(AttendInfo attendInfo) {
		return announInfoDao.updateAttendInfo(attendInfo);
	}
	
	public int updateAndroidAttendInfo(String num) {
		return announInfoDao.updateAndroidAttendInfo(num);
	}

}
