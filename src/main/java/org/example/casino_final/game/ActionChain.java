package org.example.casino_final.game;

import org.example.casino_final.chain.*;

import java.util.Random;

public class ActionChain {

    private final Handler chain;
    private final Random random = new Random();

    public ActionChain() {
        chain = new WinHandler(
                new ChanceHandler(
                        new LossHandler(null)
                )
        );
    }

    public int play() {
        return random.nextInt(3); // 0 - lose, 1 - win, 2 - chance
    }

    public boolean process(int result) {
        return chain.handle(result);
    }
}
