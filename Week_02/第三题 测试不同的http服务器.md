1. 单线程在Mac本上40 connection 8 线程在30个左右每秒
2. 多线程在Mac本上40 connection 8 线程在170个左右每秒
3. 池化在Mac本上40 connection 8 线程在160个左右每秒
4. Nio版本47597.45个每秒



## 单线程BIO
```java
package java0.nio01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8801);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                service(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void service(Socket socket) {
        try {
            Thread.sleep(20);
            String      hello       = "hello,nio";
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            printWriter.println("Content-Length:" + hello.length());
            printWriter.println();
            printWriter.write(hello);
            printWriter.close();
            socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

```


```
wrk -c 40 -d30s http://localhost:8801
Running 30s test @ http://localhost:8801
  2 threads and 40 connections
  Thread Stats Avg Stdev Max +/- Stdev
    Latency 934.09ms 104.74ms 1.03s 96.41%
    Req/Sec 17.09 10.17 50.00 66.36%
  892 requests in 30.08s, 85.08KB read
  Socket errors: connect 0, read 1244, write 15, timeout 0
Requests/sec: 29.66
Transfer/sec: 2.83KB
```

## BIO多线程
```java
public class HttpServer02 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8802);
        while (true) {
            try {
                final Socket socket = serverSocket.accept();
                new Thread(() -> {
                    service(socket);
                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

```
```
wrk -c 40 -d30s http://localhost:8802
Running 30s test @ http://localhost:8802
  2 threads and 40 connections
  Thread Stats Avg Stdev Max +/- Stdev
    Latency 28.01ms 10.38ms 212.42ms 94.07%
    Req/Sec 124.97 59.09 500.00 76.01%
  7469 requests in 30.05s, 1.52MB read
  Socket errors: connect 0, read 42320, write 33, timeout 0
Requests/sec: 248.57
Transfer/sec: 51.77KB
```
```
wrk -c 40 -t 8 -d30s http://localhost:8802
Running 30s test @ http://localhost:8802
  8 threads and 40 connections
  Thread Stats Avg Stdev Max +/- Stdev
    Latency 27.06ms 10.10ms 127.00ms 97.02%
    Req/Sec 24.12 15.26 108.00 77.31%
  5403 requests in 30.10s, 1.35MB read
  Socket errors: connect 0, read 44433, write 28, timeout 0
Requests/sec: 179.50
Transfer/sec: 45.81KB
```
## BIO线程池化技术
```
public class HttpServer03 {
    public static void main(String[] args) throws IOException {
        ExecutorService    executorService = Executors.newFixedThreadPool(40);
        final ServerSocket serverSocket    = new ServerSocket(8803);
        while (true) {
            try {
                final Socket socket = serverSocket.accept();
                executorService.execute(() -> service(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

```

```
wrk -c 40 -d30s http://localhost:8803
Running 30s test @ http://localhost:8803
  2 threads and 40 connections
  Thread Stats Avg Stdev Max +/- Stdev
    Latency 24.95ms 7.74ms 128.52ms 95.60%
    Req/Sec 100.39 53.65 430.00 78.08%
  6007 requests in 30.07s, 1.44MB read
  Socket errors: connect 0, read 46773, write 20, timeout 0
Requests/sec: 199.75
Transfer/sec: 49.07KB
```
```
wrk -c 40 -t 8 -d30s http://localhost:8803
Running 30s test @ http://localhost:8803
  8 threads and 40 connections
  Thread Stats Avg Stdev Max +/- Stdev
    Latency 24.79ms 3.94ms 60.53ms 87.29%
    Req/Sec 23.08 16.28 140.00 75.51%
  4987 requests in 30.05s, 1.34MB read
  Socket errors: connect 0, read 47841, write 20, timeout 0
Requests/sec: 165.98
Transfer/sec: 45.67KB
```
## NIO
```
wrk -c 40 -t 8 -d30s http://localhost:8808/test
Running 30s test @ http://localhost:8808/test
  8 threads and 40 connections
  Thread Stats Avg Stdev Max +/- Stdev
    Latency 31.02ms 74.71ms 1.11s 89.49%
    Req/Sec 6.96k 6.52k 35.27k 77.31%
  1431755 requests in 30.08s, 146.10MB read
Requests/sec: 47597.45
Transfer/sec: 4.86MB
```