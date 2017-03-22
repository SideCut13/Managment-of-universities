package com.ania.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteConfig;

import com.ania.domain.Registration;
import com.ania.domain.Student;
import com.ania.domain.StudentUniversity;
import com.ania.domain.University;
import com.ania.domain.User;

public class Database {
    private static final String DRV = "org.sqlite.JDBC";
    private static final String DB = "jdbc:sqlite:Dziekanat.db";

    private static Connection conn; //obiekt do zarzadzania polaczeniem z db
    private static Statement stat; //obiekt wspomagajacy w niektorych zapytaniach sql


    //zeby klasa byla statyczna musze zrobic jej prywatny konstruktor bezargumentowy
    private Database(){}

    public static void connect() throws ClassNotFoundException, SQLException
    {
        Class.forName(DRV); //ladujemy do naszej aplikacji sterownik JDBC dla sqlite

        //w sqlite mechanizm kluczy obcych jest automatycznie wylaczany
        SQLiteConfig conf = new SQLiteConfig();
        conf.enforceForeignKeys(true);

        conn = DriverManager.getConnection(DB, conf.toProperties());
        stat = conn.createStatement();
    }

    public static void createTables() throws SQLException
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

    public static void insertStudent(Student s) throws SQLException
    {
        String sqlInsert = "INSERT INTO Student (name, surname, age, address, email) VALUES (?,?,?,?,?);";
        PreparedStatement ps = conn.prepareStatement(sqlInsert);
        ps.setString(1, s.getName());
        ps.setString(2,  s.getSurname());
        ps.setInt(3,  s.getAge());
        ps.setString(4,  s.getAddress());
        ps.setString(5, s.getEmail());
        ps.execute();
    }
    public static void insertUniversity(University u) throws SQLException{
        String sqlInsert2 = "INSERT INTO University (name, city, address, email, telephoneNumber, year) VALUES (?,?,?,?,?,?);";
        PreparedStatement ps2 = conn.prepareStatement(sqlInsert2);
        ps2.setString(1, u.getName());
        ps2.setString(2, u.getCity());
        ps2.setString(3, u.getAddress());
        ps2.setString(4, u.getEmail());
        ps2.setString(5, u.getTelephoneNumber());
        ps2.setInt(6, u.getYear());
        ps2.execute();
    }
    public static void insertWpis(Registration r) throws SQLException{
        String sqlInsert = "INSERT INTO Registration (idStudent, idUniversity, studentFee, studentYear) VALUES (?,?,?,?);";
        PreparedStatement ps2 = conn.prepareStatement(sqlInsert);
        ps2.setInt(1, r.getIdStudent());
        ps2.setInt(2, r.getIdUniversity());
        ps2.setDouble(3, r.getStudentFee());
        ps2.setInt(4, r.getStudentYear());
        ps2.execute();
    }

    public static void insertUser(User u) throws SQLException{
        String sqlInsert = "INSERT INTO User (id, name, surname, age, username, password, role VALUES(?,?,?,?,?,?,?);";
        PreparedStatement ps = conn.prepareStatement(sqlInsert);
        ps.setInt(1, u.getId());
        ps.setString(2, u.getName());
        ps.setString(3, u.getSurname());
        ps.setInt(4, u.getAge());
        ps.setString(5, u.getUsername());
        ps.setString(6, u.getPassword());
        ps.setString(7, u.getRole());
        ps.execute();
    }


