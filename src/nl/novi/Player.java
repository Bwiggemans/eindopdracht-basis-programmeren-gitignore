package nl.novi;

public class Player {
    //velden/attributen
    private String name;
    private String token;
    private int score;

    //constructor
    public Player(String name, String token) {
        this.name = name;
        this.token = token;
        this.score = 0;
    }

    //getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}