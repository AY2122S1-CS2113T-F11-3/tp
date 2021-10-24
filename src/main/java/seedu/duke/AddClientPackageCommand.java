package seedu.duke;

public class AddClientPackageCommand extends Command {
    private ClientPackage clientPackage;
    private String[] rawClientPackage;

    public AddClientPackageCommand(String[] rawClientPackage) {
        this.rawClientPackage = rawClientPackage;
    }

    @Override
    public void execute() {
        createClientPackage();
        clientPackages.add(clientPackage);
        ui.showAddClientPackage(clientPackage);
    }

    private void createClientPackage() {
        try {
            String clientPackageId = rawClientPackage[0];
            String clientId = rawClientPackage[1];
            String tourCode = rawClientPackage[2];
            String flightId = rawClientPackage[3];
            Client client = extractClient(clientId);
            Tour tour = extractTour(tourCode);
            Flight flight = extractFlight(flightId);
            clientPackage = new ClientPackage(clientPackageId, client, tour, flight);
        } catch (TourPlannerException e) {
            System.out.println(e.getMessage());
        }
    }

    private Client extractClient(String clientId) throws TourPlannerException {
        return clients.getClientById(clientId);
    }

    private Tour extractTour(String tourCode) throws TourPlannerException {
        return tours.getTourByCode(tourCode);
    }

    private Flight extractFlight(String flightId) throws TourPlannerException {
        return flights.getFlightById(flightId);
    }

    private static int stringToInt(String params) {
        int clientIndex = Integer.parseInt(params);
        return clientIndex;
    }

}
