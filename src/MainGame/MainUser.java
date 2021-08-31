package MainGame;

import java.io.*;

public class MainUser implements Serializable{
    private static MainUser Main_user_instance = null;

    private String userName = null;
    private int BST_score = 0;
    private int Algo_score = 0;
    private int EncDec_score = 0;
    private int SpaceRoute_score = 0;
    private String logicRace_time = "00:00:00";

    public MainUser() {
        this(null);
    }

    public MainUser(String userName) {
        setUserName(userName);
    }

    public static MainUser getInstance()
    {
        if (Main_user_instance == null)
            Main_user_instance = new MainUser();

        return Main_user_instance;
    }

    // setters
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setBST_score(int BST_score) {
        this.BST_score = BST_score;
    }
    public void setAlgo_score(int Algo_score) {
        this.Algo_score = Algo_score;
    }
    public void setEncDec_score(int EncDec_score) {this.EncDec_score = EncDec_score;}
    public void setSpaceRoute_score(int SpaceRoute_score) {this.SpaceRoute_score = SpaceRoute_score;}
    public void setlogicRace_time(String logicRace_time) {
        this.logicRace_time = logicRace_time;
    }

    // getters
    public String getUserName() {
        return userName;
    }
    public int getBST_score() {
        return BST_score;
    }
    public int getAlgo_score() {
        return Algo_score;
    }
    public int getEncDec_score() { return EncDec_score;}
    public int getSpaceRoute_score() { return SpaceRoute_score;}
    public String getlogicRace_time() {
        return logicRace_time;
    }


}
