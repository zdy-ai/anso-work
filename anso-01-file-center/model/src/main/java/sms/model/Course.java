package sms.model;

/**
 * @Package: sms.model
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/5/12 11:40
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public class Course extends NameEntity{
    public Course() {
    }

    public Course(String id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
