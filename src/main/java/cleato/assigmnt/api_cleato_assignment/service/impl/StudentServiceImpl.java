package cleato.assigmnt.api_cleato_assignment.service.impl;

import cleato.assigmnt.api_cleato_assignment.dao.StudentCriteriaDao;
import cleato.assigmnt.api_cleato_assignment.model.StudentOne;
import cleato.assigmnt.api_cleato_assignment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.List;

@Service(value = "studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentCriteriaDao studentCriteriaDao;

    @Override
    public List<StudentOne> getStudents(String sort) throws ParseException {
        return studentCriteriaDao.getAllStudents(sort);
    }

    @Override
    public List<String> getStudentsNames(String sort) throws ParseException {
        return studentCriteriaDao.getStudentsNames(sort);
    }
}
