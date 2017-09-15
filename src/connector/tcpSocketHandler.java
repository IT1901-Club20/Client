package connector;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.stream.Stream;

public class tcpSocketHandler implements socket{
    String adress;
    int port;
    Socket s;
    DataInputStream responses;
    DataOutputStream toSend;

    /**
     * @param inAdress
     * @param inPort
     */
    public tcpSocketHandler(String inAdress, int inPort){
        try{
            s = new Socket(inAdress, inPort);
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
