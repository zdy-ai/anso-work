package sms.model;

/**
 * @Package: sms.model
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/5/12 11:36
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public abstract class Entity {
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Entity(String id) {
        this.id = id;
    }

    public Entity() {
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id='" + id + '\'' +
                '}';
    }
}
