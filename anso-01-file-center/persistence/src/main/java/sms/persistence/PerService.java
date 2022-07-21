package sms.persistence;

import sms.model.Entity;

import java.util.List;
import java.util.Optional;

/**
 * @Package: PACKAGE_NAME
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/5/12 11:55
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public interface PerService {
    <T extends Entity> List<T> list(Class<T> type) throws PerException;

    <T extends Entity>Optional<T> get(Class<T> type, String id) throws PerException;

    void save(Entity entity) throws PerException;
    void update(Entity entity) throws PerException;

    <T extends Entity> void delete(Class<T> type, String id) throws PerException;
}
