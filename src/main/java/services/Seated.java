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
        if(currentPiece<=18 && Table.getInstance().getValueAt(coordinates.getX(),coordinates.getY())==0)
        {
            currentUser = currentPiece%2!=0?Turn.firstUser:Turn.secondUser;
            Table.getInstance().setPiece(coordinates.getX(),coordinates.getY(),currentUser);
            currentPiece++;
            return true;
        }
        return false;
    }

    public Boolean movePiece(Coordinates from,Coordinates to)
    {
        Integer currentUserValue = Table.getInstance().getValueAt(from.getX(),from.getY());

        if(Table.getInstance().getValueAt(to.getX(),to.getY())==0  && Table.getInstance().getValueAt(from.getX(),from.getY())!=0) {

            Table.getInstance().deletePiece(from.getX(), from.getY());

            if (currentUserValue == 1) {
                Table.getInstance().setPiece(to.getX(), to.getY(), Turn.firstUser);
                currentUser = Turn.firstUser;
            } else if (currentUserValue == 2) {
                Table.getInstance().setPiece(to.getX(), to.getY(), Turn.secondUser);
                currentUser = Turn.secondUser;
            }
            return true;
        }
        return  false;
    }

    public Turn getCurrentUser(){
        return currentUser;
    }

}
