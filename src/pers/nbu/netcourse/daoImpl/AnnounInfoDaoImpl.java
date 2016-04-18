package pers.nbu.netcourse.daoImpl;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import pers.nbu.netcourse.util.ConnSQL;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AnnounInfoDaoImpl extends HibernateDaoSupport implements AnnounInfoDao {
	
	ConnSQL connSql=new ConnSQL();
	

	public ArrayList<AnnShow> getAllAnnounInfo(int num) {
		String sql="select AnnNum,AnnTitle,AnnCon,AnnTime,AnnUrl,TeachName,CourName " +
				"from tb_AnnounInfo a,tb_YTeacherInfo b,tb_TreeInfo c,tb_YCourseInfo d  " +
				"where AnnType='公告'"+" and a.TeachNum = b.TeachNum and a.Treeid = c.Treeid and c.courNum =d.courNum and a.annNum> "+num;
		try {
			connSql .openSQL();	
			return getAllAnnShow(connSql.executeQuery(sql));
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			connSql.closeSQL();
		}
		return null;		
	}
	
	private ArrayList<AnnShow> getAllAnnShow(ResultSet rs){
		ArrayList<AnnShow> lists= new ArrayList<AnnShow>();
		AnnShow annShow ;
		try {
			if (rs.next()) {
				do {
					String date=rs.getString("AnnTime");
					annShow = new AnnShow(rs.getInt("AnnNum"), rs.getString("AnnTitle"),rs.getString("AnnCon"), 
							date.substring(0, date.length()-2), rs.getString("AnnUrl"), rs.getString("TeachName"), rs.getString("CourName"));
					lists.add(annShow);
				} while (rs.next());
				
				return lists;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<TaskShow> getAllTask(int num) {
		String sql="select TaskNum,TaskTitle,TaskRequire,CourName,TeachName,TaskTime,EndTime "+ 
					"from tb_TaskInfo a,tb_TreeInfo b,tb_YCourseInfo,tb_YTeacherInfo "+
					"where a.Treeid=b.Treeid "+
					"and tb_YTeacherInfo.TeachNum=a.TeachNum "+
					"and YorNVis='True' "+
					"and tb_YCourseInfo.CourNum=b.CourNum and a.TaskNum>"+num;
		try {
			connSql .openSQL();	
			return getAllTaskShow(connSql.executeQuery(sql));
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			connSql.closeSQL();
		}
		return null;
	}
	
	private ArrayList<TaskShow> getAllTaskShow(ResultSet rs){
		ArrayList<TaskShow> lists= new ArrayList<TaskShow>();
		TaskShow taskShow ;
		try {
			if (rs.next()) {
				do {
					String start=rs.getString("TaskTime");
					String end=rs.getString("EndTime");
					taskShow = new TaskShow(rs.getInt("TaskNum"), rs.getString("TaskTitle"),rs.getString("CourName"), 
							rs.getString("TeachName"),start.substring(0, 19),end.substring(0, 19),rs.getString("TaskRequire") );
					lists.add(taskShow);
				} while (rs.next());
				return lists;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String loginVaild(String name, String pwd) {
		String sql="select right(IDNum,6) passwd,stuName,stuCla,regDate from tb_YStuInfo where stuNUm= "+name;
		try {
			connSql .openSQL();	
			ResultSet rs=connSql.executeQuery(sql);
			if(rs.next()){
				String pwds=rs.getString("passwd");
				if(pwd.equals(pwds)){
					return "true;"+rs.getString("stuName")+";"
								+rs.getString("stuCla")+";"+rs.getString("regDate").substring(0,19);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			connSql.closeSQL();
		}
		
		return "false";
	}

	public ArrayList<TaskManageShow> getAllTaskManage(String num,int tnum) {
		String sql="select tb.TaskNum,Treeid,TeachName,TaskTitle,CourName,TaskTime,EndTime,OpusNum from "+
					"( select TaskNum,tb_TaskInfo.Treeid,TeachName,TaskTitle,CourName,TaskTime,EndTime "+
					 "  from tb_TaskInfo,tb_YTeacherInfo,tb_YCourseInfo,tb_TreeInfo,tb_YTeachActivity,tb_YStuCouRel "+
					  "   where tb_TaskInfo.TeachNum=tb_YTeacherInfo.TeachNum and tb_YCourseInfo.CourNum=tb_TreeInfo.CourNum "+
					  "    and tb_TaskInfo.TeachNum=tb_YTeachActivity.TeachNum and tb_TaskInfo.Treeid=tb_TreeInfo.Treeid "+
					   "   and tb_YTeachActivity.CourNum=tb_TreeInfo.CourNum and tb_YStuCouRel.ActNum=tb_YTeachActivity.ActNum "+
					  "    and TaskNum>"+tnum+" and YorNVis='True'  and IsConfrim='True' and StuNum=" +num+
					  "  ) tb left  join  tb_TStuOpus on tb.TaskNum=tb_TStuOpus.TaskNum and StuNum ="+num;
		try {
			connSql .openSQL();	
			return getAllTaskMShow(connSql.executeQuery(sql));
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			connSql.closeSQL();
		}
		return null;
	}

	private ArrayList<TaskManageShow> getAllTaskMShow(ResultSet rs){
		ArrayList<TaskManageShow> lists= new ArrayList<TaskManageShow>();
		TaskManageShow taskManageShow ;
		try {
			if (rs.next()) {
				do {
					String start=rs.getString("TaskTime");
					String end=rs.getString("EndTime");
					taskManageShow = new TaskManageShow(rs.getInt("TaskNum"),rs.getInt("Treeid"),rs.getString("TeachName") ,rs.getString("TaskTitle"),rs.getString("CourName"), 
							start.substring(0, 19),end.substring(0, 19),rs.getInt("OpusNum") );
					lists.add(taskManageShow);
				} while (rs.next());
				return lists;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int updateTaskManage(String num, int tnum) {
		String sql="select a.OpusNum from " +
				"(select tb.TaskNum,Treeid,TeachName,TaskTitle,CourName,TaskTime,EndTime,OpusNum from " +
				"( select TaskNum,tb_TaskInfo.Treeid,TeachName,TaskTitle,CourName,TaskTime,EndTime " +
				"from tb_TaskInfo,tb_YTeacherInfo,tb_YCourseInfo,tb_TreeInfo,tb_YTeachActivity,tb_YStuCouRel " +
				"where tb_TaskInfo.TeachNum=tb_YTeacherInfo.TeachNum and tb_YCourseInfo.CourNum=tb_TreeInfo.CourNum " +
				"and tb_TaskInfo.TeachNum=tb_YTeachActivity.TeachNum and tb_TaskInfo.Treeid=tb_TreeInfo.Treeid " +
				"and tb_YTeachActivity.CourNum=tb_TreeInfo.CourNum and tb_YStuCouRel.ActNum=tb_YTeachActivity.ActNum " +
				"and TaskNum>0 and YorNVis='True'  and IsConfrim='True' and StuNum="+num+ " ) tb left  join  tb_TStuOpus on tb.TaskNum=tb_TStuOpus.TaskNum and StuNum ="+num+ " ) a where a.TaskNum="+tnum;
		try {
			connSql .openSQL();	
			ResultSet rs= connSql.executeQuery(sql);
			if (rs.next()) {
				do {
					return rs.getInt("OpusNum") ;
				} while (rs.next());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			connSql.closeSQL();
		}
		
		return 0;
	}
	
	private ArrayList<AttendShow> getAttendShow(ResultSet rs){
		ArrayList<AttendShow> lists= new ArrayList<AttendShow>();
		AttendShow attendShow ;
		try {
			if (rs.next()) {
				do {					
					attendShow = new AttendShow(rs.getInt("AttdenceNum"),rs.getInt("ActNum"),rs.getString("PlaceName"),rs.getString("CourName"),rs.getString("TeachName") ,
							rs.getString("AttdenceWeek"),rs.getString("StatusTime") ,rs.getString("StaName"),rs.getString("Status"),rs.getString("AttdenceClass"));
					lists.add(attendShow);
				} while (rs.next());
				return lists;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<AttendShow> getAttend(String num, int tnum) {
		String sql="select TeaAttdenceInfo.AttdenceNum,tb_YTeachActivity.ActNum,PlaceName," +
				"CourName,TeachName,AttdenceWeek,StatusTime,StaName,Status,AttdenceClass " +
				"from TeaStatus, tb_YTeachActivity ,TeaAttdenceAdmin,TeaAttdenceInfo,tb_YTeacherInfo,tb_YCourseInfo " +
				"where tb_YTeachActivity.ActNum=TeaAttdenceAdmin.ActNum and TeaAttdenceAdmin.AttOpen =TeaStatus.AttOpen " +
				"and TeaAttdenceAdmin.AttdenceNum=TeaAttdenceInfo.AttdenceNum and tb_YTeacherInfo.TeachNum=TeaAttdenceAdmin.TeachNum " +
				"and tb_YCourseInfo.CourNum=tb_YTeachActivity.CourNum  and TeaAttdenceAdmin.AttdenceClass<>'课堂考勤'  " +
				"and TeaAttdenceInfo.StuNum="+num+"  and TeaStatus.StaName<>'未开始考勤' and TeaAttdenceInfo.AttdenceNum> " +tnum+
				" order by AttdenceNum asc";
		
		try {
			connSql .openSQL();	
			return getAttendShow(connSql.executeQuery(sql));
		} catch (Exception e) {
		}finally{
			connSql.closeSQL();
		}
		
		return null;
	}
	
	public ArrayList<AttendShow> updateAttend(String num, int tnum) {
		String sql="select TeaAttdenceInfo.AttdenceNum,tb_YTeachActivity.ActNum,PlaceName," +
				"CourName,TeachName,AttdenceWeek,StatusTime,StaName,Status,AttdenceClass " +
				"from TeaStatus, tb_YTeachActivity ,TeaAttdenceAdmin,TeaAttdenceInfo,tb_YTeacherInfo,tb_YCourseInfo " +
				"where tb_YTeachActivity.ActNum=TeaAttdenceAdmin.ActNum and TeaAttdenceAdmin.AttOpen =TeaStatus.AttOpen " +
				"and TeaAttdenceAdmin.AttdenceNum=TeaAttdenceInfo.AttdenceNum and tb_YTeacherInfo.TeachNum=TeaAttdenceAdmin.TeachNum " +
				"and tb_YCourseInfo.CourNum=tb_YTeachActivity.CourNum  and TeaAttdenceAdmin.AttdenceClass<>'课堂考勤'  " +
				"and TeaAttdenceInfo.StuNum="+num+"  and TeaStatus.StaName<>'未开始考勤' and TeaAttdenceInfo.AttdenceNum= " +tnum+
				" order by AttdenceNum asc";
		
		try {
			connSql .openSQL();	
			return getAttendShow(connSql.executeQuery(sql));
		} catch (Exception e) {
		}finally{
			connSql.closeSQL();
		}
		
		return null;
	}
	
	public Boolean updateServerAttend(String num, int tnum,String ip) {
		String sql="UPDATE TeaAttdenceInfo SET Status='缺课',StuAsNum=1,ip="+ip+" WHERE StuNum="+num+ " and AttdenceNum="+tnum;
		try {
			connSql .openSQL();	
			if (connSql.executeUpdate(sql)>0) {
				return true;
			}
		} catch (Exception e) {
		}finally{
			connSql.closeSQL();
		}
		return false;
	}
	
	
	public String loginVaildT(String name, String pwd) {
		String sql="select * from tb_YTeacherInfo where TeachNum= "+name+" and TeachPws= "+pwd;
		try {
			connSql .openSQL();	
			ResultSet rs=connSql.executeQuery(sql);
			if(rs.next()){
				return "true;"+rs.getString("TeachName")+";"
								+rs.getString("TeachPost")+";"+rs.getString("TeachMod");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			connSql.closeSQL();
		}
		
		return "false";
	}
	
	public ArrayList<AnnounInfo> getAnn(int num,String tnum) {
		String sql="select * from tb_AnnounInfo where AnnType='公告' and TeachNum="+tnum+" and AnnNum>"+num;
		try {
			connSql .openSQL();	
			ResultSet rs=connSql.executeQuery(sql);
			if(rs.next()){
				ArrayList<AnnounInfo> lists=new ArrayList();
				AnnounInfo announInfo;
				do {
					String date=rs.getString("AnnTime");
					announInfo = new AnnounInfo(rs.getInt("AnnNum"),rs.getString("AnnTitle"),rs.getString("AnnCon"),date.substring(0,date.length()-2) ,
							rs.getString("AnnUrl"),rs.getString("TeachNum") ,rs.getString("AnnType"),rs.getInt("Treeid"));
					lists.add(announInfo);
				} while (rs.next());
				return lists;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			connSql.closeSQL();
		}
		return null;
	}
	
	public int addAnn(AnnounInfo announInfo) {
		String sql = "insert into tb_AnnounInfo (AnnTitle,AnnCon,AnnUrl,AnnTime,TeachNum,Treeid,AnnType) values ('" +
				announInfo.getAnnTitle() +"','"+announInfo.getAnnCon()+"',NULL,'"+announInfo.getAnnTime()+"','"+announInfo.getTeachNum()+"',"+
				announInfo.getTreeid()+",'"+announInfo.getAnnType() +
				"');select top 1 AnnNum from tb_AnnounInfo order by AnnNum desc";
		try {
			connSql .openSQL();	

//			sql = "select * from tb_AnnounInfo where AnnTitle='"+announInfo.getAnnTitle()+"' and AnnCon='"+ announInfo.getAnnCon()+
//					"' and TeachNum='"+announInfo.getTeachNum()+"' Treeid="+announInfo.getTreeid();
			ResultSet rs= connSql.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt("AnnNum") ;
			}

		} catch (Exception e) {
		}finally{
			connSql.closeSQL();
		}
		return 0;
	}
	
	public Boolean delAnn(int num) {
		String sql = "delete from tb_AnnounInfo where AnnNum="+num;
		try {
			connSql .openSQL();	
			if (connSql.executeUpdate(sql)>0) {
				return true;
			}
		} catch (Exception e) {
		}finally{
			connSql.closeSQL();
		}
		return false;
	}
	
	public Boolean updateAnn(int num, String title, String con, String time) {
		String sql = "update tb_AnnounInfo SET AnnTitle='"+title+"',AnnCon='"+con+"',AnnTime='"+time+"' where AnnNum="+num;
		try {
			connSql .openSQL();	
			if (connSql.executeUpdate(sql)>0) {
				return true;
			}
		} catch (Exception e) {
		}finally{
			connSql.closeSQL();
		}
		return false;
	}
	
	public ArrayList<CourseShow> getCourse(String tnum,int id) {
		String sql="select a.Treeid,a.CourNum,b.CourName  from tb_TreeInfo a,tb_YcourseInfo b where a.courNum=b.courNum " +
				"and TeachNum='" +tnum +
				"' and a.depth=0 and a.TreeName='公告区' and Treeid>"+id;
		
		try {
			connSql .openSQL();	
			ResultSet rs=connSql.executeQuery(sql);
			if(rs.next()){
				ArrayList<CourseShow> lists=new ArrayList();
				CourseShow c;
				do {
					c = new CourseShow(rs.getInt("Treeid"),rs.getString("CourNum") ,rs.getString("CourName"));
					lists.add(c);
				} while (rs.next());
				return lists;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			connSql.closeSQL();
		}
		return null;
	}
	
	public ArrayList<ActInfo> getAct(String tnum, String id) {
		String sql="select b.ActNum,a.ClassName,b.CourNum from tb_YTeachClass a,( select ActNum,GroupNum,CourNum " +
				" from tb_YTeachActivity where TeachNum='"+tnum+"'  )b where a.GroupNum=b.GroupNum and b.ActNum>"+id ;
		try {
			connSql .openSQL();	
			ResultSet rs=connSql.executeQuery(sql);
			if(rs.next()){
				ArrayList<ActInfo> lists=new ArrayList();
				ActInfo c;
				do {
					c = new ActInfo(rs.getString("ActNum"),rs.getString("CourNum") ,rs.getString("ClassName"));
					lists.add(c);
				} while (rs.next());
				return lists;
			}
			
		} catch (Exception e) {
		}finally{
			connSql.closeSQL();
		}
		return null;
	}
	
	public ArrayList<TreeInfo> getTree(String tnum, int id) {
		String sql="select b.Treeid,a.TreeName,a.CourNum  from tb_TreeInfo a,(select Treeid,TreeName,Parentid " +
				"from tb_TreeInfo where  TeachNum='"+tnum+"' and Depth=2 and TreeName='任务区') b " +
				"where a.Treeid = b.Parentid and b.Treeid> " +id ;
		try {
			connSql .openSQL();	
			ResultSet rs=connSql.executeQuery(sql);
			if(rs.next()){
				ArrayList<TreeInfo> lists=new ArrayList();
				TreeInfo c;
				do {
					c = new TreeInfo(rs.getInt("Treeid"),rs.getString("CourNum") ,rs.getString("TreeName"));
					lists.add(c);
				} while (rs.next());
				return lists;
			}
			
		} catch (Exception e) {
		}finally{
			connSql.closeSQL();
		}
		return null;
	}

	public int addTaskInfo(TaskInfo taskInfo) {
		String sql ="insert into tb_TaskInfo(TeachNum,TaskTitle,TaskRequire,YorNSub,YorNVis,TaskUrl,[File],Video,Annex,TaskTime,EndTime,Treeid,IsStuDown,IsShowResult,ActNum)" +
					" values('"+taskInfo.getTeachNum()+"','"+taskInfo.getTaskTitle()+"','"+taskInfo.getTaskRequire()+"','"+taskInfo.getYorNSub()+"','" +
						taskInfo.getYorNVis()+"',NULL,'"+taskInfo.getFileOn()+"','"+taskInfo.getVideo()+"','"+taskInfo.getAnnex()+"','"+taskInfo.getTaskTime()+"','" +
						taskInfo.getEndTime()+"',"+taskInfo.getTreeid()+",'"+taskInfo.getIsStuDown()+"','"+taskInfo.getIsShowResult()+"','"+taskInfo.getActNum()+"');" +
								"select top 1 TaskNum from tb_TaskInfo order by TaskNum desc";
		try {
			connSql .openSQL();	
			ResultSet rs= connSql.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt("TaskNum") ;
			}

		} catch (Exception e) {
		}finally{
			connSql.closeSQL();
		}
		return 0;
	}
	
	public Boolean delTaskInfo(int num) {
		String sql = "delete from tb_TaskInfo where TaskNum="+num;
		try {
			connSql .openSQL();	
			if (connSql.executeUpdate(sql)>0) {
				return true;
			}
		} catch (Exception e) {
		}finally{
			connSql.closeSQL();
		}
		return false;
	}
	
	public ArrayList<TaskInfo> getTaskInfo(int num, String tnum) {
		String sql="select * from tb_TaskInfo where TeachNum="+tnum+" and TaskNum>"+num;
		try {
			connSql .openSQL();	
			ResultSet rs=connSql.executeQuery(sql);
			if(rs.next()){
				ArrayList<TaskInfo> lists=new ArrayList();
				TaskInfo taskInfo;
				do {
					String start=rs.getString("TaskTime");
					String end=rs.getString("EndTime");
					taskInfo = new TaskInfo(rs.getInt("TaskNum"),rs.getString("TeachNum"),rs.getString("TaskTitle"),rs.getString("TaskRequire"),
							rs.getString("YorNSub"),rs.getString("YorNVis"),rs.getString("TaskUrl"),rs.getString("File"),rs.getString("Video"),
							rs.getString("Annex"),start.substring(0, 19),end.substring(0, 19),rs.getInt("Treeid"),rs.getString("IsStuDown"),
							rs.getString("IsShowResult"),rs.getString("ActNum"));
					lists.add(taskInfo);
				} while (rs.next());
				return lists;
			}
		} catch (Exception e) {
		}finally{
			connSql.closeSQL();
		}
		return null;
	}
	
	public Boolean updateTaskInfo(TaskInfo taskInfo) {
		String sql = "update tb_TaskInfo set TaskTitle='"+taskInfo.getTaskTitle()+"',TaskRequire='"+taskInfo.getTaskRequire()+"',YorNSub='" +
					taskInfo.getYorNSub()+"',YorNVis='"+taskInfo.getYorNVis()+"',[File]='"+taskInfo.getFileOn()+"',Video='"+taskInfo.getVideo()+"',Annex='" +
					taskInfo.getAnnex()+"',EndTime='"+taskInfo.getEndTime()+"',IsStuDown='"+taskInfo.getIsStuDown()+"',IsShowResult='"+taskInfo.getIsShowResult()+
					"' where TaskNum="+taskInfo.getTaskNum();  
		try {
			connSql .openSQL();	
			if (connSql.executeUpdate(sql)>0) {
				return true;
			}
		} catch (Exception e) {
		}finally{
			connSql.closeSQL();
		}
		return false;
	}
	
	public int addAttendInfo(AttendInfo attendInfo) {
		String sql;
		if(attendInfo.getPlaceName().equals("null")){
			if(attendInfo.getRemark().equals("null"))
				sql ="declare @attnum varchar(20);SELECT @attnum=MAX(AttdenceNum)+1 FROM TeaAttdenceAdmin;" +
						"insert into TeaAttdenceAdmin(AttdenceNum,StatusTime,TeachNum,ActNum,AttOpen,AttdenceClass,AttdenceWeek,PlaceName,Remark) " +
						"values(@attnum,'"+attendInfo.getStatusTime()+"','"+attendInfo.getTeachNum()+"','"+attendInfo.getActNum()+"',"+attendInfo.getAttOpen()+",'"+
						attendInfo.getAttdenceClass()+"','" +attendInfo.getAttdenceWeek()+"',NULL,NULL);" +
						"exec AddStuAtt '20025',@attnum;SELECT MAX(AttdenceNum) AttdenceNum FROM TeaAttdenceAdmin;";
			else 
				sql ="declare @attnum varchar(20);SELECT @attnum=MAX(AttdenceNum)+1 FROM TeaAttdenceAdmin;" +
						"insert into TeaAttdenceAdmin(AttdenceNum,StatusTime,TeachNum,ActNum,AttOpen,AttdenceClass,AttdenceWeek,PlaceName,Remark) " +
						"values(@attnum,'"+attendInfo.getStatusTime()+"','"+attendInfo.getTeachNum()+"','"+attendInfo.getActNum()+"',"+attendInfo.getAttOpen()+",'"+
						attendInfo.getAttdenceClass()+"','" +attendInfo.getAttdenceWeek()+"',NULL,'"+attendInfo.getRemark()+"');" +
						"exec AddStuAtt '20025',@attnum;SELECT MAX(AttdenceNum) AttdenceNum FROM TeaAttdenceAdmin;";
		}
		else{
			if(attendInfo.getRemark().equals("null"))
				sql ="declare @attnum varchar(20);SELECT @attnum=MAX(AttdenceNum)+1 FROM TeaAttdenceAdmin;" +
						"insert into TeaAttdenceAdmin(AttdenceNum,StatusTime,TeachNum,ActNum,AttOpen,AttdenceClass,AttdenceWeek,PlaceName,Remark) " +
						"values(@attnum,'"+attendInfo.getStatusTime()+"','"+attendInfo.getTeachNum()+"','"+attendInfo.getActNum()+"',"+attendInfo.getAttOpen()+",'"+
						attendInfo.getAttdenceClass()+"','" +attendInfo.getAttdenceWeek()+"','默认机房',NULL);" +
						"exec AddStuAtt '20025',@attnum;SELECT MAX(AttdenceNum) AttdenceNum FROM TeaAttdenceAdmin;";
			else 
				sql ="declare @attnum varchar(20);SELECT @attnum=MAX(AttdenceNum)+1 FROM TeaAttdenceAdmin;" +
						"insert into TeaAttdenceAdmin(AttdenceNum,StatusTime,TeachNum,ActNum,AttOpen,AttdenceClass,AttdenceWeek,PlaceName,Remark) " +
						"values(@attnum,'"+attendInfo.getStatusTime()+"','"+attendInfo.getTeachNum()+"','"+attendInfo.getActNum()+"',"+attendInfo.getAttOpen()+",'"+
						attendInfo.getAttdenceClass()+"','" +attendInfo.getAttdenceWeek()+"','默认机房','"+attendInfo.getRemark()+"');" +
						"exec AddStuAtt '20025',@attnum;SELECT MAX(AttdenceNum) AttdenceNum FROM TeaAttdenceAdmin;";
		}
		try {
			connSql .openSQL();	
			ResultSet rs= connSql.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt("AttdenceNum") ;
			}

		} catch (Exception e) {
		}finally{
			connSql.closeSQL();
		}
		return 0;
	}
	
	public Boolean delAttendInfo(String num) {
		String sql = "delete from TeaAttdenceAdmin where AttdenceNum="+num;
		try {
			connSql .openSQL();	
			if (connSql.executeUpdate(sql)>0) {
				return true;
			}
		} catch (Exception e) {
		}finally{
			connSql.closeSQL();
		}
		return false;
	}
	
	public ArrayList<AttendInfo> getAttendInfo(String num, String tnum) {
		String sql="select * from TeaAttdenceAdmin where TeachNum="+tnum+" and AttdenceNum>"+num;
		try {
			connSql .openSQL();	
			ResultSet rs=connSql.executeQuery(sql);
			if(rs.next()){
				ArrayList<AttendInfo> lists=new ArrayList();
				AttendInfo attendInfo;
				do {						
					attendInfo = new AttendInfo(rs.getString("AttdenceNum"),rs.getString("StatusTime"),rs.getString("TeachNum"),rs.getString("ActNum"),
							rs.getInt("AttOpen"),rs.getString("AttdenceClass"),rs.getString("AttdenceWeek"),rs.getString("PlaceName"),rs.getString("Remark"));
					lists.add(attendInfo);
				} while (rs.next());
				return lists;
			}
		} catch (Exception e) {
		}finally{
			connSql.closeSQL();
		}
		return null;
	}
	
	public Boolean updateAttendInfo(AttendInfo attendInfo) {
		String sql;
		if(attendInfo.getPlaceName().equals("null")){
			if(attendInfo.getRemark().equals("null"))
				sql ="update TeaAttdenceAdmin set StatusTime='"+attendInfo.getStatusTime()+"',AttOpen="+attendInfo.getAttOpen()+",AttdenceClass='" +
					attendInfo.getAttdenceClass()+"',AttdenceWeek='"+attendInfo.getAttdenceWeek()+"',PlaceName=NULL,Remark=NULL"+" where " +
							"AttdenceNum="+attendInfo.getAttdenceNum();
			else 
				sql ="update TeaAttdenceAdmin set StatusTime='"+attendInfo.getStatusTime()+"',AttOpen="+attendInfo.getAttOpen()+",AttdenceClass='" +
						attendInfo.getAttdenceClass()+"',AttdenceWeek='"+attendInfo.getAttdenceWeek()+"',PlaceName=NULL,Remark='"+attendInfo.getRemark()+"' where " +
								"AttdenceNum="+attendInfo.getAttdenceNum();
		}
		else{
			if(attendInfo.getRemark().equals("null"))
				sql ="update TeaAttdenceAdmin set StatusTime='"+attendInfo.getStatusTime()+"',AttOpen="+attendInfo.getAttOpen()+",AttdenceClass='" +
					attendInfo.getAttdenceClass()+"',AttdenceWeek='"+attendInfo.getAttdenceWeek()+"',PlaceName='默认机房',Remark=NULL"+" where " +
							"AttdenceNum="+attendInfo.getAttdenceNum();
			else 
				sql ="update TeaAttdenceAdmin set StatusTime='"+attendInfo.getStatusTime()+"',AttOpen="+attendInfo.getAttOpen()+",AttdenceClass='" +
						attendInfo.getAttdenceClass()+"',AttdenceWeek='"+attendInfo.getAttdenceWeek()+"',PlaceName='默认机房',Remark='"+attendInfo.getRemark()+"' where " +
								"AttdenceNum="+attendInfo.getAttdenceNum();
		}
		
		try {
			connSql .openSQL();	
			if (connSql.executeUpdate(sql)>0) {
				return true;
			}
		} catch (Exception e) {
		}finally{
			connSql.closeSQL();
		}
		return false;
		
	}
	
	
	
	
}
