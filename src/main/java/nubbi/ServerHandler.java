package nubbi;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        final ChannelFuture f = ctx.writeAndFlush(new TestObject(42, "Server says hi"));

        f.addListener(future -> System.out.println("operation complete"));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        final TestObject in = (TestObject) msg;
        System.out.println(in);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
