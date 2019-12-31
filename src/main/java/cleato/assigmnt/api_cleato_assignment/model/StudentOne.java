package cleato.assigmnt.api_cleato_assignment.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "students_one")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class StudentOne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "marks", nullable = false, length = 11)
    private Integer marks;

    @Column(name = "create_date", nullable = false)
    private Date createdDate;

    @Column(name = "status", nullable = false, length = 4, columnDefinition = "boolean default 1")
    private boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
