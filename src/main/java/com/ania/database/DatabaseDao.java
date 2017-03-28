package com.ania.database;

import com.ania.domain.Student;
import com.ania.domain.University;

import java.sql.SQLException;

/**
 * Created by Ania on 2017-03-27.
 */
public interface DatabaseDao {
    void insertStudent(Student s) throws SQLException;
    void insertUniversity(University u) throws SQLException;
}
