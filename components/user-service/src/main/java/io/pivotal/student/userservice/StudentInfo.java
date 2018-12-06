package io.pivotal.student.userservice;

import java.time.LocalDate;

public class StudentInfo {
    private final Long id;
    private final String name;
    private final LocalDate dateofBirth;
    private final LocalDate dateOfAdmission;
    private final Long semester;

    public StudentInfo(Builder builder){
        this.id  =builder.id;
        this.name = builder.name;
        this.dateOfAdmission = builder.dateOfAdmission;
        this.dateofBirth=builder.dateofBirth;
        this.semester=builder.semester;
    }

    public static Builder studentInfoBuilder(){
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

        public StudentInfo build(){
            return new StudentInfo(this);
        }
    }

}
