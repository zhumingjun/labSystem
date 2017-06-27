package com.lab.lsystem.service.bean;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.lab.lsystem.dao.ITeacherDao;
import com.lab.lsystem.domain.TeacherDomain;
import com.lab.lsystem.service.ITeacherService;
import com.lab.system.util.PageInfo;
import com.lab.system.util.ValidateUtil;

@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
public class TeacherService implements ITeacherService{

	@Resource private ITeacherDao teacherDao;
	
	/**
	 * @see ITeacherService#doGetFilterList()
	 */
	@Override
	public List<TeacherDomain> doGetFilterList() throws Exception {
		// TODO Auto-generated method stub
		
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(TeacherDomain.class);
		List<TeacherDomain> TeacherList=teacherDao.getFilterList(detachedCriteria);
		
		return TeacherList;
	}

	/**
	 * @see ITeacherService#doSave(TeacherDomain)
	 */
	@Override
	public boolean doSave(TeacherDomain Teacher) throws Exception {
		// TODO Auto-generated method stub

		if(Teacher.getId()==null){
			return teacherDao.save(Teacher);
		}else{
			return teacherDao.update(Teacher);
		}
	}

	/**
	 * @see ITeacherService#doGetById(String)
	 */
	@Override
	public TeacherDomain doGetById(String id) throws Exception {
		// TODO Auto-generated method stub
		
		return teacherDao.getById(id);
	}

	/**
	 * @see ITeacherService#doDeleteById(String)
	 */
	@Override
	public boolean doDeleteById(String id) throws Exception {
		// TODO Auto-generated method stub
		
		return teacherDao.deleteById(id);
	}

	
	

	/**
	 * @see ITeacherService#doDeleteByIds(String[])
	 */
	@Override
	public boolean doDeleteByIds(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		
		boolean b=false;
		for(String id:ids){
			b=teacherDao.deleteById(id);
			if(!b){
				return false;
			}
		}
		
		return b;
	}
	/**
	 * @see ITeacherService#doGetPageList(DetachedCriteria, PageInfo)
	 */
	@Override
	public List<TeacherDomain> doGetPageList(PageInfo pageInfo)
			throws Exception {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(TeacherDomain.class);
		List<TeacherDomain> TeacherList=teacherDao.getPageList(detachedCriteria, pageInfo);
		
		return TeacherList;
	}
	/**
	 * @see ITeacherService#doSearchteacherPageList(PageInfo pageInfo,String searchText);
	 */
	@Override
	public List<TeacherDomain> doSearchteacherPageList(PageInfo pageInfo,
			String searchText) throws Exception {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(TeacherDomain.class);
		if(ValidateUtil.notEmpty(searchText)){
			//多条件过滤，此处名字，宿舍，籍贯
			Disjunction disjunction = Restrictions.disjunction();  
			disjunction.add(Restrictions.like("name", searchText,MatchMode.ANYWHERE).ignoreCase());  	              
			detachedCriteria.add(disjunction);  
		}
		
		return teacherDao.getPageList(detachedCriteria, pageInfo);
	}
}
