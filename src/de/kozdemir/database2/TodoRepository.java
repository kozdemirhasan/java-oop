package de.kozdemir.database2;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TodoRepository extends AbstractRepository<Todo> {

	public TodoRepository() throws SQLException {
		super("todos"); 
		createTable();
	}

	@Override
	protected boolean insert(Todo t) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean update(Todo t) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Todo create(ResultSet result) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void createTable() throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
