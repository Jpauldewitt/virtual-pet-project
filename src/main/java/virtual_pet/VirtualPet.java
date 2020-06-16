package virtual_pet;

public class VirtualPet {

    private int hanger;
    private int thirst;
    private int potty;
    private int boredom;
    private int tiredness;
    private int remainingLives;

    public VirtualPet() {
        this.hanger = (int) (Math.random() * 70 + 20);
        this.thirst = (int) (Math.random() * 70 + 20);
        this.potty = (int) (Math.random() * 70 + 20);
        this.boredom = (int) (Math.random() * 70 + 20);
        this.tiredness = (int) (Math.random() * 70 + 20);
        this.remainingLives = 3;
    }

    public boolean gameOn() {
        return true;
    }

    public void introArt() {
        System.out.println("                                ");
        System.out.println("     _____                      ");
        System.out.println("   (, /  |                      ");
        System.out.println("     /---|  __   _   _          ");
        System.out.println("  ) /    |_/ (_(_/_(_)          ");
        System.out.println(" (_/          .-/               ");
        System.out.println("             (_/                ");
        System.out.println("                                ");
        System.out.println("   The Virtual Dog              ");
        System.out.println("                                ");
        System.out.println("         __                     ");
        System.out.println("        /  \\                   ");
        System.out.println("       / ..|\\                  ");
        System.out.println("      (_\\  |_)   Beep Bark Boop");
        System.out.println("      /  \\@'                   ");
        System.out.println("     /     \\                   ");
        System.out.println(" _  /  `   |                    ");
        System.out.println("\\\\/  \\  | _\\                ");
        System.out.println(" \\   /_ || \\\\_               ");
        System.out.println("  \\____)|_) \\_)               ");
        System.out.println("                                ");
    }

    public void petStatus() {
        System.out.println("Don't let these stats get to 100!");
        System.out.println();
        System.out.println("Hanger: " + getHanger());
        System.out.println("Thirst: " + getThirst());
        System.out.println("Potty: " + getPotty());
        System.out.println("Bored: " + getBoredom());
        System.out.println("Tiredness: " + getTiredness());
        System.out.println("Remaining Lives: " + getRemainingLives());
        System.out.println();
        System.out.println("What do you want to do: ");
        System.out.println("1. Feed the Argo");
        System.out.println("2. Give Argo drank");
        System.out.println("3. Take Argo outside");
        System.out.println("4. Play game with Argo");
        System.out.println("5. Go night night");
        System.out.println("6. Restart");
        System.out.println("7. Give up");
        System.out.println();
    }

    public boolean alive() {
        if (remainingLives > 0) {
            return true;
        } else {
            return false;
        }
    }
    public void restart() {
        hanger = (int) (Math.random() * 70 + 20);
        thirst = (int) (Math.random() * 70 + 20);
        potty = (int) (Math.random() * 70 + 20);
        boredom = (int) (Math.random() * 70 + 20);
        tiredness = (int) (Math.random() * 70 + 20);
        remainingLives = 3;
        return;
    }


    public int updateLives() {
        if (hanger == 100 || thirst == 100 || potty == 100 || boredom == 100 || tiredness == 100) {
            remainingLives -= 1;
        }
        return remainingLives;
    }

    public void tick() {
        if (hanger < 100)
            hanger += 14;
        if (hanger > 90)
            hanger = 100;
        if (thirst < 100)
            thirst += 8;
        if (thirst > 100)
            thirst = 100;
        if (potty < 100)
            potty += 10;
        if (potty > 100)
            potty = 100;
        if (boredom < 100)
            boredom += 10;
        if (boredom > 100)
            boredom = 100;
        if (tiredness < 100)
            tiredness += 13;
        if (tiredness > 100)
            tiredness = 100;
    }

    public int feedHanger() {
        if (hanger < 43) {
            hanger = 0;
        } else {
            hanger -= 43;
        }
        return hanger;
    }

