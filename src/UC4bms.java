import java.util.HashMap;
import java.util.Map;

public class UC4bms {

    /**
     * CLASS - Room
     * Defines static characteristics of a room.
     */
    static class Room {
        private String type;
        private int beds;
        private int size;
        private double pricePerNight;

        public Room(String type, int beds, int size, double pricePerNight) {
            this.type = type;
            this.beds = beds;
            this.size = size;
            this.pricePerNight = pricePerNight;
        }

        public String getType() { return type; }
        public int getBeds() { return beds; }
        public int getSize() { return size; }
        public double getPricePerNight() { return pricePerNight; }
    }

    /**
     * CLASS - RoomInventory
     * Acts as the single source of truth for room availability.
     */
    static class RoomInventory {
        private Map<String, Integer> roomAvailability;

        public RoomInventory() {
            roomAvailability = new HashMap<>();
            // Initializing data as per Use Case 3 & 4
            roomAvailability.put("Single", 5);
            roomAvailability.put("Double", 3);
            roomAvailability.put("Suite", 2);
        }

        public Map<String, Integer> getRoomAvailability() {
            return roomAvailability;
        }
    }

    /**
     * CLASS - RoomSearchService
     * Use Case 4: Provides read-only search functionality.
     */
    static class RoomSearchService {
        /**
         * Displays available rooms along with their details and pricing.
         * Performs read-only access to inventory and room data.
         */
        public void searchAvailableRooms(RoomInventory inventory, Room singleRoom, Room doubleRoom, Room suiteRoom) {
            Map<String, Integer> availability = inventory.getRoomAvailability();

            System.out.println("Room Search\n");

            // Check and display Single Room availability
            if (availability.getOrDefault("Single", 0) > 0) {
                displayRoomDetails(singleRoom, availability.get("Single"));
            }

            // Check and display Double Room availability
            if (availability.getOrDefault("Double", 0) > 0) {
                displayRoomDetails(doubleRoom, availability.get("Double"));
            }

            // Check and display Suite Room availability
            if (availability.getOrDefault("Suite", 0) > 0) {
                displayRoomDetails(suiteRoom, availability.get("Suite"));
            }
        }

        private void displayRoomDetails(Room room, int count) {
            System.out.println(room.getType() + ":");
            System.out.println("Beds: " + room.getBeds());
            System.out.println("Size: " + room.getSize() + " sqft");
            System.out.println("Price per night: " + room.getPricePerNight());
            System.out.println("Available: " + count);
            System.out.println();
        }
    }

    /**
     * MAIN CLASS - UseCase4RoomSearch
     * Entry point of the application.
     */
    public static void main(String[] args) {
        // 1. Setup Inventory
        RoomInventory inventory = new RoomInventory();

        // 2. Define Room Objects
        Room singleRoom = new Room("Single Room", 1, 250, 1500.0);
        Room doubleRoom = new Room("Double Room", 2, 400, 2500.0);
        Room suiteRoom = new Room("Suite Room", 3, 750, 5000.0);

        // 3. Initialize Search Service
        RoomSearchService searchService = new RoomSearchService();

        // 4. Perform Search (Read-only access)
        searchService.searchAvailableRooms(inventory, singleRoom, doubleRoom, suiteRoom);
    }
}