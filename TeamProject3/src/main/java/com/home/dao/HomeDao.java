package com.home.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.home.domain.ClassCommand;
import com.home.domain.Class_tagCommand;
import com.home.domain.CommCommand;
import com.home.domain.TeacherCommand;

@Repository
public interface HomeDao {
    public List<ClassCommand> classList();
    public List<TeacherCommand> teacherList();
    public ClassCommand class_watchInfo(int class_num);
    public TeacherCommand teacher_watchInfo(String mem_id);
    public List<Class_tagCommand> classTagList(int class_num);
    public List<CommCommand> commList(int class_num);

    public void commInsert(CommCommand comand);
}