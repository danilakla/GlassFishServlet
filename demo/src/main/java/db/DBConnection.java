package db;

import User.Users;
import java.sql.*;
import java.sql.Statement;
import java.util.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection extends Configs {
    private Connection connection;
    private Statement statement;

    public Connection GetConnection() throws SQLException, ClassNotFoundException {

         Class.forName("com.mysql.cj.jdbc.Driver");

            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/lab9?allowPublicKeyRetrieval=true&useSSL=false", "root", "you password");
            System.out.println("Connection successful!");

        return connection;
    }

    public ArrayList<Users> GetAllUsers() throws SQLException {
        String sqlQuery="select * from users;";
        statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sqlQuery);

        ArrayList<Users> users = new ArrayList<Users>();
        while(resultSet.next()){
            String username = resultSet.getString(1);
            String password = resultSet.getString(2);
            String role = resultSet.getString(3);

            Users user = new Users(username,password,role);
            users.add(user);
        }
        return users;
    }

    public boolean AddUser(Users user) throws SQLException {
        try {
            String select="insert users(username,password,role) values('"+user.getUsername() + "','"+ user.getPassword()+ "','user');";
            statement = GetConnection().createStatement();
            statement.executeUpdate(select);
            return true;
        }catch (Exception e){
            return false;

        }
        //проверка на существующее имя пользователя

    }

    public Users GetByUsername(String Username, String Password) throws SQLException {
        try {
            String select = "select * from users where username = '" + Username + "';";
            statement = GetConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            Users user = null;
            if (resultSet != null) {
                while (resultSet.next()) {
                    String username = resultSet.getString(1);
                    String password = resultSet.getString(2);
                    String role = resultSet.getString(3);
                    user = new Users(username, password, role);
                }
            }
            return user;
        }
        catch (Exception e){
            Users user=new Users();
            user.setUsername(e.getMessage());
            return user;
        }

    }
}
