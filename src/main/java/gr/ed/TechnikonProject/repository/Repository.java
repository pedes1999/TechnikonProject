package gr.ed.TechnikonProject.repository;

import java.util.List;

public interface Repository<T> {
    int create(T t);
    T read(int id);
    List<T> read();
    boolean delete(int id);
}
