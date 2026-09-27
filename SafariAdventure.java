import java.util.Random;
import java.util.Scanner;

public class SafariAdventure {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int totalPoints = 0;

        System.out.println("Welcome to Safari Adventure!");

        for (int day = 1; day <= 5; day++) {

            System.out.println("\nDay " + day);

            int dayPoints = 0;

            String area;

            do {
                System.out.print(
                    "Where would you like to explore? "
                    + "(Jungle, River, Desert, Mountains): "
                );

                area = input.nextLine();

                if (!area.equalsIgnoreCase("Jungle") &&
                    !area.equalsIgnoreCase("River") &&
                    !area.equalsIgnoreCase("Desert") &&
                    !area.equalsIgnoreCase("Mountains")) {

                    System.out.println(
                        "Invalid area. Please choose again."
                    );
                }

            } while (!area.equalsIgnoreCase("Jungle") &&
                     !area.equalsIgnoreCase("River") &&
                     !area.equalsIgnoreCase("Desert") &&
                     !area.equalsIgnoreCase("Mountains"));

            System.out.println("You chose: " + area);
            System.out.println("Exploring " + area + "...");

            int eventCount = 0;

            while (eventCount < 3) {

                eventCount++;

                int event = random.nextInt(5) + 1;

                System.out.println("\nEvent " + eventCount + ":");

                if (event == 1) {
                    System.out.println(
                        "You spotted a harmless bird. Moving on."
                    );

                    continue;
                }

                if (event == 2) {
                    System.out.println(
                        "You found edible berries! (+15 points)"
                    );

                    dayPoints += 15;
                }

                if (event == 3) {
                    System.out.println(
                        "You found a rare plant! (+25 points)"
                    );

                    dayPoints += 25;
                }

                if (event == 4) {
                    System.out.println(
                        "Bad Weather! (-10 Points)"
                    );

                    dayPoints -= 10;

                    if (dayPoints < 0) {
                        dayPoints = 0;
                    }
                }

                if (event == 5) {
                    System.out.print(
                        "A lion appears! Type 'run' to escape: "
                    );

                    String action = input.nextLine();

                    if (action.equalsIgnoreCase("run")) {
                        System.out.println(
                            "You escaped safely, ending the day early."
                        );

                        break;
                    }
                }

                if (dayPoints >= 30) {
                    System.out.println(
                        "You collected enough resources for today!"
                    );

                    break;
                }
            }

            totalPoints += dayPoints;

            System.out.println(
                "Day Summary: " + dayPoints + " points earned."
            );

            System.out.println("-----------------------------------");
        }


        if (totalPoints >= 100) {

            System.out.println("You survived and completed the adventure!");

        } else {

            System.out.println("You survived, but did not collect enough points.");
        }


        System.out.println("Safari Complete!");
        System.out.println("You collected: " + totalPoints + " points!");

        input.close();
    }
}