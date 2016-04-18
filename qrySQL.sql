012345/666666
0001/111111

//所有公告
select AnnNum,AnnTitle,AnnCon,AnnTime,AnnUrl,TeachName,CourName 
				from tb_AnnounInfo a,tb_YTeacherInfo b,tb_TreeInfo c,tb_YCourseInfo d  
				where AnnType='公告' and a.TeachNum = b.TeachNum and a.Treeid = c.Treeid and c.courNum =d.courNum and a.annNum>0

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


select * from tb_YStuInfo where stuNUm='0001'

select * from tb_Taskinfo

帐户,密码
select right(IDNum,6),stuNum from tb_YStuInfo where stuNUm='154175116'
130930199611190024

select * from tb_YStuInfo 

--教师



//发布
//公告
--该教师所拥有的课程   公告用 Treeid  CourNum  CourName
select a.Treeid,a.CourNum,b.CourName  from tb_TreeInfo a,tb_YcourseInfo b where a.courNum=b.courNum and TeachNum='171123'and a.depth=0 and a.TreeName='公告区' and Treeid>0
select * from tb_AnnounInfo where AnnType='公告' and TeachNum='171123' and AnnNum>0
插入
insert into tb_AnnounInfo (AnnTitle,AnnCon,AnnUrl,AnnTime,TeachNum,Treeid,AnnType) values (@AnnTitle,@AnnCon,@AnnUrl,@AnnTime,@TeachNum,@Treeid,@AnnType,@TreeType)

insert into tb_AnnounInfo (AnnTitle,AnnCon,AnnUrl,AnnTime,TeachNum,Treeid,AnnType) values ('nihao你好','sad阿斯达撒',NULL,'2016-04-06 15:23:23','171123',620,'公告')
select top 1 AnnNum from tb_AnnounInfo order by AnnNum desc
删除
delete from tb_AnnounInfo where AnnNum=126
更新
update tb_AnnounInfo SET AnnTitle='sad111111',AnnCon='sadsad',AnnTime='2016-04-12 11:01:01' where AnnNum='111'
查找（本地，服务器）
select * from tb_AnnounInfo where TeachNum='171123' order by AnnNum desc 



--任务区获取相应章节下任务id

//任务区id 章节名称 Treeid,TreeName,CourNum
select b.Treeid,a.TreeName,a.CourNum  from tb_TreeInfo a,(select Treeid,TreeName,Parentid from tb_TreeInfo 
where CourNum='CK0C05A' and TeachNum='171123' and Depth=2 and TreeName='任务区') b
where a.Treeid = b.Parentid

select b.Treeid,a.TreeName,a.CourNum  from tb_TreeInfo a,(select Treeid,TreeName,Parentid from tb_TreeInfo 
where  TeachNum='171123' and Depth=2 and TreeName='任务区') b
where a.Treeid = b.Parentid and b.Treeid>0

查
select * from tb_TaskInfo where TeachNum='171123' and TaskNum>0  order by TaskNum desc
select * from tb_TaskInfo where TeachNum=171123 and TaskNum>0
增
insert into tb_TaskInfo(TeachNum,TaskTitle,TaskRequire,YorNSub,YorNVis,TaskUrl,[File],Video,Annex,TaskTime,EndTime,Treeid,IsStuDown,IsShowResult,ActNum) values('171123','sad','gfgf','True','True',NULL,'True','False','False','2015-10-12 10:33:31.063','2015-10-19 10:33:31.063',632,'False','False','20027');
select top 1 TaskNum from tb_TaskInfo order by TaskNum desc
删
delete from tb_TaskInfo where TaskNum=118
改
update tb_TaskInfo set TaskTitle='fafada',TaskRequire='fsdfshgfhd',YorNSub='True',YorNVis='True',[File]='False',Video='True',Annex='False',EndTime='2015-10-20 10:33:31.063',IsStuDown='True',IsShowResult='False' where TaskNum=118
else
update tb_TaskInfo set ActNum='20025' where TeachNum=171123 and TaskNum>0
--考勤 获取教学班名  ActNum,ClassName,CourNum
select b.ActNum,a.ClassName,b.CourNum from tb_YTeachClass a,( select ActNum,GroupNum,CourNum  from tb_YTeachActivity where TeachNum='171123'  )b 
where a.GroupNum=b.GroupNum and b.ActNum>0

//教师发布出勤后 学生缺课记录添加
exec AddStuAtt '20030','1067'

select * from tb_YTeacherInfo where TeachNum='171123' and TeachPws='666666'
SELECT MAX(AttdenceNum)+1 num FROM TeaAttdenceAdmin
查
select * from TeaAttdenceAdmin where TeachNum='171123' and AttdenceNum>0
增

删
delete from TeaAttdenceAdmin where AttdenceNum=118
改
