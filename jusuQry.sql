select * from tb_YTeacherInfo where TeachNum='171123' and TeachPws='666666'
SELECT MAX(AttdenceNum)+1 num FROM TeaAttdenceAdmin
查
select * from TeaAttdenceAdmin where TeachNum='171123' and AttdenceNum>0 

select * from TeaAttdenceAdmin where TeachNum='171123' and AttdenceNum>0 order by AttdenceNum desc

select * from TeaAttdenceAdmin where TeachNum='171123' and AttOpen<>2

select AttOpen from TeaAttdenceAdmin where AttdenceNum=1008

select * from TeaAttdenceInfo where AttdenceNum=1019


查
select * from tb_TaskInfo where TeachNum='171123' and TaskNum>0  order by TaskNum desc
select * from tb_TaskInfo where TeachNum=171123 and TaskNum>0

select * from tb_AnnounInfo where AnnType='公告' and TeachNum='171123' and AnnNum>0

select b.ActNum,a.ClassName,b.CourNum from tb_YTeachClass a,( select ActNum,GroupNum,CourNum  from tb_YTeachActivity where TeachNum='171123'  )b 
where a.GroupNum=b.GroupNum and b.ActNum>0;

select a.Treeid,a.CourNum,b.CourName  from tb_TreeInfo a,tb_YcourseInfo b where a.courNum=b.courNum and TeachNum='171123' 
and a.depth=0 and a.TreeName='公告区' and Treeid>0

select b.Treeid,a.TreeName,a.CourNum  from tb_TreeInfo a,(select Treeid,TreeName,Parentid from tb_TreeInfo 
where  TeachNum='171123' and Depth=2 and TreeName='任务区') b
where a.Treeid = b.Parentid and b.Treeid>0

select b.Treeid,a.TreeName,a.CourNum  from tb_TreeInfo a,(select Treeid,TreeName,Parentid from tb_TreeInfo 
where CourNum='CK0C05A' and TeachNum='171123' and Depth=2 and TreeName='任务区') b
where a.Treeid = b.Parentid




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


select TeaAttdenceInfo.AttdenceNum,tb_YTeachActivity.ActNum,PlaceName,
CourName,TeachName,AttdenceWeek,StatusTime,StaName,Status,AttdenceClass   
from TeaStatus, tb_YTeachActivity ,TeaAttdenceAdmin,TeaAttdenceInfo,tb_YTeacherInfo,tb_YCourseInfo  
where tb_YTeachActivity.ActNum=TeaAttdenceAdmin.ActNum and TeaAttdenceAdmin.AttOpen =TeaStatus.AttOpen 
and TeaAttdenceAdmin.AttdenceNum=TeaAttdenceInfo.AttdenceNum and tb_YTeacherInfo.TeachNum=TeaAttdenceAdmin.TeachNum  
and tb_YCourseInfo.CourNum=tb_YTeachActivity.CourNum    
and TeaAttdenceInfo.StuNum='0001'  and TeaStatus.StaName<>'未开始考勤' and TeaAttdenceInfo.AttdenceNum>0
order by AttdenceNum asc