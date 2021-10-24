package seedu.duke;

import java.util.ArrayList;

public class ClientPackageList {
    private static final String CLIENTPACKAGE_NOT_FOUND_MESSAGE = "Client Package ID cannot be found. Please try another Client Package ID";

    private static ArrayList<ClientPackage> clientPackages;
    private static int clientPackageCount = 0;

    public ClientPackageList() {
        clientPackages = new ArrayList<>();
        clientPackageCount = 0;
    }

    public void add(ClientPackage pack) {
        clientPackageCount++;
        clientPackages.add(pack);
    }

    public ClientPackage get(int index) {
        return clientPackages.get(index);
    }

    public ClientPackage getClientPackageById(String clientPackageId) throws TourPlannerException {
        for (int i = 0; i < clientPackageCount; i++) {
            if (clientPackages.get(i).getId().equals(clientPackageId)) {
                return clientPackages.get(i);
            }
        }
        throw new TourPlannerException(CLIENTPACKAGE_NOT_FOUND_MESSAGE);
    }

    public ArrayList<ClientPackage> getClientPackageByClient(Client client) {
        ArrayList<ClientPackage> clientPackagesWithClient = new ArrayList<>();
        for (int i = 0; i < clientPackageCount; i++) {
            ClientPackage clientPackage = clientPackages.get(i);
            if (clientPackage.getClient().equals(client)) {
                clientPackagesWithClient.add(clientPackage);
            }
        }
        return clientPackagesWithClient;
    }

    public ArrayList<ClientPackage> getClientPackageByTour(Tour tour) {
        ArrayList<ClientPackage> clientPackagesWithTour = new ArrayList<>();
        for (int i = 0; i < clientPackageCount; i++) {
            ClientPackage clientPackage = clientPackages.get(i);
            if (clientPackage.getTour().equals(tour)) {
                clientPackagesWithTour.add(clientPackage);
            }
        }
        return clientPackagesWithTour;
    }

    public ArrayList<ClientPackage> getClientPackageByFlight(Flight flight) {
        ArrayList<ClientPackage> clientPackagesWithFlight = new ArrayList<>();
        for (int i = 0; i < clientPackageCount; i++) {
            ClientPackage clientPackage = clientPackages.get(i);
            if (clientPackage.getFlight().equals(flight)) {
                clientPackagesWithFlight.add(clientPackage);
            }
        }
        return clientPackagesWithFlight;
    }

    public int getClientPackageCount() {
        return clientPackageCount;
    }

    public void cut(ClientPackage clientPackage) {
            clientPackages.remove(clientPackage);
            clientPackageCount--;
    }

}
