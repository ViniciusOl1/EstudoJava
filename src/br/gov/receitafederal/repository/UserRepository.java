package br.gov.receitafederal.repository;

import br.gov.receitafederal.connection.ConnectionFactory;
import br.gov.receitafederal.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static void save(User user){
        String query = "INSERT INTO users (fullname, cpf, email, password) values (?,?,?,?)";
        Connection connection = ConnectionFactory.getConnection();

        try{
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, user.getFullName());
            pst.setString(2, user.getCpf());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPassword());

            int executedSuccessfully = pst.executeUpdate();
            ConnectionFactory.close(connection, pst);

            if(executedSuccessfully > 0){
                System.out.println("Usuário" + user.getFullName() + "criado com sucesso");
                System.out.println(executedSuccessfully);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void update(User user){
        if(user == null || user.getId() == null){
            System.out.println("Usuário não encontrado");
            return;
        }

        String query = "UPDATE users SET fullname=?, cpf=?, email=?, password=? WHERE (id=?)";

        Connection connection = ConnectionFactory.getConnection();

        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, user.getFullName());
            pst.setString(2, user.getCpf());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPassword());

            int executedSuccessfully = pst.executeUpdate();
            ConnectionFactory.close(connection, pst);

            if(executedSuccessfully > 0){
                System.out.println("Usuário" + user.getFullName() + "atualizado com sucesso");
                System.out.println(executedSuccessfully);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void delete(User user){

        if(user == null || user.getId() == null){
            System.out.println("Usuário não encontrado");
            return;
        }
        String query = "DELETE FROM users WHERE (id = ?)";
        Connection connection = ConnectionFactory.getConnection();

        try{
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1,String.valueOf(user.getId()));

            int executeSuccess = pst.executeUpdate();
            ConnectionFactory.close(connection, pst);
            if (executeSuccess > 0){
                System.out.println("Usuário: " + user.getFullName() + "excluído");
                System.out.println(executeSuccess);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
