package Gym;

import java.io.Serializable;
import java.util.Objects;

public abstract class  DefaultMember implements Serializable {
    private String membershipNumber;
    private String name;
    private Date startMembershipDate; // calling the data type from Date class



    public DefaultMember(String membershipNumber, String name, Date startMembershipDate) {
        this.membershipNumber = membershipNumber;
        this.name = name;
        this.startMembershipDate = startMembershipDate;
    }


    public DefaultMember(String membershipNumber, String name) {
        this.membershipNumber = membershipNumber;
        this.name = name;
    }



    // this constructor initialize for Junit test
    public DefaultMember() {

    }


    public String getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartMembershipDate() {
        return startMembershipDate;
    }

    public void setStartMembershipDate(Date startMembershipDate) {
        this.startMembershipDate = startMembershipDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultMember that = (DefaultMember) o;
        return Objects.equals(membershipNumber, that.membershipNumber) &&
                Objects.equals(name, that.name) &&
                Objects.equals(startMembershipDate, that.startMembershipDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(membershipNumber, name, startMembershipDate);
    }

    @Override
    public String toString() {
        return
                "membershipNumber= '" + membershipNumber + '\'' +
                ", name= '" + name + '\'' +
                ", startMembershipDate= " + startMembershipDate+" } " ;
    }


}
