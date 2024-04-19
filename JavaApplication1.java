package JavaApplication1;


import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.io.OutputStream;
import java.io.PrintStream;



public  class JavaApplication1 
{
	 JButton start,about,close,yes,no,enter;
	 JFrame frame1,frame2,fram;
	 JPanel jp,jp2,centerpanel;
	 JTextArea jta;
	 JTextField numinput;
	 String choice = "";
	 JScrollPane js;
	 Scanner scanner = new Scanner(System.in);
	 
	private void setGuiEnabled(boolean enabled) {
        // Enable/disable GUI components
        yes.setEnabled(enabled);
        no.setEnabled(enabled);
        numinput.setEnabled(enabled);
        enter.setEnabled(enabled);
    }

	 public  void homepage()
	 {
		 try {
		 PrintStream printStream = new PrintStream(new OutputStream() {
	         @Override
	         public void write(int b) {
	            jta.append(String.valueOf((char) b));
	             jta.setCaretPosition(jta.getDocument().getLength());
	         }
	     });
		  System.setOut(printStream);
		     System.setErr(printStream);
		 frame1 = new JFrame();
	 		 frame1.setBounds(500,500,400,300);
	 		 frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 		 frame1.setLayout(new GridLayout(4,1));
	 		 
	 		 
	 		 JLabel lb = new JLabel("Number guessing game for hnin oo wai");
	 		 lb.setBackground(Color.PINK);
	 		 lb.setOpaque(true); 
	 		 lb.setFont(new Font("Calibri",Font.BOLD,17));
	 		 lb.setHorizontalAlignment(SwingConstants.CENTER);;
	 		 frame1.add(lb);
	 		 
	 		 
	 		 start = new JButton("Start");
	 		 start.setBackground(Color.GREEN);
	 		 start.setFont(new Font("Roboto",Font.BOLD,20));
	 		 start.addActionListener(new ActionListener()
	 				 {
	 			 		public void actionPerformed(ActionEvent ae)
	 			 		{
                                                     SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    gamepage();	
                    core();
                    return null;
                }

                @Override
                protected void done() {
                    // Re-enable GUI components after task completion
                    setGuiEnabled(true);
                }
            };
            worker.execute();
	 			 		}
	 			 
	 				 }
	 				 
	 				 );
	 		 frame1.add(start);
	 		 
	 		 
	 		 frame2 = new JFrame();
	 	     frame2.setBounds(100, 100, 400, 300);
	 	    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 		 JTextArea aboutmsg = new JTextArea();
	 		aboutmsg.setFont(new Font("Arial", Font.BOLD, 16)); // Set font with bold style and increased size
	        aboutmsg.setForeground(Color.BLUE); // Set text color to blue
	        aboutmsg.setBackground(new Color(240, 240, 240)); // Set background color
	        aboutmsg.setBorder(BorderFactory.createCompoundBorder(
	                BorderFactory.createEmptyBorder(10, 10, 10, 10), // Add padding
	                BorderFactory.createLineBorder(Color.BLACK))); // Add border
	 		 aboutmsg.setLineWrap(true);
	 		 aboutmsg.setWrapStyleWord(true);
	 		 aboutmsg.setText("This game is developed by the boyfriend of the beatiful girl Hnin Oo Wai. \n    Ko Ko Lin Thant is a tech enthusiatic person and also very atheletic."
	 		 					+ "He is very open minded and also very very kind. He is the type of person who will indeed become a billionaire one day!");
	 		 
	 		 about = new JButton("About");
	 		 about.setBackground(Color.GRAY);
	 		 about.setFont(new Font("Roboto",Font.BOLD,20));
	 		 about.addActionListener(new ActionListener()
	 				 {	 
	 			 public void actionPerformed(ActionEvent ae)
	 			 {
	 				frame2.getContentPane().add(aboutmsg, BorderLayout.CENTER);
	 				frame2.setVisible(true);
	 				 
	 			 }
	 				 
	 				 });
	 		 
	 		 frame1.add(about);
	 		 
