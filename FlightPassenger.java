import java.util.*;


class Flight {
    String pId;
    String process;
    int startTime;
    String priority;

    public Flight(String pId, String process, int startTime, String priority) {
        this.pId = pId;
        this.process = process;
        this.startTime = startTime;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return pId + "\t" + process + "\t" + startTime + "\t" + priority;
    }
}

class FlightComparator implements Comparator<Flight> {
    private int sortBy;

    public FlightComparator(int sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public int compare(Flight flight1, Flight flight2) {
        switch (sortBy) {
            case 1:
                return flight1.pId.compareTo(flight2.pId);
            case 2:
                return Integer.compare(flight1.startTime, flight2.startTime);
            case 3:
                return flight1.priority.compareTo(flight2.priority);
            default:
                return 0;
        }
    }
}


public class FlightPassenger {
    public static void main(String[] args) {
        List<Flight> flightList = new ArrayList<>();
        flightList.add(new Flight("P1", "VSCODE", 100, "MID"));
        flightList.add(new Flight("P23", "Eclipse", 234, "MID"));
        flightList.add(new Flight("P93", "Chrome", 189, "High"));
        flightList.add(new Flight("P42", "JDK", 9, "High"));
        flightList.add(new Flight("P9", "CMD", 7, "High"));
        flightList.add(new Flight("P87", "Notepad", 23, "Low"));

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose sorting parameter:");
        System.out.println("1. Sort by P_ID");
        System.out.println("2. Sort by Start Time");
        System.out.println("3. Sort by Priority");
        int sortBy = sc.nextInt();

        Collections.sort(flightList, new FlightComparator(sortBy));

        System.out.println("Sorted Flight Table:");
        System.out.println("P_ID\tProcess\tStart Time\tPriority");
        for (Flight flight : flightList) {
            System.out.println(flight);
        }
    }
}
