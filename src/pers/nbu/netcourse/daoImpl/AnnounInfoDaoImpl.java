package pers.nbu.netcourse.daoImpl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pers.nbu.netcourse.dao.AnnounInfoDao;
import pers.nbu.netcourse.entity.AnnShow;
import pers.nbu.netcourse.entity.TaskManageShow;
import pers.nbu.netcourse.entity.TaskShow;
import pers.nbu.netcourse.util.ConnSQL;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AnnounInfoDaoImpl extends HibernateDaoSupport implements AnnounInfoDao {
	
	ConnSQL connSql=new ConnSQL();
	

	public ArrayList<AnnShow> getAllAnnounInfo(int num) {
		//return (ArrayList<AnnounInfo>) getHibernateTemplate().find("from AnnounInfo where AnnType=?",new String[]{"公告"});
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

	public ArrayList<TaskManageShow> getAllTaskManage(String num) {
		String sql="select tb.TaskNum,Treeid,TeachName,TaskTitle,CourName,TaskTime,EndTime,OpusNum from "+
					"( select TaskNum,tb_TaskInfo.Treeid,TeachName,TaskTitle,CourName,TaskTime,EndTime "+
					 "  from tb_TaskInfo,tb_YTeacherInfo,tb_YCourseInfo,tb_TreeInfo,tb_YTeachActivity,tb_YStuCouRel "+
					  "   where tb_TaskInfo.TeachNum=tb_YTeacherInfo.TeachNum and tb_YCourseInfo.CourNum=tb_TreeInfo.CourNum "+
					  "    and tb_TaskInfo.TeachNum=tb_YTeachActivity.TeachNum and tb_TaskInfo.Treeid=tb_TreeInfo.Treeid "+
					   "   and tb_YTeachActivity.CourNum=tb_TreeInfo.CourNum and tb_YStuCouRel.ActNum=tb_YTeachActivity.ActNum "+
					  "    and TaskNum>0 and YorNVis='True'  and IsConfrim='True' and StuNum=" +num+
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
}
