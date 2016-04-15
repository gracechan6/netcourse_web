012345/666666
0001/111111

//查询所有作业
select TaskNum,TaskTitle,TaskRequire,CourName,TeachName,TaskTime,EndTime
from tb_TaskInfo a,tb_TreeInfo b,tb_YCourseInfo,tb_YTeacherInfo 
where a.Treeid=b.Treeid 
            and tb_YTeacherInfo.TeachNum=a.TeachNum 
            and YorNVis='True' 
            and tb_YCourseInfo.CourNum=b.CourNum and a.TaskNum>0

insert into tb_TaskInfo(TeachNum,TaskTitle,TaskRequire,YorNSub,YorNVis,TaskTime,EndTime,Treeid) 
values('1122','fsdfs','fasadasd','True','True','2016-04-15','2016-04-18',111);

select * from tb_TStuOpus where stuNum='154175109';
select count(OpusNum) as Number from tb_TStuOpus where StuNum='154175109';

exec sq_SelStuTaskInfo '20025','154175109';

//学生作业上交情况 OpusNum有值代表上交
select tb.TaskNum,Treeid,TeachName,TaskTitle,CourName,TaskTime,EndTime,OpusNum from 
( select TaskNum,tb_TaskInfo.Treeid,TeachName,TaskTitle,CourName,TaskTime,EndTime 
   from tb_TaskInfo,tb_YTeacherInfo,tb_YCourseInfo,tb_TreeInfo,tb_YTeachActivity,tb_YStuCouRel 
     where tb_TaskInfo.TeachNum=tb_YTeacherInfo.TeachNum and tb_YCourseInfo.CourNum=tb_TreeInfo.CourNum 
      and tb_TaskInfo.TeachNum=tb_YTeachActivity.TeachNum and tb_TaskInfo.Treeid=tb_TreeInfo.Treeid 
      and tb_YTeachActivity.CourNum=tb_TreeInfo.CourNum and tb_YStuCouRel.ActNum=tb_YTeachActivity.ActNum 
      and TaskNum>0 and YorNVis='True'  and IsConfrim='True' and StuNum='0001'  ) tb left  join  tb_TStuOpus on tb.TaskNum=tb_TStuOpus.TaskNum and StuNum ='0001' 

判断用户有没有交作业
select a.OpusNum from
(select tb.TaskNum,Treeid,TeachName,TaskTitle,CourName,TaskTime,EndTime,OpusNum from 
( select TaskNum,tb_TaskInfo.Treeid,TeachName,TaskTitle,CourName,TaskTime,EndTime 
   from tb_TaskInfo,tb_YTeacherInfo,tb_YCourseInfo,tb_TreeInfo,tb_YTeachActivity,tb_YStuCouRel 
     where tb_TaskInfo.TeachNum=tb_YTeacherInfo.TeachNum and tb_YCourseInfo.CourNum=tb_TreeInfo.CourNum 
      and tb_TaskInfo.TeachNum=tb_YTeachActivity.TeachNum and tb_TaskInfo.Treeid=tb_TreeInfo.Treeid 
      and tb_YTeachActivity.CourNum=tb_TreeInfo.CourNum and tb_YStuCouRel.ActNum=tb_YTeachActivity.ActNum 
      and TaskNum>0 and YorNVis='True'  and IsConfrim='True' and StuNum='0001'  ) tb left  join  tb_TStuOpus on tb.TaskNum=tb_TStuOpus.TaskNum and StuNum ='0001') a where a.TaskNum=107


//学生查看自己的考勤记录
select TeaAttdenceInfo.AttdenceNum,tb_YTeachActivity.ActNum,PlaceName,
CourName,TeachName,AttdenceWeek,StatusTime,StaName,Status,AttdenceClass   
from TeaStatus, tb_YTeachActivity ,TeaAttdenceAdmin,TeaAttdenceInfo,tb_YTeacherInfo,tb_YCourseInfo  
where tb_YTeachActivity.ActNum=TeaAttdenceAdmin.ActNum and TeaAttdenceAdmin.AttOpen =TeaStatus.AttOpen 
and TeaAttdenceAdmin.AttdenceNum=TeaAttdenceInfo.AttdenceNum and tb_YTeacherInfo.TeachNum=TeaAttdenceAdmin.TeachNum  
and tb_YCourseInfo.CourNum=tb_YTeachActivity.CourNum  and TeaAttdenceAdmin.AttdenceClass<>'课堂考勤'  
and TeaAttdenceInfo.StuNum='0001'  and TeaStatus.StaName<>'未开始考勤' and TeaAttdenceInfo.AttdenceNum>0
order by AttdenceNum asc

//学生查看自己的某条考勤记录情况
select TeaAttdenceInfo.AttdenceNum,tb_YTeachActivity.ActNum,PlaceName,
CourName,TeachName,AttdenceWeek,StatusTime,StaName,Status,AttdenceClass,ip   
from TeaStatus, tb_YTeachActivity ,TeaAttdenceAdmin,TeaAttdenceInfo,tb_YTeacherInfo,tb_YCourseInfo  
where tb_YTeachActivity.ActNum=TeaAttdenceAdmin.ActNum and TeaAttdenceAdmin.AttOpen =TeaStatus.AttOpen 
and TeaAttdenceAdmin.AttdenceNum=TeaAttdenceInfo.AttdenceNum and tb_YTeacherInfo.TeachNum=TeaAttdenceAdmin.TeachNum  
and tb_YCourseInfo.CourNum=tb_YTeachActivity.CourNum  and TeaAttdenceAdmin.AttdenceClass<>'课堂考勤'  
and TeaAttdenceInfo.StuNum='0001'  and TeaStatus.StaName<>'未开始考勤' and TeaAttdenceInfo.AttdenceNum=1004
order by AttdenceNum asc

//学生考勤签到  手机端只要传 StuNum和AttdenceNum  ip即可
UPDATE TeaAttdenceInfo SET Status='缺课',StuAsNum=0,ip='mobile' WHERE StuNum='0001' and AttdenceNum='1007'

//考勤测试
insert into TeaAttdenceAdmin values(1007,'2016-04-15 11:48:26','171123',20025,1,'机房考勤','第十二周','默认机房',NULL);
insert into TeaAttdenceInfo values(1007,'0001','缺课',NULL,0,NULL);
//教师发布出勤后 学生缺课记录添加
exec AddStuAtt '20030','1067'

select * from tb_YStuInfo where stuNUm='0001'

select * from tb_Taskinfo

帐户,密码
select right(IDNum,6),stuNum from tb_YStuInfo where stuNUm='154175116'
130930199611190024


select * from tb_YStuInfo 