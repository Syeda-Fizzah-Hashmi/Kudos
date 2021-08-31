package logicRace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Level3Score {

    private FileWriter output;
    private Scanner input;
    private String HighScore;
    private String readScore;
    File level3 = new File("level3.txt");
    public Level3Score(String time){
        if (level3.exists()){
            try{
                input = new Scanner(level3);
                while(input.hasNext()){
                    String Line = input.nextLine();
                    if (Line.compareTo(time) > 0){
                        try {
                            output = new FileWriter("level3.txt");
                            output.write(time);
                            output.close();
                        }
                        catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                }
                input.close();
                HighScore = time;
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }
        else{
            try{
                level3.createNewFile();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            try {
                output = new FileWriter("level3.txt");
                output.write(time);
                output.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            HighScore = time;
        }
    }
}
