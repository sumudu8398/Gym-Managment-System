package GUI;

import Gym.Date;
import Gym.DefaultMember;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Display extends Application {
    ArrayList<DefaultMember> defaultMemberArrayList=new ArrayList<DefaultMember>(); // intializing a arrayList name defaultMemberArrayList
    Stage window;
    TableView<DefaultMember>table;


    public static void main(String[] args) {
        launch(args);



    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setTitle("MyGym Manager");

        //ID column

        TableColumn<DefaultMember,String> idColumn=new TableColumn<>("MembershipNumber");
        idColumn.setMinWidth(200);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("membershipNumber"));

        //Name column

        TableColumn<DefaultMember,String> nameColumn=new TableColumn<>("Name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Date column



        TableColumn<DefaultMember,String> dateColumn=new TableColumn<>("StartMembershipDate");
        dateColumn.setMinWidth(200);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("startMembershipDate"));



        table=new TableView<>();
        table.setItems(getList());
        table.getColumns().addAll(idColumn,nameColumn,dateColumn);





        VBox vBox=new VBox();
        vBox.getChildren().addAll(table);

        Scene scene=new Scene(vBox);

        window.setScene(scene);
        window.show();






    }

    public ObservableList<DefaultMember>getList(){
        //initializing a observablelist
        ObservableList<DefaultMember> defaultMembers=FXCollections.observableArrayList();
        try {

            ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("object.txt"));  // opening object.txt file
            while (true) {//it runs until break
                DefaultMember defaultMember = (DefaultMember) objectInputStream.readObject();//reading object what we wrote on console
                if (defaultMember!=null){
                    defaultMemberArrayList.add(defaultMember);
                }
                else {

                    break;
                }

            }



        } catch (IOException e) {
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();

        }
        for (int i=0;i<defaultMemberArrayList.size();i++){ //go through from defaultmemberArrayList
            DefaultMember defaultMember1=defaultMemberArrayList.get(i); // passing value for defaultmember1
            defaultMembers.add(new DefaultMember(defaultMember1.getMembershipNumber(),defaultMember1.getName(),defaultMember1.getStartMembershipDate()) {
            });// adding values to observable list
        }

        return defaultMembers;






    }

}
