package GROUP1_ICT1M2FINALPROJECT;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GROUP1_ICT1M2FINALPROJECT {
    // --- ANSI Color Codes ---
    public static final String RESET = "\033[0m";
    public static final String BLACK = "\033[0;30m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String MAGENTA = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";

    // --- ANSI Bold Colors ---
    public static final String BLACK_BOLD = "\033[1;30m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String MAGENTA_BOLD = "\033[1;35m";
    public static final String CYAN_BOLD = "\033[1;36m";
    public static final String WHITE_BOLD = "\033[1;37m";

    // Constants for menu choices
    private static final int START = 1;
    private static final int ABOUT_US = 2;
    private static final int EXIT = 3;
    private static final int CALCULATOR = 1;
    private static final int CONVERSION = 2;
    private static final int ABOUT = 3;
    private static final int BACK_TO_MAIN_MENU = 4; // Consistent back option

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            displayLoadingScreen();
            startMenu(scanner);
        } catch (Exception e) {
            System.err.println(RED_BOLD + "An unhandled error occurred: " + e.getMessage() + RESET);
            e.printStackTrace();
        }
    }

    private static void startMenu(Scanner scanner) {
        int choice;
        do {
            displayStartMenu();
            choice = getUserChoice(scanner, 1, 3);

            switch (choice) {
                case START:
                    mainMenu(scanner);
                    break;
                case ABOUT_US:
                    aboutUsMenu(scanner);
                    break;
                case EXIT:
                    System.out.println(GREEN_BOLD + "Exiting application. Goodbye!" + RESET);
                    break;
                default:
                    System.out.println(RED + "An unexpected error occurred with menu choice." + RESET);
            }
        } while (choice != EXIT);
    }

    private static void mainMenu(Scanner scanner) {
        int choice;
        do {
            displayMainMenu();
            choice = getUserChoice(scanner, 1, 4);

            switch (choice) {
                case CALCULATOR:
                    calculatorMenu(scanner);
                    break;
                case CONVERSION:
                    conversionMenu(scanner);
                    break;
                case ABOUT:
                    aboutUsMenu(scanner);
                    break;
                case BACK_TO_MAIN_MENU:
                    System.out.println(GREEN_BOLD + "Returning to Start Menu..." + RESET);
                    return;
                default:
                    System.out.println(RED + "An unexpected error occurred with menu choice." + RESET);
            }
        } while (true);
    }private static void calculatorMenu(Scanner scanner) {
        int choice;
        do {
            displayCalculatorMenu();
            choice = getUserChoice(scanner, 1, 5);

            switch (choice) {
                case 1:
                    addition(scanner);
                    break;
                case 2:
                    subtraction(scanner);
                    break;
                case 3:
                    multiplication(scanner);
                    break;
                case 4:
                    division(scanner);
                    break;
                case 5: // Back to Main Menu
                    System.out.println(GREEN + "Returning to Main Menu..." + RESET);
                    return;
                default:
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
            }
        } while (true);
    }

    private static void conversionMenu(Scanner scanner) {
        int choice;
        do {
            displayConversionMenu();
            choice = getUserChoice(scanner, 1, 4);

            switch (choice) {
                case 1:
                    mmCmM(scanner);
                    break;
                case 2:
                    oddEven(scanner);
                    break;
                case 3:
                    circleAreaCircumference(scanner);
                    break;
                case 4: // Back to Main Menu
                    System.out.println(GREEN + "Returning to Main Menu..." + RESET);
                    return;
                default:
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
            }
        } while (true);
    } 

    private static void aboutUsMenu(Scanner scanner) {
        int choice;
        do {
            displayAboutUsMenu();
            choice = getUserChoice(scanner, 1, 3);

            switch (choice) {
                case 1:
                    briefDescription(scanner);
                    break;
                case 2:
                    developers();
                    break;
                case 3:
                    System.out.println(GREEN + "Returning to Main Menu..." + RESET);
                    return;
                default:
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
            }
        } while (true);
    }

    // --- Display Methods ---
