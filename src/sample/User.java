package sample;

import java.io.*;

public class User implements Serializable {

    private String userName;
    private int score;

    public User() {
        this(null, 0);
    }

    public User(String userName, int score) {
        setUserName(userName);
        setScore(score);
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
