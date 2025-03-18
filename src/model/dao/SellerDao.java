package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {

	void insert(Seller obj);// inserir no banco de dados
	void update(Seller obj);// atualizar no banco de dados
	void deleteById(Integer id);// deletar no banco de dados
	Seller findById(Integer id);// buscar no banco de dados
	List<Seller> findAll();// buscar no banco de dados
}
