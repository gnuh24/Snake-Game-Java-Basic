package Elements;
import java.util.ArrayList;
import  Elements.Map;
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
    public boolean die() {
        boolean flag = false;
        // TH1: Tông vào bản thân
        for (int i=0; i< this.mapOfSnake.size() && !flag; i++)
            for (int j=i+1; j< this.mapOfSnake.size() -1 ; j++)
                if (this.mapOfSnake.get(i).equals(this.mapOfSnake.get(j)))
                    flag = true;



        // TH2: Tông vào tường
        for (int i=0; i< this.mapOfSnake.size() && !flag ; i++)
            if (this.mapOfSnake.get(i).get(0).equals(0) || this.mapOfSnake.get(i).get(0).equals(Map.row -1) || this.mapOfSnake.get(i).get(1).equals(0) || this.mapOfSnake.get(i).get(1).equals(Map.column - 1))
                flag = true;
        return flag;
    }
}
