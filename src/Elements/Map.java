package Elements;
import Elements.Snake;

public class Map {
    String [][] map = new String [4][8];
    static int row = 4;
    static int column = 8;

    public Map(){
        for (int i=0; i< Map.row; i++){
            for (int j=0; j< Map.column; j++){
                if (i == 0 || j == 0 || i == 3 || j == 7){
                    this.map[i][j] = "*";
                }
                else this.map[i][j] = " ";
            }
        }
    }
    static boolean checkIndex(Snake snake, int row, int column){
        boolean flag = false;
        for (int i=0; i< snake.mapOfSnake.size() && flag; i++)
            if (snake.mapOfSnake.get(i).get(0).equals(row) && snake.mapOfSnake.get(i).get(0).equals(column))
                flag = true;

        return flag;
    }
    public void drawMap(Snake snake){
        for (int i=0; i< Map.row ; i++){
            for (int j=0; j< Map.column; j++){
                    if (checkIndex(snake, i, j) || i == 0 || j == 0 || i == Map.row - 1 || j == Map.column -1)
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

    public void move(String step){

    }

}
