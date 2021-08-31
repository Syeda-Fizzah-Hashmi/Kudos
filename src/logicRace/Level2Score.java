package logicRace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Level2Score {
    private FileWriter output;
    private Scanner input;
    private String HighScore;
    private String readScore;
    File level2 = new File("level2.txt");
    public Level2Score(String time){
        if (level2.exists()){
            try{
                input = new Scanner(level2);
                while(input.hasNext()){
                    String Line = input.nextLine();
                    if (Line.compareTo(time) > 0){
                        try {
                            output = new FileWriter("level2.txt");
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
                level2.createNewFile();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            try {
                output = new FileWriter("level2.txt");
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
