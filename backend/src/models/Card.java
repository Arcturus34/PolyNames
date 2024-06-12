package models;

public record Card(
    int id,
    int state,
    int idColor,
    int idWord
) {
    public int getIdColor(){
        return idColor;
    }
    public int getIdWord(){
        return idWord;
    }

    public int getId(){
        return id;
    }

    public int getState(){
        return state;
    }
};
