package pers.nbu.netcourse.daoImpl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pers.nbu.netcourse.dao.AnnounInfoDao;
import pers.nbu.netcourse.entity.AnnShow;
import pers.nbu.netcourse.util.ConnSQL;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AnnounInfoDaoImpl extends HibernateDaoSupport implements AnnounInfoDao {
	
	ConnSQL connSql=new ConnSQL();
	

	public ArrayList<AnnShow> getAllAnnounInfo() {
		// TODO Auto-generated method stub
		//return (ArrayList<AnnounInfo>) getHibernateTemplate().find("from AnnounInfo where AnnType=?",new String[]{"公告"});
		String sql="select AnnNum,AnnTitle,AnnCon,AnnTime,AnnUrl,TeachName,CourName " +
				"from tb_AnnounInfo a,tb_YTeacherInfo b,tb_TreeInfo c,tb_YCourseInfo d  " +
				"where AnnType='公告'"+" and a.TeachNum = b.TeachNum and a.Treeid = c.Treeid and c.courNum =d.courNum ";
		
		try {
			connSql .openSQL();	
			return getAllAnnShow(connSql.executeQuery(sql));
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			connSql.closeSQL();
		}
		
		return null;
		/*return (ArrayList<AnnShow>) getHibernateTemplate().find("select AnnNum,AnnTitle,AnnCon,AnnTime,AnnUrl,TeachName,CourName " +
				"from tb_AnnounInfo a,tb_YTeacherInfo b,tb_TreeInfo c,tb_YCourseInfo d  " +
				"where AnnType=? and a.TeachNum = b.TeachNum and a.Treeid = c.Treeid and c.courNum =d.courNum ",new String[]{"公告"});*/
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
