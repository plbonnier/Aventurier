import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<String> map;
    private Adventurer adventurer;

    public Adventurer getAdventurer() {
        return adventurer;
    }

    //lecture du fichier texte pour créer la map
    public void createMap(String filePath) {
        //Initilisation de la map
        map = new ArrayList<>();

        //lecture du fichier texte
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                map.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getMap() {
        return map;
    }

    public void showMap(Adventurer adventurer) {
        for (int y = 0; y < map.size(); y++) {
            StringBuilder ligne = new StringBuilder(map.get(y));
            if (adventurer.getY() == y) {
                ligne.setCharAt(adventurer.getX(), 'A'); // 'A' représente l'aventurier
            }
            System.out.println(ligne);
        }
    }

    // méthode pour vérifier si une case est accessible
    public boolean isAccessible(int x, int y) {
        //si y est en dehors de la map
        if (y<0 || y>=map.size()) {
            return false;
        //si x est en dehors de la map. on définit la longueur de la map par la longueur de la ligne y
        } else if (x<0 || x>=map.get(y).length()){
            return false;
        //si la case n'est pas un espace vide
        } else if (map.get(y).charAt(x) == '#'){
            return false;
        } else {
            return true;
        }
    }
}

