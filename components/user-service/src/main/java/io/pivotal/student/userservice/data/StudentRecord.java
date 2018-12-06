package io.pivotal.student.userservice.data;

import org.springframework.http.ContentDisposition;

import javax.xml.ws.spi.WebServiceFeatureAnnotation;
import java.time.LocalDate;
import java.util.prefs.Preferences;

public class StudentRecord {
    public final Long id;
    public final String name;
    public final LocalDate dateofBirth;
    public final LocalDate dateOfAdmission;
    public final Long semester;

    public StudentRecord(Builder builder){
        this.id  =builder.id;
        this.name = builder.name;
        this.dateOfAdmission = builder.dateOfAdmission;
        this.dateofBirth=builder.dateofBirth;
        this.semester=builder.semester;
    }

    public static Builder studentRecordBuilder(){
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String name;
        private LocalDate dateofBirth;
        private LocalDate dateOfAdmission;
        private Long semester;

        public Builder setId(Long id) {
            this.id = id;
            return  this;
        }

        public Builder setName(String name) {
            this.name = name;
            return  this;
        }
        public Builder setDateofBirth(LocalDate dateofBirth) {
            this.dateofBirth = dateofBirth;
            return  this;
        }

        public Builder setDateOfAdmission(LocalDate dateOfAdmission) {
            this.dateOfAdmission = dateOfAdmission;
            return  this;
        }

        public Builder setSemester(Long semester) {
            this.semester = semester;
            return  this;
        }

        public static Builder newInstance(){
            return new Builder();
        }

        public StudentRecord build(){
            return new StudentRecord(this);
        }
    }

}
