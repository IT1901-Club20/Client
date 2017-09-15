import connector.*;

public class main {
    public static void main(String[] args){
        tcpSocketHandler s;
        s = new tcpSocketHandler("127.0.0.1", 1337);
        s.send("Hei på deg");
        s.disconnect();
    }
}
