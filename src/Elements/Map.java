package Elements;
import java.lang.Math;
import java.util.ArrayList;

public class Map {
    String [][] map = new String [10][20];
    static int row = 10;
    static int column = 20;

    int xPrey;
    int yPrey;

    public Map(){
        for (int i=0; i< Map.row; i++){
            for (int j=0; j< Map.column; j++){
                if (i == 0 || j == 0 || i == Map.row -1 || j == Map.column - 1){
                    this.map[i][j] = "*";
                }
                else this.map[i][j] = " ";
            }
        }
    }
    static boolean checkIndex(Snake snake, int row, int column){
        // False: Vị trí này không đụng con rắn và True = !False
        for (int i=0; i< snake.mapOfSnake.size(); i++)
            if ( snake.mapOfSnake.get(i).get(0) == row && snake.mapOfSnake.get(i).get(1) == column){
                return true;
            }
        return false;
    }
    public void drawMap(Snake snake){
        for (int i=0; i< Map.row ; i++){
            for (int j=0; j< Map.column; j++){
                    if ( checkIndex(snake, i, j) || i == 0 || j == 0 || i == Map.row - 1 || j == Map.column -1 || (i == this.xPrey && j == this.yPrey) )
                        this.map[i][j] = "*";
                    else this.map[i][j] = " ";
            }
        }
    }
    public void display(){
        for (int i=0; i < Map.row; i++){
            for (int j=0; j < Map.column; j++){
                System.out.print(this.map[i][j]);
            }
            System.out.println();
        }
    }

    public void spawnPrey(Snake snake){

        do {
            this.xPrey = (int) (Math.random() * (Map.row - 1) + 1);
            this.yPrey = (int) (Math.random() * (Map.column - 1) + 1);
        } while ( checkIndex(snake ,this.xPrey, this.yPrey) || this.xPrey == (Map.row -1) || this.yPrey == (Map.column-1) );

    }



    public boolean checkEat(String move, Snake snake){
        ArrayList <Integer> temp = new ArrayList<>();
        temp.add(this.xPrey);
        temp.add(this.yPrey);
        return snake.indexNextMove(move).equals(temp);
    }
}
