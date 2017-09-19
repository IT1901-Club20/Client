package connector;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class tcpSocketHandler implements Socket {
    String adress;
    int port;
    java.net.Socket s;
    DataInputStream responses;
    DataOutputStream toSend;

    /**
     * @param inAdress
     * @param inPort
     */
    public tcpSocketHandler(String inAdress, int inPort){
        try{
            s = new java.net.Socket(inAdress, inPort);
            toSend = new DataOutputStream(s.getOutputStream());
        }
        catch (IOException e){
            System.out.println("Socket fail to initilize");
        }
    }


    @Override
    public int connect(String adress, int port) {
        return 0;
    }

    @Override
    public int disconnect() {
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int send(String transmission) {
        try{
            toSend.writeUTF((transmission + String.valueOf(s.getLocalSocketAddress())));
        }
        catch (IOException e){
            System.out.println("Transmission failed");
        }
        return 0;
    }

    @Override
    public void addTransmissionListener(Object listener) {

    }
}