	 		 close = new JButton("Close");
	 		 close.setBackground(Color.RED);
	 		 close.setFont(new Font("Roboto",Font.BOLD,20));
	 		 close.addActionListener(new ActionListener()
	 				 {
	 			 			public void actionPerformed(ActionEvent ae)
	 			 			{
	 			 				if (JOptionPane.showConfirmDialog(frame2, "Do you want to exit?", "Confirm Message",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION);
	 			 				{System.exit(0); }
	 			 				
	 			 				frame2.add(aboutmsg);
	 			 				frame2.setVisible(true);
	 			 			}
	 			 
	 			 
	 				 }
	 		 
	 				 
	 				 
	 				 );
	 		 
	 		 
	 		 
	 		 
	 		 
	 		 frame1.add(close);	 		 
	 		 frame1.setVisible(true);
		 }catch(Exception e)
		 {
			 System.out.println(e);
		 }
		
	 }
	 

 



	
	
	public void gamepage()
	{
		 
		 try {
		 fram = new JFrame("Number guessing game");
		fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 jp = new JPanel();
		jp.setBounds(0,0,440,400);
		jp.setBorder(BorderFactory.createTitledBorder("Enjoy the game"));
		jp.setLayout(null);
		
		
		
		 jta = new JTextArea();
		jta.setBackground(Color.DARK_GRAY);
		jta.setForeground(Color.WHITE);
		JScrollPane js = new JScrollPane(jta);
		
		js.setBounds(5,20,430,375);
		jp.add(js);
		
		
		

		
		fram.add(jp);
		
		
		
		
		
		
		
		 jp2 = new JPanel(new BorderLayout());
		jp2.setBounds(0,410,440,150);
		jp2.setBorder(BorderFactory.createTitledBorder("Control"));
		
		
		
		 yes = new JButton(" YES ");
		yes.setBackground(Color.BLUE);
		
		yes.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		 jp2.add(yes, BorderLayout.WEST); 
		
		no = new JButton(" NO ");
		no.setBackground(Color.BLUE);
		no.setBackground(Color.red);
		no.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		 jp2.add(no, BorderLayout.EAST);
		numinput = new JTextField(20);
		numinput.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font
        numinput.setHorizontalAlignment(JTextField.CENTER); // Center-align text
        numinput.setBackground(new Color(0xFAFAFA)); // Light gray background
        numinput.setForeground(Color.BLACK); // Black text color
        numinput.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2)); // Gray border
        numinput.setMargin(new Insets(5, 5, 5, 5)); // Add padding
        numinput.setToolTipText("Enter a number"); 
       
		
		
         enter = new JButton("Enter");		
		 enter.setFont(new Font("Arial", Font.BOLD, 24));
		 enter.setBackground(Color.GRAY); // Light blue
	     enter.setOpaque(true); // Make button opaque to show background color
	     enter.setBorderPainted(false); // Hide default button border
	     enter.setMnemonic(KeyEvent.VK_ENTER);
	     
	     enter.addActionListener(new ActionListener() 
 		{
 		
	        		public void actionPerformed(ActionEvent ae)
	        			
	        		 {
	        			if (numinput.getText().isEmpty()) {
	        		        JOptionPane.showMessageDialog(fram, "Please Enter a number");
	        		    }
	        			else {
	        		        try {
	        		            
	        		            getnum();
	        		            numinput.setText("");
	        		            numinput.requestFocus();
	        		        } catch (NumberFormatException e) {
	        		            // If parsing fails, show an error message
	        		            JOptionPane.showMessageDialog(fram, "Please Enter a valid number");
	        		            // Optionally, you can clear the input field or take other actions here
	        		            numinput.setText("");
	        		            numinput.requestFocus();
	        		        }
	        			
 		
	        				} 
	        		 }}); 
 		
	     
	     enter.addMouseListener(new java.awt.event.MouseAdapter() {
	         public void mouseEntered(java.awt.event.MouseEvent evt) {
	                enter.setBackground(new Color(0x007BFF)); // Dark blue
	            }

	            public void mouseExited(java.awt.event.MouseEvent evt) {
	                enter.setBackground(new Color(0x80A9FF)); // Light blue
	            }
	        });

		
		
		
	
		
        
		
		centerpanel = new JPanel (new GridLayout(2,1));
		centerpanel.add(numinput);
		centerpanel.add(enter);
		
		
		jp2.add(centerpanel, BorderLayout.CENTER);
		
		
		
		fram.getContentPane().add(jp2);		
		
		
		
		
		fram.setLayout(null);
		fram.setBounds(300,300,460,600);
		fram.setVisible(true);
		
		
		 }catch(Exception e)
		 {
			 System.out.println(e);
		 }
		
		
	}
	

  
  
  public static  void main (String[] args) 
  {
  	
  	JavaApplication1 game = new JavaApplication1();
  	game.homepage();
    
    
  


  }




