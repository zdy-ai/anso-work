package sms.filestore;

import sms.model.Entity;
import sms.persistence.PerException;
import sms.persistence.PerService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Package: sms.persistence
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/5/12 14:06
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public class PerServiceImpl implements PerService {
//    private final Path dataPath = Paths.get(".", "data");
    private final Path dataPath = Paths.get("E://", "data");

    @Override
    public <T extends Entity> List<T> list(Class<T> type) throws PerException {
        List<T> results = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(getEntitiesPath(type),"*.bin")){
            for (Path path :directoryStream){
                results.add(readEntity(path));
            }
        } catch (IOException | ClassNotFoundException e) {
           throw new PerException(e);
        }
        return null;
    }

    @Override
    public <T extends Entity> Optional<T> get(Class<T> type, String id) throws PerException {
        return Optional.empty();
    }

    @Override
    public void save(Entity entity) throws PerException {
        try {
            saveEntity(entity);
        } catch (IOException e) {
            throw new PerException(e);
        }
    }

    @Override
    public void update(Entity entity) throws PerException {
        try {
            saveEntity(entity);
        } catch (IOException e) {
            throw new PerException(e);
        }
    }

    @Override
    public <T extends Entity> void delete(Class<T> type, String id) throws PerException {

    }

    private Path getEntitiesPath(Class<?> type) {
        return dataPath.resolve(type.getSimpleName());
    }

    private Path getEntityPath(Class<?> type, String id) {
        return getEntitiesPath(type).resolve(String.format("%s.txt", id));
    }

    private <T extends Entity> T readEntity(Path path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
            return (T) objectInputStream.readObject();
        }
    }

    private void saveEntity(Entity entity) throws IOException {
        Path path = getEntityPath(entity.getClass(), entity.getId());
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            objectOutputStream.writeObject(entity.toString());
        }
    }

    private void deleteEntity(Class<?> type, String id) throws IOException {
        Files.deleteIfExists(getEntityPath(type, id));
    }
}
