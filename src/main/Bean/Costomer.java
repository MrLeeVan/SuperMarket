package main.Bean;

import java.io.Serializable;

/**
 * @Author Leevan
 * @Date： 2018/8/17 11:28
 */
public class Costomer implements Serializable {
    private int usrId;
    private String usrname;
    private String password;

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//默认构造方法
    public Costomer(){

    }

    public Costomer(int usrId, String usrname, String password) {
        this.usrId = usrId;
        this.usrname = usrname;
        this.password = password;
    }
}