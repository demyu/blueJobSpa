public class calendar{
    private String date, Name;
    private double balance;
    private int ID;
    private String number;
    
    public calendar(String date, String Name){

        this.date=date;
        this.Name=Name;
        balance=0;
    }

    public String dateGetString(){
        return date;
    }
    public void addBalance(double x){
        balance +=x;
    }

    public void setID(int x){
        ID= x;
    }

    public int getID(){
        return ID;
    }

    public void setNumber(String x){
        number = x;
    }

    public double getBalance(){
        return balance;
    }
}

    
