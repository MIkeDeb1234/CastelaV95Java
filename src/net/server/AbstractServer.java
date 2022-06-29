package net.server;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import tools.printer.FilePrinter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public abstract class AbstractServer {
    private final IoAcceptor acceptor;
    private final int port;


    protected AbstractServer(int port) {
        //Set the server port
        this.port = port;
        //Assign a new acceptor
        this.acceptor = new NioSocketAcceptor();
    }
    public void start()
    {
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 30);
        try {
            acceptor.bind(new InetSocketAddress(port));
        } catch (IOException e) {
            FilePrinter.error(e);
        }

    }
}
