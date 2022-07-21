package sms.model;

import java.io.Serializable;

/**
 * @Package: sms.model
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/5/12 11:39
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public class Student extends NameEntity implements Serializable {

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Student(String id, String name, String group) {
        super(id, name);
        this.group = group;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    private String group;

}
