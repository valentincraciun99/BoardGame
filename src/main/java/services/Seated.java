package services;

import services.enums.Turn;

public class Seated {

    Turn currentUser;
    Integer currentPiece;

    public Seated() {
        currentPiece = 1;
    }

    public Boolean putPiece()
    {
        if(currentPiece<=18)
        {
            currentUser = currentPiece%2!=0?Turn.firstUser:Turn.secondUser;
            //add to matrix

            currentPiece++;
            return true;
        }
        return false;
    }

    public Turn getCurrentUser(){
        return currentUser;
    }

}
