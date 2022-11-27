package gr.ed.TechnikonProject.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    int create(T t);

    Optional<T> read(int id);

    List<T> read();

    boolean delete(int id);
}
