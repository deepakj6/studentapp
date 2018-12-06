package io.pivotal.student.userservice;

import io.pivotal.student.userservice.data.StudentFields;
import io.pivotal.student.userservice.data.StudentRecord;
import io.pivotal.student.userservice.data.StudentsDataAccess;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;

import java.util.List;

import static io.pivotal.student.userservice.StudentInfo.studentInfoBuilder;
import static io.pivotal.student.userservice.data.StudentFields.studentFieldsBuilder;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/users")
public class StudentController {

    private Long totalSemesters;
    private RestOperations restOperations;
    private StudentsDataAccess db;

    public StudentController(){}

    public StudentController(@Value("${TOTAL_SEMESTERS}") String totalSems, StudentsDataAccess dataAccess, RestOperations restOperations)
    {
        totalSemesters = Long.parseLong(totalSems);
        this.restOperations = restOperations;
        this.db=dataAccess;
    }

    public StudentController(StudentsDataAccess dataAccess, RestOperations restOperations)
    {
        this.restOperations = restOperations;
        this.db=dataAccess;
    }

    @GetMapping("/test")
    public String test(){
        return "Hi there!";
    }

    @PostMapping
    public ResponseEntity<StudentInfo> create(StudentForm form){

        StudentFields fields = formToFields(form);
        StudentRecord record =  db.create(fields);
        ResponseEntity<StudentInfo> studentInfo =
                new ResponseEntity<StudentInfo>(recordToInfo(record),HttpStatus.CREATED);

        return studentInfo;
    }

    @GetMapping
    public List<StudentInfo> list(@RequestParam Long semester){
        return db.findAllBySemester(semester)
                .stream()
                .map(this::recordToInfo)
                .collect(toList());
    }

    private StudentFields formToFields(StudentForm form){
        return  studentFieldsBuilder()
                .setFirstName(form.name)
                .setDateofBirth(form.dateofBirth)
                .setDateOfAdmission(form.dateOfAdmission)
                .setSemester(form.semester)
                .build();
    }

    private StudentInfo recordToInfo(StudentRecord record){
        return studentInfoBuilder()
                .setId(record.id)
                .setName(record.name)
                .setDateofBirth(record.dateofBirth)
                .setDateOfAdmission(record.dateOfAdmission)
                .setSemester(record.semester)
                .build();
    }
}
