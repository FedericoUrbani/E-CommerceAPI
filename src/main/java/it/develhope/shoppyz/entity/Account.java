package it.develhope.shoppyz.entity;

public class Account {
    private int id;
    private String name;
    private String password;
    private byte sellsactivation;
    private byte enabled;
    private String email;

    public Account(int id, String name, String password, byte sellsactivation, byte isenabled, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sellsactivation = sellsactivation;
        this.enabled = isenabled;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sellsactivation=" + sellsactivation +
                ", enabled=" + enabled +
                ", mail='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getSellsactivation() {
        return sellsactivation;
    }

    public void setSellsactivation(byte sellsactivation) {
        this.sellsactivation = sellsactivation;
    }

    public byte getEnabled() {
        return enabled;
    }

    public void setEnabled(byte enabled) {
        this.enabled = enabled;
    }


    public String getMail() {
        return email;
    }

    public void setMail(String mail) {
        this.email = email;
    }
}


