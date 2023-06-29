package Elements;
import java.util.ArrayList;
public class Snake {
    public ArrayList < ArrayList <Integer> > mapOfSnake = new ArrayList<>();

    public Snake(){
        ArrayList <Integer> temp = new ArrayList<>();
        temp.add(1); temp.add(1);
        this.mapOfSnake.add(temp);
    }
    public void eat(int row, int column){
        ArrayList <Integer> temp = new ArrayList<>();
        temp.add(row); temp.add(column);
        this.mapOfSnake.add(0, temp);
    }
    public ArrayList <Integer> indexNextMove( String move){
        ArrayList <Integer> temp = new ArrayList<>();
        switch (move){

            case "a":
                temp.add(this.mapOfSnake.get(0).get(0) );
                temp.add(this.mapOfSnake.get(0).get(1)- 1);
                break;
            case "s":
                temp.add(this.mapOfSnake.get(0).get(0) + 1);
                temp.add(this.mapOfSnake.get(0).get(1));
                break;
            case "d":
                temp.add(this.mapOfSnake.get(0).get(0));
                temp.add(this.mapOfSnake.get(0).get(1) + 1);
                break;

            case "w":
                temp.add(this.mapOfSnake.get(0).get(0) - 1);
                temp.add(this.mapOfSnake.get(0).get(1));
                break;
        }
        return temp;
    }

    public void move(ArrayList <Integer> temp){
                this.mapOfSnake.add(0, temp);
                this.mapOfSnake.remove( this.mapOfSnake.size() - 1);
    }
    public boolean die() {
        boolean flag = false;
        // TH1: Tông vào bản thân
        for (int i=0; i< this.mapOfSnake.size() && !flag; i++)
            for (int j=i+1; j< this.mapOfSnake.size() -1 ; j++)
                if (this.mapOfSnake.get(i).equals(this.mapOfSnake.get(j))) {
                    flag = true;
                    break;
                }



        // TH2: Tông vào tường
        for (int i=0; i< this.mapOfSnake.size() && !flag ; i++)
            if (this.mapOfSnake.get(i).get(0).equals(0) || this.mapOfSnake.get(i).get(0).equals(Map.row - 1) || this.mapOfSnake.get(i).get(1).equals(0) || this.mapOfSnake.get(i).get(1).equals(Map.column - 1)) {
                flag = true;
                break;
            }
        return flag;
    }
}
