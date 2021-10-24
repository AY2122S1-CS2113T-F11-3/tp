package seedu.duke;

public class CutClientCommand extends Command {
    private final String clientId;
    private Client client;

    /**
     * Class constructor for CutCommand.
     *
     * @param clientId ID of to-be-deleted client in the client list
     */
    public CutClientCommand(String clientId) {
        this.clientId = clientId;
    }

    /**
     * Executes the deletion of a specific client from client list, corresponding to his/her index in the list.
     */
    @Override
    public void execute() {
        try {
            this.client = clients.getClientById(clientId);
            int newClientCount = clients.getClientCount() - 1;
            ui.showCut(client);
            clients.cut(client);
            assert newClientCount == clients.getClientCount();
            assert newClientCount >= 0;
        } catch (IndexOutOfBoundsException e1) {
            System.out.println("INVALID: Index out of bounds");
        } catch (TourPlannerException e2) {
            System.out.println(e2.getMessage());
        }
    }
}
