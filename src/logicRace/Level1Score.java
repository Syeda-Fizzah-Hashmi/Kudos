package logicRace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Level1Score {
    private FileWriter output;
    private Scanner input;
    private String HighScore;
    private String readScore;
    File level1 = new File("level1.txt");
    public Level1Score(String time){
            if (level1.exists()){
                try{
                    input = new Scanner(level1);
                    while(input.hasNext()){
                        String Line = input.nextLine();
                        if (Line.compareTo(time) > 0){
                            try {
                                output = new FileWriter("level1.txt");
                                System.out.println("FROM THE FILE: " + Line);
                                System.out.println("FROM THE GAME: " + time);
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
                    level1.createNewFile();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                try {
                    output = new FileWriter("level1.txt");
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
