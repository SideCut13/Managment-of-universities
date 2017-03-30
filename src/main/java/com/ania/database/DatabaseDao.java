package com.ania.database;

import com.ania.domain.Student;
import com.ania.domain.University;
import org.sqlite.ExtendedCommand;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;

/**
 * Created by Ania on 2017-03-27.
 */
public interface DatabaseDao {
    void insertStudent(Student s) throws SQLException;
    void insertUniversity(University u) throws SQLException;

    void updateStudent(Student s) throws SQLException;
    void updateUniversity(University u) throws SQLException;

    void deleteStudent(int id) throws SQLException;
    void deleteUniversity(int id) throws SQLException;

}
