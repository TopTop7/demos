import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            //创建服务端socket
            serverSocket = new ServerSocket(8080);
            //等待客户端请求，并获取客户端socket
            socket = serverSocket.accept();
            outputStream = socket.getOutputStream();
            outputStream.write("HTTP/1.1 200 OK\n".getBytes());
            outputStream.write("Content-Type: text/html; charset=utf-8\n".getBytes());
            outputStream.write("\n\n".getBytes());

            outputStream.write(("<html><body>哈哈哈哈哈哈</body></html>\n").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