    //update
    //select User ale tylko po username - ma zwracac true jezeli juz taki user istnieje - po to zeby nie bylo takich samych
    //userow
    //select User ale tylko po username i password - zwraca User kiedy istnieje user o takim hasle i loginie
    //lub null
    //delete
    public static void updateStudent(Student s) throws SQLException
    {
        String sqlUpdate = "UPDATE Student SET name = ?, surname = ?, age = ?, address = ?, email = ? WHERE id = ?;";
        PreparedStatement ps = conn.prepareStatement(sqlUpdate);
        ps.setString(1, s.getName());
        ps.setString(2,  s.getSurname());
        ps.setInt(3,  s.getAge());
        ps.setString(4,  s.getAddress());
        ps.setString(5, s.getEmail());
        ps.setInt(6, s.getId());
        ps.execute();
    }
    public static void updateUniversity(University u) throws SQLException
    {
        String sqlUpdate = "UPDATE University SET name = ?, city = ?, address = ?, email = ?, telephoneNumber = ?, year = ? WHERE id = ?;";
        PreparedStatement ps = conn.prepareStatement(sqlUpdate);
        ps.setString(1, u.getName());
        ps.setString(2,  u.getCity());
        ps.setString(3,  u.getAddress());
        ps.setString(4, u.getEmail());
        ps.setString(5, u.getTelephoneNumber());
        ps.setInt(6, u.getYear());
        ps.setInt(7, u.getId());
        ps.execute();
    }
    public static void updateUser(User u) throws SQLException{
        String sqlUpdate = "UPDATE User SET name = ?, surname = ?, age = ?, username = ?, password = ?, role = ? WHARE id = ?;";
        PreparedStatement ps = conn.prepareStatement(sqlUpdate);
        ps.setString(1, u.getName());
        ps.setString(2, u.getSurname());
        ps.setInt(3, u.getAge());
        ps.setString(4, u.getUsername());
        ps.setString(5, u.getPassword());
        ps.setString(6, u.getRole());
        ps.setInt(7, u.getId());
        ps.execute();

    }
    public static void deleteStudent(int id) throws SQLException
    {
        String sqlDelete = "DELETE FROM Student WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sqlDelete);
        ps.setInt(1, id);
        ps.execute();
    }
    public static void deleteUniversity(int id) throws SQLException
    {
        String sqlDelete = "DELETE FROM University WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sqlDelete);
        ps.setInt(1, id);
        ps.execute();
    }
    public static List<Student> selectStudents() throws SQLException
    {
        String sqlSelect = "SELECT * FROM Student";
        List<Student> students = new ArrayList<Student>();

        ResultSet rs = stat.executeQuery(sqlSelect);

        int id, age;
        String name, surname, address, email;

        while(rs.next()) //zarowno sprawdza czy jest kolejny wiersz jak i go pobiera
        {
            id = rs.getInt(1);
            name = rs.getString(2);
            surname = rs.getString(3);
            age = rs.getInt(4);
            address = rs.getString(5);
            email = rs.getString(6);
            students.add(new Student(id, name, surname, age, address, email));
        }
        return students;
    }

    public static Student selectStudentById(int idS) throws SQLException
    {
        String sqlStudent = "SELECT * FROM Student WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sqlStudent);
        ps.setInt(1, idS);
        ResultSet rs = ps.executeQuery();


        int id, age;
        String name, surname, address, email;

        if(rs.next()) //zarowno sprawdza czy jest kolejny wiersz jak i go pobiera
        {
            id = rs.getInt(1);
            name = rs.getString(2);
            surname = rs.getString(3);
            age = rs.getInt(4);
            address = rs.getString(5);
            email = rs.getString(6);
            return new Student(id, name, surname, age, address, email);
        }
        return null;

    }

    public static List<Integer> selectStudentsIds() throws SQLException
    {
        String sqlSelect = "SELECT id FROM Student";
        List<Integer> studentsIds = new ArrayList<Integer>();

        ResultSet rs = stat.executeQuery(sqlSelect);

        int id;

        while(rs.next()) //zarowno sprawdza czy jest kolejny wiersz jak i go pobiera
        {
            id = rs.getInt(1);
            studentsIds.add(id);
        }
        return studentsIds;
    }

    public static List<University> selectUniversity() throws SQLException
    {
        String sqlSelect = "SELECT * FROM University";
        List<University> universities = new ArrayList<University>();

        ResultSet rs = stat.executeQuery(sqlSelect);

        int id, year;
        String name, city, address, email, telephoneNumber;

        while(rs.next()) //zarowno sprawdza czy jest kolejny wiersz jak i go pobiera
        {
            id = rs.getInt(1);
            name = rs.getString(2);
            city = rs.getString(3);
            address = rs.getString(4);
            email = rs.getString(5);
            telephoneNumber = rs.getString(6);
            year = rs.getInt(7);
            universities.add(new University(id, name, city, address, email, telephoneNumber, year));
        }
        return universities;
    }

