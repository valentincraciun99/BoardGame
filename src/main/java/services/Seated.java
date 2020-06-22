package services;

import common.Table;
import model.Coordinates;
import services.enums.Turn;

public class Seated {

    Turn currentUser;
    Integer currentPiece;

    public Seated() {
        currentPiece = 1;
    }

    public Boolean putPiece(Coordinates coordinates)
    {
        if(currentPiece<=18)
        {
            currentUser = currentPiece%2!=0?Turn.firstUser:Turn.secondUser;
            Table.getInstance().setPiece(coordinates.getX(),coordinates.getY(),currentUser);
            currentPiece++;
            return true;
        }
        return false;
    }

    public Turn getCurrentUser(){
        return currentUser;
    }

}
