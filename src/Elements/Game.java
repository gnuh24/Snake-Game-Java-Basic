package Elements;

import java.util.Scanner;
public class Game {
    public int score;
    Snake snake;
    Map map;
    public Game(){
        this.score = 0;
        this.snake = new Snake();
        this.map = new Map();
        this.map.spawnPrey(this.snake);
        this.map.drawMap(this.snake);

        System.out.println("The game is starting ^^");
        System.out.println("Nhấn A S D W để di chuyển");
        System.out.println("Rắn của bạn sẽ bắt đầu từ vị trí ở góc trái trên cùng");


    }
    public void gamePlay(){
        this.score = 0;
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while (flag){
            System.out.println("Score = " + this.score);
            this.map.display();
            String temp = input.nextLine();


            if ( this.map.checkEat(temp, this.snake) ){
                this.snake.eat(this.map.xPrey, this.map.yPrey);
                this.score++;
                this.map.spawnPrey(this.snake);
            }

            else this.snake.move( this.snake.indexNextMove(temp) );

            this.map.drawMap(this.snake);

            if (this.snake.die()){
                flag = false;
                System.out.println("You have died ^^");
                System.out.println("Your score: " + this.score);
            }

        }

    }

}
