package ownersAndAnimals;

public class Connector {

    private String url = "jdbc:oracle:thin:@dbserver.mif.pg.gda.pl:1521:ORACLEMIF";
    private String user = "MAGWOL_P";
    private String password = "x2TLw";

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
