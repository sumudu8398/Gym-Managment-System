package Gym;

import java.io.Serializable;
import java.util.Objects;

public class Over60Member extends DefaultMember implements Serializable {
    private String age;
    private String address;

    public Over60Member(String membershipNumber, String name, Date startMembershipDate, String age, String address) {
        super(membershipNumber, name, startMembershipDate);
        this.age = age;
        this.address = address;
    }

    public Over60Member(String membershipNumber, String name,  String age, String address) {
        super(membershipNumber, name);
        this.age = age;
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Over60Member that = (Over60Member) o;
        return Objects.equals(age, that.age) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), age, address);
    }

    @Override
    public String toString() {
        return "Over60Member - "    + super.toString()+
                "age='" + age + '\'' +
                ", address='" + address + '\'' +" } " ;
    }
}
