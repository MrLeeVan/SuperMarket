package main.Utils;

import main.Bean.Costomer;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/9/3 17:17
 */
public class CostomerIO implements Serializable{
    private static List<Costomer> costomers = new ArrayList<>();
    private static final String USER_FILE = "user.obj";

    //写入用户数据
    public boolean writeCostomers() throws BusinessException {
        try {
            ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream( USER_FILE ) );
            out.writeObject( costomers );
            out.close();

        } catch (IOException e) {
            throw new BusinessException( "io.write.error" );
        }
        return true;
    }

    //读取用户数据
    public boolean readCostomers() throws BusinessException {
        try {
            ObjectInputStream in = new ObjectInputStream( new FileInputStream( USER_FILE ) );
            costomers = (List<Costomer>) in.readObject();
            in.close();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            throw new BusinessException( "io.read.error" );
        }
    }
    //添加用户
    public void add(Costomer costomer) {
        costomer.setUsrId( costomers.size() + 1 );
        costomers.add( costomer );
    }

    //查询用户
    public  Costomer findByUsernameAndPassword(String username, String password){
        for( Costomer u: costomers){
            if( username.equals( u.getUsername())&&password .equals(u.getPassword())){
            return u;
            }
        }
        return null;
    }
}
