package com.home.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.home.domain.ClassCommand;
import com.home.domain.Class_tagCommand;
import com.home.domain.CommCommand;
import com.home.domain.TeacherCommand;

@Service("homeDaoImpl")
public class HomeDaoImpl extends SqlSessionDaoSupport implements HomeDao {

	public List<ClassCommand> classList() {
		List<ClassCommand> list=getSqlSession().selectList("mainClassSelect");
		return list;
	}

	public List<TeacherCommand> teacherList() {
		List<TeacherCommand> list=getSqlSession().selectList("mainTeacherSelect");
		return list;
	}

	public ClassCommand class_watchInfo(int class_num) {
		ClassCommand data=getSqlSession().selectOne("watchClassSelect", class_num);
		return data;
	}

	public TeacherCommand teacher_watchInfo(String mem_id) {
		TeacherCommand data=getSqlSession().selectOne("watchTeacherSelect", mem_id);
		return data;
	}

	public List<Class_tagCommand> classTagList(int class_num) {
		List<Class_tagCommand> list=getSqlSession().selectList("watchTagSelect", class_num);
		return list;
	}

	public List<CommCommand> commList(int class_num) {
		List<CommCommand> list=getSqlSession().selectList("watchCommentSelect", class_num);
		return list;
	}

	public void commInsert(CommCommand comand) {
		getSqlSession().insert("watchCommentInsert", comand);
	}
}
