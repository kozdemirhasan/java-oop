package de.kozdemir.database2;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {

	boolean save(T t) throws SQLException;

	boolean delete(T t) throws SQLException;

	boolean delete(int id) throws SQLException;

	List<T> find() throws SQLException;

	T findById(int id) throws SQLException;
}
