package gui;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.ChangeListener;

import game.Player;

import javax.swing.event.ChangeEvent;


public class InitPlayers {

	private JFrame frame;
	private JTextField textFieldName;
	private ArrayList<Player> players = new ArrayList<Player>();
	private int day = 0;
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	private JComboBox comboBoxPlayers = new JComboBox();
	private TextField statusText = new TextField();
	JButton btnSaveProfile = new JButton("Save");
	private JButton btnCreateProfile;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitPlayers window = new InitPlayers();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 */
	public InitPlayers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 497, 401);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JRadioButton rdbtnMale = new JRadioButton("Male");
        JRadioButton rdbtnFemale = new JRadioButton("Female");
        JSpinner spinner_age = new JSpinner();
        spinner_age.addKeyListener(new KeyAdapter() {
        	
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if (e.getKeyCode() == KeyEvent.VK_ENTER)
                {
        			btnSaveProfile.doClick();

                }
        	}
        });
        spinner_age.addMouseWheelListener(new MouseWheelListener() {
        	public void mouseWheelMoved(MouseWheelEvent e) {
        		 int notches = e.getWheelRotation();
        		 if(spinner_age.isEnabled()){
        		 if (notches < 0) {
        			 spinner_age.setValue(spinner_age.getNextValue());
        	       } else if((Integer)(spinner_age.getValue())!=0){
        	    	   spinner_age.setValue(spinner_age.getPreviousValue());
        	       }
        		 }
        	}
        });
        spinner_age.setBounds(171, 226, 116, 28);
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(87, 187, 63, 22);
        frame.getContentPane().setLayout(null);
        JLabel lblWelcome = new JLabel("Welcome to Virtual Pet");
        lblWelcome.setBackground(new Color(0, 0, 0));
        lblWelcome.setBounds(75, 12, 363, 34);
        frame.getContentPane().add(lblWelcome);
        lblWelcome.setForeground(Color.RED);
        lblWelcome.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
       
        JLabel lblChooseYourProfile = new JLabel("Choose your profile");
        lblChooseYourProfile.setBackground(new Color(102, 205, 170));
        lblChooseYourProfile.setForeground(new Color(255, 255, 255));
        lblChooseYourProfile.setFont(lblChooseYourProfile.getFont().deriveFont(lblChooseYourProfile.getFont().getStyle() | Font.BOLD, lblChooseYourProfile.getFont().getSize() + 3f));
        lblChooseYourProfile.setBounds(28, 58, 159, 28);
        frame.getContentPane().add(lblChooseYourProfile);
       
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(87, 148, 54, 28);
        frame.getContentPane().add(lblName);
       
        textFieldName = new JTextField();
        textFieldName.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if (e.getKeyCode() == KeyEvent.VK_ENTER)
                {
        			btnSaveProfile.doClick();
                }
        	}
        });
        textFieldName.setBounds(171, 148, 116, 28);
        frame.getContentPane().add(textFieldName);
        textFieldName.setColumns(10);
        textFieldName.setEnabled(false);
        comboBoxPlayers.setBounds(205, 58, 116, 28);
       
        
        comboBoxPlayers.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(comboBoxPlayers.getSelectedIndex()!= 0){
        			Player player = (Player) comboBoxPlayers.getSelectedItem();
        			textFieldName.setText(player.getName());
        			textFieldName.setEnabled(false);
        			spinner_age.setValue(player.getAge());
        			if(player.getGender().equals("male")){
        				rdbtnMale.setSelected(true);
        				rdbtnFemale.setSelected(false);
        			}else{
        				rdbtnFemale.setSelected(true);
        				rdbtnMale.setSelected(false);
        			}
        			rdbtnMale.setEnabled(true);
        			rdbtnFemale.setEnabled(true);
                    spinner_age.setEnabled(true);
        		}else{
        			if(! textFieldName.isEnabled()){
        				rdbtnMale.setEnabled(false);
            			rdbtnFemale.setEnabled(false);
                        spinner_age.setEnabled(false);
                        textFieldName.setEnabled(false);
                        textFieldName.setText("");
                        spinner_age.setValue(0);
        			}

        		}
        	}
        });
        comboBoxPlayers.addItem("");
        for(Player player: players){
        	comboBoxPlayers.addItem(player);
        }
       
        frame.getContentPane().add(comboBoxPlayers);
       
        JLabel lblAge = new JLabel("Age");
        lblAge.setBounds(87, 226, 54, 28);
        frame.getContentPane().add(lblAge);
        
        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 9999999, 1);
        spinner_age.setModel(model);
        frame.getContentPane().add(spinner_age);
        spinner_age.setEnabled(false);
        frame.getContentPane().add(lblGender);
       
        btnCreateProfile = new JButton("New");
        btnCreateProfile.setBounds(10, 289, 81, 34);
        btnCreateProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(comboBoxPlayers.getItemCount()!=4){
            		comboBoxPlayers.setSelectedIndex(0);
                	rdbtnMale.setEnabled(true);
                	rdbtnFemale.setEnabled(true);
                    spinner_age.setEnabled(true);
                    textFieldName.setEnabled(true);
                    textFieldName.setText("");
                    spinner_age.setValue(0);
                    rdbtnMale.setSelected(true);
                    rdbtnFemale.setSelected(false);
            	}else{
            		JOptionPane.showMessageDialog(frame,
            					    "You may only create at most 3 players,\ntry to delete one before creating a new one.",
            					    "NOTICE",
            					    JOptionPane.WARNING_MESSAGE);
            	}
            	


            }
        });
        frame.getContentPane().add(btnCreateProfile);
       
        JButton btnDeleteProfile = new JButton("Delete");
        btnDeleteProfile.setBounds(100, 289, 81, 34);
        btnDeleteProfile.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(comboBoxPlayers.getSelectedItem()!=""){
        		comboBoxPlayers.removeItem(comboBoxPlayers.getSelectedItem());
                textFieldName.setText("");
                spinner_age.setValue(0);
            	rdbtnMale.setSelected(true);
                comboBoxPlayers.setSelectedIndex(0);
        		}
        	}
        });
        frame.getContentPane().add(btnDeleteProfile);
       
        
        btnSaveProfile.setBounds(321, 289, 69, 34);
        btnSaveProfile.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		boolean sameName = false;
        		int size = comboBoxPlayers.getItemCount();
        		for(int i = 1; i<size;i++){
        			String name = ((Player) comboBoxPlayers.getItemAt(i)).getName();
        			
        			if(textFieldName.isEnabled() && textFieldName.getText().equals(name)){
        				statusText.setText(name);
        				sameName = true;
        				break;
        			}
        		}
        		if(! textFieldName.getText().equals("")){
        			String gender = rdbtnFemale.isSelected()?"Female":"Male";
        			if(comboBoxPlayers.getSelectedItem().equals("")){
        				if(comboBoxPlayers.getItemCount()==4){
            				statusText.setText("Exceeded limit! You can only choose up to 3 players");
            			}
        				else if(! sameName){
            			Player player = new Player(1, textFieldName.getText(), (Integer)spinner_age.getValue(), gender);
                		players.add(player);
                		comboBoxPlayers.addItem(player);
                		rdbtnMale.setEnabled(false);
            			rdbtnFemale.setEnabled(false);
                        spinner_age.setEnabled(false);
                        textFieldName.setEnabled(false);
                        textFieldName.setText("");
                        spinner_age.setValue(0);
        				}else{
        					statusText.setText("Same name with another player!");
            		}

        			}else{
            			
            			Player player = (Player) comboBoxPlayers.getSelectedItem();
            			player.setAge((int) spinner_age.getValue());
            			player.setGender(gender);
            			
            		}

        		}
        		
        		
        	}
        });
        frame.getContentPane().add(btnSaveProfile);
       
        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String msg="";
        		if(comboBoxPlayers.getItemCount()<=1){
        			msg += "At least 1 player!\n";
        			
        		}
        		if(day==0){
        			msg += "At least 1 day!";

        		}
        		if(msg.length()>0){
        			JOptionPane.showMessageDialog(frame,
        						    msg,
        						    "Error",
        						    JOptionPane.ERROR_MESSAGE);
        		}
        			else{
        		
        			frame.dispose();
        			PickPets pickPets = new PickPets(getPlayers(), day);
        			pickPets.start(getPlayers(), day);
        		}
        	}
        });
        btnStart.setBounds(402, 289, 79, 34);
        frame.getContentPane().add(btnStart);
        statusText.setBounds(0, 329, 495, 22);
        
        statusText.setBackground(new Color(192, 192, 192));
        statusText.setEditable(false);
        statusText.setText("Welcome to the Virtual Pet Game");
        frame.getContentPane().add(statusText);

        rdbtnFemale.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(rdbtnFemale.isSelected()){
        			rdbtnMale.setSelected(false);
        		}
        		rdbtnFemale.setSelected(true);
        	}
        });
        rdbtnFemale.setBounds(236, 183, 85, 23);
        frame.getContentPane().add(rdbtnFemale);
        rdbtnFemale.setEnabled(false);
        
        rdbtnMale.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(rdbtnMale.isSelected()){
        			rdbtnFemale.setSelected(false);
        		}
        		rdbtnMale.setSelected(true);
        	}
        });
        rdbtnMale.setBounds(171, 183, 63, 23);
        rdbtnMale.setSelected(true);
        rdbtnMale.setEnabled(false);
        frame.getContentPane().add(rdbtnMale);
        
        JLabel lblDays = new JLabel("Days");
        lblDays.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
        lblDays.setForeground(new Color(224, 255, 255));
        lblDays.setBounds(402, 58, 56, 28);
        frame.getContentPane().add(lblDays);
        
        JSpinner spinnerDay = new JSpinner();
        spinnerDay.setBounds(349, 63, 39, 20);
        frame.getContentPane().add(spinnerDay);
        spinnerDay.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent arg0) {
        		day = (int)spinnerDay.getValue();
        	}
        });
        spinnerDay.setModel(new SpinnerNumberModel(0, 0, 9999999, 1));
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/sea.jpg")).getImage()));
        lblNewLabel.setBounds(28, 0, 517, 147);
        frame.getContentPane().add(lblNewLabel);
        lblNewLabel.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/sea2.jpg")).getImage()));
        
        JLabel label = new JLabel("");
        label.setBounds(-109, 0, 495, 128);
        frame.getContentPane().add(label);
        spinnerDay.addMouseWheelListener(new MouseWheelListener() {
        	public void mouseWheelMoved(MouseWheelEvent e) {
        		 int notches = e.getWheelRotation();
        		 if (notches < 0) {
        			 spinnerDay.setValue(spinnerDay.getNextValue());
        	       } else if((Integer)(spinnerDay.getValue())!=0){
        	    	   spinnerDay.setValue(spinnerDay.getPreviousValue());
        	       }
        	}
        });
       
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
       
        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("SAVE");

        mnFile.add(mntmNewMenuItem);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("LOAD");
        mnFile.add(mntmNewMenuItem_1);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("HELP");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Help help = new Help();
        		help.start();
        	}
        });
        mnFile.add(mntmNewMenuItem_2);
        
        JMenuItem mntmNewMenuItem_3 = new JMenuItem("RESTART");

        mnFile.add(mntmNewMenuItem_3);
    }
    public ArrayList<Player> getPlayers(){
    	int size  = comboBoxPlayers.getItemCount();
    	
    	ArrayList<Player> players = new ArrayList<Player>();
    	for(int i = 1; i< size;i++){
    		players.add((Player) comboBoxPlayers.getItemAt(i));
//    		System.out.println(comboBoxPlayers.getItemAt(i));
    	}
    	return players;
    }
    public ArrayList<Player> editPlayers(ArrayList<Player> players){
    	this.players = players;
    	System.out.println(players.size());
    	start();
    	return getPlayers();
    	
    }
}
