package io.pivotal.student.userservice.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

@Component
@Repository
public class StudentsDataAccess {

    private JdbcTemplate jdbcTemplate;

    public StudentsDataAccess(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcTemplate = jdbcTemplate;
    }

    public StudentRecord create(StudentFields fields){
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection ->{
            PreparedStatement ps = connection.prepareStatement(
                    "insert into students (student_name, date_of_birth, date_of_admission, semester)" +
                            " values(?,?,?,?)", RETURN_GENERATED_KEYS);
            ps.setString(1,fields.name);
            ps.setDate(2, Date.valueOf(fields.dateofBirth));
            ps.setDate(3, Date.valueOf(fields.dateOfAdmission));
            ps.setLong(4, fields.semester);
            return ps;
        },keyHolder);

        return find(keyHolder.getKey().longValue());
    }

    public List<StudentRecord> findAllBySemester(Long semester) {
        return jdbcTemplate.query(
                "select id, student_name, date_of_birth, date_of_admission, semester from students where semester = ? order by date_of_admission",
                mapper, semester);
    }

    private StudentRecord find(long id) {
        return  jdbcTemplate.queryForObject(
                "select id, student_name, date_of_birth, date_of_admission, semester from students where id = ?)",
                mapper,id);
    }

    private RowMapper<StudentRecord> mapper =
            (rs, rowNum) -> StudentRecord.studentRecordBuilder()
            .setId(rs.getLong("id"))
            .setName(rs.getString("name"))
            .setDateofBirth(rs.getDate("dateOfBirth").toLocalDate())
            .setDateOfAdmission(rs.getDate("dateOfAdmission").toLocalDate())
             .build();


}
