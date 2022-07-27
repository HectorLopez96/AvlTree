import java.util.Scanner;

public class terminal {

    public static Integer askNumber(String message){
        try {
            Scanner scanner = new Scanner(System.in);
            showMessage(message);
            return scanner.nextInt();
        } catch(NumberFormatException e){
            showMessage("Error with received input");
        }
        return null;
    }
    public static void showMessage(String message){
        System.out.println(message);
    }

    public static void decorate(){
        System.out.println("\n***********************************************");
    }

    public static void clearScreen(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            /*No hace nada*/
        }
    }
}