    public int feedTiredness() {
        if (tiredness < 14) {
            tiredness = 0;
        } else {
            tiredness -= 14;
        }
        return tiredness;
    }

    public int feedPotty() {
        if (potty < 90) {
            potty += 10;
        } else {
            potty = 100;
        }
        return potty;
    }

    public void feedUpdate() {
        feedHanger();
        feedTiredness();
        feedPotty();
    }

    public int drankThirst() {
        if (thirst < 65) {
            thirst = 0;
        } else {
            thirst -= 65;
        }
        return thirst;
    }

    public int drankTiredness() {
        if (tiredness < 10) {
            tiredness = 0;
        } else {
            tiredness -= 10;
        }
        return tiredness;
    }

    public int drankPotty() {
        if (potty < 90) {
            potty += 10;
        } else {
            potty = 100;
        }
        return potty;
    }

    public void drankUpdate(){
        drankThirst();
        drankTiredness();
        drankPotty();
    }

    public int takeoutPotty() {
        if (potty < 90) {
            potty = 0;
        } else {
            potty -= 90;
        }
        return potty;
    }

    public int takeoutThirst() {
        if (thirst < 90) {
            thirst += 10;
        } else {
            thirst = 100;
        }
        return thirst;
    }

    public int takeoutHanger() {
        if (hanger < 85) {
            hanger += 15;
        } else {
            hanger = 100;
        }
        return hanger;
    }

    public void takeoutUpdate(){
        takeoutPotty();
        takeoutThirst();
        takeoutHanger();
    }

    public int gameBoredom() {
        if (boredom < 80) {
            boredom = 0;
        } else {
            boredom -= 80;
        }
        return boredom;
    }

    public int gameTiredness() {
        if (tiredness < 90) {
            tiredness += 10;
        } else {
            tiredness = 100;
        }
        return tiredness;
    }

    public int gameHanger() {
        if (hanger < 90) {
            hanger += 10;
        } else {
            hanger = 100;
        }
        return hanger;
    }

    public void playedGameUpdate(){
        gameBoredom();
        gameTiredness();
        gameHanger();
    }

    public int nightTiredness() {
        if (tiredness <= 100) {
            tiredness = 0;
        }
        return tiredness;
    }

    public int nightHanger() {
        if (hanger < 90) {
            hanger += 10;
        } else {
            hanger = 100;
        }
        return hanger;
    }

    public int nightThirst() {
        if (thirst < 90) {
            thirst += 10;
        } else {
            thirst = 100;
        }
        return thirst;
    }

    public void nightUpdate(){
        nightTiredness();
        nightHanger();
        nightThirst();
    }

    public void gameOverArt(){
        System.out.println("   _____          __  __ ______ ______      ________ _____ ");
        System.out.println("  / ____|   /\\   |  \\/  |  ____/ __ \\ \\    / /  ____|  __ \\");
        System.out.println(" | |  __   /  \\  | \\  / | |__ | |  | \\ \\  / /| |__  | |__) |");
        System.out.println(" | | |_ | / /\\ \\ | |\\/| |  __|| |  | |\\ \\/ / |  __| |  _  / ");
        System.out.println(" | |__| |/ ____ \\| |  | | |___| |__| | \\  /  | |____| | \\ \\ ");
        System.out.println("  \\_____/_/    \\_\\_|  |_|______\\____/   \\/   |______|_|  \\_\\");
        System.out.println("");
    }

    public void gameOverMessage(){
        System.out.println("            Oh no, you have no more lives left!");
        System.out.println("Press enter 6 to restart, or enter 7 to quit");
    }


    public int getHanger() {
        return this.hanger;
    }

    public int getThirst() {
        return this.thirst;
    }

    public int getPotty() {
        return this.potty;
    }

    public int getBoredom() {
        return this.boredom;
    }

    public int getTiredness() {
        return this.tiredness;
    }

    public int getRemainingLives() {
        return this.remainingLives;
    }
}