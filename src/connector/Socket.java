package connector;

public interface Socket {
    int connect(String adress, int port);
    int disconnect();
    int send(String transmission);
    void addTransmissionListener(Object listener);
}
