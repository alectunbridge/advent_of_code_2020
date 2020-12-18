package advent_of_code_2020;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayTwelve {

    public static final String LEFT = "L";
    public static final String RIGHT = "R";
    static long directionCount = 0;
    static long shipEasting = 0;
    static long shipSouthing = 0;
    static long waypointEasting = 10;
    static long waypointSouthing = -1;

    public static void main(String[] args) {
        List<String> commands = new ArrayList<>();
        try {
            File file = new File(DayTwelve.class.getClassLoader().getResource("day_twelve.txt").getFile());
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                commands.add(line);
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        for (String command : commands) {
            String directionAction = String.valueOf(command.charAt(0));
            int valueToMove = Integer.parseInt(command.substring(1));

            if (directionAction.equals("L") || directionAction.equals("R")) {
                rotateWaypoint(directionAction, valueToMove);
            }

            if (directionAction.equals("F")) {
                moveShip(valueToMove);
            }
            if (directionAction.equals("E")) {
                waypointEasting += valueToMove;
            }
            if (directionAction.equals("S")) {
                waypointSouthing += valueToMove;
            }
            if (directionAction.equals("W")) {
                waypointEasting -= valueToMove;
            }
            if (directionAction.equals("N")) {
                waypointSouthing -= valueToMove;
            }
        }

        System.out.printf("ship: %d, %d\n", shipEasting, shipSouthing);
        System.out.printf("waypoint: %d, %d\n", waypointEasting, waypointSouthing);

        directionCount = Math.abs(shipEasting) + Math.abs(shipSouthing);
        System.out.println(directionCount);
    }

    private static void moveShip(int numberOfMoves) {
        shipEasting += numberOfMoves*waypointEasting;
        shipSouthing += numberOfMoves*waypointSouthing;
    }

    private static void rotateWaypoint(String directionChange, int valueToMove) {
        for(int i=0; i<valueToMove/90; i++) {
            long tempWaypointEasting=waypointEasting;
            long tempWaypointSouthing=waypointSouthing;
            switch (directionChange) {
                case LEFT:
                    waypointEasting = tempWaypointSouthing;
                    waypointSouthing = -tempWaypointEasting;
                    break;
                case RIGHT:
                    waypointEasting = -tempWaypointSouthing;
                    waypointSouthing = tempWaypointEasting;
                    break;
                default:
                    throw new IllegalArgumentException(String.format("erm wasn't expecting direction of: %s", directionChange));
            }
        }
    }

    //23986 too low
    //30388 too low
}