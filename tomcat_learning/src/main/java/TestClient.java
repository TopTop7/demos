import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 模拟客户端获取服务端数据
 */
public class TestClient {
    public static void main(String[] args) {
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            socket = new Socket("www.imooc.com", 80);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            outputStream.write("GET /article HTTP/1.1 \n".getBytes());
            outputStream.write("HOST:www.imooc.com\n".getBytes());
            outputStream.write("\n".getBytes());
            int i = 0;
            while ((i = inputStream.read()) > 0) {
                System.out.print((char) i);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != socket) {
                    socket.close();
                    socket = null;
                }
                if (null != inputStream) {
                    inputStream.close();
                    inputStream = null;
                }
                if (null != outputStream) {
                    outputStream.close();
                    outputStream = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