public void core() {
	//String y_choice = "";
	   
	    try {
	        PrintStream printStream = new PrintStream(new OutputStream() {
	            @Override
	            public void write(int b) {
	                jta.append(String.valueOf((char) b));
	                jta.setCaretPosition(jta.getDocument().getLength());
	            }
	        });
	        System.setOut(printStream);
	        System.setErr(printStream);

	        HeartPattern heart1 = new HeartPattern();
	        Random rand = new Random();

	        System.out.print("Number guessing game! Would you like to start now ? \n 'Yes' Or 'No' : ");
                
                String choice_real = getinput_String();
               
	         // Get user input
               System.out.println();
	        while (choice_real.equalsIgnoreCase("Yes")) {
	            System.out.print("Enter the minimum range of random num you would like to guess, \n minimum range : ");
	            int minrange = getnum() ; // 
	            scanner.nextLine(); 

	            System.out.print("Enter the maximum range of random num you would like to guess, \n maximum range : ");
	            int maxrange = getnum();
	            scanner.nextLine(); // Consume newline character

	            System.out.print("Enter a number : ");
	            int num = getnum() ; // Get user input
	            scanner.nextLine(); // Consume newline character

	            int r_num = minrange + rand.nextInt(maxrange - minrange);

	            if (num == r_num) {
	                System.out.println("You won my princess\n you are so smart hnin oo wai, koko loves you so much, have fun on the trip ");
	                System.out.println();
	                heart1.heart();
	            }

	            while (num != r_num) {
	                determine_result(num, r_num);
	                System.out.print("Enter a number : ");
	                num = getnum() ; // Get user input
	                scanner.nextLine(); // Consume newline character

	                if (num == r_num) {
	                    System.out.println("You won my princess\n you are so smart hnin oo wai, koko loves you so much, have fun on the trip ");
	                    System.out.println();
	                    heart1.heart();
	                    break;
	                }
	            }

	            System.out.println();
	            System.out.print(" Would you like to start again ? \n 'Yes' Or 'No' : ");
	            choice_real = getinput_String();
	        }

	        if (choice_real.equalsIgnoreCase("No")) {
	            System.out.println("Okay pr");
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    } finally {
	        scanner.close(); // Close the Scanner object to release resources
	    }
	}





  public static void determine_result(int n, int r )


  {
    if (n < r)
    {
       System.out.println ("Higher");
       System.out.println ();
    }

    if (n > r)
    {
      System.out.println ("Lower");
      System.out.println ();
    }






  }


  public int getnum() {
	    int num = 0;
	    String input = numinput.getText().trim(); // Get input from JTextField
	    if (!input.isEmpty()) { // Check if input is not empty
	        try {
	            num = Integer.parseInt(input); // Parse input to integer
	        } catch (NumberFormatException e) {
	            // Handle invalid input (non-numeric)
	            e.printStackTrace();
	        }
	    } else {
	        // If the JTextField is empty, read input from the console using the provided Scanner
	        if (scanner.hasNextInt()) {
	            num = scanner.nextInt();
	        } else {
	            // Handle non-integer input
	            System.out.println("Invalid input. Please enter an integer.");
	            scanner.next(); // Consume the invalid input
	        }
	    }
	    return num;
	}

	  

  

   public String getinput_String() {
       
        //String choice = ""; // Default choice
        
        try {
            // Create action listeners for the "Yes" and "No" buttons using lambda expressions
            yes.addActionListener(e -> choice = "Yes"); // Update choice if "Yes" button is clicked
            no.addActionListener(e -> choice = "No");   // Update choice if "No" button is clicked

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage());
        }

        // Return the choice once it's made
        return choice;
    }




}


class HeartPattern  
{  
         
        public  void heart  ()  
        {  
                
                final int size = 4  ;  
          
                 
            for (int m = 0; m < size; m++) {  
                    for (int n = 0; n <= 4 * size; n++) {  
                            double pos1 = Math.sqrt(Math.pow(m - size, 2) + Math.pow(n - size, 2));  
                            double pos2 = Math.sqrt(Math.pow(m - size, 2) + Math.pow(n - 3 * size, 2));  
   
                            if (pos1 < size + 0.5 || pos2 < size + 0.5) {  
                                    System.out.print('*');  
                            } else {  
                                    System.out.print(' ');  
                            }  
                        }  
                        System.out.print(System.lineSeparator());  
                }  
                
                for (int m = 1; m <= 2 * size; m++)  
                {  
                    for (int n = 0; n < m; n++) {  
                        System.out.print(' ');  
                }  
                for (int n = 0; n < 4 * size + 1 - 2 * m; n++) {  
                        System.out.print("*");  
                    }  
                System.out.print(System.lineSeparator());  
                }  
    }  
}




