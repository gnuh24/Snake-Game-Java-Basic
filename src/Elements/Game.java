package Elements;
import Elements.Snake;
import Elements.Map;
public class Game {
    public int score;

    public Game(Map map, Snake snake){
        score = 0;
        System.out.println("Score = " + score);
        map.display();
    }

}
