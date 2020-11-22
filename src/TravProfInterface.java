import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Struct;
import java.util.Scanner;

public class TravProfInterface {

    static TravProfDB db;

    private JFrame mainFrame;
    private JLabel p_title,status_label,p1_title,p1_lb1,p1_lb2,p1_lb3,p1_lb4,p1_lb5,p1_lb6,p1_lb7,p1_lb8,p1_lb9,p1_lb10,p1_lb11,p1_lb12,p2_title,p2_lb1,p2_lb2,p3_title,p3_statuslb,p4_title,p4_lb1,p4_lb2;
    private JLabel p5_title,p5_lb1,p5_lb2,p5_lb3,p5_lb4,p5_lb5,p5_lb6,p5_lb7,p5_lb8,p5_lb9,p5_lb10,p5_lb11,p5_lb12;
    private JLabel p6_title,p6_lb1,p6_lb2,p6_lb3,p7_title,p7_lb1,p7_lb2,p7_lb3;
    private JLabel p8_title,p8_lb1,p8_lb2,p8_lb3,p8_lb4,p8_lb5,p8_lb6,p8_lb7,p8_lb8,p8_lb9,p8_lb10,p8_lb11,p8_lb12;
    private JLabel p9_title,p9_lb1;
    private JPanel p,p1,p2,p3,p4,p5,p6,p7,p8,p9;
    private JButton btn,btn1,p1_btn1,p2_btn_delete,p3_btn_ok,p4_btn_find,p5_btn_ok,p6_btn_find,p7_btn_update,btn_firstprof,btn_nextprof;
    private JTextField textField1,textField2,textField3,textField4,textField5,textField6,textField7,textField8,p2_textField1,p2_textField2,p4_textField1,p4_textField2,p6_textField1,p6_textField2,p7_textField1,p9_textField1;
    private JRadioButton jradio_btn1,jradio_btn2,jradio_btn3,jradio_btn4,jradio_btn5,jradio_btn6,jradio_btn7;

    private JComboBox JComboBox_travel,JComboBox_pay,JComboBox_allergies,JComboBox_illness,JComboBox_Update,JComboBox_Updtravel,JComboBox_Updpay,JComboBox_Updallergies,JComboBox_Updillness;

    String travtypelist[] = {"Business","Pleasure"};
    String paytypelist[] = {"Credit","Check","Debit","Invoice"};
    String allerlist[] = {"None","Food","Medication","Other"};
    String illlist[] = {"None","Heart","Diabetes","Asthma","Other"};
    String updatelist[] = {"Address","Phone","Travel Type","Trip Cost","Payment Type","MD Contact","MD Phone #","Illnesses","Allergies"};



    public TravProfInterface(String dbFile) throws IOException, ClassNotFoundException {
        db = new TravProfDB(dbFile);
    }
    public TravProfInterface(){
        prepareGUI();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //menu options
        TravProfInterface inter = new TravProfInterface("ITS_DB");
        TravProfInterface gui = new TravProfInterface();
     }


    public static boolean displayAllTravProf() {
        Scanner in = new Scanner(System.in);
        System.out.println("Agent ID:");
        String travAgentID = in.nextLine();

        TravProf p = TravProfInterface.db.findFirstProfile();
        while (p != null) {
            if (p.gettravAgentID().equals(travAgentID)) {
                //displayTravProf(p);
            }
            p = TravProfInterface.db.findNextProfile();
        }
        return true;
    }


