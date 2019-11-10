package kyu6;

/**
 * You live in the city of Cartesia where all roads are laid out in a perfect grid.
 * You arrived ten minutes too early to an appointment, so you decided to take the opportunity to go for a short walk.
 * The city provides its citizens with a Walk Generating App on their phones -
 * - everytime you press the button it sends you an array of one-letter strings representing directions to walk (eg. ['n', 's', 'w', 'e']).
 * You always walk only a single block in a direction and you know it takes you one minute to traverse one city block,
 * so create a function that will return true if the walk the app gives you will take you exactly ten minutes
 * (you don't want to be early or late!) and will, of course, return you to your starting point. Return false otherwise.
 * <p>
 * Note: you will always receive a valid array containing a random assortment of direction letters ('n', 's', 'e', or 'w' only).
 * It will never give you an empty array (that's not a walk, that's standing still!).
 */
public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        if (walk.length != 10 || walk.length % 2 != 0)
            return false;
        int x = 0, y = 0;
        for (char direction : walk) {
            if (direction == 'n') y++;
            if (direction == 's') y--;
            if (direction == 'e') x++;
            if (direction == 'w') x--;
            /*switch (direction) {
                case 'n': y++; break;
                case 's': y--; break;
                case 'w': x++; break;
                case 'e': x--; break;*/
        }
        return x == 0 && y == 0;
    }
}
