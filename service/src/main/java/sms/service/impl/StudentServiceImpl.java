package sms.service.impl;

import sms.model.Student;
import sms.persistence.PerException;
import sms.persistence.PerService;
import sms.service.ServiceException;
import sms.service.StudentService;

import java.util.List;
import java.util.Optional;

/**
 * @Package: sms.service.impl
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/5/12 14:28
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public class StudentServiceImpl implements StudentService {
    private PerService perService = PerServiceLoader.perService;
    @Override
    public List<Student> list() throws ServiceException {
        try {
            return perService.list(Student.class);
        } catch (PerException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Student> getStudent(String id) throws ServiceException {
        try {
            return perService.get(Student.class, id);
        } catch (PerException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addStudent(Student student) throws ServiceException {
        try {
            perService.save(student);
        } catch (PerException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateStudent(Student student) throws ServiceException {
        try {
            perService.save(student);
        } catch (PerException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteStudent(Student student) throws ServiceException {
        try {
            perService.delete(Student.class, student.getId());
        } catch (PerException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void add(String id, String name, String group) throws ServiceException {
        addStudent(new Student(id,name,group));
    }

    @Override
    public void update(String id, String name, String group) throws ServiceException {
        updateStudent(new Student(id,name,group));
    }
}
