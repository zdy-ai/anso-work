package sms.service;

import sms.model.Student;

import java.util.List;
import java.util.Optional;

/**
 * @Package: sms.service
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/5/12 14:25
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public interface StudentService {
    List<Student> list() throws ServiceException;

    Optional<Student> getStudent(String id) throws ServiceException;

    void addStudent(Student student) throws ServiceException;
    void updateStudent(Student student) throws ServiceException;
    void deleteStudent(Student student) throws ServiceException;

    void add(String id, String name, String group) throws ServiceException;
    void update(String id, String name, String group) throws ServiceException;

}
