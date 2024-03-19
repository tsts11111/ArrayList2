package org.example;




import java.util.*;


public class Event {
    private String eventID;
    private String eventName;
    private String eventVenue;
    private Date eventDate;
    private List<Attendee> eventAttendees=new ArrayList<>();
    private final int capacity = 200;
    HashMap<String, Attendee> seatDetails = new HashMap<>(capacity, 0.6F);

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public List<Attendee> getEventAttendees() {
        return eventAttendees;
    }

    public void setEventAttendees(List<Attendee> eventAttendees) {
        this.eventAttendees = eventAttendees;
    }
    public void getSeatDetails(String seatNo){
        int flag = 0;
        for (Map.Entry<String, Attendee> entry : seatDetails.entrySet()) {
            if (entry.getKey().equals(seatNo)) {
                flag = 1;
                System.out.println("Seat No: " + entry.getKey() + ", Attendee: " + entry.getValue().getName());
            }
        }
        if (flag == 0) {
            System.out.println("Seat not found.");
        }
    }
    public void setSeatDetails(String seatNo, Attendee attendee){
        seatDetails.put(seatNo, attendee);
    }

    public void organizeEvent(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Attendee");
            System.out.println("2. Remove Attendee");
            System.out.println("3. Update Attendee");
            System.out.println("4. Find Attendee");
            System.out.println("5. Display Total Number of Attendees");
            System.out.println("6. Get seat details");
            System.out.println("7. Handle complementary passes");
            System.out.println("8. Handle performances");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Attendee Name to Add: ");
                    String attendeeToAdd = scanner.next();
                    System.out.print("Enter the email of attendee: ");
                    String email = scanner.next();
                    System.out.print("Enter the phone of attendee: ");
                    String phone = scanner.next();
                    System.out.print("Enter the address of attendee: ");
                    String address = scanner.next();
                    System.out.println("Enter the seat number of attendee: ");
                    String seatNo = scanner.next();
                    eventAttendees.add(new Attendee(attendeeToAdd,email,phone,address,seatNo));
                    System.out.println("Attendee added successfully.");
                    break;
                case 2:
                    System.out.print("Enter Attendee Name to Remove: ");
                    String attendeeToRemove = scanner.next();
                    if (eventAttendees.removeIf(attendees -> attendees.getName().equals(attendeeToRemove))) {
                        System.out.println("Attendee removed successfully.");
                    } else {
                        System.out.println("Attendee not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Attendee Name to Update: ");
                    String attendeeToUpdate = scanner.next();
                    for (Attendee attendee : eventAttendees) {
                        if (attendee.getName().equals(attendeeToUpdate)) {
                            System.out.print("Enter the new name of attendee: ");
                            String updatedName = scanner.next();
                            attendee.setName(updatedName);
                            System.out.print("Enter the new email of attendee: ");
                            String updatedEmail = scanner.next();
                            attendee.setEmail(updatedEmail);
                            System.out.print("Enter the new phone of attendee: ");
                            String updatedPhone = scanner.next();
                            attendee.setPhone(updatedPhone);
                            System.out.print("Enter the new address of attendee: ");
                            String updatedAddress = scanner.next();
                            attendee.setAddress(updatedAddress);
                            System.out.print("Enter the new seat number of attendee: ");
                            String updatedSeatNo = scanner.next();
                            attendee.setSeatNo(updatedSeatNo);
                            System.out.println("Attendee updated successfully.");
                            break;
                        }else {
                            System.out.println("Attendee not found.");
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter Attendee Name to Find: ");
                    String attendeeToFind = scanner.next();
                    if (eventAttendees.stream().anyMatch(attendees -> attendees.getName().equals(attendeeToFind))) {
                        System.out.println(attendeeToFind + " is attending the event.");
                    } else {
                        System.out.println(attendeeToFind + " is not attending the event.");
                    }
                    break;
                case 5:
                    System.out.println("Total number of attendees: " + eventAttendees.size());
                    break;
                case 6:
                    System.out.println("Enter the seat number to get details: ");
                    String seatNum = scanner.next();
                    getSeatDetails(seatNum);
                    break;
                case 7:
                    HandleComplementaryPasses handleComplementaryPasses = new HandleComplementaryPasses();
                    handleComplementaryPasses.handleComplementaryPasses();
                    break;
                case 8:
                    HandlePerformances handlePerformances = new HandlePerformances();
                    handlePerformances.handlePerformances();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);
    }





    public Event() {
    }
}
