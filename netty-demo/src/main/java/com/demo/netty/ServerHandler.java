package com.demo.netty;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
  
@Component  
@Qualifier("serverHandler")  
@Sharable  
public class ServerHandler extends SimpleChannelInboundHandler<String> {  
  
    private static final Logger log = LoggerFactory.getLogger(ServerHandler.class);  

      
    @Override  
    public void messageReceived(ChannelHandlerContext ctx, String msg)  
            throws Exception {  
        log.info("client msg:"+msg);  
//添加处理请求的逻辑
    }  
    @Override  
    public void channelActive(ChannelHandlerContext ctx) throws Exception {  
          
        log.info("RamoteAddress : " + ctx.channel().remoteAddress() + " active !");  
          
//        ctx.channel().writeAndFlush( "Welcome to " + InetAddress.getLocalHost().getHostName() + " service!\n");  
        ctx.channel().writeAndFlush("connect success");
          
        super.channelActive(ctx);  
    }  
      
  
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {  
        cause.printStackTrace();  
//        System.out.println(cause.getMessage());
        ctx.close();  
    }  
  
    @Override  
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {  
        log.info("\nChannel is disconnected");  
        super.channelInactive(ctx);  
    }  

    private double getdistance(double lat1,double lon1,double lat2,double lon2) {
        float earth_radius=6378.137f;
        double a=Math.toRadians(lat1)-Math.toRadians(lat2);
        double b=Math.toRadians(lon1)-Math.toRadians(lon2);
        double distance=2*Math.asin(Math.sqrt(Math.pow(Math.sin(a/2), 2)+Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2))*Math.pow(Math.sin(b/2), 2)))
                *earth_radius;
        return distance;
    }
}