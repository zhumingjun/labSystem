package com.lab.lsystem.service;

import java.util.List;

import com.lab.lsystem.domain.TeacherPaperDomain;
import com.lab.system.util.PageInfo;

public interface ITeacherPaperService{

		/**
		 * ͨ获取id
		 * @param id
		 * @return
		 * @throws Exception
		 */
		public TeacherPaperDomain doGetById(String id)throws Exception;
		
		/**
		 * 获取用户List
		 * @return
		 * @throws Exception
		 */
		public List<TeacherPaperDomain> doGetFilterList() throws Exception;
		
		
		/**
		 *保存
		 * @param UserDomain
		 * @return
		 * @throws Exception
		 */
		public boolean doSave(TeacherPaperDomain teacherPaper) throws Exception;
		
		/**
		 * 删除
		 * @param id
		 * @return
		 * @throws Exception
		 */
		public boolean doDeleteById(String id) throws Exception;
		
		/**
		 * 删除多个
		 * @param ids
		 * @return
		 * @throws Exception
		 */
		public boolean doDeleteByIds(String[] ids)throws Exception;
		
		
		/**
		 * 分页查询
		 * @return
		 * @throws Exception
		 */
		public List<TeacherPaperDomain> doGetPageList(PageInfo pageInfo)throws Exception;
		/**
		 * 根据论文ID获取教师论文实体
		 * @param pageInfo
		 * @param searchText
		 * @return
		 */

		public List<TeacherPaperDomain> doGetByPaperId(String paperId)throws Exception;
		/**
		 *根据教师Id获取教师的论文
		 * @param pageInfo
		 * @param teacherId
		 * @return
		 * @throws Exception
		 */
		public List<TeacherPaperDomain> doGetPageListByTeacherId(
				PageInfo pageInfo, String teacherId)throws Exception;

}
