package Gym;

import java.io.Serializable;
import java.util.Objects;

public class StudentMember extends DefaultMember implements Serializable {
    private String schoolName;
    private String grade;

    public StudentMember(String membershipNumber, String name, Date startMembershipDate, String schoolName, String grade) {
        super(membershipNumber, name, startMembershipDate);
        this.schoolName = schoolName;
        this.grade = grade;
    }


    public StudentMember(String membershipNumber, String name,  String schoolName, String grade) {
        super(membershipNumber, name);
        this.schoolName = schoolName;
        this.grade = grade;
    }
    public StudentMember(){
        super();

    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentMember that = (StudentMember) o;
        return Objects.equals(schoolName, that.schoolName) &&
                Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), schoolName, grade);
    }

    @Override
    public String toString() {
        return  "Student Member - " + super.toString() +
                "schoolName='" + schoolName + '\'' +
                ", grade='" + grade + '\'' +" } ";
    }
}
