package com.example.demo.service.classSchedule;

import java.util.List;

import com.example.demo.model.ClassSchedule;

public interface ClassScheduleServiceImpl {
    List<ClassSchedule> getAllClassSchedules();

    ClassSchedule getClassScheduleById(Long id);

    void saveClassSchedule(ClassSchedule classSchedule);

    void deleteClassSchedule(Long id);
}
