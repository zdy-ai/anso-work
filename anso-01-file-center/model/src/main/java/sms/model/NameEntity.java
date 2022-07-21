package sms.model;

/**
 * @Package: sms.model
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/5/12 11:37
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public abstract class NameEntity extends Entity{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NameEntity(String id, String name) {
        super(id);
        this.name = name;
    }

    public NameEntity() {
    }

    protected String name;

    @Override
    public String toString() {
        return "NameEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
