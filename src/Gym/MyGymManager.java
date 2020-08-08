package Gym;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MyGymManager  implements GymManager,Serializable {


    private ArrayList<DefaultMember> memberArrayList = new ArrayList<DefaultMember>(100);



    @Override
    public ArrayList<DefaultMember> AddMember(DefaultMember member) {
        if (memberArrayList.size()<100) { // checking arraylist size
            memberArrayList.add(member); // add object for arraylist
        }
        System.out.println((100-memberArrayList.size())+" Remaining......");


        return memberArrayList;

    }

    @Override
    public void Delete() {
        System.out.println("Enter Membership ID");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();  // geting membership number

        for (int i = 0; i < memberArrayList.size(); i++) {
            DefaultMember details = memberArrayList.get(i);
            if (details.getMembershipNumber().equals(id)) { // checking membership number equals to element membeship number
                memberArrayList.remove(i);// if its true remove element
                System.out.println(details.getMembershipNumber()+" Removed");
                break;
            }

        }

    }


    @Override
    public void Print() throws InterruptedException {  //print the list
        for (int i = 0; i < memberArrayList.size(); i++) {
            System.out.println(memberArrayList.get(i));
            Thread.sleep(1000);
        }


    }



    @Override
    public void Write() throws IOException {
        // used 2 type of writes
        // first one is write a tostring, it can see when we open the file

         File file=new File("print.txt");
         PrintWriter printWriter=new PrintWriter(new FileOutputStream(file,true));
         for (int j=0;j<memberArrayList.size();j++){
             DefaultMember defaultMember=memberArrayList.get(j);
             printWriter.println(defaultMember.toString());
         }
         printWriter.close();



        // 2nd one implemented for java fx part
        //
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("object.txt"));
        for (int i=0;i<memberArrayList.size();i++){
            DefaultMember get=memberArrayList.get(i);
            objectOutputStream.writeObject(get);
        }
        objectOutputStream.close();


    }


    public void RunMenu() throws Exception {
        while (true) {


            System.out.println("Welcome to My Gym.............");
            System.out.println("Press 1 to add Member ");
            System.out.println("Press 2 to Delete Record ");
            System.out.println("Press 3 to Show records");
            System.out.println("Press 4 to save");
            System.out.println("Press 9 to exit programme");

            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();

            switch (choose){
                case 1:
                    System.out.println("Press 1 to Student Member or Press 2 for Over 60 Member......");
                    int get = scanner.nextInt();

                    switch (get){
                        case 1:

                            try {


                                System.out.println("Enter Membership ID ");
                                String memStudent = scanner.next();
                                System.out.println("Enter Name ");
                                String nameStudent = scanner.next();
                                System.out.println("Enter Date ");
                                System.out.println("Year ");
                                int dateStudentYear = scanner.nextInt();
                                System.out.println("Month ");
                                int dateStudentMonth = scanner.nextInt();
                                System.out.println("Day ");
                                int dateStudentDay = scanner.nextInt();
                                System.out.println("Enter School Name ");
                                String school = scanner.next();
                                System.out.println("Enter Grade ");
                                String grade = scanner.next();

                                Date date = new Date(dateStudentDay, dateStudentMonth, dateStudentYear);

                                StudentMember studentMember = new StudentMember(memStudent, nameStudent, date, school, grade);
                                AddMember(studentMember);
                            }catch (Exception e){
                                System.out.println("Invalid Entering.......");
                            }

                            break;





                        case 2:
                            try {


                                System.out.println("Enter Membership ID ");
                                String memOver = scanner.next();
                                System.out.println("Enter Name ");
                                String nameOver = scanner.next();
                                System.out.println("Enter Date ");
                                System.out.println("Year ");
                                int dateOverYear = scanner.nextInt();
                                System.out.println("Month ");
                                int dateOverMonth = scanner.nextInt();
                                System.out.println("Day ");
                                int dateOverDay = scanner.nextInt();
                                System.out.println("Enter Age ");
                                String age = scanner.next();
                                System.out.println("Enter Address ");
                                String address = scanner.next();

                                Date date1 = new Date(dateOverDay, dateOverMonth, dateOverYear);

                                Over60Member over60Member = new Over60Member(memOver, nameOver, date1, age, address);
                                AddMember(over60Member);
                            }catch (Exception e){
                                System.out.println("Invalid enter..... ");
                            }

                            break;

                        default:
                            System.out.println("Try again....");
                            continue;

                    }
                    break;



                case 2:
                    Delete();
                    break;


                case 3:
                    Print();
                    break;

                case 4:

                    Write();
                    break;

                case 9:
                    System.exit(0);

                default:
                    System.out.println("Try again....");
                    break;

            }
        }
    }
}
