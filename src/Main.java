import net.Server;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.buffer.SimpleBufferAllocator;
import tools.printer.FilePrinter;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            FilePrinter.setAllowColor(Boolean.parseBoolean(args[0]));
        }
        IoBuffer.setUseDirectBuffer(false);     // join IO operations performed by lxconan
        IoBuffer.setAllocator(new SimpleBufferAllocator());

        Server.getInstance().init();

    }
}