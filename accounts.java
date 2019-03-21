public class accounts{
    private String name;
    private String password;
    private int ID;


    public accounts(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public void setID(int x){
        ID = x;
    }

    public int getID(){
        return ID;
    }
}