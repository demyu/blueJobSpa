import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class calendarGUI extends JFrame{
    
    private JTextField tbName, tbPass, tbDate, tbNumber;
    private JButton bLogin, bAdd, bAccept, bClear,bSignup, blogout, bDisplay;
    private JComboBox services;
    private JPanel login1, login2, login3, login4, login6, login7,login8,login9, login10, login11, login12, login13, login14,
                    login15, login16;
    private JLabel total, UName, lpass, lDate, lSPA, lNumber, lService, lTotal;
    private String[] SpaStrings = {"Full Body Massage","Honey body polish", "Volcanic rock massage", "Acupuncture", 
    "Sea salt body spa", "Peppermint Foot Rub", "Manicure Pedicure", "Casmara Facial", "Coffee Rub", "Traditional Hilot"};
    private String ComboString;
    private double balance=0;
    private int ctr1, ctr2, ctr3, ctr4, ctr5, ctr6, ctr7, ctr8, ctr9, ctr10, usersCtr=0, idCtr=0, ctrAppointments=0;
    private double FBM=5000, HBP=3000, VRM=10000, AUP=2000, SSBS=1500, PFR=2000, MP=1000, CF=4000, CR=3000, TH=1500;
    public boolean result, result1, panel1E = false, panel2E = true, numberResult;
    private int ctr=0, mm,dd,yy;
    calendar[] accts= new calendar[999999];
    private int currentUser;
    accounts[] users = new accounts[999999];

    public calendarGUI(){

        tbName = new JTextField("", 15);
            tbName.setFont(new Font("Luciana", Font.BOLD, 20));
            tbName.setHorizontalAlignment(JTextField.CENTER);
            tbName.setBackground(Color.GRAY);
            tbName.setForeground(Color.ORANGE);
        UName = new JLabel("Input Name");
            UName.setFont(new Font("Luciana", Font.BOLD, 20));
            UName.setForeground(Color.ORANGE);

        tbPass = new JTextField("",15);
            tbPass.setFont(new Font("Luciana", Font.BOLD, 20));
            tbPass.setHorizontalAlignment(JTextField.CENTER);
            tbPass.setBackground(Color.GRAY);
            tbPass.setForeground(Color.ORANGE);
        lpass = new JLabel("Enter Password");
            lpass.setFont(new Font("Luciana", Font.BOLD, 20));
            lpass.setForeground(Color.ORANGE);

        tbDate = new JTextField("", 10);
            tbDate.setFont(new Font("Luciana", Font.BOLD, 20));
            tbDate.setHorizontalAlignment(JTextField.CENTER);
            tbDate.setBackground(Color.GRAY);
            tbDate.setForeground(Color.ORANGE);
        lDate = new JLabel("Input Date mm/dd/yyyy");
            lDate.setFont(new Font("Signboard", Font.BOLD, 20));
            lDate.setForeground(Color.ORANGE);
        bLogin = new JButton("Login");
            bLogin.setBackground(Color.BLACK);
            bLogin.setFont(new Font("Luciana", Font.BOLD, 20));
            bLogin.setForeground(Color.ORANGE);
            bLogin.addActionListener(new LoginListener());
            bLogin.setEnabled(false);
        bAdd = new JButton("Add");
            bAdd.setBackground(Color.BLACK);
            bAdd.setFont(new Font("Luciana", Font.BOLD, 20));
            bAdd.setForeground(Color.ORANGE);
            bAdd.addActionListener(new ComboListener());
        bAccept = new JButton("Reserve");
            bAccept.setBackground(Color.BLACK);
            bAccept.setFont(new Font("Luciana", Font.BOLD, 20));
            bAccept.setForeground(Color.ORANGE);
            bAccept.addActionListener(new bAcceptListener());
        bClear = new JButton("Clear");
            bClear.addActionListener(new ClearListener());
            bClear.setBackground(Color.BLACK);
            bClear.setFont(new Font("Luciana", Font.BOLD, 20));
            bClear.setForeground(Color.ORANGE);
        services = new JComboBox(SpaStrings);
            services.setBackground(Color.BLACK);
            services.setFont(new Font("Luciana", Font.BOLD, 15));
            services.setForeground(Color.ORANGE);
        lService = new JLabel("Select Services");
            lService.setFont(new Font("Signboard", Font.BOLD, 20));
            lService.setForeground(Color.ORANGE);

        total = new JLabel("0");
            total.setFont(new Font("Luciana", Font.BOLD, 20));
            total.setHorizontalAlignment(JTextField.CENTER);
            total.setBackground(Color.BLACK);
            total.setForeground(Color.ORANGE);
            total.setOpaque(true);
        lTotal = new JLabel("Total Amount");
            lTotal.setFont(new Font("Signboard", Font.BOLD, 20));
            lTotal.setForeground(Color.ORANGE);
        lSPA = new JLabel("Welcome to BLUEJOB SPA");
            lSPA.setFont(new Font("Luciana", Font.BOLD, 50));
            lSPA.setHorizontalAlignment(JTextField.CENTER);
            lSPA.setBackground(Color.BLACK);
            lSPA.setForeground(Color.ORANGE);
            lSPA.setOpaque(true);

        lNumber = new JLabel("Enter cellphone number");
            lNumber.setFont(new Font("Luciana", Font.BOLD, 20));
            lNumber.setForeground(Color.ORANGE);
        tbNumber = new JTextField("",15);
            tbNumber.setFont(new Font("Luciana", Font.BOLD, 20));
            tbNumber.setHorizontalAlignment(JTextField.CENTER);
            tbNumber.setForeground(Color.ORANGE);
            tbNumber.setBackground(Color.GRAY);
            
        bSignup= new JButton("Sign-up");
            bSignup.setFont(new Font("Luciana", Font.BOLD, 20));
            bSignup.setForeground(Color.ORANGE);
            bSignup.setBackground(Color.BLACK);
            bSignup.addActionListener(new signUpListener());

        blogout= new JButton("Log-out");
            blogout.setFont(new Font("Luciana", Font.BOLD, 20));
            blogout.setForeground(Color.ORANGE);
            blogout.setBackground(Color.BLACK);
            blogout.addActionListener(new logoutListener());

        bDisplay= new JButton("See all appointments");
            bDisplay.setFont(new Font("Luciana", Font.BOLD, 20));
            bDisplay.setForeground(Color.ORANGE);
            bDisplay.setBackground(Color.BLACK);
            bDisplay.addActionListener(new displayListener());
        
        login1 = new JPanel(new BorderLayout());
            login9 = new JPanel(new GridLayout(3,1));
                login13 = new JPanel(new FlowLayout());
                login14 = new JPanel(new FlowLayout());
                login15= new JPanel(new FlowLayout());
            login10 = new JPanel(new GridLayout(3,1));
                login12 = new JPanel();
            login11 = new JPanel();
        login4 = new JPanel(new GridLayout(3,1));
                login16 = new JPanel(new FlowLayout());
                //login17 = new JPanel(new FlowLayout());
                //login18= new JPanel(new FlowLayout());
        login2= new JPanel(new FlowLayout());
        login3 = new JPanel(new FlowLayout());
        //login5 = new JPanel(new FlowLayout());
            login6= new JPanel(new FlowLayout());
            login7= new JPanel(new FlowLayout());
            login8= new JPanel(new FlowLayout());
        setLayout(new GridLayout(1,2));

        add(login1);
            login1.add(lSPA, BorderLayout.NORTH);
            login1.add(login9, BorderLayout.WEST);
                login9.add(login13);
                    login13.add(lDate);
                    login13.add(tbDate);
                login9.add(login14);
                    login14.add(lNumber);
                    login14.add(tbNumber);
            login1.add(login10, BorderLayout.CENTER);
                login10.add(login16);
                    login16.add(lService);
                    login16.add(services);
                    login16.add(bAdd);
                login10.add(login2);
                    login2.add(lTotal);
                    login2.add(total);
            login1.add(login11, BorderLayout.SOUTH);
                login11.add(bAccept);
                login11.add(bClear);
                login11.add(blogout);
                login11.add(bDisplay);

            
        add(login4);
            login4.add(login6);
                login6.add(UName);
                login6.add(tbName);
            login4.add(login7);
                login7.add(lpass);
                login7.add(tbPass);
            login4.add(login8);
                login8.add(bLogin);
                login8.add(bSignup);
        
        disabler(panel1E, panel2E);
        //Darkmoder
        login1.setBackground(Color.BLACK);
        login2.setBackground(Color.BLACK);
        login3.setBackground(Color.BLACK);
        login4.setBackground(Color.BLACK);
        login6.setBackground(Color.BLACK);
        login7.setBackground(Color.BLACK);
        login8.setBackground(Color.BLACK);
        login9.setBackground(Color.BLACK);
        login10.setBackground(Color.BLACK);
        login12.setBackground(Color.BLACK);
        login13.setBackground(Color.BLACK);
        login14.setBackground(Color.BLACK);
        login15.setBackground(Color.BLACK);
        login16.setBackground(Color.BLACK);
        login11.setBackground(Color.BLACK);
    }
    

    public class LoginListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            //Login here
            if(loginChecker(users, tbName.getText(), tbPass.getText(), usersCtr)){
               accounts acurr= users[logginIn(users, tbName.getText(), tbPass.getText(), usersCtr)];
               JOptionPane.showMessageDialog(null, "Succesfully Logged in", "BlueJob Spa", JOptionPane.INFORMATION_MESSAGE);
               disabler(true, false);
            }else{
                JOptionPane.showMessageDialog(null, "Username of password does not match", "BlueJob Spa", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }
    public class signUpListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            if(usersCtr==0 && emptyLoginChecker(tbName.getText(), tbPass.getText())){
                accounts acurr = new accounts(tbName.getText(), tbPass.getText());
                users[usersCtr]=acurr;
                usersCtr++;
                JOptionPane.showMessageDialog(null, "Sign up succesfull", "BlueJob Spa", JOptionPane.INFORMATION_MESSAGE);
                bLogin.setEnabled(true);
            }else if(signUpChecker(users, tbName.getText()) && emptyLoginChecker(tbName.getText(), tbPass.getText())){
                accounts acurr = new accounts(tbName.getText(), tbPass.getText());
                users[usersCtr]= acurr;
                usersCtr++;
                JOptionPane.showMessageDialog(null, "Sign up succesfull", "BlueJob Spa", JOptionPane.INFORMATION_MESSAGE);
                lSPA.setText(""+usersCtr);
            }else if(!emptyLoginChecker(tbName.getText(), tbPass.getText())){
            JOptionPane.showMessageDialog(null, "Please input Name and Password", "BlueJob Spa", JOptionPane.INFORMATION_MESSAGE);
            }else{
            JOptionPane.showMessageDialog(null, "Name Already Taken", "BlueJob Spa", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public class ClearListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            clearMethod();
        }
    }
    public class bAcceptListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            result = StringChecker(tbDate.getText(), ctr,mm,dd,yy);
                if (result && balance!=0){
                        result1= takeChecker(accts, ctr, tbDate.getText());
                        if(result1){
                            if(numberLengthChecker(tbNumber.getText())){
                                if(numberChecker(tbNumber.getText())){
                                    calendar curr = new calendar(tbDate.getText(), tbName.getText());
                                    accounts acurr= users[logginIn(users, tbName.getText(), tbPass.getText(), usersCtr)];
                                    curr.addBalance(balance); 
                                    accts[ctr] = curr;
                                    currentUser=ctr;
                                    ctr++;
                                    curr.setID(idCtr);
                                    acurr.setID(idCtr);
                                    curr.setNumber(tbNumber.getText());
                                    JOptionPane.showMessageDialog(null, "Appointment succesfull", "BlueJob Spa", JOptionPane.INFORMATION_MESSAGE);
                                    clearMethod();
                                }else {
                                    JOptionPane.showMessageDialog(null, "Not a number", "BlueJob Spa", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Number not 11 digits", "BlueJob Spa", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                }else 
                    JOptionPane.showMessageDialog(null, "Invalid date/ Please add an order", "BlueJob Spa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public class ComboListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            //JComboBox test =(JComboBox)services.getSource();
            ComboString = (String)services.getSelectedItem();
                if(ComboString.equals("Full Body Massage")){
                    ctr1++;
                }
                if(ComboString.equals("Honey body polish")){
                    ctr2++;
                }
                if(ComboString.equals("Volcanic rock massage")){
                    ctr3++;
                }
                if(ComboString.equals("Acupuncture")){
                    ctr4++;
                }
                if(ComboString.equals("Sea salt body spa")){
                    ctr5++;
                }
                if(ComboString.equals("Peppermint Foot Rub")){
                    ctr6++;
                }
                if(ComboString.equals("Manicure Pedicure")){
                    ctr7++;
                }
                if(ComboString.equals("Casmara Facial")){
                    ctr8++;
                }
                if(ComboString.equals("Coffee Rub")){
                    ctr9++;
                }
                if(ComboString.equals("Traditional Hilot")){
                    ctr10++;
                }
            balance= (ctr1*FBM)+(ctr2*HBP)+(ctr3*VRM)+(ctr4*AUP)+(ctr5*SSBS)+(ctr6*PFR)+(ctr7*MP)+(ctr8*CF)+(ctr9*CR)+(ctr10*TH);
            total.setText(Double.toString(balance));
        }
    }

    public class displayListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            accounts acurr= users[logginIn(users, tbName.getText(), tbPass.getText(), usersCtr)];

            if(ctr == 0){
                JOptionPane.showMessageDialog(null, "No appointments found", "BlueJob Spa", JOptionPane.INFORMATION_MESSAGE);
            }else{
                for(int x=0; x<ctr; x++){
                    calendar curr = accts[x];
                    if(curr.getID() == acurr.getID()){
                        JOptionPane.showMessageDialog(null, "Date: "+curr.dateGetString()+ " To be payed: " + curr.getBalance() ,"BlueJob Spa", JOptionPane.INFORMATION_MESSAGE);
                        ctrAppointments++;
                    }
                }
                if (ctrAppointments==0){
                    JOptionPane.showMessageDialog(null, "No appointments found", "BlueJob Spa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }


    //////////////////////////////////////////////////////////
    public static boolean takeChecker(calendar[] accts , int ctr, String i){
        if(ctr ==0)
            return true;

        for(int r = 0; r<ctr; r++){
            if(accts[r].dateGetString().equals(i)){
                JOptionPane.showMessageDialog(null, "Date already taken/Please add an order","BlueJob Spa", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public static boolean StringChecker(String i, int ctr, int mm, int dd, int yy){
        boolean result2= true;
        int digitCounter=0;
        int backSlashCounter=0;
        for(int x=0; x<i.length(); x++){
            if(Character.isLetter(i.charAt(x))){
                result2 =false;
                break;
            }
            if(Character.isDigit(i.charAt(x))){
                digitCounter++;
            }
            
            if(i.charAt(x) == '/'){
                 backSlashCounter++;
            }

            if(digitCounter==8 && backSlashCounter == 2){
                result2 =true;
            }else 
                result2 = false;
        }
        if(result2){
            //Divides the date for date checking
            String month = Character.toString(i.charAt(0))+ Character.toString(i.charAt(1));
            mm =Integer.parseInt(month);
            String day = Character.toString(i.charAt(3)) + Character.toString(i.charAt(4));
            dd = Integer.parseInt(day);
            String year = Character.toString(i.charAt(6))+ Character.toString(i.charAt(7))
                          +Character.toString(i.charAt(8))+Character.toString(i.charAt(9));
            yy = Integer.parseInt(year);

            if(mm<=12 && dd<=31 && yy>2018){
                if((mm == 1 || mm== 3 || mm==5 || mm==7 || mm==8 || mm==10 || mm ==12 ) && dd<=31){
                    return true;
                //Method Feb
                } else if(mm == 2 && isLeapYear(yy) && dd <=29){
                    return true;
                }else if(mm == 2 && dd<=28){
                    return true;
                }else if((mm== 4|| mm==6|| mm == 9|| mm==11) && dd<=30){
                    return true;
                }else 
                    return false;
            }else 
                return false;
        }else{
            JOptionPane.showMessageDialog(null, "Invalid Format","BlueJob Spa", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    public void clearMethod(){
            tbDate.setText("");
            tbNumber.setText("");
            total.setText("0");
            ctr1=ctr2=ctr3=ctr4=ctr5=ctr6=ctr7=ctr8=ctr9=ctr10=0;
    }

    //Clears current user and fields
    public class logoutListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            idCtr++;
            clearMethod();
            disabler(false, true);
        }
    }

    //Disables/Enable Login-Logout panel
    public void disabler(boolean x, boolean y){
        tbDate.setEnabled(x);
        tbNumber.setEnabled(x);
        bAccept.setEnabled(x); 
        services.setEnabled(x); 
        bClear.setEnabled(x);
        bAdd.setEnabled(x);
        blogout.setEnabled(x);
        bDisplay.setEnabled(x);
        tbName.setEnabled(y);
        tbPass.setEnabled(y);
        bLogin.setEnabled(y);
        bSignup.setEnabled(y);

    }

    //Checks if February is LeapYear
    public static boolean isLeapYear(int year) {
        if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0)){
            return true;
        }else{
            return false;
        }
    }

    public boolean emptyLoginChecker(String p, String y){
        if(p.length() >0 && y.length()>0){
            return true;
        }
        return false;
    }
    public boolean signUpChecker(accounts[] users,String x){
        for(int y=0; y<usersCtr; y++){
            if(users[y].getName().equals(x)){
                return false;
            }
        }
        return true;
    }
    //Checks if name and password are correct
    public boolean loginChecker(accounts[] users,String u, String q, int userCtr){
        for(int h=0; h<userCtr; h++){
            if(users[h].getName().equals(u) && users[h].getPassword().equals(q)){
                return true;
            }
        }
        return false;
    }

    public int logginIn(accounts[] users,String u, String q, int userCtr){
        for(int h=0; h<userCtr; h++){
            if(users[h].getName().equals(u) && users[h].getPassword().equals(q)){
                return h;
            }
        }
        return 0;
    }

    public boolean numberChecker(String number){
        for(int x = 0; x<number.length(); x++){
            if(Character.isLetter(x)){
                return false;
            }
        }
        return true;
    }

    //Checks if number is eleven digits
    public boolean numberLengthChecker(String number){
        if(number.length() ==11){
            return true;
        }
        return false;
    }
}

