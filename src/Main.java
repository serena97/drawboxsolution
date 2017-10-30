import java.util.Scanner;

/**
 *
 */
public class Main {

    /**
     * The main method takes in 2 separate user inputs: height, and then width. A box must have at least a height and width of 2,
     * so the function validates that the height and width must be a integer greater or equal to 2.
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height;
        do {
            System.out.print("Enter height that is >= 2: ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number! Try again. ");
                scanner.next();
            }
            height = scanner.nextInt();
        } while (height <= 1);


        int width;
        do {
            System.out.print("Enter width that is >= 2 : ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number! Try again. ");
                scanner.next();
            }
            width = scanner.nextInt();
        } while (width <= 1);

        System.out.println("drawing box with height "+height+", width "+width);
        makebox(height, width);
    }

    /**
     * @param height is the number of rows
     * @param width is the number of columns
     * @return a 2D String array containing the ASCII strings
     */
    public static String[][] makebox(int height, int width) {
        String[][] box = new String[width][height];
        int w = width - 1;
        int h = height - 1;
        // populate first row and last row with corner symbols
        box[0][0] = Character.toString('\u250C') +" "; //topleft
        box[w][0] = Character.toString('\u2510') + " "; //topright
        box[0][h] = Character.toString('\u2514') + " "; //bottomleft
        box[w][h] = Character.toString('\u2518') + " "; //bottomright

        // if needed, populate first and last row with - symbol
        if(width >= 2) {
            for(int col = 1; col < w; col++) {
                box[col][0] = Character.toString('\u2500') + " "; // - symbol at top
                box[col][h] = Character.toString('\u2500') + " "; // - symbol at bottom
            }
        }

        // populate middle rows
        if(height > 2) {
            for (int row = 1; row < h; row++) {
                box[0][row] = Character.toString('\u2575') + " "; //pipe
                for (int col = 1; col < width; col++) {
                    box[col][row] = "  "; //whitespace
                }
                box[w][row] = Character.toString('\u2575') + " ";
            }
        }

        drawbox(box, height, width);
        return box;
    }

    /**
     * This function prints each item in the box 2D array on the terminal
     * @param box is the constructed box in makebox()
     * @param height of the box
     * @param width of the box
     */
    public static void drawbox(String[][] box, int height, int width) {
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                System.out.print(box[x][y]);
            }
            System.out.println();
        }
    }

}
