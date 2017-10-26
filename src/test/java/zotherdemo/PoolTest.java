package zotherdemo;

import com.busi.domain.User;
import com.zotherdemo.SocketPool;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zzy on 2017/9/25.
 */
public class PoolTest {
    public static void main(String[] args) throws Exception{

//        LinkedList<User> list = new LinkedList<>();
//        for(int i=0;i<5;i++){
//            User user = new User();
//            user.setId(Long.parseLong(i+""));
//            user.setRealname("张"+i);
//            list.add(user);
//        }
//
//        User user = null;
//        System.out.println("before size: "+list.size());
//        user = list.removeFirst();
//
//        list.add(user);
//        System.out.println("after size: "+list.size());
//
//        for(User u: list){
//            System.out.println("id: "+u.getId()+" "+u.toString());
//        }


        int count = 10000;

        SocketPool pool = new SocketPool();
//        pool.initSocketPool();
//        Long begin = System.currentTimeMillis();
//        for(int i=0;i<count;i++){
//            //获取socket
//            Socket socket = pool.getSocket();
//            //发送消息
//            pool.send(socket,("message "+i).getBytes());
//            //释放socket
//            pool.releaseSocket(socket);
//        }
//        System.out.println("连接池发送10000次耗时"+(System.currentTimeMillis() - begin)+" ms");

        Long t1 = System.currentTimeMillis();
        for(int i=0;i<count;i++){
            //获取socket
            Socket socket = pool.createSingleSocket();
            //发送消息
            pool.send(socket,("message "+i).getBytes());
            if(null != socket){
                socket.close();
            }
        }
        System.out.println("普通发送10000次耗时"+(System.currentTimeMillis() - t1)+" ms");


        ServerSocket serverSocket = new ServerSocket();
    }

}
