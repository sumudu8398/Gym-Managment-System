package Gym;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyGymManagerTest extends StudentMember {


    public MyGymManagerTest(){

    }
    MyGymManager myGymManage=new MyGymManager();

    StudentMember studentMember=new StudentMember("101","Vin","Rahula","12");
    Over60Member over60Member=new Over60Member("103","Sam","63","Colombo");


    @Test
    public void getSchoolMembership(){
        assertEquals("101",studentMember.getMembershipNumber());

    }
    @Test
    public void getOverMembership(){

        assertEquals("103",over60Member.getMembershipNumber());
    }

    @Test
     public void getSchoolMembershipName(){
        assertEquals("Vin",studentMember.getName());

    }
    @Test
    public void getOverMembershipName(){
        assertEquals("Sam",over60Member.getName());
    }

    @Test
    public void getSchool(){
        assertEquals("Rahula",studentMember.getSchoolName());

    }
    @Test
    public void getAge(){

        assertEquals("63",over60Member.getAge());
    }

    @Test
    public void getGradeYear(){
        assertEquals("12",studentMember.getGrade());

    }
    @Test
    public void getAddress(){

        assertEquals("Colombo",over60Member.getAddress());
    }




}