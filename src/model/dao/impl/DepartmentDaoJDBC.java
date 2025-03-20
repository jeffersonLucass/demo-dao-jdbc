package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;

	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {

		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("INSERT INTO department " + "(Name) " + "VALUES " + "(?)");

			st.setString(1, obj.getName());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Inserido com sucesso! Linhas afetadas: " + rowsAffected);
			} else {
				System.out.println("Nenhuma linha foi afetada!");
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("UPDATE department " + "SET Name = ? " + "WHERE Id = ?");

			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Atualizado com sucesso! Linhas afetadas: " + rowsAffected);
			} else {
				System.out.println("Nenhuma linha foi afetada!");
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e2) {
				System.out.println("Erro ao fechar o PreparedStatement: " + e2.getMessage());
			}
		}

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Department findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			if (rs.next()) {
				Department department = new Department();
				department.setId(rs.getInt("Id"));
				department.setName(rs.getString("Name"));
				
				return department;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
