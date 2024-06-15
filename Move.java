import java.util.List;
import java.util.Scanner;

public class Move {
    
    public static void main(String[] args) {
        String filePath = "carte.txt";
        Map map = new Map();
        map.createMap(filePath);
        List<String> carte = map.getMap();

        Scanner scanner = new Scanner(System.in);
        
        // Initialisation de la position de l'aventurier
        System.out.println("où voulez-vous placer l'aventurier?");
        System.out.print("x: ");
        int x = scanner.nextInt();
        System.out.print("y : ");
        int y = scanner.nextInt();

        Adventurer  adventurer = new Adventurer(x, y);

        //Afficher la carte avec le personnage à sa position de départ
        map.showMap(adventurer);
        //laissé vide pour que le scanner.nextLine() (celui qui recupère les déplacements) ne récupère pas le retour à la ligne
        scanner.nextLine();

        System.out.println("Donner les déplacements (n/s/e/o) que l'aventurier doit réaliser pour se déplacer :");
        //récupère la chaine de mouvements
        String listMovement = scanner.nextLine().trim();

        int groupMovement = 1;
        //déplace l'aventurier selon les mouvements donnés
        for (int i=0; i<listMovement.length(); i++) {
            char move = listMovement.charAt(i);
            adventurer.moveAdventurer(move, carte);
        }

        // indique la position finale de l'aventurier
        System.out.println("Position de l'aventurier après les mouvements: " + adventurer.getX() + ", " + adventurer.getY());

        scanner.close();
    }
}