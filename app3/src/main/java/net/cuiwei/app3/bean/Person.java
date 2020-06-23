package net.cuiwei.app3.bean;

import java.io.Serializable;

/**
 * Created by work on 2015/11/23.
 */
public class Person implements Serializable {

    private String name;
    private String passwd;
    private String sex;

    public Person(String name, String passwd, String sex)
    {
        this.name = name;
        this.passwd = passwd;
        this.sex =sex;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
