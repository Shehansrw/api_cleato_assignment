package cleato.assigmnt.api_cleato_assignment.service;

import cleato.assigmnt.api_cleato_assignment.model.StudentOne;

import java.text.ParseException;
import java.util.List;

public interface StudentService {
    List<StudentOne> getStudents(String sort) throws ParseException;
    List<String> getStudentsNames(String sort) throws ParseException;
}