    public void prepareGUI(){
        //set the layout
        //layout detail : https://javatutorial.net/java-swing-jframe-layouts
        mainFrame = new JFrame("ITS GUI Interface");
        mainFrame.setSize(500,450);
        mainFrame.setLayout(null);
        // iconURL is null when not found
        mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("plane.jpg")));


        /*
            Panel p Main Menu
         */
        JPanel p = new JPanel();
        p.setSize(500, 450);
        p.setLayout(null);

        p_title = new JLabel("ITS Main Menu ", JLabel.CENTER);
        p_title.setFont(new Font("Verdana", Font.PLAIN, 20));
        p_title.setBounds(50, 30, 300, 20);
        p.add(p_title);

        jradio_btn1 = new JRadioButton();
        jradio_btn1.setText("Enter a New TravProf");
        jradio_btn1.setBounds(100, 90, 150, 20);
        p.add(jradio_btn1);

        jradio_btn2 = new JRadioButton();
        jradio_btn2.setText("Delete a traveler by Name and travelAgentID");
        jradio_btn2.setBounds(100, 120, 300, 20);
        p.add(jradio_btn2);

        jradio_btn3 = new JRadioButton();
        jradio_btn3.setText("Find and display a TravProf by Name and travAgentID");
        jradio_btn3.setBounds(100, 150, 350, 20);
        p.add(jradio_btn3);

        jradio_btn4 = new JRadioButton();
        jradio_btn4.setText("TravProf Modifications");
        jradio_btn4.setBounds(100, 180, 300, 20);
        p.add(jradio_btn4);

        jradio_btn5 = new JRadioButton();
        jradio_btn5.setText("Display all profiles");
        jradio_btn5.setBounds(100, 210, 150, 20);
        p.add(jradio_btn5);

        jradio_btn6 = new JRadioButton();
        jradio_btn6.setText("Write to database");
        jradio_btn6.setBounds(100, 240, 150, 20);
        p.add(jradio_btn6);

        jradio_btn7 = new JRadioButton();
        jradio_btn7.setText("Initialize database");
        jradio_btn7.setBounds(100, 270, 150, 20);
        p.add(jradio_btn7);

        //buttongroup for single selection only
        ButtonGroup g = new ButtonGroup();
        g.add(jradio_btn1);
        g.add(jradio_btn2);
        g.add(jradio_btn3);
        g.add(jradio_btn4);
        g.add(jradio_btn5);
        g.add(jradio_btn6);
        g.add(jradio_btn7);

        btn = new JButton("Submit");
        btn.setBounds(100, 330, 100, 20);
        p.add(btn);

        btn1 = new JButton("Exit");
        btn1.setBounds(300, 330, 100, 20);
        p.add(btn1);

        //status label
        status_label = new JLabel("       ");
        status_label.setBounds(100, 370, 200, 20);
        p.add(status_label);

        p.setVisible(true); // main menu is initialized to be on, turn off and on as needed

        /*
            Panel p1 to CreateTravProf
         */
        JPanel p1 = new JPanel();
        p1.setSize(500, 450);
        p1.setLayout(null);

        p1_title = new JLabel("Create Traveler Profile ", JLabel.CENTER);
        p1_title.setFont(new Font("Verdana", Font.PLAIN, 20));
        p1_title.setBounds(50, 30, 300, 20);
        p1.add(p1_title);

        p1_lb1 = new JLabel("AgentID : ");
        p1_lb1.setBounds(50,60,100,20);
        p1.add(p1_lb1);

        p1_lb2 = new JLabel("First Name : ");
        p1_lb2.setBounds(50,80,100,20);
        p1.add(p1_lb2);

        p1_lb3 = new JLabel("Last Name : ");
        p1_lb3.setBounds(50,100,100,20);
        p1.add(p1_lb3);

        p1_lb4 = new JLabel("Address : ");
        p1_lb4.setBounds(50,120,100,20);
        p1.add(p1_lb4);

        p1_lb5 = new JLabel("Phone : ");
        p1_lb5.setBounds(50,140,100,20);
        p1.add(p1_lb5);

        p1_lb6 = new JLabel("Trip Cost : ");
        p1_lb6.setBounds(50,160,100,20);
        p1.add(p1_lb6);

        p1_lb7 = new JLabel("Travel Type : ");
        p1_lb7.setBounds(50,180,100,20);
        p1.add(p1_lb7);

        p1_lb8 = new JLabel("Payment Type : ");
        p1_lb8.setBounds(50,200,100,20);
        p1.add(p1_lb8);

        p1_lb9 = new JLabel("Medical Contact : ");
        p1_lb9.setBounds(50,220,100,20);
        p1.add(p1_lb9);

        p1_lb10 = new JLabel("Medical Num : ");
        p1_lb10.setBounds(50,240,100,20);
        p1.add(p1_lb10);

        p1_lb11 = new JLabel("Allergies : ");
        p1_lb11.setBounds(50,260,100,20);
        p1.add(p1_lb11);

        p1_lb12 = new JLabel("Illnesses : ");
        p1_lb12.setBounds(50,280,100,20);
        p1.add(p1_lb12);

        textField1 = new JTextField();
        textField1.setBounds(160,60,100,20);
        p1.add(textField1);
        textField2 = new JTextField();
        textField2.setBounds(160,80,100,20);
        p1.add(textField2);
        textField3 = new JTextField();
        textField3.setBounds(160,100,100,20);
        p1.add(textField3);
        textField4 = new JTextField();
        textField4.setBounds(160,120,100,20);
        p1.add(textField4);
        textField5 = new JTextField();
        textField5.setBounds(160,140,100,20);
        p1.add(textField5);
        textField6 = new JTextField();
        textField6.setBounds(160,160,100,20);
        p1.add(textField6);


        JComboBox_travel = new JComboBox(travtypelist);
        JComboBox_travel.setBounds(160,180,100,20);
        p1.add(JComboBox_travel);

        JComboBox_pay = new JComboBox(paytypelist);
        JComboBox_pay.setBounds(160,200,100,20);
        p1.add(JComboBox_pay);

        textField7 = new JTextField();
        textField7.setBounds(160,220,100,20);
        p1.add(textField7);
        textField8 = new JTextField();
        textField8.setBounds(160,240,100,20);
        p1.add(textField8);

        JComboBox_allergies = new JComboBox(allerlist);
        JComboBox_allergies.setBounds(160,260,100,20);
        p1.add(JComboBox_allergies);


        JComboBox_illness = new JComboBox(illlist);
        JComboBox_illness.setBounds(160,280,100,20);
        p1.add(JComboBox_illness);


        p1_btn1 = new JButton("Submit");
        p1_btn1.setBounds(100, 330, 100, 20);
        p1.add(p1_btn1);

        p1.setVisible(false);
        p1hideTextField();

        /*
            Panel p2 to DeleteTravProf
         */
        JPanel p2 = new JPanel();
        p2.setSize(500, 450);
        p2.setLayout(null);

        p2_title = new JLabel("Delete Traveler Profile ", JLabel.CENTER);
        p2_title.setFont(new Font("Verdana", Font.PLAIN, 20));
        p2_title.setBounds(50, 30, 300, 20);
        p2.add(p2_title);

        p2_lb1 = new JLabel("AgentID : ");
        p2_lb1.setBounds(50,60,100,20);
        p2.add(p2_lb1);

        p2_lb2 = new JLabel("Last Name : ");
        p2_lb2.setBounds(50,80,100,20);
        p2.add(p2_lb2);

        p2_textField1 = new JTextField();
        p2_textField1.setBounds(160,60,100,20);
        p2.add(p2_textField1);

        p2_textField2 = new JTextField();
        p2_textField2.setBounds(160,80,100,20);
        p2.add(p2_textField2);

        p2_btn_delete = new JButton("Delete");
        p2_btn_delete.setBounds(100, 120, 100, 30);
        p2.add(p2_btn_delete);

        p2_textField1.setVisible(false);
        p2_textField2.setVisible(false);
        p2.setVisible(false);

        /*
            Panel p3 to DeleteTravProf  deleted or not found
         */
        JPanel p3 = new JPanel();
        p3.setSize(500, 450);
        p3.setLayout(null);

        p3_title = new JLabel("Delete Traveler Profile ", JLabel.CENTER);
        p3_title.setFont(new Font("Verdana", Font.PLAIN, 20));
        p3_title.setBounds(50, 30, 300, 20);
        p3.add(p3_title);

        p3_statuslb = new JLabel("       ");
        p3_statuslb.setBounds(50, 60, 250, 20);
        p3.add(p3_statuslb);

        p3_btn_ok = new JButton("OK");
        p3_btn_ok.setBounds(50, 80, 100, 30);
        p3.add(p3_btn_ok);

        p3.setVisible(false);
        /*
            Panel p4 find  travprof
         */
        JPanel p4 = new JPanel();
        p4.setSize(500, 450);
        p4.setLayout(null);

        p4_title = new JLabel("Find and Display Profile ", JLabel.CENTER);
        p4_title.setFont(new Font("Verdana", Font.PLAIN, 20));
        p4_title.setBounds(50, 30, 300, 20);
        p4.add(p4_title);

        p4_lb1 = new JLabel("AgentID : ");
        p4_lb1.setBounds(50,60,100,20);
        p4.add(p4_lb1);

        p4_lb2 = new JLabel("Last Name : ");
        p4_lb2.setBounds(50,80,100,20);
        p4.add(p4_lb2);

        p4_textField1 = new JTextField();
        p4_textField1.setBounds(160,60,100,20);
        p4.add(p4_textField1);

        p4_textField2 = new JTextField();
        p4_textField2.setBounds(160,80,100,20);
        p4.add(p4_textField2);

        p4_btn_find = new JButton("Find");
        p4_btn_find.setBounds(100, 120, 100, 30);
        p4.add(p4_btn_find);

        p4_textField1.setVisible(false);
        p4_textField2.setVisible(false);
        p4.setVisible(false);

        /*
            Panel p5 find and display travprof
         */
        JPanel p5 = new JPanel();
        p5.setSize(500, 450);
        p5.setLayout(null);

        p5_title = new JLabel("Profile: ", JLabel.CENTER);
        p5_title.setFont(new Font("Verdana", Font.PLAIN, 20));
        p5_title.setBounds(50, 30, 300, 20);
        p5.add(p5_title);

        p5_lb1 = new JLabel("AgentID : ");
        p5_lb1.setBounds(50,60,200,20);
        p5.add(p5_lb1);

        p5_lb2 = new JLabel("First Name : ");
        p5_lb2.setBounds(50,80,200,20);
        p5.add(p5_lb2);

        p5_lb3 = new JLabel("Last Name : ");
        p5_lb3.setBounds(50,100,200,20);
        p5.add(p5_lb3);

        p5_lb4 = new JLabel("Address : ");
        p5_lb4.setBounds(50,120,200,20);
        p5.add(p5_lb4);

        p5_lb5 = new JLabel("Phone : ");
        p5_lb5.setBounds(50,140,200,20);
        p5.add(p5_lb5);

        p5_lb6 = new JLabel("Trip Cost : ");
        p5_lb6.setBounds(50,160,200,20);
        p5.add(p5_lb6);

        p5_lb7 = new JLabel("Travel Type : ");
        p5_lb7.setBounds(50,180,200,20);
        p5.add(p5_lb7);

        p5_lb8 = new JLabel("Payment Type : ");
        p5_lb8.setBounds(50,200,200,20);
        p5.add(p5_lb8);

        p5_lb9 = new JLabel("Medical Contact : ");
        p5_lb9.setBounds(50,220,200,20);
        p5.add(p5_lb9);

        p5_lb10 = new JLabel("Medical Num : ");
        p5_lb10.setBounds(50,240,200,20);
        p5.add(p5_lb10);

        p5_lb11 = new JLabel("Allergies : ");
        p5_lb11.setBounds(50,260,200,20);
        p5.add(p5_lb11);

        p5_lb12 = new JLabel("Illnesses : ");
        p5_lb12.setBounds(50,280,200,20);
        p5.add(p5_lb12);

        p5_btn_ok = new JButton("Ok");
        p5_btn_ok.setBounds(50, 320, 100, 30);
        p5.add(p5_btn_ok);


        p5.setVisible(false);
        /*
            Panel p6 Update Profile
         */
        JPanel p6 = new JPanel();
        p6.setSize(500, 450);
        p6.setLayout(null);

        p6_title = new JLabel("Update Profile ", JLabel.CENTER);
        p6_title.setFont(new Font("Verdana", Font.PLAIN, 20));
        p6_title.setBounds(50, 30, 300, 20);
        p6.add(p6_title);

        p6_lb1 = new JLabel("AgentID : ");
        p6_lb1.setBounds(50,60,100,20);
        p6.add(p6_lb1);

        p6_lb2 = new JLabel("Last Name : ");
        p6_lb2.setBounds(50,80,100,20);
        p6.add(p6_lb2);

        p6_lb3 = new JLabel("Update Field : ");
        p6_lb3.setBounds(50,100,100,20);
        p6.add(p6_lb3);

        p6_textField1 = new JTextField();
        p6_textField1.setBounds(160,60,100,20);
        p6.add(p6_textField1);
        p6_textField2 = new JTextField();
        p6_textField2.setBounds(160,80,100,20);
        p6.add(p6_textField2);
        JComboBox_Update = new JComboBox(updatelist);
        JComboBox_Update.setBounds(160,100,100,20);
        p6.add(JComboBox_Update);

        p6_btn_find = new JButton("Find");
        p6_btn_find.setBounds(100, 130, 100, 30);
        p6.add(p6_btn_find);

        p6_textField1.setVisible(false);
        p6_textField2.setVisible(false);
        JComboBox_Update.setVisible(false);
        p6.setVisible(false);
        /*
            Panel p7 Update Profile new info
         */
        JPanel p7 = new JPanel();
        p7.setSize(500, 450);
        p7.setLayout(null);

        p7_title = new JLabel("Update ", JLabel.CENTER);
        p7_title.setFont(new Font("Verdana", Font.PLAIN, 20));
        p7_title.setBounds(50, 30, 300, 20);
        p7.add(p7_title);

        p7_lb1 = new JLabel("AgentID : ");
        p7_lb1.setBounds(50,60,100,20);
        p7.add(p7_lb1);

        p7_lb2 = new JLabel("Last Name : ");
        p7_lb2.setBounds(50,80,100,20);
        p7.add(p7_lb2);

        p7_lb3 = new JLabel("  ");
        p7_lb3.setBounds(50,100,100,20);
        p7.add(p7_lb3);

        p7_textField1 = new JTextField();
        p7_textField1.setBounds(160,100,100,20);
        p7.add(p7_textField1);

        JComboBox_Updtravel = new JComboBox(travtypelist);
        JComboBox_Updtravel.setBounds(160,100,100,20);
        p7.add(JComboBox_Updtravel);

        JComboBox_Updpay = new JComboBox(paytypelist);
        JComboBox_Updpay.setBounds(160,100,100,20);
        p7.add(JComboBox_Updpay);

        JComboBox_Updallergies = new JComboBox(allerlist);
        JComboBox_Updallergies.setBounds(160,100,100,20);
        p7.add(JComboBox_Updallergies);


        JComboBox_Updillness = new JComboBox(illlist);
        JComboBox_Updillness.setBounds(160,100,100,20);
        p7.add(JComboBox_Updillness);


        p7_btn_update = new JButton("Update");
        p7_btn_update.setBounds(100, 130, 100, 30);
        p7.add(p7_btn_update);

        p7_textField1.setVisible(false);
        JComboBox_Updtravel.setVisible(false);
        JComboBox_Updpay.setVisible(false);
        JComboBox_Updallergies.setVisible(false);
        JComboBox_Updillness.setVisible(false);
        p7.setVisible(false);
        /*
            Panel p9 find agent id
         */
        JPanel p9 = new JPanel();
        p9.setSize(500, 450);
        p9.setLayout(null);

        p9_title = new JLabel("Find and Display All Profile ", JLabel.CENTER);
        p9_title.setFont(new Font("Verdana", Font.PLAIN, 20));
        p9_title.setBounds(50, 30, 300, 20);
        p9.add(p9_title);

        p9_lb1 = new JLabel("AgentID : ");
        p9_lb1.setBounds(50,60,100,20);
        p9.add(p9_lb1);


        p9_textField1 = new JTextField();
        p9_textField1.setBounds(160,60,100,20);
        p9.add(p9_textField1);

        btn_firstprof = new JButton("Next");
        btn_firstprof.setBounds(100, 120, 100, 30);
        p9.add(btn_firstprof);

        p9_textField1.setVisible(false);
        p9.setVisible(false);

        /*
            Panel p8 Display all profile
        */
        JPanel p8 = new JPanel();
        p8.setSize(500, 450);
        p8.setLayout(null);

        p8_title = new JLabel("Profile: ", JLabel.CENTER);
        p8_title.setFont(new Font("Verdana", Font.PLAIN, 20));
        p8_title.setBounds(50, 30, 300, 20);
        p8.add(p8_title);

        p8_lb1 = new JLabel("AgentID : ");
        p8_lb1.setBounds(50,60,200,20);
        p8.add(p8_lb1);

        p8_lb2 = new JLabel("First Name : ");
        p8_lb2.setBounds(50,80,200,20);
        p8.add(p8_lb2);

        p8_lb3 = new JLabel("Last Name : ");
        p8_lb3.setBounds(50,100,200,20);
        p8.add(p8_lb3);

        p8_lb4 = new JLabel("Address : ");
        p8_lb4.setBounds(50,120,200,20);
        p8.add(p8_lb4);

        p8_lb5 = new JLabel("Phone : ");
        p8_lb5.setBounds(50,140,200,20);
        p8.add(p8_lb5);

        p8_lb6 = new JLabel("Trip Cost : ");
        p8_lb6.setBounds(50,160,200,20);
        p8.add(p8_lb6);

        p8_lb7 = new JLabel("Travel Type : ");
        p8_lb7.setBounds(50,180,200,20);
        p8.add(p8_lb7);

        p8_lb8 = new JLabel("Payment Type : ");
        p8_lb8.setBounds(50,200,200,20);
        p8.add(p8_lb8);

        p8_lb9 = new JLabel("Medical Contact : ");
        p8_lb9.setBounds(50,220,200,20);
        p8.add(p8_lb9);

        p8_lb10 = new JLabel("Medical Num : ");
        p8_lb10.setBounds(50,240,200,20);
        p8.add(p8_lb10);

        p8_lb11 = new JLabel("Allergies : ");
        p8_lb11.setBounds(50,260,200,20);
        p8.add(p8_lb11);

        p8_lb12 = new JLabel("Illnesses : ");
        p8_lb12.setBounds(50,280,200,20);
        p8.add(p8_lb12);

        btn_nextprof = new JButton("Next");
        btn_nextprof.setBounds(150, 320, 100, 30);
        p8.add(btn_nextprof);

        p8.setVisible(false);







        //Main frame
        mainFrame.add(p);
        mainFrame.add(p1);
        mainFrame.add(p2);
        mainFrame.add(p3);
        mainFrame.add(p4);
        mainFrame.add(p5);
        mainFrame.add(p6);
        mainFrame.add(p7);
        mainFrame.add(p8);
        mainFrame.add(p9);
        mainFrame.setVisible(true);

        //Main menu Buttons
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int panelnum = 0;
                if(jradio_btn1.isSelected()){
                    //createNewTravProf();
                    p.setVisible(false);
                    p1.setVisible(true);
                    p1showTextField();
                }
                if(jradio_btn2.isSelected()){
                    //deleteTravProf();
                    p.setVisible(false);
                    p2.setVisible(true);
                    p2_textField1.setVisible(true);
                    p2_textField2.setVisible(true);
                }
                if(jradio_btn3.isSelected()){
                    //findTravProf();
                    p.setVisible(false);
                    p4.setVisible(true);
                    p4_textField1.setVisible(true);
                    p4_textField2.setVisible(true);
                    //btn_nextprof.setVisible(true);

                }
                if(jradio_btn4.isSelected()){
                    //Modify prof
                    p.setVisible(false);
                    p6.setVisible(true);
                    p6_textField1.setVisible(true);
                    p6_textField2.setVisible(true);
                    JComboBox_Update.setVisible(true);
                }
                if(jradio_btn5.isSelected()){
                    //displayAllTravProf();
                    p.setVisible(false);
                    p9.setVisible(true);
                    p9_textField1.setVisible(true);
                }
                if(jradio_btn6.isSelected()){
                    //writeToDB();
                    try {
                        TravProfInterface.db.writeAllTravProf();
                        status_label.setText("Saved to Database");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                        status_label.setText("Failed to load from Database");
                    }
                }
                if(jradio_btn7.isSelected()){
                    //initDB();
                    try {
                        TravProfInterface.db.initializeDataBase();
                        status_label.setText("Loaded from Database");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                        status_label.setText("Failed to save to Database");
                    }
                }

            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
            }
        });

        //create travprof panel button
        p1_btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String travAgentID = textField1.getText();
                String firstname = textField2.getText();
                String lastname = textField3.getText();
                String address = textField4.getText();
                String number = textField5.getText();
                String cost = textField6.getText();
                float tripcost = Float.parseFloat(cost);
                String mdcontact = textField7.getText();
                String mdnumber = textField8.getText();
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
                textField7.setText("");
                textField8.setText("");

                int travelpick = JComboBox_travel.getSelectedIndex();
                int paypick = JComboBox_pay.getSelectedIndex();
                int allerpick = JComboBox_allergies.getSelectedIndex();
                int illpick = JComboBox_illness.getSelectedIndex();

                String traveltype,paytype,allergies,illnesses;
                traveltype = paytype = allergies = illnesses = " ";
                if(travelpick == 0){ traveltype = "Business"; }
                if(travelpick == 1){ traveltype = "Pleasure"; }
                if(paypick == 0){ paytype = "Credit";}
                if(paypick == 1){ paytype = "Check"; }
                if(paypick == 2){ paytype = "Debit"; }
                if(paypick == 3){ paytype = "Invoice"; }
                if(allerpick == 0){ allergies = "None"; }
                if(allerpick == 1){ allergies = "Food"; }
                if(allerpick == 2){ allergies = "Medication"; }
                if(allerpick == 3){ allergies = "Other"; }
                if(illpick == 0){ illnesses = "None"; }
                if(illpick == 1){ illnesses = "Heart"; }
                if(illpick == 2){ illnesses = "Diabetes"; }
                if(illpick == 3){ illnesses = "Asthma"; }
                if(illpick == 4){ illnesses = "Other"; }

                MedCond md = new MedCond(mdcontact, mdnumber, allergies, illnesses);
                TravProf tp = new TravProf(travAgentID, firstname, lastname, address, number, tripcost, traveltype, paytype, md);
                TravProfInterface.db.insertNewProfile(tp);

                p1hideTextField();
                p1.setVisible(false);
                p.setVisible(true);

            }
        });

        p2_btn_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String travAgentID = p2_textField1.getText();
                String lastname = p2_textField2.getText();
                p2_textField1.setText("");
                p2_textField2.setText("");

                boolean deleted = TravProfInterface.db.deleteProfile(travAgentID, lastname);
                p2.setVisible(false);
                p2_textField1.setVisible(false);
                p2_textField2.setVisible(false);
                p3.setVisible(true);
                if (deleted) {
                    //confirmation screen
                    p3_statuslb.setText("Profile Deleted");
                } else {
                    //confirmation screen modified
                    p3_statuslb.setText("Fail to find profile or profile does not exist");
                }

            }
        });

        p3_btn_ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p3.setVisible(false);
                p.setVisible(true);
            }
        });

        p4_btn_find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            String travAgentID = p4_textField1.getText();
            String lastname = p4_textField2.getText();
            p4_textField1.setText("");
            p4_textField2.setText("");
            p4_textField1.setVisible(false);
            p4_textField2.setVisible(false);
            p4.setVisible(false);

            TravProf tp = TravProfInterface.db.findProfile(travAgentID, lastname);
                if (tp != null) {
                    p5.setVisible(true);
                    MedCond m = tp.getMedCondInfo();
                    p5_lb1.setText("ID: " + tp.gettravAgentID());
                    p5_lb2.setText("First Name: " + tp.getFirstName());
                    p5_lb3.setText("Last Name: " + tp.getLastName());
                    p5_lb4.setText("Address: " + tp.getAddress());
                    p5_lb5.setText("Phone Number: " + tp.getPhone());
                    p5_lb6.setText("Trip Cost: " + tp.getTripCost());
                    p5_lb7.setText("Travel Type: " + tp.getTravelType());
                    p5_lb8.setText("Payment Type: " + tp.getPaymentType());
                    p5_lb9.setText("Medical Contact: " + m.getMdContact());
                    p5_lb10.setText("Medical Phone #: " + m.getMdPhone());
                    p5_lb11.setText("Allergies: " + m.getAlgType());
                    p5_lb12.setText("Illnesses: " + m.getIllType());

                } else {
                    p.setVisible(true);
                    status_label.setText("Profile Does not exist");

                }
            }
        });

        p5_btn_ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p5_lb1.setText(" ");
                p5_lb2.setText(" ");
                p5_lb3.setText(" ");
                p5_lb4.setText(" ");
                p5_lb5.setText(" ");
                p5_lb6.setText(" ");
                p5_lb7.setText(" ");
                p5_lb8.setText(" ");
                p5_lb9.setText(" ");
                p5_lb10.setText(" ");
                p5_lb11.setText(" ");
                p5_lb12.setText(" ");
                p5.setVisible(false);
                p.setVisible(true);
            }
        });

        p6_btn_find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String travAgentID = p6_textField1.getText();
                String lastname = p6_textField2.getText();
                p6_textField1.setText("");
                p6_textField2.setText("");
                p6_textField1.setVisible(false);
                p6_textField2.setVisible(false);
                p6.setVisible(false);

                TravProf tp = TravProfInterface.db.findProfile(travAgentID, lastname);
                if (tp != null) {
                    p7.setVisible(true);
                    p7_textField1.setVisible(true);
                    p7_lb1.setText("ID:"+tp.gettravAgentID());
                    p7_lb2.setText("Last Name:"+tp.getLastName());
                    int Updatepick = JComboBox_Update.getSelectedIndex();
                    if(Updatepick == 0){p7_lb3.setText("Address: ");}
                    if(Updatepick == 1){p7_lb3.setText("Phone: ");}
                    if(Updatepick == 2){
                        JComboBox_Updtravel.setVisible(true);
                        JComboBox_Updpay.setVisible(false);
                        JComboBox_Updillness.setVisible(false);
                        JComboBox_Updallergies.setVisible(false);
                        p7_textField1.setVisible(false);
                        p7_lb3.setText("Travel Type: ");
                    }
                    if(Updatepick == 3){ p7_lb3.setText("Trip Cost: ");}
                    if(Updatepick == 4){
                        JComboBox_Updtravel.setVisible(false);
                        JComboBox_Updpay.setVisible(true);
                        JComboBox_Updillness.setVisible(false);
                        JComboBox_Updallergies.setVisible(false);
                        p7_textField1.setVisible(false);
                        p7_lb3.setText("Payment Type: ");
                    }
                    if(Updatepick == 5){p7_lb3.setText("MD Contact: ");}
                    if(Updatepick == 6){p7_lb3.setText("MD Phone #: ");}
                    if(Updatepick == 7){
                        JComboBox_Updtravel.setVisible(false);
                        JComboBox_Updpay.setVisible(false);
                        JComboBox_Updillness.setVisible(true);
                        JComboBox_Updallergies.setVisible(false);
                        p7_textField1.setVisible(false);
                        p7_lb3.setText("Illnesses: ");
                    }
                    if(Updatepick == 8){
                        JComboBox_Updtravel.setVisible(false);
                        JComboBox_Updpay.setVisible(false);
                        JComboBox_Updillness.setVisible(false);
                        JComboBox_Updallergies.setVisible(true);
                        p7_textField1.setVisible(false);
                        p7_lb3.setText("Allergies: ");
                    }

                } else {
                    p.setVisible(true);
                    status_label.setText("Profile Does not exist");
                }
            }
        });

        p7_btn_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newInfo = p7_textField1.getText();
                p7_textField1.setText("");
                p7_textField1.setVisible(false);
                p7.setVisible(false);
                p.setVisible(true);

                int updtravelpick = JComboBox_Updtravel.getSelectedIndex();
                int updpaypick = JComboBox_Updpay.getSelectedIndex();
                int updallerpick = JComboBox_Updallergies.getSelectedIndex();
                int updillpick = JComboBox_Updillness.getSelectedIndex();
                String travAgentID = p7_lb1.getText().substring(3);
                String lastname = p7_lb2.getText().substring(10);
                TravProf tp = TravProfInterface.db.findProfile(travAgentID, lastname);
                MedCond medInfo = tp.getMedCondInfo();
                if (tp != null) {
                    int Updatepick = JComboBox_Update.getSelectedIndex();
                    if(Updatepick == 0){tp.updateAddress(newInfo);}
                    if(Updatepick == 1){tp.updatePhone(newInfo);}
                    if(Updatepick == 2){
                        if(updtravelpick == 0){ newInfo = "Business"; }
                        if(updtravelpick == 1){ newInfo = "Pleasure"; }
                        tp.updateTravelType(newInfo);
                    }
                    if(Updatepick == 3){tp.updateTripCost(Float.parseFloat(newInfo));}
                    if(Updatepick == 4){
                        if(updpaypick == 0){ newInfo = "Credit";}
                        if(updpaypick == 1){ newInfo = "Check"; }
                        if(updpaypick == 2){ newInfo = "Debit"; }
                        if(updpaypick == 3){ newInfo = "Invoice"; }
                        tp.updatePaymentType(newInfo);
                    }
                    if(Updatepick == 5){medInfo.updateMdContact(newInfo);}
                    if(Updatepick == 6){medInfo.updateMdPhone(newInfo);}
                    if(Updatepick == 7){
                        if(updillpick == 0){ newInfo = "None"; }
                        if(updillpick == 1){ newInfo = "Heart"; }
                        if(updillpick == 2){ newInfo = "Diabetes"; }
                        if(updillpick == 3){ newInfo = "Asthma"; }
                        if(updillpick == 4){ newInfo = "Other"; }
                        medInfo.updateIllType(newInfo);
                    }
                    if(Updatepick == 8){
                        if(updallerpick == 0){ newInfo = "None"; }
                        if(updallerpick == 1){ newInfo = "Food"; }
                        if(updallerpick == 2){ newInfo = "Medication"; }
                        if(updallerpick == 3){ newInfo = "Other"; }
                        medInfo.updateAlgType(newInfo);
                    }
                    status_label.setText("Profile Updated");

                } else {
                    status_label.setText("Profile Does not exist");
                }
            }
        });

        btn_nextprof.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                String travAgentID = p9_textField1.getText();
                //p9_textField1.setText("");
                p9.setVisible(false);
                p8.setVisible(true);
                //TravProf
                TravProf pr = TravProfInterface.db.findNextProfile();
                if (pr != null) {
                    if (pr.gettravAgentID().equals(travAgentID)) {
                        p8.setVisible(true);
                        MedCond m = pr.getMedCondInfo();
                        p8_lb1.setText("ID: " + pr.gettravAgentID());
                        p8_lb2.setText("First Name: " + pr.getFirstName());
                        p8_lb3.setText("Last Name: " + pr.getLastName());
                        p8_lb4.setText("Address: " + pr.getAddress());
                        p8_lb5.setText("Phone Number: " + pr.getPhone());
                        p8_lb6.setText("Trip Cost: " + pr.getTripCost());
                        p8_lb7.setText("Travel Type: " + pr.getTravelType());
                        p8_lb8.setText("Payment Type: " + pr.getPaymentType());
                        p8_lb9.setText("Medical Contact: " + m.getMdContact());
                        p8_lb10.setText("Medical Phone #: " + m.getMdPhone());
                        p8_lb11.setText("Allergies: " + m.getAlgType());
                        p8_lb12.setText("Illnesses: " + m.getIllType());
                    }
                } else {
                    p.setVisible(true);
                    p8.setVisible(false);
                    status_label.setText("No more Profiles to view");


                }

            }
        });
        btn_firstprof.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                String travAgentID = p9_textField1.getText();
                //p9_textField1.setText("");
                p9.setVisible(false);
                p8.setVisible(true);
                //TravProf
                TravProf pr = TravProfInterface.db.findFirstProfile();
                if (pr != null) {
                    if (pr.gettravAgentID().equals(travAgentID)) {
                        p8.setVisible(true);
                        MedCond m = pr.getMedCondInfo();
                        p8_lb1.setText("ID: " + pr.gettravAgentID());
                        p8_lb2.setText("First Name: " + pr.getFirstName());
                        p8_lb3.setText("Last Name: " + pr.getLastName());
                        p8_lb4.setText("Address: " + pr.getAddress());
                        p8_lb5.setText("Phone Number: " + pr.getPhone());
                        p8_lb6.setText("Trip Cost: " + pr.getTripCost());
                        p8_lb7.setText("Travel Type: " + pr.getTravelType());
                        p8_lb8.setText("Payment Type: " + pr.getPaymentType());
                        p8_lb9.setText("Medical Contact: " + m.getMdContact());
                        p8_lb10.setText("Medical Phone #: " + m.getMdPhone());
                        p8_lb11.setText("Allergies: " + m.getAlgType());
                        p8_lb12.setText("Illnesses: " + m.getIllType());

                    }
                } else {
                    p.setVisible(true);
                    p8.setVisible(false);
                    status_label.setText("No Profiles to view");
                }

            }
        });

    };

    public void p1hideTextField(){
        textField1.setVisible(false);
        textField2.setVisible(false);
        textField3.setVisible(false);
        textField4.setVisible(false);
        textField5.setVisible(false);
        textField6.setVisible(false);
        textField7.setVisible(false);
        textField8.setVisible(false);
        JComboBox_travel.setVisible(false);
        JComboBox_pay.setVisible(false);
        JComboBox_allergies.setVisible(false);
        JComboBox_illness.setVisible(false);
    }
    public void p1showTextField(){
        textField1.setVisible(true);
        textField2.setVisible(true);
        textField3.setVisible(true);
        textField4.setVisible(true);
        textField5.setVisible(true);
        textField6.setVisible(true);
        textField7.setVisible(true);
        textField8.setVisible(true);
        JComboBox_travel.setVisible(true);
        JComboBox_pay.setVisible(true);
        JComboBox_allergies.setVisible(true);
        JComboBox_illness.setVisible(true);
    }
}