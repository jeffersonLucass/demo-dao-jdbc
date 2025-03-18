package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	void insert(Department obj);// inserir no banco de dados
	void update(Department obj);// atualizar no banco de dados
	void deleteById(Integer id);// deletar no banco de dados
	Department findById(Integer id);// buscar no banco de dados
	List<Department> findAll();// buscar no banco de dados
	
}
