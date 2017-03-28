package com.ania.database;

import com.ania.domain.Student;
import com.ania.domain.University;
import org.sqlite.SQLiteConfig;

import java.sql.*;

/**
 * Created by Ania on 2017-03-27.
 */
public class DatabaseDaoImpl implements DatabaseDao{

    private static final String DRV = "org.sqlite.JDBC";
    private static final String DB = "jdbc:sqlite:Dziekanat.db";

    private Connection conn; //obiekt do zarzadzania polaczeniem z db
    private Statement stat; //obiekt wspomagajacy w niektorych zapytaniach sql

    private static DatabaseDaoImpl databaseDao = null;

    private DatabaseDaoImpl()
    {
        try {
            Class.forName(DRV); //ladujemy do naszej aplikacji sterownik JDBC dla sqlite
            //w sqlite mechanizm kluczy obcych jest automatycznie wylaczany
            SQLiteConfig conf = new SQLiteConfig();
            conf.enforceForeignKeys(true);

            conn = DriverManager.getConnection(DB, conf.toProperties());
            stat = conn.createStatement();
            createTables();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTables() throws SQLException
    {
        String sqlStudent = "CREATE TABLE IF NOT EXISTS Student "
                + "( "
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name VARCHAR(50) NOT NULL, "
                + "surname VARCHAR(50) NOT NULL, "
                + "age INTEGER NOT NULL, "
                + "address VARCHAR(50) NOT NULL, "
                + "email VARCHAR(50) NOT NULL "
                + " );";

        String sqlUniversity = "CREATE TABLE IF NOT EXISTS University "
                + "( "
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name VARCHAR(50) NOT NULL, "
                + "city VARCHAR(50) NOT NULL, "
                + "address VARCHAR(50) NOT NULL, "
                + "email VARCHAR(50) NOT NULL, "
                + "telephoneNumber VARCHAR(50) NOT NULL, "
                + "year INTEGER NOT NULL"
                + " );";

        String sqlRegistration = "CREATE TABLE IF NOT EXISTS Registration "
                + "( "
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "idStudent INTEGER NOT NULL, "
                + "idUniversity INTEGER NOT NULL, "
                + "studentFee DOUBLE NOT NULL, "
                + "studentYear INTEGER NOT NULL, "
                + "FOREIGN KEY (idStudent) REFERENCES Student(id) ON DELETE CASCADE ON UPDATE CASCADE, "
                + "FOREIGN KEY (idUniversity) REFERENCES University(id) ON DELETE CASCADE ON UPDATE CASCADE"
                + " );";

        String sqlUser = "CREATE TABLE IF NOT EXISTS User "
                + "("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name VARCHAR(50) NOT NULL, "
                + "surname VARCHAR(50) NOT NULL, "
                + "age INTEGER NOT NULL, "
                + "username VARCHAR(50) NOT NULL, "
                + "password VARCHAR(50) NOT NULL, "
                + "role VARCHAR(50) NOT NULL "
                + ")";

        stat.execute(sqlStudent);
        stat.execute(sqlUniversity);
        stat.execute(sqlRegistration);
        stat.execute(sqlUser);
    }

    public static DatabaseDaoImpl getInstance()
    {
        if (databaseDao == null)
        {
            databaseDao = new DatabaseDaoImpl();
        }
        return databaseDao;
    }

    @Override
    public void insertStudent(Student s) throws SQLException {
        String sqlInsert = "INSERT INTO Student (name, surname, age, address, email) VALUES (?,?,?,?,?);";
        PreparedStatement ps = conn.prepareStatement(sqlInsert);
        ps.setString(1, s.getName());
        ps.setString(2,  s.getSurname());
        ps.setInt(3,  s.getAge());
        ps.setString(4,  s.getAddress());
        ps.setString(5, s.getEmail());
        ps.execute();
    }

    @Override
    public void insertUniversity(University u) throws SQLException {

    }
}
