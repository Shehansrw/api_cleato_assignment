package cleato.assigmnt.api_cleato_assignment.dao.impl;

import cleato.assigmnt.api_cleato_assignment.dao.StudentCriteriaDao;
import cleato.assigmnt.api_cleato_assignment.model.StudentOne;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository("studentCriteriaDao")
public class StudentCriteriaImpl implements StudentCriteriaDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<StudentOne> getAllStudents(String sort) throws ParseException {
        String OrderBy = " ORDER BY create_date " + sort;
        if((sort == null || sort.equals("")) && !(sort.equals("ASC") && sort.equals("DESC"))){
            OrderBy = "";
        }

        List<StudentOne> studentOneList = new ArrayList<StudentOne>();
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery("SELECT Student.* FROM (SELECT id, name, marks, create_date, status FROM students_one UNION ALL SELECT id, name, marks, create_date, status FROM students_two)Student" + OrderBy);

        List<Object[]> rows = query.list();
        for(Object[] row : rows) {
            StudentOne st = new StudentOne();
            st.setId(Integer.parseInt(row[0].toString()));
            st.setName(row[1].toString());
            st.setMarks(Integer.parseInt(row[2].toString()));

            SimpleDateFormat formatter5=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            st.setCreatedDate(formatter5.parse(row[3].toString()));

            st.setStatus(Boolean.parseBoolean(row[4].toString()));

            studentOneList.add(st);
        }
        return studentOneList;
    }

    @Override
    public List<String> getStudentsNames(String sort) throws ParseException {
        String OrderBy = " ORDER BY create_date " + sort;
        if((sort == null || sort.equals("")) && !(sort.equals("ASC") && sort.equals("DESC"))){
            OrderBy = "";
        }

        List<String> studentNameList = new ArrayList<String>();
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery("SELECT Student.* FROM (SELECT id, name, marks, create_date, status FROM students_one UNION ALL SELECT id, name, marks, create_date, status FROM students_two)Student" + OrderBy);

        List<Object[]> rows = query.list();
        for(Object[] row : rows) {
            studentNameList.add(row[1].toString());
        }
        return studentNameList;
    }
}
