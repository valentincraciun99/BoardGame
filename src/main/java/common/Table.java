package common;

import services.enums.Turn;

public class Table {

    private static Table instance;

    int matrix[][]= {
            { 0, 0, 0, 0 , 0, 0, 0,0 },
            { 0, 0, 0, 0 , 0, 0, 0,0 },
            { 0, 0, 0, 0 , 0, 0, 0,0 },
            { 0, 0, 0, 0 , 0, 0, 0,0 },
            { 0, 0, 0, 0 , 0, 0, 0,0 },
            { 0, 0, 0, 0 , 0, 0, 0,0 },
            { 0, 0, 0, 0 , 0, 0, 0,0 },
            { 0, 0, 0, 0 , 0, 0, 0,0 }};;

    private  Table(){

        for(int i=1;i<=7;i++)
            for(int j=1;j<=7;j++)
                matrix[i][j]=0;

    }

    public static Table getInstance(){
        if(instance == null){
            instance = new Table();
        }

        return instance;
    }

    public void setPiece(int line, int column, Turn user)
    {
        if(user == Turn.firstUser)
        {
            matrix[line][column]=1;
        }
        else
        {
            matrix[line][column] =2;
        }

    }

    public void deletePiece(int line,int column)
    {
        matrix[line][column]=0;
    }

    public Integer getValueAt(int i,int j){
        return matrix[i][j];
    }



}
