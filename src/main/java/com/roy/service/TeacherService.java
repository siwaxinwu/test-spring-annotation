package com.roy.service;

import com.roy.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * description：
 * author：dingyawu
 * date：created in 23:39 2020/12/4
 * history:
 */
@Service
public class TeacherService {
    @Autowired(required = true)
    @Qualifier("teacherDao")
    private TeacherDao teacherDao2;

    @Override
    public String toString() {
        return teacherDao2.toString();
    }
}
