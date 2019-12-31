package cleato.assigmnt.api_cleato_assignment.dao;

import cleato.assigmnt.api_cleato_assignment.model.StudentOne;

import java.text.ParseException;
import java.util.List;

public interface StudentCriteriaDao {
    List<StudentOne> getAllStudents(String sort) throws ParseException;
    List<String> getStudentsNames(String sort) throws ParseException;
}