    public static List<Integer> selectUniversityIds() throws SQLException
    {
        String sqlSelect = "SELECT id FROM University";
        List<Integer> universityIds = new ArrayList<Integer>();

        ResultSet rs = stat.executeQuery(sqlSelect);

        int id;

        while(rs.next()) //zarowno sprawdza czy jest kolejny wiersz jak i go pobiera
        {
            id = rs.getInt(1);
            universityIds.add(id);
        }
        return universityIds;
    }
    public static University selectUniversityById(int idS) throws SQLException
    {
        String sqlUniversity = "SELECT * FROM University WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sqlUniversity);
        ps.setInt(1, idS);
        ResultSet rs = ps.executeQuery();


        int id, year;
        String name, city, address, email, telephoneNumber;

        if(rs.next()) //zarowno sprawdza czy jest kolejny wiersz jak i go pobiera
        {
            id = rs.getInt(1);
            name = rs.getString(2);
            city = rs.getString(3);
            address = rs.getString(4);
            email = rs.getString(5);
            telephoneNumber = rs.getString(6);
            year = rs.getInt(7);
            return new University(id, name, city, address, email, telephoneNumber, year);
        }
        return null;

    }

    public static List<StudentUniversity> selectInnerJoin() throws SQLException
    {
        String sqlInnerJoin = "SELECT R.id, S.name, S.surname, S.age, S.address, S.email, U.name, "
                + "U.city, U.address, U.email, U.telephoneNumber, U.year, R.studentFee, R.studentYear "
                + "FROM Student S INNER JOIN Registration R ON S.id = R.idStudent INNER JOIN University U ON R.idUniversity = U.id;";
        List<StudentUniversity> studentUniversities = new ArrayList<>();

        ResultSet rs = stat.executeQuery(sqlInnerJoin);

        int id, age, year, studentYear;
        double studentFee;
        String studentName, surname, studentAddress, studentEmail, universityName, city, universityAddress, universityEmail, telephoneNumber;

        while(rs.next())
        {
            id = rs.getInt(1);
            studentName = rs.getString(2);
            surname = rs.getString(3);
            age = rs.getInt(4);
            studentAddress = rs.getString(5);
            studentEmail = rs.getString(6);
            universityName = rs.getString(7);
            city = rs.getString(8);
            universityAddress = rs.getString(9);
            universityEmail = rs.getString(10);
            telephoneNumber = rs.getString(11);
            year = rs.getInt(12);
            studentFee = rs.getDouble(13);
            studentYear = rs.getInt(14);
            studentUniversities.add(new StudentUniversity(id, studentName, surname, age, studentAddress, studentEmail, universityName, city, universityAddress, universityEmail, telephoneNumber, year, studentFee, studentYear));
        }

        return studentUniversities;
    }

