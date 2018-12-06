package io.pivotal.student.userservice;

import java.time.LocalDate;

//This class instance will be send as a request body from the REST client
public class StudentForm {

    public final String name;
    public final LocalDate dateofBirth;
    public final LocalDate dateOfAdmission;
    public final Long semester;

    public StudentForm(Builder builder){
        this.name = builder.name;
        this.dateOfAdmission = builder.dateOfAdmission;
        this.dateofBirth=builder.dateofBirth;
        this.semester=builder.semester;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String lastName;
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

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
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

        public StudentForm build(){
            return new StudentForm(this);
        }
    }

}
