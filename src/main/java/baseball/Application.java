package baseball;

import baseball.controller.Game;
import baseball.question.Question;

public class Application {
    public static void main(String[] args) {
        Game game;
        do {
            game = new Game(new Question().judgeNumbers);
            game.start();
        } while (game.needContinue());
    }
}