    public static List<String> selectInnerJoinStudentNames() throws SQLException
    {
        String sqlInnerJoin = "SELECT DISTINCT S.name "
                + "FROM Student S INNER JOIN Registration R ON S.id = R.idStudent INNER JOIN University U ON R.idUniversity = U.id;";
        List<String> studentNames = new ArrayList<>();

        ResultSet rs = stat.executeQuery(sqlInnerJoin);

        while(rs.next())
        {
            studentNames.add(rs.getString(1));
        }

        return studentNames;
    }
    public static List<String> selectInnerJoinStudentSurnames() throws SQLException
    {
        String sqlInnerJoin = "SELECT DISTINCT S.surname "
                + "FROM Student S INNER JOIN Registration R ON S.id = R.idStudent INNER JOIN University U ON R.idUniversity = U.id;";
        List<String> studentSurnames = new ArrayList<>();

        ResultSet rs = stat.executeQuery(sqlInnerJoin);

        while(rs.next())
        {
            studentSurnames.add(rs.getString(1));
        }

        return studentSurnames;
    }
    public static List<Integer> selectInnerJoinStudentAges() throws SQLException
    {
        String sqlInnerJoin = "SELECT DISTINCT S.age "
                + "FROM Student S INNER JOIN Registration R ON S.id = R.idStudent INNER JOIN University U ON R.idUniversity = U.id;";
        List<Integer> studentAges = new ArrayList<>();

        ResultSet rs = stat.executeQuery(sqlInnerJoin);

        while(rs.next())
        {
            studentAges.add(rs.getInt(1));
        }

        return studentAges;
    }
    public static List<String> selectInnerJoinUniversityCity() throws SQLException
    {
        String sqlInnerJoin = "SELECT DISTINCT U.city "
                + "FROM Student S INNER JOIN Registration R ON S.id = R.idStudent INNER JOIN University U ON R.idUniversity = U.id;";
        List<String> universityCity = new ArrayList<>();

        ResultSet rs = stat.executeQuery(sqlInnerJoin);

        while(rs.next())
        {
            universityCity.add(rs.getString(1));
        }

        return universityCity;
    }
    public static void deleteStudentUniversity(int id) throws SQLException
    {
        String sqlDelete = "DELETE FROM Registration WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sqlDelete);
        ps.setInt(1, id);
        ps.execute();
    }

    public static List<StudentUniversity> filterInnerJoin(boolean isName, boolean isSurname, boolean isCity, boolean isAge, boolean isYear,
                                                          List<String> names, List<String> surnames, List<String> cities, int ageFrom, int ageTo, int yearFrom, int yearTo
    ) throws SQLException
    {
        String sqlInnerJoin = "SELECT R.id, S.name, S.surname, S.age, S.address, S.email, U.name, "
                + "U.city, U.address, U.email, U.telephoneNumber, U.year, R.studentFee, R.studentYear "
                + "FROM Student S INNER JOIN Registration R ON S.id = R.idStudent INNER JOIN University U ON R.idUniversity = U.id "
                + "WHERE 1 = 1 ";

        if (isName)
        {
            sqlInnerJoin += " AND S.name IN ('" + String.join("','", names) +"') ";
        }

        if (isSurname)
        {
            sqlInnerJoin += " AND S.surname IN ('" + String.join("','", surnames) +"') ";
        }

        if (isCity)
        {
            sqlInnerJoin += " AND U.city IN ('" + String.join("','", cities) +"') ";
        }

        if (isAge)
        {
            sqlInnerJoin += " AND S.age BETWEEN " + ageFrom + " AND " + ageTo + " ";
        }

        if (isYear)
        {
            sqlInnerJoin += " AND R.studentYear BETWEEN " + yearFrom + " AND " + yearTo + " ";
        }

        sqlInnerJoin += ";";
        List<StudentUniversity> studentUniversities = new ArrayList<>();

        ResultSet rs = stat.executeQuery(sqlInnerJoin);

        int id, age, year, studentYear;
        double studentFee;
        String studentName, surname, studentAddress, studentEmail, universityName, city, universityAddress, universityEmail, telephoneNumber;

        while(rs.next())
        {
            id = rs.getInt(1);
            studentName = rs.getString(2);
            surname = rs.getString(3);
            age = rs.getInt(4);
            studentAddress = rs.getString(5);
            studentEmail = rs.getString(6);
            universityName = rs.getString(7);
            city = rs.getString(8);
            universityAddress = rs.getString(9);
            universityEmail = rs.getString(10);
            telephoneNumber = rs.getString(11);
            year = rs.getInt(12);
            studentFee = rs.getDouble(13);
            studentYear = rs.getInt(14);
            studentUniversities.add(new StudentUniversity(id, studentName, surname, age, studentAddress, studentEmail, universityName, city, universityAddress, universityEmail, telephoneNumber, year, studentFee, studentYear));
        }

        return studentUniversities;
    }
}
