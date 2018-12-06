package io.pivotal.student.userservice.data;

import java.time.LocalDate;

public class StudentFields {

    public final String name;
    public final LocalDate dateofBirth;
    public final LocalDate dateOfAdmission;
    public final Long semester;

    public static Builder studentFieldsBuilder(){
        return new Builder();
    }

    public StudentFields(Builder builder){

        this.name = builder.name;
        this.dateOfAdmission = builder.dateOfAdmission;
        this.dateofBirth=builder.dateofBirth;
        this.semester=builder.semester;
    }



    public static class Builder {
        private String name;
        private LocalDate dateofBirth;
        private LocalDate dateOfAdmission;
        private Long semester;


        public Builder setFirstName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDateofBirth(LocalDate dateofBirth) {
            this.dateofBirth = dateofBirth;
            return this;
        }

        public Builder setDateOfAdmission(LocalDate dateOfAdmission) {
            this.dateOfAdmission = dateOfAdmission;
            return this;
        }

        public Builder setSemester(Long semester) {
            this.semester = semester;
            return this;
        }

        public static Builder newInstance() {
            return new StudentFields.Builder();
        }

        public StudentFields build() {
            return new StudentFields(this);
        }
    }
}
