package org.example.casino_final.game;

public class Player {
    private int coins;
    private int games;

    public Player(int coins) {
        this.coins = coins;
    }

    public boolean pay() {
        if (coins > 0) {
            coins--;
            games++;
            return true;
        }
        return false;
    }

    public void win(int amount) {
        coins += amount;
    }

    public int getCoins() {
        return coins;
    }
}
