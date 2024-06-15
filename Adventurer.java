import java.util.List;

class Adventurer {
    private int x;
    private int y;

    public Adventurer(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // gère le déplacement de l'aventurier
    public void moveAdventurer(char direction, List<String> map) {
        switch (direction) {
            case 'n': // haut
                if (y > 0 + 1 && map.get(y - 1).charAt(x) == ' ') y--;
                break;
            case 'N': // haut
                if (y > 0 + 1 && map.get(y - 1).charAt(x) == ' ') y--;
                break;
            case 's': // bas
                if (y < map.size() - 1 && map.get(y + 1).charAt(x) == ' ') y++;
                break;
            case 'S': // bas
                if (y < map.size() - 1 && map.get(y + 1).charAt(x) == ' ') y++;
                break;
            case 'o': // gauche
                if (x > 0 && map.get(y).charAt(x - 1) == ' ') x--;
                break;
            case 'O': // gauche
                if (x > 0 && map.get(y).charAt(x - 1) == ' ') x--;
                break;
            case 'e': // droite
                if (x < map.get(y).length() - 1 && map.get(y).charAt(x + 1) == ' ') x++;
                break;
            case 'E': // droite
                if (x < map.get(y).length() - 1 && map.get(y).charAt(x + 1) == ' ') x++;
                break;
        }
    }

}