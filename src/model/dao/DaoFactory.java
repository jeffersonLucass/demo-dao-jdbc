package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

// // A classe DaoFactory é responsável por criar instâncias de objetos DAO (Data Access Object).
// Utiliza o padrão de projeto Factory para encapsular a lógica de criação dos DAOs.
// Isso permite que o código que utiliza os DAOs não precise conhecer os detalhes de implementação,
// promovendo a separação de responsabilidades e facilitando a manutenção e evolução do código.

public class DaoFactory {

    // Método que retorna uma instância de SellerDao.
    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

   
}

