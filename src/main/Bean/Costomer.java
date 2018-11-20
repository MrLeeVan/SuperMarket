package main.Bean;

import java.io.Serializable;

/**
 * @Author Leevan
 * @Date： 2018/8/17 11:28
 */
public class Costomer implements Serializable {
    private int usrId;
    private String username;
    private String password;

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//默认构造方法

    public Costomer(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Costomer(int usrId, String username, String password) {
        this.usrId = usrId;
        this.username = username;
        this.password = password;
    }
}