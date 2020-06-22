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

    public Integer getMaxNumberOfPiecesPerLineOrColumn(Coordinates coordinates,Integer playerValue)
    {
        Integer piecesLine=0;
        Integer piecesColumn=0;
        for(int i=1;i<=7;i++)
        {
            if(Table.getInstance().getValueAt(coordinates.getX(),i)==playerValue)
                piecesLine++;
            else if(Table.getInstance().getValueAt(coordinates.getX(),i)!=0)
                piecesLine--;
            if(Table.getInstance().getValueAt(i,coordinates.getY())==playerValue)
                piecesColumn++;
            else if(Table.getInstance().getValueAt(i,coordinates.getY())!=0)
                piecesColumn--;

        }

        return  Math.max(piecesColumn,piecesLine);
    }

    public Turn getCurrentUser(){
        return currentUser;
    }

    public Integer findWinner() {
        var firstPlayer = 0;
        var secondPlayer= 1;

        for(int i=1;i<=7;i++)
        {
            for(int j=1;j<=7;j++){
                if(Table.getInstance().getValueAt(i,j)==1)
                    firstPlayer++;
                if(Table.getInstance().getValueAt(i,j)==2)
                    secondPlayer++;
            }
        }

        if(firstPlayer<=2)
            return 2;
        if(secondPlayer<=2)
            return 1;

        return 0;

    }
}
