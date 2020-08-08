package Gym;

import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface GymManager {
    public ArrayList<DefaultMember> AddMember(DefaultMember member);
    public void Delete();
    public void Print() throws InterruptedException;
    public void Write() throws IOException;
    public void RunMenu() throws Exception;

}
