package ngrok.model;

import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class OuterLink {

    private String url;
    private Socket outerSocket;
    private Socket controlSocket;
    private BlockingQueue<Socket> proxySocketQueue = new LinkedBlockingQueue<>();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Socket getOuterSocket() {
        return outerSocket;
    }

    public void setOuterSocket(Socket outerSocket) {
        this.outerSocket = outerSocket;
    }

    public Socket getControlSocket() {
        return controlSocket;
    }

    public void setControlSocket(Socket controlSocket) {
        this.controlSocket = controlSocket;
    }

    public Socket pollProxySocket(long timeout, TimeUnit unit) throws InterruptedException {
        return proxySocketQueue.poll(timeout, unit);
    }

    public void putProxySocket(Socket proxySocket) throws InterruptedException {
        proxySocketQueue.put(proxySocket);
    }
}
