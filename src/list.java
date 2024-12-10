import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    private static ArrayList<String> christmasMovies = new ArrayList<String>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String choice;
        christmasMovies.addAll(Arrays.asList("Diehard", "Violent Night", "How the Grinch Stole Christmas!", "It's a wonderful life", "Gremlins", "National Lampoon's Christmas Vacation", "A Christmas Prince: The Royal Baby", "A Christmas Prince", "A Christmas Prince: The Royal Wedding", "Frosty The Snowman"));
        for (int i = 0; i < christmasMovies.size(); i++) {
            System.out.println((i + 1) + ". " + christmasMovies.get(i));
        }
        do {
            choice = InputHelper.getRegExString(scan,"Options:\n" + "A – Add an item to the list \n" + "D – Delete an item from the list\n" + "P – Print the list\n" + "Q – Quit the program\n", "[AaDdPpQq]");
            if (choice.equalsIgnoreCase("a")){
                addMethod();
            } else if (choice.equalsIgnoreCase("d")) {
                deleteMethod();
            } else if (choice.equalsIgnoreCase("p")) {
                printMethod();
            }else{
                if (quitMethod()){
                    break;
                }
            }

        } while (true);
    }
    private static String addMethod() {
        String adder;
        Scanner scan = new Scanner(System.in);
        adder = InputHelper.getNonZeroLenString(scan, "What Christmas movie would you like to add to the list?");
        christmasMovies.add(adder);
        return adder;
    }
    private static int deleteMethod() {
        int index;
        Scanner scan = new Scanner(System.in);
        index = InputHelper.getRangedInt(scan, "At what position is the Christmas movie you would like to delete?", christmasMovies.size(), 0 );
        christmasMovies.remove(index - 1);
        return index;
    }
    private static void printMethod() {
        for (int i = 0; i < christmasMovies.size(); i++) {
            System.out.println((i + 1) + ". " + christmasMovies.get(i));
        }
    }
    private static boolean quitMethod() {
        Scanner scan = new Scanner(System.in);
        boolean confirm;
        confirm = InputHelper.getYNConfirm(scan, "Are you sure you want to quit? [y/n]");
        return confirm;
    }
}


