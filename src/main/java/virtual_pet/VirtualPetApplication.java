package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        VirtualPet Argo = new VirtualPet();

        Argo.introArt();
        while (Argo.gameOn()) {
            Argo.petStatus();
            int userChoice = input.nextInt();
            if ((userChoice <= 0 || userChoice > 7) && (Argo.alive())) {
                System.out.println("You entered: " + userChoice + ", which is not a valid option");
                Argo.tick();
                Argo.updateLives();
            } else if (userChoice == 1 && (Argo.alive())) {
                System.out.println("You entered: " + userChoice + ". Feed the Argo.");
                System.out.println("He is not himself when he is hungry, but it seems like he is always hungry!");
                System.out.println();
                Argo.tick();
                Argo.feedUpdate();
                Argo.updateLives();
            } else if (userChoice == 2 && (Argo.alive())) {
                System.out.println("You chose: " + userChoice + ". Give Argo 'Drank'.");
                System.out.println("He loves the virtual water, and drinks in 3's.");
                System.out.println();
                Argo.tick();
                Argo.drankPotty();
                Argo.updateLives();
            } else if (userChoice == 3 && (Argo.alive())) {
                System.out.println("You chose: " + userChoice + ". Take Argo Outside. ");
                System.out.println("Yay, he went potty!.");
                System.out.println();
                Argo.tick();
                Argo.takeoutUpdate();
                Argo.updateLives();
            } else if (userChoice == 4 && (Argo.alive())) {
                System.out.println("You chose: " + userChoice + ". Play game with Argo.");
                System.out.println("...You don't play game with Argo, Argo plays game with you!.");
                System.out.println();
                Argo.tick();
                Argo.playedGameUpdate();
                Argo.updateLives();
            } else if (userChoice == 5 && (Argo.alive())) {
                System.out.println("You chose: " + userChoice + ". Go night night");
                System.out.println("Man, he was out like a light. Like a light.");
                System.out.println();
                Argo.tick();
                Argo.nightUpdate();
            } else if (userChoice == 6) {
                System.out.println("You chose: " + userChoice + ". Restart");
                System.out.println("Just keep trying");
                Argo.restart();
            } else if (userChoice == 7) {
                System.out.println("You chose: " + userChoice + ". Quit");
                Argo.gameOverArt();
                System.out.println("Fine! Quit! Just like that. It's over.");
                System.exit(0);
            } else {
                Argo.gameOverArt();
                Argo.gameOverMessage();
            }
        }
    }
}