private static void displayLoadingScreen() {
    String loadingMessage = BLUE_BOLD + "                                   ❀ 𝐋𝐎𝐀𝐃𝐈𝐍𝐆 ❀   " + RESET;

    String designTop =
        BLUE_BOLD +
        "              ⠀⠀⠀⠀⠀⠀⢀⠖⠒⠂⠉⠙⡆⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠠⡇⠀⠀⠋⠒⠲⣄⠀⠀⠀⠀⠀⠀\n" +
        "              ⠀⠀⠀⠀⠀⠀⠀⠳⣄⡀⣀⠞⠁⠀⠀⠀⠀⠐⢏⠁⢀⡝⠀⠀⠀⠀⠀⠀⠀⠀⢇⠀⠀⠀⠀⢀⡾⠀⠀⠀⠀⠀⠀⠀\n" +
        "              ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠃⠀⠀⠀⠀⠀⢀⡀⠀⢻⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢧⣀⣠⠤⠟⠀⠀⠀⠀⠀⠀⠀⠀\n" +
        "                    ⠀⠀⠀⠀⠀⠀⣀⣴⠟⠻⢿⣤⡀⠀⠀⠀⠀⠀⣰⣴⣿⣲⣶⣄⠀⠀⠀⠀⠀⠀⠀⢀⡀⠀⠀⠀\n" +
        "                 ⢀⡠⠤⢤⠀⠀⠀⠀⢨⣿⠆⠀⠀⠀⠈⠻⣦⣀⠀⢀⣴⣯⣷⡐⣇⣿⡋⣷⣀⠀⠀⠀⠀⢰⡁⠈⠁⠀⢠\n" +
        "              ⣀⠴⠊⠀⠀⠀⡧⠀⠀⠀⠀⣿⣿⠆⠀⠀⠀⠀⠀⠉⠙⠛⣿⣿⣾⣙⣿⣿⣷⠛⣾⡿⠛⠛⠛⣷⠀⠙⠦⢤⠜⠁\n" +
        "             ⢰⡀⠀⠀⠀⠀⢀⠇⠀⠀⣠⡼⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣯⢼⡏⢻⣿⣿⣿⡷⢿⣦⣀⠀⣿⠀⠀⠀⠀⠀⠀\n" +
        "             ⠀⠉⠒⠦⠤⠴⠊⠀⢀⣾⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣟⣿⣞⣷⢫⣿⣿⣛⣿⣻⣾⣙⣧⣿⣧⣄⡀⠀⠀⠀\n" +
        "                    ⠀⣸⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⠿⠿⠟⢿⣴⣯⣶⣟⢹⣻⣷⢾⢿⣍⣿⣷⠀⠀\n" +
        "               ⠀⠀⠀ ⣴⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⣿⣿⣿⣮⣿⣿⣮⡾⣹⣏⣿⠀⠀\n" +
        "              ⠀⠀⠰⠞⠛⢻⡗⠒⠂⢀⢄⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠘⣿⠻⢿⣿⣿⣴⡷⢻⣿⠏⠀⠀\n" +
        "          ⠀⠀ ⠀⠀⢀⣸⣿⣤⣀⠀⠛⠋⠙⡷⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣷⣏⣷⠿⣮⣿⠟⠁⠀⠀\n" +
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠛⠉⢹⣆⢀⣀⠀⠀⠀⠀⠀⠀⠀⠀⢴⠒⢦⡀⠀⠀⠀⢰⡾⠛⣶⣾⠟⠛⠿⢿⡟⠻⠶⣄⠀\n" +
        "         ⠀⠀ ⠀⠀⠀⠀⠀⢠⡾⠛⣻⡷⠖⠲⠶⢤⡀⠀⠀⠀⠈⠉⠉⠀⠀⠀⠀⢀⣀⡀⠈⠀⠀⠒⢲⣾⣅⡀⠀⠀⠀⠀⠀\n" +
        "             ⠀⠀⠀⠀⠀⠀⠀⠀⢺⡀⠀⠀⠀⠀⢻⣄⠀⠀⠀⠀⠀⠀⠀⣰⠟⠉⠉⠉⠳⣖⢲⣶⣿⡁⠈⠉⠀⠀⠀\n" +
        "⠀⠀            ⢠⠀⠀⠀⠀⠀⠀⠈⢻⣶⣤⠀⠀⠈⡟⠛⠛⠒⠛⠓⣶⣾⠃⠀⠀⠀⠀⠀⣿⡏⠁⠈⢻⣦⠀⠀⠀⠀⠀⠀\n" +
        " ╔═══════════════════*.·:⢸⣏⠁ ⠀⠀⣠⡟✧ ✦   ⣯⠀⠀⠀⠤⣶⠟.·:·.*══════════════════════════════════╗                 \n" +
        " ║         ⠀⠀ ⠀⠀⠁⠀⠀⠀ ⠀⠀⠀⢸⣏⠁⠀⠀⣠⡟⠀⠀⠀⠀⠀ ⠀⣯⠀⠀⠀ ⣶⠀⠀⠀⠉⠀⠀                                   ║               \n" +
        " ║                  ⠀⠀⠀⠀⠀⠙⠶⠶⠞⠋⠀⠀⠀⠀⠀  ⠀⠀⠻⣤⣀⡀⣠⠟⠀                                         ║               \n" +
        " ║" + CYAN_BOLD + "  ░██╗░░░░░░░██╗███████╗██╗░░░░░ ░█████╗░░█████╗░███╗░░░███╗███████╗                 " + BLUE_BOLD + "      ║               \n" +
        " ║" + CYAN_BOLD + "  ░██║░░██╗░░██║██╔════╝██║░░░░░ ██╔══██╗██╔══██╗████╗░████║██╔════╝                 " + BLUE_BOLD + "      ║               \n" +
        " ║" + CYAN_BOLD + "  ░╚██╗████╗██╔╝█████╗░░██║░░░░░ ██║░░╚═╝██║░░██║██╔████╔██║█████╗░░                 " + BLUE_BOLD + "      ║               \n" +
        " ║" + CYAN_BOLD + "  ░░████╔═████║░██╔══╝░░██║░░░░░ ██║░░██╗██║░░██║██║╚██╔╝██║██╔══╝░░                  " + BLUE_BOLD + "     ║               \n" +
        " ║" + CYAN_BOLD + "  ░░╚██╔╝░╚██╔╝░███████╗███████╗ ╚█████╔╝╚█████╔╝██║░╚═╝░██║███████╗                 " + BLUE_BOLD + "      ║               \n" +
        " ║" + CYAN_BOLD + "  ░░░╚═╝░░░╚═╝░░╚══════╝╚══════╝ ░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚══════╝                 " + BLUE_BOLD + "      ║               \n" +
        " ║                                                                                                                             ║               \n";
    String designBottom =
        BLUE_BOLD +
        " ╚══════════════════════════*.·:·.✧ ✦ ✧.·:·.*═══════════════════════════════════════════╝               \n" +
        RESET;

    // Combine top and bottom
    String design = designTop + designBottom;

    // Loading animation frames
    String[] animation = {
        " °  ",
        " ° ⚬ ",
        "° ⚬ ⭘  ",
        "° ⚬ ⭘ ⚆ ",
        "° ⚬ ⭘ ⚆ ⚇ ",
        "• 𖧹 𒊹 ⚈ ⚉",
        "• 𖧹 𒊹 ⚈",
        "• 𖧹 𒊹",
        "• 𖧹  ",
        "• "
    };

    // Loop animation
    for (int i = 0; i < 30; i++) {
        System.out.print("\033[H\033[2J"); // clear screen
        System.out.flush();
        System.out.println("\n\n\n\n");
        System.out.println(design);
        System.out.println(loadingMessage + " " + animation[i % animation.length]);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    System.out.print("\033[H\033[2J");
    System.out.flush();
    System.out.println(BLUE_BOLD + "                     𝐋𝐎𝐀𝐃𝐈𝐍𝐆 𝐂𝐎𝐌𝐏𝐋𝐄𝐓𝐄𝐃!!           \n" + RESET);
}

   
      private static void displayStartMenu() {
          
System.out.println(BLUE_BOLD + "\n          ♡ ∩_∩ " + RESET);
System.out.println(BLUE_BOLD + "         („• ֊ •„)♡" + RESET);
System.out.println(BLUE_BOLD + "     ╔━━━━━━U━U━━━━━*.·:·.☽✧ஓ๑♡๑ஓ✧☾.·:·.*━━━━━━━━━━━━━━━━╗    " + RESET);               
System.out.println(BLUE_BOLD + "    ║                                                       ║    "   + RESET);      
System.out.println(BLUE_BOLD + "    ║                                                       ║    " + RESET);
System.out.println(BLUE_BOLD + "    ║         ███╗░░░███╗███████╗███╗░░██╗██╗░░░██╗         ║    " + RESET);
System.out.println(BLUE_BOLD + "    ║         ████╗░████║██╔════╝████╗░██║██║░░░██║         ║    " + RESET);
System.out.println(BLUE_BOLD + "    ║         ██╔████╔██║█████╗░░██╔██╗██║██║░░░██║         ║     " + RESET);
System.out.println(BLUE_BOLD + "    ║         ██║╚██╔╝██║██╔══╝░░██║╚████║██║░░░██║         ║      " + RESET);
System.out.println(BLUE_BOLD + "    ║         ██║░╚═╝░██║███████╗██║░╚███║╚██████╔╝         ║      " + RESET);
System.out.println(BLUE_BOLD + "    ║         ╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚══╝░╚═════╝░         ║      " + RESET);
System.out.println(BLUE_BOLD + "    ║                                                       ║      " + RESET);
System.out.println(BLUE_BOLD + "    ║                                                       ║      " + RESET);
System.out.println(CYAN + "         ║                  [1] 𝕾𝖙𝖆𝖗𝖙                              ║      " + RESET);
System.out.println(BLUE_BOLD + "    ║                                                       ║      " + RESET);
System.out.println(CYAN + "         ║                  [2] 𝕬𝖇𝖔𝖚𝖙 𝖀𝖘                          ║      " + RESET);
System.out.println(BLUE_BOLD + "    ║                                                       ║      " + RESET);
System.out.println(RED + "          ║                  [3] 𝕰𝖝𝖎𝖙                              ║      " + RESET);
System.out.println(BLUE_BOLD + "    ║                                                       ║      " + RESET);
System.out.println(BLUE_BOLD + "    ║                                                       ║      " + RESET);
System.out.println(BLUE_BOLD + "     ╚━━━━━━━━━━━━━━*.·:·.☽✧ஓ๑♡๑ஓ✧☾.·:·.*━━━━━━━━━━━━━━━━╝      " + RESET);
          
       }
  //
private static void displayMainMenu() {
    System.out.println(BLUE_BOLD + "            ⪩ ⪨               ");
    System.out.println("         ૮₍˶ᵔ ᵕ ᵔ˶₎ა");
    System.out.println("    ╔━━━━━━━U━U━━━━━━━━━━━*.·:·.☽✧ஓ๑♡๑ஓ✧☾.·:·.*━━━━━━━━═╤╤╤╤═━━━━━━━━╗               ");
    System.out.println("    ┃┃ ✿███╗░░░███╗░█████╗░██╗███╗░░██╗      ✿            ❦❦❦        ┃┃               ");
    System.out.println("    ┃┃   ████╗░████║██╔══██╗██║████╗░██║                               ┃┃               ");
    System.out.println("    ┃┃   ██╔████╔██║███████║██║██╔██╗██║                               ┃┃               ");
    System.out.println("    ┃┃   ██║╚██╔╝██║██╔══██║██║██║╚████║                               ┃┃               ");
    System.out.println("    ┃┃   ██║░╚═╝░██║██║░░██║██║██║░╚███║                               ┃┃               ");
    System.out.println("    ┃┃   ╚═╝░░░░░╚═╝╚═╝░░╚═╝╚═╝╚═╝░░╚══╝                               ┃┃               ");
    System.out.println("    ┃┃                  ✿ ███╗░░░███╗███████╗███╗░░██╗██╗░░░██╗  ✿    ┃┃               ");
    System.out.println("    ┃┃        ✿           ████╗░████║██╔════╝████╗░██║██║░░░██║        ┃┃               ");
    System.out.println("    ┃✿           ✿        ██╔████╔██║█████╗░░██╔██╗██║██║░░░██║       ✿┃               ");
    System.out.println("    ┃┃                     ██║╚██╔╝██║██╔══╝░░██║╚████║██║░░░██║       ┃┃               ");
    System.out.println("    ┃✿                     ██║░╚═╝░██║███████╗██║░╚███║╚██████╔╝      ✿┃               ");
    System.out.println("    ┃┃                     ╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚══╝░╚═════╝░       ┃┃               ");
    System.out.println("    ┃✿                                                                ✿┃               ");
    System.out.println("    ┃┃                                                                 ┃┃               ");
    System.out.println("    ┃✿            " + CYAN +    "[1]𝕮𝖆𝖑𝖈𝖚𝖑𝖆𝖙𝖔𝖗"     + BLUE_BOLD +  "     ✿┃               ");
    System.out.println("    ┃┃                                                                 ┃┃               ");
    System.out.println("    ┃┃             " + CYAN +    "[2]𝕮𝖔𝖓𝖛𝖊𝖗𝖘𝖎𝖔𝖓"   + BLUE_BOLD +   "     ┃┃               ");
    System.out.println("    ┃┃                                                                 ┃┃               ");
    System.out.println("    ┃✿             " + CYAN +    "[3]𝕬𝖇𝖔𝖚𝖙 𝖀𝖘"    + BLUE_BOLD +   "    ✿┃               ");
    System.out.println("    ┃┃                                                                 ┃┃               ");
    System.out.println("    ┃┃             " + CYAN +     "[4]𝕰𝖝𝖎𝖙"       + BLUE_BOLD +   "     ┃┃               ");
    System.out.println("    ┃┃                                                                 ┃┃               ");
    System.out.println("    ┃┃                                                                 ┃┃               ");
    System.out.println("    ╚═╤╤╤╤═━━━━━━━━━━━━━━━*.·:·.☽✧ஓ๑♡๑ஓ✧☾.·:·.*━━━━━━━━━━━━━━━━━━━━━━╝               ");
    System.out.println("      ❦❦❦                         " + RESET);

    }
    private static void displayCalculatorMenu() {
        
    System.out.println(BLUE_BOLD + "            ⪩ ⪨");
    System.out.println("         ૮₍˶ᵔ ᵕ ᵔ˶₎ა");
    System.out.println("    ╔━━━━━━━U━U━━━━━═╤╤╤╤═━━━━━━━━*.·:·.☽✧ஓ๑♡๑ஓ✧☾.·:·.*━━━━━━━━━━━━━━━━━━━━━━━═╤╤╤╤═━━━━━━━━━━╗");
    System.out.println("    ┃┃ ✿░█████╗░░█████╗░██╗░░░░░░█████╗░██╗░░░██╗██╗░░░░░░█████╗░████████╗░█████╗░██████╗░  ✿ ┃┃");
    System.out.println("    ┃┃   ██╔══██╗██╔══██╗██║░░░░░██╔══██╗██║░░░██║██║░░░░░██╔══██╗╚══██╔══╝██╔══██╗██╔══██╗    ┃┃");
    System.out.println("    ┃┃   ██║░░╚═╝███████║██║░░░░░██║░░╚═╝██║░░░██║██║░░░░░███████║░░░██║░░░██║░░██║██████╔╝    ┃┃");
    System.out.println("    ┃┃   ██║░░██╗██╔══██║██║░░░░░██║░░██╗██║░░░██║██║░░░░░██╔══██║░░░██║░░░██║░░██║██╔══██╗    ┃┃");
    System.out.println("    ┃┃   ╚█████╔╝██║░░██║███████╗╚█████╔╝╚██████╔╝███████╗██║░░██║░░░██║░░░╚█████╔╝██║░░██║    ┃┃");
    System.out.println("    ┃┃   ░╚════╝░╚═╝░░╚═╝╚══════╝░╚════╝░░╚═════╝░╚══════╝╚═╝░░╚═╝░░░╚═╝░░░░╚════╝░╚═╝░░╚═╝    ┃┃");
    System.out.println("    ┃✿                                                                                         ✿┃");
    System.out.println("    ┃┃                                                                                          ┃┃");
    System.out.println("    ┃✿                    " + CYAN + "【1】𝕬𝖉𝖉𝖎𝖙𝖎𝖔𝖓" + BLUE_BOLD + "                                              ✿┃");
    System.out.println("    ┃┃                                                                                          ┃┃");
    System.out.println("    ┃✿                    " + CYAN + "【2】𝕾𝖚𝖇𝖙𝖗𝖆𝖈𝖙𝖎𝖔𝖓" + BLUE_BOLD + "                                           ✿┃");
    System.out.println("    ┃┃                                                                                          ┃┃");
    System.out.println("    ┃✿                    " + CYAN + "【3】𝕸𝖚𝖑𝖙𝖎𝖕𝖑𝖎𝖈𝖆𝖙𝖎𝖔𝖓" + BLUE_BOLD + "                                          ✿┃");
    System.out.println("    ┃┃                                                                                          ┃┃");
    System.out.println("    ┃┃                    " + CYAN + "【4】𝕯𝖎𝖛𝖎𝖘𝖎𝖔𝖓" + BLUE_BOLD + "                                              ┃┃");
    System.out.println("    ┃┃                                                                                          ┃┃");
    System.out.println("    ┃┃                    " + YELLOW + "【5】𝕭𝖆𝖈𝖐 𝖙𝖔 𝕸𝖆𝖎𝖓 𝕸𝖊𝖓𝖚" + BLUE_BOLD + "                                   ┃┃");
    System.out.println("    ┃┃                                                                                          ┃┃");
    System.out.println("    ╚═╤╤╤╤═━━━━━━━━━━━━━━━━━━━━━━━━━*.·:·.☽✧ஓ๑♡๑ஓ✧☾.·:·.*━━━━━━━━━━━━━━━━━━━═╤╤╤╤═━━━━━━━━━━━━╝");
    System.out.println("      ❦❦❦                                                                     ❦❦❦" + RESET);
}
 private static void displayConversionMenu() {
    System.out.println(BLUE_BOLD + "            ⪩ ⪨");
    System.out.println("         ૮₍˶ᵔ ᵕ ᵔ˶₎ა");
    System.out.println("    ╔━━━━━━━U━U━━━━━═╤╤╤╤═━━━━━━━━*.·:·.☽✧ஓ๑♡๑ஓ✧☾.·:·.*━━━━━━━━━━━━━━━━━━━═╤╤╤╤═━━━━━━━━━━╗");
    System.out.println("    ┃┃                                                                                      ┃┃");
    System.out.println("    ┃┃ ✿░█████╗░░█████╗░███╗░░██╗██╗░░░██╗███████╗░██████╗░░██████╗██╗░█████╗░███╗░░██╗ ✿  ┃┃");
    System.out.println("    ┃┃   ██╔══██╗██╔══██╗████╗░██║██║░░░██║██╔════╝██╔══██╗██╔════╝██║██╔══██╗████╗░██║     ┃┃");
    System.out.println("    ┃┃   ██║░░╚═╝██║░░██║██╔██╗██║╚██╗░██╔╝█████╗░░██████╔╝╚█████╗░██║██║░░██║██╔██╗██║     ┃┃");
    System.out.println("    ┃┃   ██║░░██╗██║░░██║██║╚████║░╚████╔╝░██╔══╝░░██╔══██╗░╚═══██╗██║██║░░██║██║╚████║     ┃┃");
    System.out.println("    ┃┃   ╚█████╔╝╚█████╔╝██║░╚███║░░╚██╔╝░░███████╗██║░░██║██████╔╝██║╚█████╔╝██║░╚███║     ┃┃");
    System.out.println("    ┃┃   ░╚════╝░░╚════╝░╚═╝░░╚══╝░░░╚═╝░░░╚══════╝╚═╝░░╚═╝╚═════╝░╚═╝░╚════╝░╚═╝░░╚══╝     ┃┃");
    System.out.println("    ┃✿                                                                                     ✿┃");
    System.out.println("    ┃┃                                                                                      ┃┃");
    System.out.println("    ┃✿                    " + CYAN + "【1】𝑴𝒊𝒍𝒍𝒊𝒎𝒆𝒕𝒆𝒓𝒔 𝒕𝒐 𝑪𝒆𝒏𝒕𝒊𝒎𝒆𝒕𝒆𝒓𝒔 𝒕𝒐 𝑴𝒆𝒕𝒆𝒓𝒔" + BLUE_BOLD + "                                  ✿┃");
    System.out.println("    ┃┃                                                                                      ┃┃");
    System.out.println("    ┃✿                    " + CYAN + "【2】𝑪𝒉𝒆𝒄𝒌 𝑶𝒅𝒅 𝒐𝒓 𝑬𝒗𝒆𝒏" + BLUE_BOLD + "                                              ✿┃");
    System.out.println("    ┃┃                                                                                      ┃┃");
    System.out.println("    ┃✿                    " + CYAN + "【3】𝑨𝒓𝒆𝒂 𝒂𝒏𝒅 𝑪𝒊𝒓𝒄𝒖𝒎𝒇𝒆𝒓𝒆𝒏𝒄𝒆 𝒐𝒇 𝒂 𝑪𝒊𝒓𝒄𝒍𝒆" + BLUE_BOLD + "                                  ✿┃");
    System.out.println("    ┃┃                                                                                      ┃┃");
    System.out.println("    ┃┃                    " + YELLOW + "【4】𝑩𝒂𝒄𝒌 𝒕𝒐 𝑴𝒂𝒊𝒏 𝑴𝒆𝒏𝒖" + BLUE_BOLD + "                                              ┃┃");
    System.out.println("    ┃┃                                                                                      ┃┃");
    System.out.println("    ┃┃                                                                                      ┃┃");
    System.out.println("    ╚═╤╤╤╤═━━━━━━━━━━━━━━━━━━━━━━━━━*.·:·.☽✧ஓ๑♡๑ஓ✧☾.·:·.*━━━━━━━━━━━━━━━═╤╤╤╤═━━━━━━━━━━━━╝");
    System.out.println("      ❦❦❦                                                                     ❦❦❦" + RESET);
}
private static void displayAboutUsMenu() {
    System.out.println(BLUE_BOLD + "           ⪩ ⪨");
    System.out.println("        ૮₍˶ᵔ ᵕ ᵔ˶₎ა");
    System.out.println("    ╔━━━━━U━U━━━━━═╤╤╤╤═━━━━━*.·:·.☽✧ஓ๑♡๑ஓ✧☾.·:·.*━━━━━━━━═╤╤╤╤═━━━━━━━━━━╗");
    System.out.println("    ┃┃             ❦❦❦                                      ❦❦❦          ┃┃");
    System.out.println("    ┃┃ ✿ ░█████╗░██████╗░░█████╗░██╗░░░██╗████████╗   ██╗░░░██╗░██████╗ ✿ ┃┃");
    System.out.println("    ┃┃   ██╔══██╗██╔══██╗██╔══██╗██║░░░██║╚══██╔══╝   ██║░░░██║██╔════╝    ┃┃");
    System.out.println("    ┃┃   ███████║██████╦╝██║░░██║██║░░░██║░░░██║░░░   ██║░░░██║╚█████╗░    ┃┃");
    System.out.println("    ┃┃   ██╔══██║██╔══██╗██║░░██║██║░░░██║░░░██║░░░   ██║░░░██║░╚═══██╗    ┃┃");
    System.out.println("    ┃┃   ██║░░██║██████╦╝╚█████╔╝╚██████╔╝░░░██║░░░   ╚██████╔╝██████╔╝    ┃┃");
    System.out.println("    ┃┃   ╚═╝░░╚═╝╚═════╝░░╚════╝░░╚═════╝░░░░╚═╝░░░   ░╚═════╝░╚═════╝░    ┃┃");
    System.out.println("    ┃┃                                                                     ┃┃");
    System.out.println("    ┃✿                                                                    ✿┃");
    System.out.println("    ┃┃                                                                     ┃┃");
    System.out.println("    ┃✿       " + CYAN + "【1】𝑩𝒓𝒊𝒆𝒇 𝑫𝒆𝒔𝒄𝒓𝒊𝒑𝒕𝒊𝒐𝒏 𝒐𝒇 𝒕𝒉𝒆 𝑷𝒓𝒐𝒋𝒆𝒄𝒕" + BLUE_BOLD + "     ✿┃");
    System.out.println("    ┃┃                                                                     ┃┃");
    System.out.println("    ┃✿       " + CYAN + "【2】𝑫𝒆𝒗𝒆𝒍𝒐𝒑𝒆𝒓𝒔" + BLUE_BOLD + "                     ✿┃");
    System.out.println("    ┃┃                                                                     ┃┃");
    System.out.println("    ┃✿     " + YELLOW + "【3】𝑩𝒂𝒄𝒌 𝒕𝒐 𝑴𝒂𝒊𝒏 𝑴𝒆𝒏𝒖" + BLUE_BOLD + "             ✿┃");
    System.out.println("    ┃┃                                                                     ┃┃");
    System.out.println("    ┃┃                                                                     ┃┃");
    System.out.println("    ╚═╤╤╤╤═━━━━━━━━━━━━━━━━━━*.·:·.☽✧ஓ๑♡๑ஓ✧☾.·:·.*━━━━━━━═╤╤╤╤═━━━━━━━━━━━╝");
    System.out.println("      ❦❦❦                                                  ❦❦❦" + RESET);
}
    // --- Utility Methods ---

    private static int getUserChoice(Scanner scanner, int min, int max) {
        int choice = -1;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print(YELLOW + "Enter your choice: " + RESET);
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the leftover newline character

                if (choice >= min && choice <= max) {
                    isValid = true;
                } else {
                    System.out.println(RED + "Invalid choice. Please enter a number between " + min + " and " + max + "." + RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(RED + "Invalid input. Please enter an integer." + RESET);
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return choice;
    }
    private static double getDoubleInput(Scanner scanner, String prompt) {
        double value = 0.0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(YELLOW + prompt + RESET);
            try {
                value = scanner.nextDouble();
                scanner.nextLine(); // Consume the leftover newline character
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println(RED + "Invalid input. Please enter a valid number." + RESET);
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return value;
    }

    private static int getIntegerInput(Scanner scanner, String prompt) {
        int value = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(YELLOW + prompt + RESET);
            try {
                value = scanner.nextInt();
                scanner.nextLine(); // Consume the leftover newline character
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println(RED + "Invalid input. Please enter a valid integer." + RESET);
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return value;
    }// --- Calculator functions ---
     public static void addition(Scanner scanner) {
    System.out.println(BLUE_BOLD +
        "   ♡ ∩_∩ \n" +
        "   („• ֊ •„)♡\n" +
        "╭━━━U━U ━━━.·:*¨༺ ༻¨*:·..·:*¨༺ ༻¨*:·.━━━━━━━━━╮" + RESET);
    System.out.println(BLUE_BOLD +
        "╿▯                                               ▯╿\n" +
        "╿▯       ▄▀█ █▀▄ █▀▄ █ ▀█▀ █ █▀█ █▄░█       ▯╿\n" +
        "╿▯       █▀█ █▄▀ █▄▀ █ ░█░ █ █▄█ █░▀█       ▯╿\n" +
        "╿▯                                               ▯╿\n" +
        "╿▯                                               ▯╿" + RESET);
    double num1 = getDoubleInput(scanner, MAGENTA + "╿▯                𝑬𝒏𝒕𝒆𝒓 𝒇𝒊𝒓𝒔𝒕 𝒏𝒖𝒎𝒃𝒆𝒓:                ▯╿\n" + RESET);
    double num2 = getDoubleInput(scanner, MAGENTA + "╿▯                𝑬𝒏𝒕𝒆𝒓 𝒔𝒆𝒄𝒐𝒏𝒅 𝒏𝒖𝒎𝒃𝒆𝒓:              ▯╿\n" + RESET);
    double result = num1 + num2;
    System.out.println(BLUE_BOLD +
        "╿▯                                               ▯╿\n" +
        "╿▯                    𝑹𝒆𝒔𝒖𝒍𝒕: " + MAGENTA + result + "                         " + BLUE_BOLD + "▯╿\n" +
        "╿▯     _ _  __     _ _  __    _ _  __    _ _  __  ▯╿\n" +
        "╿▯    ( | )/_/    ( | )/_/   ( | )/_/   ( | )/_/ ▯╿\n" +
        "╿▯  __( >O< )   __( >O< )  __( >O< )   _( >O< )  ▯╿\n" +
        "╿▯\\_\\(_|_)  \\_\\(_|_) \\_\\(_|_) \\_\\(_|_)   ▯╿\n" +
        "╰━━━━━.·:*¨༺ ༻¨*:·..·:*¨༺ ༻¨*:·.━━━━━━━━━━━━━╯" + RESET);
}

    public static void subtraction(Scanner scanner) {
            System.out.println(BLUE_BOLD +
        "   ♡ ∩_∩ \n" +
        "   („• ֊ •„)♡\n" +
        "╭━━━━━U━U ━━━.·:*¨༺ ༻¨*:·..·:*¨༺ ༻¨*:·.━━━━━━━━╮            \n" +
        "╿▯                                                 ▯╿            \n" +
        "╿▯ █▀ █░█ █▄▄ ▀█▀ █▀█ ▄▀█ █▀▀ ▀█▀ █ █▀█ █▄░█ ▯╿             \n" +
        "╿▯ ▄█ █▄█ █▄█ ░█░ █▀▄ █▀█ █▄▄ ░█░ █ █▄█ █░▀█ ▯╿              \n" +
        "╿▯                                                  ▯╿              \n" +
        "╿▯                                                  ▯╿               \n" +
        "╿▯               𝑬𝒏𝒕𝒆𝒓 𝒇𝒊𝒓𝒔𝒕 𝒏𝒖𝒎𝒃𝒆𝒓:                    ▯╿                        \n" + RESET);
         double num1 = getDoubleInput       (scanner, "                ");
        System.out.println(BLUE_BOLD +
        "╿▯                𝑬𝒏𝒕𝒆𝒓 𝒔𝒆𝒄𝒐𝒏𝒅 𝒏𝒖𝒎𝒃𝒆𝒓:                 ▯╿\n" + RESET);
        double num2 = getDoubleInput(scanner, "                   ");
    System.out.println(BLUE_BOLD +
        "╿▯                                                   ▯╿\n" +
        "╿▯ " + MAGENTA + "       𝑹𝒆𝒔𝒖𝒍𝒕:      " + BLUE_BOLD + "▯╿\n" +
        "╿▯       " + MAGENTA + (num1 - num2) + BLUE_BOLD + "                                 ▯╿\n" +
        "╿▯        _ _  __     _ _  __    _ _  __    _        ▯╿\n" +
        "╿▯       ( | )/_/    ( | )/_/   ( | )/_/   ( | )/_/  ▯╿\n" +
        "╿▯     __( >O< )   __( >O< )  __( >O< )   _( >O< )   ▯╿\n" +
        "╿▯   \\_\\(_|_)  \\_\\(_|_) \\_\\(_|_) \\_\\(_|_)    ▯╿\n" +
        "╰━━━━━━━━━━━━.·:*¨༺ ༻¨*:·..·:*¨༺ ༻¨*:·.━━━━━━━━━━╯" + RESET);
}

    public static void multiplication(Scanner scanner) {
    System.out.println(BLUE_BOLD +
        "   ♡ ∩_∩ \n" +
        "   („• ֊ •„)♡\n" +
        "╭━━━━━U━U ━━━━━.·:*¨༺ ༻¨*:·..·:*¨༺ ༻¨*:·.━━━━━━━━━━━━━━━━━━━━╮            \n" +
        "╿▯                                                               ▯╿            \n" +
        "╿▯  █▀▄▀█ █░█ █░░ ▀█▀ █ █▀█ █░░ █ █▀▀ ▄▀█ ▀█▀ █ █▀█ █▄░█ ▯╿             \n" +
        "╿▯  █░▀░█ █▄█ █▄▄ ░█░ █ █▀▀ █▄▄ █ █▄▄ █▀█ ░█░ █ █▄█ █░▀█ ▯╿              \n" +
        "╿▯                                                               ▯╿              \n" +
        "╿▯                                                               ▯╿              \n" +
        "╿▯                                                               ▯╿               \n" +
        "╿▯                𝑬𝒏𝒕𝒆𝒓 𝒇𝒊𝒓𝒔𝒕 𝒏𝒖𝒎𝒃𝒆𝒓:                                ▯╿                        \n" + RESET);
      double num1 = getDoubleInput       (scanner, "                ");
        System.out.println(BLUE_BOLD +
        "╿▯                𝑬𝒏𝒕𝒆𝒓 𝒔𝒆𝒄𝒐𝒏𝒅 𝒏𝒖𝒎𝒃𝒆𝒓:                              ▯╿\n" + RESET);
       double num2 = getDoubleInput(scanner, "                        ");
    System.out.println(BLUE_BOLD +
        "╿▯                                                               ▯╿\n" +
        "╿▯    " + MAGENTA + "       𝑹𝒆𝒔𝒖𝒍𝒕:      " + BLUE_BOLD + "            ▯╿\n" +
        "╿▯        " + MAGENTA + (num1 * num2) + BLUE_BOLD + "                                 ▯╿\n" +
        "╿▯           _ _  __     _ _  __    _ _  __    _ _  __           ▯╿\n" +
        "╿▯          ( | )/_/    ( | )/_/   ( | )/_/   ( | )/_/           ▯╿\n" +
        "╿▯         __( >O< )   __( >O< )  __( >O< )   _( >O< )           ▯╿\n" +
        "╿▯       \\_\\(_|_)  \\_\\(_|_) \\_\\(_|_) \\_\\(_|_)            ▯╿\n" +
        "╰━━━━━━━━━━━━━━.·:*¨༺ ༻¨*:·..·:*¨༺ ༻¨*:·.━━━━━━━━━━━━━━━━━━━━╯" + RESET);
}
    public static void division(Scanner scanner) {
    System.out.println(BLUE_BOLD +
        "   ♡ ∩_∩ \n" +
        "   („• ֊ •„)♡\n" +
        "╭━━━━U━U ━━.·:*¨༺ ༻¨*:·..·:*¨༺ ༻¨*:·.━━━━━━━━━━━━╮ \n" +
        "╿▯                                                   ▯╿    \n" +
        "╿▯        █▀▄ █ █░█ █ █▀ █ █▀█ █▄░█            ▯╿\n" +
        "╿▯        █▄▀ █ ▀▄▀ █ ▄█ █ █▄█ █░▀█             ▯╿\n" +
        "╿▯                                                   ▯╿          \n" +
        "╿▯                𝑬𝒏𝒕𝒆𝒓 𝒏𝒖𝒎𝒆𝒓𝒂𝒕𝒐𝒓:                     ▯╿                        \n" + RESET);
    double num1 = getDoubleInput(scanner, "               ");
    double num2 = 0;
    boolean validDenominator = false;
    while (!validDenominator) {
        System.out.println(BLUE_BOLD +
            "╿▯                𝑬𝒏𝒕𝒆𝒓 𝒅𝒆𝒏𝒐𝒎𝒊𝒏𝒂𝒕𝒐𝒓:                    ▯╿\n" + RESET);
        num2 = getDoubleInput(scanner, "                   ");
        if (num2 == 0) {
            System.out.println(RED + "╿▯      ⚠ Cannot divide by zero. Please enter a non-zero number. ⚠      ▯╿" + RESET);
        } else {
            validDenominator = true;
        }
    }
    System.out.println(BLUE_BOLD +
        "╿▯                                                               ▯╿\n" +
        "╿▯                         𝑹𝒆𝒔𝒖𝒍𝒕:                                 ▯╿\n" +
        MAGENTA + "╿▯                         " + (num1 / num2) + "                                 ▯╿" + RESET + "\n" +
        BLUE_BOLD +
        "╿▯           _ _  __     _ _  __    _ _  __    _ _  __           ▯╿\n" +
        "╿▯          ( | )/_/    ( | )/_/   ( | )/_/   ( | )/_/           ▯╿\n" +
        "╿▯         __( >O< )   __( >O< )  __( >O< )   _( >O< )           ▯╿\n" +
        "╿▯         \\_\\(_|_)    \\_\\(_|_)   \\_\\(_|_)   \\_\\(_|_)            ▯╿\n" +
        "╰━━━━━━━━━━━━━━.·:*¨༺ ༻¨*:·..·:*¨༺ ༻¨*:·.━━━━━━━━━━━━━━━━━━━━╯" + RESET);
}

    // --- Conversion functions ---

public static void mmCmM(Scanner scanner) {
    System.out.println(BLUE_BOLD +
        "   ♡ ∩_∩ \n" +
        "   („• ֊ •„)♡\n" +
        "╭━━━━━U━U ━━━.·:*¨༺ ༻¨*:·..·:*¨༺ ༻¨*:·.━━━━━━━━━━━╮            \n" +
        "╿▯                                                    ▯╿            \n" +
        "╿▯  █▀▄▀█ █ █░░ █░░ █ █▀▄▀█ █▀▀ ▀█▀ █▀▀ █▀█ █▀  ▯╿  \n" +
        "╿▯  █░▀░█ █ █▄▄ █▄▄ █  █░▀░█ ██▄ █░ ██▄ █▀▄ ▄█  ▯╿  \n" +
        "╿▯                                                    ▯╿             \n" +
        "╿▯                 ▀█▀ █▀█                           ▯╿           \n" +
        "╿▯                 ░█░ █▄█                           ▯╿             \n" +
        "╿▯                                                    ▯╿             \n" +
        "╿▯ █▀  █▀▀ █▄░█ ▀█▀ █ █▀▄▀█ █▀▀ ▀█▀ █▀▀ █▀█ █▀ ▯╿             \n" +
        "╿▯ █▄▄ ██▄ █░▀█ ░█░ █ █░▀░█ ██▄ ░█░ ██▄ █▀▄ ▄█ ▯╿             \n" +
        "╿▯                                                    ▯╿             \n" +
        "╿▯  ▀█▀ █▀█   █▀▄▀█ █▀▀ ▀█▀ █▀▀ █▀█ █▀           ▯╿             \n" +
        "╿▯  ░█░ █▄█   █░▀░█ ██▄ ░█░ ██▄ █▀▄ ▄█          ▯╿             \n" +   
        "╿▯                                                   ▯╿             \n" +
        "╿▯          𝑬𝒏𝒕𝒆𝒓 𝒍𝒆𝒏𝒈𝒕𝒉 𝒊𝒏 𝒎𝒊𝒍𝒍𝒊𝒎𝒆𝒕𝒆𝒓𝒔:                    ▯╿             \n" + RESET);
    double mm = getDoubleInput(scanner, "                      ");
    double cm = mm / 10;
    double m = mm / 1000;
    System.out.println(BLUE_BOLD +
        "╿▯                                                  ▯╿\n" +
        "╿▯                 𝑹𝒆𝒔𝒖𝒍𝒕𝒔:                           ▯╿\n" +
        MAGENTA + 
        "╿▯ 𝑪𝒆𝒏𝒕𝒊𝒎𝒆𝒕𝒆𝒓𝒔: " + String.format("%.2f", cm) + "      ▯╿\n" +
        "╿▯   𝑴𝒆𝒕𝒆𝒓𝒔: " + String.format("%.3f", m) + "         ▯╿" + RESET + "\n" +
        BLUE_BOLD +
        "╿▯                                                  ▯╿\n" +
        "╿▯    ╱|、     ╱|、     ╱|       ╱|        ╱|        ▯╿\n" +
        "╿▯   (˚ˎ 。7  (˚ˎ 。7   (˚ˎ 。7   (˚ˎ 。7   (˚ˎ 。7     ▯╿\n" +
        "╿▯     |、˜〵  |、˜〵   |、˜〵    |、˜〵    |、˜〵     ▯╿\n" +
        "╿▯     じしˍ,)ノ.じしˍ,)ノ. じしˍ,)ノ.  じしˍ,)ノ.  じしˍ,)ノ.  ▯╿\n" +
        "╰━━━━━━━━━━.·:*¨༺ ༻¨*:·..·:*¨༺ ༻¨*:·.━━━━━━━━━━╯" + RESET);
}

    public static void oddEven(Scanner scanner) {
    System.out.println(BLUE_BOLD +
        "   ♡ ∩_∩ \n" +
        "   („• ֊ •„)♡\n" +
        "╭━━━━━U━U ━━━.·:*¨༺ ༻¨*:·..·:*¨༺ ༻¨*:·.━━━━━━━━━━━━━╮            \n" +
        "╿▯                                                      ▯╿            \n" +
        "╿▯   █▀█ █▀▄ █▀▄   █▀█ █▀█   █▀▀ █░█ █▀▀ █▄░█    ▯╿             \n" +
        "╿▯   █▄█ █▄▀ █▄▀   █▄█ █▀▄   ██▄ ▀▄▀ ██▄ █░▀█    ▯╿              \n" +
        "╿▯                                                      ▯╿               \n" +
        "╿▯               █▀▀ █░█ █▀▀ █▀▀ █▄▀                 ▯╿              \n" +
        "╿▯               █▄▄ █▀█ ██▄ █▄▄ █░█                 ▯╿              \n" +
        "╿▯                                                      ▯╿               \n" +
        "╿▯             𝑬𝒏𝒕𝒆𝒓 𝒂𝒏 𝒊𝒏𝒕𝒆𝒈𝒆𝒓:                            ▯╿                        \n" + RESET);
    int num = getIntegerInput(scanner, "                           ");
    boolean isEven = num % 2 == 0;
    System.out.println(BLUE_BOLD +
        "╿▯                                                      ▯╿\n" +
        "╿▯                     𝑹𝒆𝒔𝒖𝒍𝒕:                            ▯╿\n" +
        (isEven
            ? MAGENTA + "╿▯                 " + num + " 𝒊𝒔 𝒆𝒗𝒆𝒏.                     ▯╿" + RESET
            : MAGENTA + "╿▯                 " + num + " 𝒊𝒔 𝒐𝒅𝒅.                      ▯╿" + RESET) + "\n" +
        BLUE_BOLD +
        "╿▯                                                      ▯╿\n" +
        "╿▯    ╱|、   v ╱|、     ╱|      ╱|         ╱|            ▯╿\n" +
        "╿▯   (˚ˎ 。7  (˚ˎ 。7   (˚ˎ 。7   (˚ˎ 。7   (˚ˎ 。7          ▯╿\n" +
        "╿▯     |、˜〵  |、˜〵   |、˜〵    |、˜〵    |、˜〵          ▯╿\n" +
        "╿▯     じしˍ,)ノ.じしˍ,)ノ. じしˍ,)ノ.  じしˍ,)ノ.  じしˍ,)ノ.       ▯╿\n" +
        "╰━━━━━━━━━━━━.·:*¨༺ ༻¨*:·..·:*¨༺ ༻¨*:·.━━━━━━━━━━━━━╯" + RESET);
}

    public static void circleAreaCircumference(Scanner scanner) {
    System.out.println(BLUE_BOLD +
        "   ♡ ∩_∩ \n" +
        "   („• ֊ •„)♡\n" +
        "╭━━━━━U━U ━━━━━━.·:*¨༺ ༻¨*:·..·:*¨༺ ༻¨*:·.━━━━━━━━━━━━━━━━╮            \n" +
        "╿▯                                                            ▯╿            \n" +
        "╿▯    ▄▀█ █▀█ █▀▀ ▄▀█   ▄▀█ █▄░█ █▀▄                     ▯╿             \n" +
        "╿▯    █▀█ █▀▄ ██▄ █▀█   █▀█ █░▀█ █▄▀                     ▯╿              \n" +
        "╿▯                                                            ▯╿               \n" +
        "╿▯█▀▀ █ █▀█ █▀▀ █░█ █▀▄▀█ █▀▀ █▀▀ █▀█ █▀▀ █▄░█ █▀▀ █▀▀ ▯╿              \n" +
        "╿▯█▄▄ █ █▀▄ █▄▄ █▄█ █░▀░█ █▀░ ██▄ █▀▄ ██▄ █░▀█ █▄▄ ██▄ ▯╿              \n" +
        "╿▯                                                            ▯╿               \n" +
        "╿▯    █▀█ █▀▀   ▄▀█   █▀▀ █ █▀█ █▀▀ █░░ █▀▀                                                        ▯╿               \n" +
        "╿▯    █▄█ █▀░   █▀█   █▄▄ █ █▀▄ █▄▄ █▄▄ ██▄                                                        ▯╿               \n" +
        "╿▯                                                            ▯╿               \n" +
        "╿▯               𝑬𝒏𝒕𝒆𝒓 𝒓𝒂𝒅𝒊𝒖𝒔 𝒐𝒇 𝒕𝒉𝒆 𝒄𝒊𝒓𝒄𝒍𝒆:              ▯╿                        \n" + RESET);
    double radius = getDoubleInput(scanner, "                        ");
    double area = Math.PI * radius * radius;
    double circumference = 2 * Math.PI * radius;
    System.out.println(BLUE_BOLD +
        "╿▯                                                      ▯╿\n" +
        "╿▯ " + MAGENTA + "       𝑨𝒓𝒆𝒂: " + String.format("%.2f", area) + BLUE_BOLD + "                      ▯╿\n" +
        "╿▯ " + MAGENTA + "       𝑪𝒊𝒓𝒄𝒖𝒎𝒇𝒆𝒓𝒆𝒏𝒄𝒆: " + String.format("%.2f", circumference) + BLUE_BOLD + "          ▯╿\n" +
        "╿▯                                                      ▯╿\n" +
        "╿▯    ╱|、   v ╱|、     ╱|      ╱|         ╱|            ▯╿\n" +
        "╿▯   (˚ˎ 。7  (˚ˎ 。7   (˚ˎ 。7   (˚ˎ 。7   (˚ˎ 。7          ▯╿\n" +
        "╿▯     |、˜〵  |、˜〵   |、˜〵    |、˜〵    |、˜〵          ▯╿\n" +
        "╿▯     じしˍ,)ノ.じしˍ,)ノ. じしˍ,)ノ.  じしˍ,)ノ.  じしˍ,)ノ.       ▯╿\n" +
        "╰━━━━━━━━━━━━.·:*¨༺ ༻¨*:·..·:*¨༺ ༻¨*:·.━━━━━━━━━━━━━╯" + RESET);
}


    // --- About Us functions ---

     public static void briefDescription(Scanner scanner) {
    System.out.println(BLUE_BOLD +
        "   ♡ ∩_∩ \n" +
        "   („• ֊ •„)♡\n" +
        "╭━━━━━U━U ━━━━━━.·:*¨༺ ༻¨*:·..·:*¨༺ ༻¨*:·.━━━━━━━━━━━━━━━━╮            \n" +
        "╿▯                                                            ▯╿            \n" +
        "╿▯      █▄▄ █▀█ █ █▀▀ █▀▀             ▯╿             \n" +
        "╿▯      █▄█ █▀▄ █ ██▄ █▀░▯╿              \n" +
        "╿▯                                                            ▯╿               \n" +
        "╿▯    █▀▄ █▀▀ █▀ █▀▀ █▀█ █ █▀█ ▀█▀ █ █▀█ █▄░█▯╿              \n" +
        "╿▯    █▄▀ ██▄ ▄█ █▄▄ █▀▄ █ █▀▀ ░█░ █ █▄█ █░▀█▯╿              \n" +
        "╿▯                                                            ▯╿               \n" +
        "╿▯    █▀█ █▀▀  ▀█▀ █░█ █▀▀   █▀█ █▀█ █▀█ ░░█ █▀▀ █▀▀ ▀█▀                                ▯╿               \n" +
        "╿▯    █▄█ █▀░  ░█░ █▀█ ██▄   █▀▀ █▀▄ █▄█ █▄█ ██▄ █▄▄ ░█░▯╿               \n" +
        "╿▯                                                            ▯╿               \n" +
        "╿▯                     ▯╿                        \n" +
        GREEN + "╿▯   This is the final project of GROUP 1 from ICT1M2.           ▯╿\n" +
        "╿▯   This project includes basic calculator functions, unit conversions, and information about the project.   ▯╿\n" +
        BLUE_BOLD +
        "╿▯                                                      ▯╿\n" +
        "╿▯                                                      ▯╿\n" +
        "╿▯    ╱|、   v ╱|、     ╱|      ╱|         ╱|            ▯╿\n" +
        "╿▯   (˚ˎ 。7  (˚ˎ 。7   (˚ˎ 。7   (˚ˎ 。7   (˚ˎ 。7          ▯╿\n" +
        "╿▯     |、˜〵  |、˜〵   |、˜〵    |、˜〵    |、˜〵          ▯╿\n" +
        "╿▯     じしˍ,)ノ.じしˍ,)ノ. じしˍ,)ノ.  じしˍ,)ノ.  じしˍ,)ノ.       ▯╿\n" +
        "╰━━━━━━━━━━━━.·:*¨༺ ༻¨*:·..·:*¨༺ ༻¨*:·.━━━━━━━━━━━━━╯" + RESET);
     }

    public static void developers() {
        System.out.println(BLUE_BOLD + "\n===== Developers =====" + RESET);
        System.out.println(CYAN + "Correos" + RESET);
        System.out.println(CYAN + "Jamer" + RESET);
        System.out.println(CYAN + "Abarientos" + RESET);
        System.out.println(CYAN + "Adriano" + RESET);
        System.out.println(CYAN + "Loren" + RESET);
        System.out.println(CYAN + "Manaog" + RESET);
    }
}
