package models;

public class TempCard {

    private int id;
    private String Color;
    private String Word;
    private int state;

    public TempCard(int id, int state, String Color, String Word){
        this.id = id;
        this.state = state;
        this.Color = Color;
        this.Word = Word;
    }

    public int getId(){
        return this.id;
    }

    public int getState(){
        return this.state;
    }

    public String getColor(){
        return this.Color;
    }

    public String getWord(){
        return this.Word;
    }
}
