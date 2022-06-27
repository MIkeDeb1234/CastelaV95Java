package net.server;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public abstract class AbstractServer {
    private final IoAcceptor acceptor;
    private final int port;


    protected AbstractServer(int port) {
        this.port = port;
        this.acceptor = new NioSocketAcceptor();
    }
    public void start()
    {
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 30);

    }
}
