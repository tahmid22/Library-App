/*
 * ISC 3U0
 * MR.A.SAYED
 * Hasham Alam and Tahmid Mostafa
 * March,23,2015
 * Library Database
 * *****THIS is how our program Works
 *****Our Library Program is mainly divided into two sections: a) the user options, and b) the librarian options. 
 *****The Librarian options:
The librarian can delete and add users and books, look up books and also view the books and users that exists in the library system.
 ***Adding Books: 
Librarian fills out all the attributes of a book and users in order to add the book and user respectively. The add button makes the 
method to work in the library class and adds the user and book in the user list and book list respectively.
 ***Deleting User and Books: In order to delete the user, the librarian enters in the student number of the user, and by pressing the delete button the 
librarian deletes the user from the user list. Similarly, to delete book, the librarian enters in the book title, and hits the delete button.
 ***Looking Up Books: The librarian searches by the book title to check whether the book exists in the library. It also shows if the book is checked out by a user, 
or available in the library to check out.
 *****The User Options:
By logging in by the librarian, a user is able to see his details. A user is also able to check out books, return books, pay fine, compare books and inform the library system if he lost the book.
 ***Details: 
After logging, in the first screen, a user is able to see the user details: his full name, fine, number of books and the list of books that are assigned to him.
 ***Checking Out Book:
 In order to check out a book, a user can search a book to see if the book is available to check out and if the user is able to check out. 
 A user cannot check out a book if the book is already checked out, the user has more the 3 books assigned and if the user has fine more than $5.00. After checking all these, if the user is able to check out a book, the user can do so by clicking on the "check out" button.
 ***Return Book: 
To return a book, a user enters in the book title and the ISBN of the book and the number of days the user is borrowing the book for. 
After checking in the return method that: the user is the valid user to whom the book is assigned and how long the user is borrowing the book for, the user can return the book by hitting on the "return book" button. It will add fine if needed and will make the book available to check out from library.
 ***Lost Book:
 A user is able to make change in the library System if he lost a book. The user enters in the book title and the system deletes the book from the book list, and adds the cost of the book as fine.
 ***Compare Books:
 A user can compare two books by entering in the book titles and it will return which book has higher rating.
 ***Pay Fine: 
A user is able to pay his fine by entering in the amount the user wants to pay.
 ********************************************************************************
 ****************Some Bugs that has been noticed for our program
 *Any other person can return the same book, that has been assigned to another person
 *It takes in fine more than 5 dollar,instead the fine should be 5$ or less
 *Tiny bugs , such as when you don't press a button, it shows nothing entered
 *****************ExtraFeatures
 *Not applicable 
 *****worked Divided
 *Tahmid made all the methods in the library class,  book and user
 *I worked on the applet part 
 *We both put it together at the end.
 */

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;

public class LoginClass extends Applet implements ActionListener {
	user newStudent ; // This object is made to retrieve the information of a user, when entered in a student id
	library hogwartsLibrary = new library ();// This object is being used to store the student list and the book list

	user userList[];
	book bookList[];

	//***********************************VARIABLES DECLARATION****************************************************//
	// The following variables are being used for the student's info text area
	String stuInfoText;// string is later used to add the student info into the stuInfo Box
	String firstName1 ;// Gets the first name of the user
	String lastName1 ;// Gets the last name of the user
	double fine;//Used to get user's fine
	int issuedNumOfBooks ;// Gets the Student's issued number of books

	//Comparing 2 books in the library
	String higherRated;// This string is being used to compare 2 book and returns the highest rated title
	boolean ifRatedHigh=false;

	// For the login Screen- If the student enters in the id instances more than 6
	boolean tooMuchUserNum = false;
	int userInstance;

	boolean checkOutBook1;//Being used to checkout a book
	book [] newBooksList ; // This is being used to get the bookList from the assigned books and then later on it is being used to print out the books

	// These booleans are later on to be used to get something from the methods and do something with it
	boolean ifLostBook=false;// If book has been lost, do something with later on 
	boolean returnResultOfDeletedBook;//// If book has been deleted, do something with later on 
	boolean returnResultOfDeletedUser;// If user has been deleted, do something with later on 
	boolean IfBookIsThere = false;// This boolean has been used to search the book in the library
	boolean returnCheck; //This boolean checks to see if the book has been returned
	boolean ifStudentAdded; // This boolean checks to see if a new student has been added to the student data base
	boolean isReturned;// gets the boolean from the returnedBook method, when book has successfully returned
	boolean checkStudent = false;// later on it's used to check if the student is in the list

	double returnPayFine ;// Gets the net of the fine

	//These booleans are made to contrast between the screens in paint
	boolean loginScreen = true;
	boolean checkOutScreen= false;
	boolean stuScreen = false;
	boolean libScreen = false;
	boolean addBookScreen= false;
	boolean addStudentScreen=false;
	boolean viewAllBooks=false;
	boolean viewAllStudents=false;
	boolean returnBookScreen=false;
	boolean lostBookScreen=false;
	boolean deleteUserScreen=false;
	boolean deleteBookScreen =false;
	boolean emptyLogin = false;

	//*********************************** TEXTFIELDS / BUTTONS DECLARATION****************************************************//
	//Declares a textField for the login screen
	TextField stuId; 
	//Buttons Declaration for login screen
	Button loginButton;
	Button libLogin;
	Button logoutButton;

	// Declares the buttons for student screen
	Button addFine;
	Button payFine;
	Button checkOutBook; 
	Button returnBook;
	Button compareBook;
	//Declares textFields for the student screen
	TextArea stuInfo;
	TextField payingFine;
	TextField returningBook;
	TextField takingInIsbn;
	TextField addingTheNumDays;
	TextField compareBook1;
	TextField compareBook2;         

	//Declares buttons for lostBook screen
	Button lostMyBook;
	//Declares a single textField for lostBook screen
	TextField lostBooksTitle;

	//Button for returnBook screen
	Button returBookButton;

	//Declares textFields for the checkout screen
	TextField searchForBooks;
	////Declares buttons for the checkout screen
	Button giveBook;

	//Declares a single textField for the librarian Screen
	TextField libSearchBooks;

	//Buttons for the Librarian Screen
	Button addBook;
	Button addUser;
	JButton invisibleSearch;
	Button viewBooks;
	Button viewStudents;
	Button lostBookButton;
	Button deleteBookButton;
	Button deleteUserButton;
	Button deleteBook;

	// Declares a single textField for the deleting book screen
	TextField deletingBookTitle;
	// Declares a single textField for the deleting user screen
	TextField deletingUserId;       
	// Declares a single button for the deleting user screen
	Button deletingUser;

	// Declares textFields for the addBook screen
	TextField bookTitle;
	TextField authorsName;
	TextField Category;
	TextField Isbn;
	TextField costOfBooks;
	TextField rating;

	//Declares a single button for the addBook screen
	Button addingBook;

	//Declares textFields for the add Student screen
	TextField firstName;
	TextField lastName;
	TextField stuNum;       
	//Declares a single button for the add Student screen
	Button addNewStudent;

	// Declares the back buttons
	Button backToLibraryOptions;
	Button backToStudentOptions;
	//*********************************** DECLARES THE PATH OF THE IMAGES****************************************************//
	private final String PICTURE_PATH_Logo = "Logo.png";
	private final String PICTURE_PATH_Search= "searchButton.png";
	private final String PICTURE_PATH_Background="background.jpg";
	private final String PICTURE_PATH_searchBtnForStu = "searchBtnForStu.png";
	private final String PICTURE_PATH_stuOptions = "stuOptions.png";

	//*********************************** DECLARES IMAGES MODIFER****************************************************//
	Image Logo;
	Image search;
	Image background;
	Image searchBtnForStu;
	Image stuOpt;

	//// Initilizition the program or run it
	public void init ()
	{
		//sets a custom layout grid and resizes the screen
		setLayout (null); 
		resize (900,600);//resizes the screen
		setBackground(Color.BLACK);

		// Initializes a single textField for the login screen
		stuId = new TextField ("", 6);
		stuId.setBounds (350, 110, 200, 20);
		// Initializes the buttons for the login screen
		loginButton = new Button ("Login");
		loginButton.setBounds (350,135, 95, 30);
		loginButton.setForeground(Color.red);
		libLogin = new Button ("Librarian options");
		libLogin.setBounds (450,135,105,30);
		libLogin.setForeground(Color.blue);
		logoutButton= new Button ("LogOut");
		logoutButton.setBounds(600,500,160,30);

		// Adds two buttons and a single textField to the login screen
		add (stuId);
		add (libLogin);
		add (loginButton);

		// Initializes the buttons for the Student Screen
		addFine = new Button ("Add Fine"); 
		addFine.setBounds (550,100,115,31);
		checkOutBook = new Button ("Check Out a book");
		checkOutBook.setBounds (550,140,115,35);
		returnBook = new Button ("Return Book");
		returnBook.setBounds(550,180,115,35);
		payFine = new Button (" Pay Fine ");
		payFine.setBounds(360,440,100,20);
		compareBook = new Button ("Compare Book");
		compareBook.setBounds (120,480,100,20);         
		// Initializes the textiFields for the student Screen
		returningBook= new TextField ("",6);
		returningBook.setBounds(330,180,200,20);
		takingInIsbn= new TextField ("",6);
		takingInIsbn.setBounds(330,220,200,20);
		payingFine = new TextField ("",6);
		payingFine.setBounds(350,405,125,20);
		compareBook1= new TextField ("",6);
		compareBook1.setBounds(110,405,125,20);
		compareBook2= new TextField ("",6);
		compareBook2.setBounds(110,445,125,20);

		// Initializes the buttons for the return book screen
		returBookButton = new Button ("returnBook"); 
		returBookButton.setBounds(600,430,160,30);
		lostBookButton= new Button ("Lost a book ?");
		lostBookButton.setBounds(550,220,115,35);               
		//Initializes the buttons textFields for the return book screen
		addingTheNumDays= new TextField ("",6);
		addingTheNumDays.setBounds(330,260,200,20);

		//Button / textField for the lostBook screen
		lostMyBook= new Button ("lost my book !");
		lostMyBook.setBounds(600,430,160,30);
		lostBooksTitle = new TextField ("",6);
		lostBooksTitle.setBounds(330,225,200,20);               

		// Initializes the textFields for the checkout screen 
		searchForBooks = new TextField ("" ,6);
		searchForBooks.setBounds(200,130,350,30);               
		// Initializes the buttons for the checkout screen
		giveBook= new Button ("Check out");
		giveBook.setBounds(551,130,115,31); 

		// Initializes the textFields for the librarian screen
		stuInfo = new TextArea ( stuInfoText,8,60);
		stuInfo.setBounds(100,101,400,190);
		stuInfo.setEditable(false);
		libSearchBooks = new TextField ("");
		libSearchBooks.setBounds(200,294,350,30);          

		// Initializes the textFields for deleting book screen
		deletingBookTitle= new TextField();
		deletingBookTitle.setBounds(350,125,250,23);
		//Initializes the buttons for deleting book screen
		deletingUserId = new TextField();
		deletingUserId.setBounds(350,125,250,23);

		// Initializes the buttons for the librarian screen 
		addBook = new Button ("Add a new book");
		addBook.setBounds (550,130,200,30);
		addUser = new Button ("Add a new student");
		addUser.setBounds (550,170,200,30);
		deleteBookButton= new Button ("Delete a book ");
		deleteBookButton.setBounds(550,210,200,30);
		deleteUserButton= new Button ("Delete a user");
		deleteUserButton.setBounds(550,250,200,30); 
		deleteBook= new Button ("Delete Book");
		deleteBook.setBounds(600,430,160,30);
		deletingUser=new Button ("Delete User");
		deletingUser.setBounds(600,430,160,30);
		viewBooks = new Button ("View All Books");
		viewBooks.setBounds (200,450,200,30);
		viewStudents=new Button("View All Students");
		viewStudents.setBounds(400,450,150,30);
		invisibleSearch = new JButton ("Search");
		invisibleSearch.setBounds(562,283,55,55);
		invisibleSearch.setOpaque(false);
		invisibleSearch.setContentAreaFilled(false);
		invisibleSearch.setBorderPainted(false);

		//Initializes the textFields for the addingBook screen
		bookTitle=new TextField ("");
		bookTitle.setBounds(350,125,250,23);
		authorsName=new TextField ("");
		authorsName.setBounds(350,165,250,23);
		Category=new TextField ("");
		Category.setBounds(350,205,250,23);
		Isbn=new TextField ("");
		Isbn.setBounds(350,245,250,23);
		costOfBooks=new TextField ("");
		costOfBooks.setBounds(350,285,250,23);
		rating=new TextField ("");
		rating.setBounds(350,325,250,23);
		//Initializes the buttons for the addingBook screen
		addingBook = new Button ("Add Book");
		addingBook.setBounds(600,430,160,30);
		addNewStudent=new Button ("Add this Student");
		addNewStudent.setBounds(600,430,160,30);

		// Initializes the textFields for adding student
		firstName=new TextField ("",6);
		firstName.setBounds(350,125,250,23);
		lastName = new TextField ("",6);
		lastName.setBounds(350,165,250,23);
		stuNum = new TextField ("",6); 
		stuNum.setBounds(350,205,250,23);
		// Initializes the buttons for adding student
		addNewStudent=new Button ("Add this Student");
		addNewStudent.setBounds(600,430,160,30);

		///Initializes the back buttons
		backToLibraryOptions = new Button ("<-- Go Back ");
		backToLibraryOptions.setBounds(600,465,160,30);
		backToStudentOptions = new Button ("<-- Go Back");
		backToStudentOptions.setBounds(600,465,160,30);




		//Button Action Listeners
		addingBook.addActionListener(this);
		loginButton.addActionListener(this);
		libLogin.addActionListener(this);
		addBook.addActionListener(this);
		addUser.addActionListener(this);
		giveBook.addActionListener(this); 
		logoutButton.addActionListener(this);
		invisibleSearch.addActionListener(this);
		checkOutBook.addActionListener(this);
		returnBook.addActionListener(this);
		payFine.addActionListener(this);
		compareBook.addActionListener(this);
		backToLibraryOptions.addActionListener(this);
		backToStudentOptions.addActionListener(this);
		addFine.addActionListener(this);
		addNewStudent.addActionListener(this);
		viewBooks.addActionListener(this);
		viewStudents.addActionListener(this);
		returBookButton.addActionListener(this);
		lostBookButton.addActionListener(this);
		deleteBookButton.addActionListener(this);
		lostMyBook.addActionListener(this);
		deleteUserButton.addActionListener(this);
		deleteBook.addActionListener(this);
		deletingUser.addActionListener(this);

		/// Preparing Image for the Applet
		Logo = getToolkit ().getImage (PICTURE_PATH_Logo);
		prepareImage (Logo, this);
		search =getToolkit ().getImage( PICTURE_PATH_Search);
		prepareImage (search, this);
		background =getToolkit ().getImage (PICTURE_PATH_Background);
		prepareImage (background,this);
		searchBtnForStu=getToolkit ().getImage (PICTURE_PATH_searchBtnForStu);
		prepareImage(searchBtnForStu,this);
		stuOpt = getToolkit().getImage(PICTURE_PATH_stuOptions);
		prepareImage (stuOpt,this);


	} // init method

	public void paint (Graphics g)
	{
		///Declaration of Fonts
		Font typeFont1= new Font ("Calibri", 0, 14 );// Font for the username
		Font typeFont= new Font ("Times New Roman", 0, 20 );
		//Draws Background Images               
		g.drawImage(background,0,0,null);
		g.drawImage(Logo,475,170,null);

		if (loginScreen==true){
			g.setFont(typeFont); 
			g.setColor(Color.white);
			g.drawString ("Student Id :" , 250,125);
			if (emptyLogin==true){
				g.setFont(typeFont1); 
				g.drawString ("-- Nothing entered --" , 390,200);
			}
		}

		if (stuScreen == true){
			g.setColor(Color.white);
			g.drawString ("Book # 1",50,420);
			g.drawString ("Book # 2",50,460);
			g.drawString ("Pay Fine : ",290,420);
			g.drawImage(stuOpt,-130,-220,null); // draws out the logo of Hogwarts Library
		}
		if (checkOutScreen==true && loginScreen == false ){     
			g.setColor(Color.white);
			if (IfBookIsThere == false){ 
				g.drawString("Please enter in a valid book name ", 570,100);
			}
			else if (IfBookIsThere == true){
				g.drawString("This book is in our library", 570,100);
			}
		}

		if(libScreen==true){
			g.setColor(Color.white);
			g.setFont(typeFont1); 
			g.drawString("If you want to add a new book, simply click on the button called  ''Add a new book''", 60, 145);
			g.drawString("If you want to add a new user, simply click on the button called  ''Add a new Student''", 60,190);
			g.drawString("If you want to delete a specfic book from the database, please click on the button beside it", 35, 230);
			g.drawString("If you want to delete a specfic user from the database, please click on the button beside it", 35, 268);
			Font headingFont= new Font ("Times New Roman", 2, 50 );// Font for the username
			g.setFont(headingFont); 
			g.drawString("Librarian options", 180, 100);
			g.drawImage(search,-268,-175,null);

		}


		if (addBookScreen==true){
			g.setColor(Color.white);
			g.drawString("Book Title: ", 250,140);
			g.drawString("Author's Name : ", 250,180);
			g.drawString("Category: ", 250,220);
			g.drawString("Isbn: ", 250,260);
			g.drawString("Price: ", 250,300);
			g.drawString("Rating: ", 250,340);
			g.setFont(typeFont);
			g.drawString ("Add a new book here , down below ! ",300,80);
		}

		if (addStudentScreen==true){
			g.setColor(Color.white);
			g.drawString("First Name: ", 250,140);
			g.drawString("Last Name : ", 250,180);
			g.drawString("Student Num : ", 250,220);
			g.setFont(typeFont);
			g.drawString ("Add a new user here , down below ! ",300,80);
			if (ifStudentAdded ==true) {
				g.setFont(typeFont);
				g.setColor(Color.white);
				g.drawString("Student has been added ", 350,300);
			}

		}

		if (returnCheck==true && addBookScreen==true ){
			g.setColor(Color.white);
			g.drawString("Book has been added ", 250,400);

		}
		if (IfBookIsThere == true && libScreen==true){
			g.setColor(Color.white);
			g.setFont(typeFont);
			g.drawString("Book is here in our library! ", 250,400);
		}
		else if (IfBookIsThere==false && libScreen==true ){
			g.setColor(Color.white);
			g.setFont(typeFont);
			g.drawString("Please, Enter in valid book Name ", 250,400);
		}

		try{
			if(viewAllBooks==true)
			{
				g.setFont(typeFont);
				g.setColor(Color.white);
				g.drawString("View All Books ", 150,150);
				int  bookNumber = hogwartsLibrary.bookNum(); 
				int y=200;
				for(int i=0;i<bookNumber;i++)
				{
					book [] s2 = hogwartsLibrary.bookList();
					g.drawString(s2[i].getTitle(), 100, y);
					y=y+30;
				}
			}
		}catch(Exception e){
			g.setFont(typeFont);
			g.setColor(Color.white);
			g.drawString("View All Books ", 150,150);
			int  bookNumber = hogwartsLibrary.bookNum(); 
			int y=200;
			for(int i=0;i<bookNumber;i++)
			{


				book [] s2 = hogwartsLibrary.bookList();
				if (s2[i]!=null){
					g.drawString(s2[i].getTitle(), 100, y);
					y=y+30;
				}
			}

		}

		try{ // What this does is that it gets the students, if there is null , it will go to catch and then draws it again
			if (viewAllStudents==true ){
				g.setFont(typeFont);
				g.setColor(Color.white);
				g.drawString("View All Students ", 150,150);
				int  userNumber = hogwartsLibrary.userCounter(); 
				int y=200;
				for(int i=0;i< userNumber;i++)
				{
					user [] s2 = hogwartsLibrary.stuList();
					g.drawString(s2[i].getfirstName(), 100, y);//
					y=y+30;
				}
			} 
		}
		catch (Exception e){
			g.setFont(typeFont);
			g.setColor(Color.white);
			g.drawString("View All Students ", 150,150);
			int  userNumber = hogwartsLibrary.userCounter(); 
			int y=200;
			for(int i=0;i< userNumber;i++)
			{
				user [] s2 = hogwartsLibrary.stuList();
				if (s2[i]!=null){
					g.drawString(s2[i].getfirstName(), 100, y);
					y=y+30;
				}
			}
		}

		if (tooMuchUserNum==true && loginScreen==true){
			g.setColor(Color.white);
			g.drawString ("Or - The Id must be 6 instances long ", 370, 230);
		}
		if (ifRatedHigh==true && stuScreen==true){
			g.setColor(Color.white);
			g.drawString(higherRated,130,560);
		}
		try {// What this does is that it gets the assigned book list and if there is an empty spot or , if there is null , it will go to catch and then draws it again
			if (checkOutBook1==true && checkOutScreen ==true){ 
				g.setColor(Color.white);
				int bookNumber  = hogwartsLibrary.returnTotalBookNum ();
				int y=200;
				for(int i=0;i<=bookNumber;i++)
				{       newBooksList = hogwartsLibrary.assignedBooks();
				g.drawString("The following book has been assigned to you" + "''" +newBooksList[i].getTitle()+"''", 250, y);
				y=y+20;
				} 
			}
		}catch (Exception e){} 

		if (returnBookScreen==true ){
			g.setColor(Color.white);
			g.drawString("Book Title: ",250,197);
			g.drawString("Isbn:",280,237);
			g.drawString("Number of Days:",219,277);
			Font headingFont= new Font ("Times New Roman", 2, 50 );// Font for the heading
			g.setFont(headingFont); 
			g.drawString("Return Book ", 300, 100);
		}
		if (isReturned == true && returnBookScreen==true){
			g.setColor(Color.white);
			g.setFont(typeFont);
			g.drawString("Book has been successfully returned, ",290,320);
		}
		else if (isReturned ==false && returnBookScreen==true){
			g.setColor(Color.white);
			g.setFont(typeFont);
			g.drawString("Nothing Entered",290,320);
			g.drawString("Error, either this is the wrong user ",290,340);
			g.drawString("Or the book has never been assigned to you ",290,360);
		}

		if (lostBookScreen==true  ){    
			if (ifLostBook == true){
				g.setColor(Color.white);
				g.drawString("Thanks, you can proceed now ",330,320);
			}
			g.setColor(Color.white);
			g.drawString("Book Title:",250,237);
			Font headingFont= new Font ("Times New Roman", 2, 50 );// Font for the  heading
			g.setFont(headingFont); 
			g.drawString("Lost your book? ", 300, 100);
		}


		if (returnResultOfDeletedBook==true && deleteBookScreen==true  ){
			g.setColor(Color.white);
			g.setFont(typeFont);
			g.drawString("Book has been deleted from the database",310,200);
		}
		if (deleteBookScreen==true ){
			g.setColor(Color.white);
			g.drawString("Book Title: ",250,140);
			Font headingFont= new Font ("Times New Roman", 2, 50 );// Font for the  heading
			g.setFont(headingFont); 
			g.drawString("Delete Book", 360, 100);
		}

		if (deleteUserScreen==true){
			g.setColor(Color.white);
			g.drawString("Student Id: ",250,140);
			Font headingFont= new Font ("Times New Roman", 2, 50 );// Font for the heading
			g.setFont(headingFont); 
			g.drawString("Delete User", 360, 100);
		}

		if (returnResultOfDeletedUser==true && deleteUserScreen == true){
			g.setColor(Color.white);
			g.setFont(typeFont);
			g.drawString("User has been deleted from the database",310,200);
		}

	} // paint method

	public void actionPerformed (ActionEvent evt)
	{
		if(evt.getSource()== loginButton){ 
			if(!(stuId.getText ().trim ()).equals ("")){// If there is nothing entered, then don't proceed to the student screen
				String userNum = stuId.getText ().trim ();
				int userId = Integer.parseInt(userNum);
				userInstance = userNum.length();//Gets the length of the entered id

				if (userInstance!=6){
					tooMuchUserNum=true;
					return;
				}

				user userBeingLookedUp = null;

				userList = hogwartsLibrary.returnUserList();
				boolean foundUser = false;

				for (int i =0; i<userList.length;i++){
					if (userList[i]!=null && userList[i].getstuNum() == userId){
						userBeingLookedUp=userList[i];
						foundUser = true;
						checkStudent = true;
						
						for (int a = 0; a < 3; a++)
						{
							if(userList[a].getCheckedOutBooks() != null)
							{
								System.out.println(userList[a].getCheckedOutBooks());
							}
						}
						
					}
				}

				if (foundUser == false){
					//display error
					return;
				}

				if (foundUser == true){
					System.out.println("Test");
				
				book [] assignedBooks = userBeingLookedUp.getCheckedOutBooks();

				if(assignedBooks == null){
				
				}
				
				else
				{		
					System.out.println(assignedBooks[0].getTitle());
				}
				
				
				}
				



				firstName1 = userBeingLookedUp.getfirstName();//gets its first name
				lastName1 =  userBeingLookedUp.getlastName();// get its last name
				fine = hogwartsLibrary.returnedTotalFine();//gets the total fine
				issuedNumOfBooks = hogwartsLibrary.returnTotalBookNum(); //gets the total number of books

				stuInfoText = "Student's first name: " + firstName1 +"\n"+"Student's last name: " + lastName1 ;// This is being used to show the student info inside of a textArea later on 
				stuInfoText+=  "\n"+ "Issued # of books: " + issuedNumOfBooks + "\n"+ "Fine: $"+ fine + "\n"+"Payed: $"+returnPayFine;//


				if (checkStudent == true  ){
					stuScreen = true;
					loginScreen= false;
					libScreen = false;                                              
					checkOutScreen = false;
					addBookScreen = false;
					viewAllBooks=false;
					lostBookScreen=false;

					remove (stuId);
					remove (loginButton);
					remove (libLogin);
					remove  (invisibleSearch);
					remove (searchForBooks);
					remove (giveBook);
					add (logoutButton);
					remove (addFine);
					add (checkOutBook);
					add (returnBook);
					add (payFine);
					add (compareBook);
					add (stuInfo); 
					add(compareBook1);
					add(compareBook2);
					add (payingFine);
					add (lostBookButton);

					remove (stuInfo); // This is where the studentInfo is being initialized, because when a new student enters in a id, it should change
					stuInfo = new TextArea ( stuInfoText,8,60);
					stuInfo.setBounds(100,101,400,190);
					stuInfo.setEditable(false);
					add(stuInfo);
					repaint();      
				}
				repaint();      
			}       
		}



		if (evt.getSource() == checkOutBook){
			checkOutScreen =true;
			loginScreen= false;
			libScreen = false;
			stuScreen = false;
			addBookScreen = false;
			addStudentScreen= false;
			viewAllBooks=false;
			lostBookScreen=false;

			remove (stuId);
			remove (loginButton);
			remove (libLogin);
			remove  (invisibleSearch);
			remove (searchForBooks);
			remove (giveBook);
			remove (addFine);
			remove (checkOutBook);
			remove (returnBook);
			remove (payFine);
			remove (compareBook);
			remove (stuInfo);
			remove (payingFine);
			remove (payingFine);
			remove (returningBook);
			remove (addingTheNumDays);
			remove (compareBook1);
			remove (compareBook2);
			remove (lostBookButton);
			remove (deleteBookButton);

			add(logoutButton);
			add (giveBook);         
			add (searchForBooks);                   
			remove (takingInIsbn);
			add (backToStudentOptions);
			repaint ();
		}
		else {
			emptyLogin = true;
			repaint();
		}


		if (evt.getSource()==libLogin){
			loginScreen =false;
			libScreen =true;
			stuScreen = false;
			checkOutScreen =false;
			addStudentScreen= false;
			viewAllBooks=false;
			deleteBookScreen =false;
			deleteUserScreen=false;

			remove (deletingUserId);             
			remove (stuId);
			remove (loginButton);
			remove (libLogin);
			remove  (invisibleSearch);
			remove (addFine);
			remove (checkOutBook);
			remove (returnBook);
			remove (payFine);
			remove (compareBook);
			add (invisibleSearch);
			remove (lostBooksTitle);
			remove(firstName);
			remove(lastName);
			remove(addNewStudent);
			add (libSearchBooks);
			add (addUser);
			add (logoutButton);
			add  (invisibleSearch);
			add (addBook);
			add (viewBooks);
			add (viewStudents);
			add (deleteBookButton);
			add (deleteUserButton);

			repaint();

		}

		if (evt.getSource()==addBook){
			addBookScreen = true;
			loginScreen =false;
			libScreen =false;
			stuScreen = false;
			checkOutScreen =false;                  
			addStudentScreen= false;
			viewAllBooks=false;

			remove (deletingUserId);
			remove (deleteUserButton);
			remove (deleteBookButton);
			remove (libSearchBooks);
			remove (addUser);
			remove (logoutButton);
			remove  (invisibleSearch);
			remove(addBook);
			remove (lostBooksTitle);
			add (logoutButton);
			add (addingBook);
			add (bookTitle);
			add(authorsName);
			add(Category);
			add(Isbn);
			add(costOfBooks);
			add(rating);
			add (backToLibraryOptions);

		}

		if (evt.getSource()==backToLibraryOptions){
			libScreen=true;
			loginScreen= false;
			stuScreen = false;
			checkOutScreen = false;
			addBookScreen = false;
			addStudentScreen= false;
			viewAllBooks=false;
			deleteBookScreen =false;
			deleteUserScreen=false;

			remove(deletingUser);
			remove (deletingUserId);
			remove (deletingBookTitle);
			remove (lostBooksTitle);
			remove (deleteBook);                  
			remove (stuId);
			remove (loginButton);
			remove (libLogin);
			remove  (invisibleSearch);
			remove (addFine);
			remove (checkOutBook);
			remove (returnBook);
			remove (payFine);
			remove (compareBook);                   
			remove (addingBook);
			remove (bookTitle);
			remove (backToLibraryOptions);
			remove (authorsName);
			remove (Category);
			remove (Isbn);
			remove (costOfBooks);
			remove (rating);                        
			remove(firstName);
			remove(lastName);
			remove(addNewStudent);
			remove (takingInIsbn);
			remove(stuNum);
			remove (lostBooksTitle);
			add (deleteUserButton);
			add (libSearchBooks);
			add (addUser);
			add (logoutButton);
			add  (invisibleSearch);
			add (addBook);
			add (deleteBookButton);
			add(viewBooks);
			add(viewStudents);
			add (invisibleSearch);
			add (logoutButton);

			repaint();
		}

		if (evt.getSource()==addUser){
			addStudentScreen = true;
			loginScreen =false;
			libScreen =false;
			stuScreen = false;
			checkOutScreen =false;
			addBookScreen = false;                  
			viewAllBooks=false;
			deleteBookScreen =false;
			deleteUserScreen=false;
			remove (deleteUserButton);
			remove (deleteBookButton);
			remove (libSearchBooks);
			remove (addUser);
			remove (logoutButton);
			remove  (invisibleSearch);
			remove(addBook);
			remove (lostBooksTitle);
			add(backToLibraryOptions);
			add(firstName);
			add(lastName);
			add(addNewStudent);
			add (logoutButton);
			add (stuNum);   

			repaint();
		}

		if (evt.getSource() == addNewStudent &&!(firstName.getText ().trim().equals("") ) &&(!(lastName.getText ().trim().equals("") ))){// when add student has been clicked and the textfields are not empty
			String inputFirstName = firstName.getText().trim();// Takes the text from the firstName and makes into string
			String inputLastName = lastName.getText().trim();// Takes the text from the lastName and makes into string
			String inputStuNum = stuNum.getText().trim();
			int studentNum = Integer.parseInt(inputStuNum);// Takes the text from the stuNum and makes into an integer
			user newStudent = new user (studentNum,inputFirstName,inputLastName,0,0,null);// makes an user object which is used to sent it to addUser and make it equal to a empty spot
			ifStudentAdded= hogwartsLibrary.addUser(newStudent);// Gets the boolean, if the student has been added successfully, makes it equal to true and which is also you used to display the text
			repaint();
		}

		if (evt.getSource()==invisibleSearch&& !(libSearchBooks.getText ().trim().equals(""))){
			String inputBook1 = libSearchBooks.getText ().trim();
			IfBookIsThere = hogwartsLibrary.inBookList(inputBook1);// Sends a Book title to bookList method and if it equals a book in the bookList, then returns true
			repaint();
		}
		if (evt.getSource()== giveBook){
			String inputBook2 = searchForBooks.getText ().trim();   
			checkOutBook1 = hogwartsLibrary.inBookList(inputBook2); // Sends the input to inBookList to check if its there in the bookList
			hogwartsLibrary.issueBook(checkOutBook1);// if the book is in the bookList, then send that boolean to issueBook and assign the book

			remove (searchForBooks);// To clear out the textField when checkout a book
			searchForBooks = new TextField ("" ,6);
			searchForBooks.setBounds(200,130,350,30);
			add(searchForBooks);
			repaint();

		}

		if (evt.getSource()== logoutButton){
			loginScreen=true;
			IfBookIsThere=false;
			libScreen= false;
			stuScreen=false;
			addBookScreen = false;
			addStudentScreen= false;
			viewAllBooks=false;
			viewAllStudents=false;
			lostBookScreen=false;
			deleteBookScreen =false;
			deleteUserScreen=false;
			checkOutScreen =false;
			remove( deletingBookTitle);
			remove (deletingUserId);
			remove (lostBooksTitle);
			remove (lostBooksTitle);
			remove (deleteBook);            
			remove (deleteBookButton);
			remove(viewBooks);
			remove(viewStudents);
			remove  (invisibleSearch);
			remove (addBook);
			remove (logoutButton);
			remove (addUser);
			remove (searchForBooks);
			remove (logoutButton);
			remove (backToLibraryOptions);
			remove(giveBook);
			remove (addFine);
			remove (checkOutBook);
			remove (returnBook);
			remove (payFine);
			remove (compareBook);
			remove (stuInfo);
			remove (libSearchBooks);
			remove (logoutButton);
			remove (addingBook);
			remove (bookTitle);
			remove (backToStudentOptions);
			remove(firstName);
			remove(lastName);
			remove(addNewStudent);
			remove (payingFine);
			remove (returningBook);
			remove (addingTheNumDays);
			remove (compareBook1);
			remove (compareBook2);
			remove (takingInIsbn);
			remove (lostBookButton);
			remove (deleteUserButton);
			remove(deletingUser);
			remove (stuId);
			stuId = new TextField ("", 6);
			stuId.setBounds (350, 110, 200, 20);
			add (stuId);
			add (loginButton);

			add(libLogin);
			repaint();
		}

		if (evt.getSource()==backToStudentOptions){ 

			loginScreen= false;
			libScreen = false;
			stuScreen = true;
			checkOutScreen = false;
			addBookScreen = false;
			addStudentScreen= false;
			returnBookScreen=false;
			lostBookScreen=false;

			remove (giveBook);
			remove (lostMyBook);
			remove (searchForBooks);
			remove (giveBook);
			remove (backToStudentOptions);
			remove (addingTheNumDays);
			remove (returningBook);
			remove (addingTheNumDays);                      
			remove (takingInIsbn);
			remove (returningBook);                 
			remove(returBookButton);                        
			remove (lostBooksTitle);
			add (logoutButton);
			add (checkOutBook);
			add (returnBook);
			add (payFine);
			add (compareBook);      
			add (compareBook1);
			add (compareBook2);
			add(lostBookButton);
			add(payingFine);
			remove (stuInfo);
			fine = hogwartsLibrary.returnedTotalFine();// takes in a total fine of a student
			issuedNumOfBooks = hogwartsLibrary.returnTotalBookNum(); //takes in a total number of books


			// This simply updates the student Info
			stuInfoText = "Student's first name: " + firstName1 +"\n"+"Student's last name: " + lastName1 ;
			stuInfoText+=  "\n"+ "Issued # of books: " + issuedNumOfBooks + "\n"+ "Fine: $"+ fine + "\n"+"Payed: $"+returnPayFine;
			stuInfo = new TextArea ( stuInfoText,8,60);
			stuInfo.setBounds(100,101,400,190);
			stuInfo.setEditable(false);
			add (stuInfo);                          
			repaint();
		}

		if (evt.getSource()==addingBook &&!(bookTitle.getText ().trim().equals("")) &&!(authorsName.getText ().trim().equals(""))&&!(Category.getText ().trim().equals(""))&&!(Isbn.getText ().trim().equals(""))&&!(costOfBooks.getText ().trim().equals(""))&&!(rating.getText ().trim().equals(""))){
			//Takes in all of the attributes of book , in order to add
			String bookName = bookTitle.getText().trim();
			String author=  authorsName.getText().trim();
			String categoryName =  Category.getText().trim();
			String isbnNumber = Isbn.getText().trim();
			int isbnNum = Integer.parseInt(isbnNumber);
			String costing = costOfBooks.getText().trim();
			int costOf= Integer.parseInt(costing);
			String mark = rating.getText().trim();
			int markOfBook=Integer.parseInt(mark);
			book newBook1 = new book (bookName,isbnNum,categoryName,author,costOf,markOfBook, false, null);// sends the object to the addBook method and assigns it a spot
			returnCheck = hogwartsLibrary.addBook(newBook1);
		}

		if (evt.getSource()==viewStudents){
			viewAllStudents=true;
			viewAllBooks=false;
			loginScreen = false;
			checkOutScreen= false;
			stuScreen = false;
			libScreen = false;
			addBookScreen= false;
			addStudentScreen=false;
			deleteBookScreen =false;
			deleteUserScreen=false;
			remove (deleteUserButton);
			remove (stuId);
			remove ( deletingBookTitle);
			remove(viewBooks);
			remove (viewStudents);
			remove (deleteBookButton);
			remove  (invisibleSearch);
			remove (addBook);
			remove (addUser);
			remove (searchForBooks);
			remove(giveBook);
			remove (deletingUserId);
			remove (addUser);
			remove (addFine);
			remove (checkOutBook);
			remove (returnBook);
			remove (payFine);
			remove (compareBook);
			remove (stuInfo);
			remove (libSearchBooks);
			remove (addingBook);
			remove (bookTitle);
			remove (backToStudentOptions);
			remove(firstName);
			remove(lastName);
			remove(addNewStudent);
			remove (payingFine);
			remove (returningBook);
			remove (addingTheNumDays);
			remove (compareBook1);
			remove (compareBook2);
			remove (takingInIsbn);
			remove (addingBook);
			remove(bookTitle);
			remove(authorsName);
			remove(Category);
			remove(Isbn);
			remove(costOfBooks);
			remove(rating);
			remove (backToLibraryOptions); 
			remove (stuNum);
			remove (lostBooksTitle);
		}
		if(evt.getSource()==viewBooks)
		{
			viewAllBooks=true;
			loginScreen = false;
			checkOutScreen= false;
			stuScreen = false;
			libScreen = false;
			addBookScreen= false;
			addStudentScreen=false;
			deleteBookScreen =false;
			deleteUserScreen=false;
			remove (lostBooksTitle);
			add (logoutButton);
			remove (addUser);
			remove (stuId);
			remove(viewBooks);
			remove (deleteUserButton);
			remove (deletingUserId);
			remove (viewStudents);
			remove (deleteBookButton);
			remove  (invisibleSearch);
			remove (addBook);                       
			remove (addUser);
			remove (searchForBooks);
			remove(giveBook);
			remove (addFine);
			remove (checkOutBook);
			remove (returnBook);
			remove (payFine);
			remove (compareBook);
			remove (stuInfo);
			remove (libSearchBooks);
			remove (addingBook);
			remove (bookTitle);
			remove (backToStudentOptions);
			remove(firstName);
			remove(lastName);
			remove(addNewStudent);
			remove (payingFine);
			remove (returningBook);
			remove (addingTheNumDays);
			remove (compareBook1);
			remove (compareBook2);
			remove (takingInIsbn);
			remove (addingBook);
			remove(bookTitle);
			remove(authorsName);
			remove(Category);
			remove(Isbn);
			remove(costOfBooks);
			remove(rating);
			remove (backToLibraryOptions);  
			remove (stuNum);
			remove ( deletingBookTitle);

			repaint();
		}

		if (evt.getSource()==returnBook){
			viewAllBooks=false;
			loginScreen = false;
			checkOutScreen= false;
			stuScreen = false;
			libScreen = false;
			addBookScreen= false;
			addStudentScreen=false;
			returnBookScreen =true;

			remove (stuId);
			remove (loginButton);
			remove (libLogin);
			remove  (invisibleSearch);
			remove (searchForBooks);
			remove (giveBook);                      
			remove (addFine);
			remove (checkOutBook);
			remove (returnBook);
			remove (payFine);
			remove (compareBook);
			remove (stuInfo); 
			add(logoutButton);
			add(backToStudentOptions);
			add(returningBook);
			add(takingInIsbn);
			add(addingTheNumDays);
			remove(payingFine);
			remove (compareBook1);
			remove (compareBook2);
			add(returBookButton);
			remove(lostBookButton);
			repaint();

		}
		if (evt.getSource()== compareBook&& !(compareBook1.getText().trim().equals(""))&&!(compareBook2.getText().trim().equals(""))){
			viewAllBooks=false;
			loginScreen = false;
			checkOutScreen= false;
			stuScreen = true;
			libScreen = false;
			addBookScreen= false;
			addStudentScreen=false;
			returnBookScreen =false;
			//Takes in two books to have a comparison between them
			String book1=compareBook1.getText().trim();
			String book2 =compareBook2.getText().trim();
			higherRated=hogwartsLibrary.compareBook(book1, book2);// sends the two books to compareBook method in the library class and returns the one book with the higher rate
			ifRatedHigh=true;
		}

		if (evt.getSource()==returBookButton&&!(returningBook.getText().trim().equals(""))&&!( takingInIsbn.getText().trim().equals(""))&&!(addingTheNumDays.getText().trim().equals(""))){
			viewAllBooks=false;
			loginScreen = false;
			checkOutScreen= false;
			stuScreen =false;
			libScreen = false;
			addBookScreen= false;
			addStudentScreen=false;
			returnBookScreen =true;                 
			//To return a book, it takes the number of days,bookTitle and books isbn
					String returnBook1 = returningBook.getText().trim();
			String returnIsbn = takingInIsbn.getText().trim();
			int  returneingIsbn= Integer.parseInt(returnIsbn);
			String numDays =addingTheNumDays.getText().trim();
			int days= Integer.parseInt(numDays);

			isReturned = hogwartsLibrary.returnBook(returnBook1,returneingIsbn, days);// Sends that to returnBookMethod
			repaint();      

		}

		if (evt.getSource()==payFine &&!(payingFine.getText().trim().equals(""))){
			String sendPayFine=payingFine.getText().trim();
			returnPayFine =Double.parseDouble(sendPayFine);
			double payingInFine = hogwartsLibrary.payFine(returnPayFine);//takes in the input for paying fine and sends it to the payFine
			///Updates the studentInfo textBox
			remove (stuInfo);
			fine = hogwartsLibrary.returnedTotalFine();
			issuedNumOfBooks = hogwartsLibrary.returnTotalBookNum();                        
			stuInfoText = "Student's first name: " + firstName1 +"\n"+"Student's last name: " + lastName1 ;
			stuInfoText+=  "\n"+ "Issued # of books: " + issuedNumOfBooks + "\n"+ "Fine: $"+ fine + "\n"+"Payed: $"+returnPayFine;
			stuInfo = new TextArea ( stuInfoText,8,60);
			stuInfo.setBounds(100,101,400,190);
			stuInfo.setEditable(false);
			add (stuInfo);   

		}

		if(evt.getSource()==deleteUserButton ){
			loginScreen = false;
			checkOutScreen= false;
			stuScreen = false;
			libScreen = false;
			addBookScreen= false;
			addStudentScreen=false;
			viewAllBooks=false;
			viewAllStudents=false;
			returnBookScreen=false;
			deleteBookScreen =false;
			deleteUserScreen =true;


			remove (deleteUserButton);
			remove (libSearchBooks);
			remove (addUser);
			remove (logoutButton);
			remove (invisibleSearch);
			remove (addBook);
			remove (viewBooks);
			remove (viewStudents);
			remove(deleteBookButton);
			add(logoutButton);
			add(backToLibraryOptions);
			remove ( deletingBookTitle);
			add(deletingUserId);
			add(deletingUser);


			repaint();
		}


		if (evt.getSource()==deletingUser && !(deletingUserId.getText().trim().equals(""))){

			String takingInUser= deletingUserId.getText().trim();
			int deletingStudentFromList= Integer.parseInt(takingInUser);
			returnResultOfDeletedUser = hogwartsLibrary.deleteUser(deletingStudentFromList);// sends the userNumber to delete user and deletes the user from the list
		}



		if (evt.getSource() == lostBookButton ){
			viewAllBooks=false;
			loginScreen = false;
			checkOutScreen= false;
			stuScreen = false;
			libScreen = false;
			addBookScreen= false;
			addStudentScreen=false;
			returnBookScreen =false;
			lostBookScreen=true;
			add (lostMyBook);
			add(lostBooksTitle);
			add(logoutButton);
			add(backToStudentOptions);
			remove (checkOutBook);
			remove (returnBook);
			remove (payFine);
			remove (compareBook);
			remove (stuInfo); 
			remove(compareBook1);
			remove(compareBook2);
			remove (payingFine);
			remove (lostBookButton);
			add(backToStudentOptions);

			repaint();


		}


		if (evt.getSource()==lostMyBook && !(lostBooksTitle.getText().trim().equals(""))){
			String theLostBooksName= lostBooksTitle.getText().trim();
			ifLostBook = hogwartsLibrary.lostBook(theLostBooksName);// Sends the name of the book to lostbook method and it erases it from the list
			repaint();
		}


		if (evt.getSource () == deleteBookButton){

			loginScreen = false;
			checkOutScreen= false;
			stuScreen = false;
			libScreen = false;
			addBookScreen= false;
			addStudentScreen=false;
			viewAllBooks=false;
			viewAllStudents=false;
			returnBookScreen=false;
			deleteUserScreen=false;
			deleteBookScreen =true;
			remove (deleteUserButton);
			remove(libSearchBooks);
			remove (addUser);
			remove (invisibleSearch);
			remove(addBook);
			remove (viewBooks);
			remove (viewStudents);
			remove (deleteBookButton);
			add (logoutButton);
			add(backToLibraryOptions);
			add ( deletingBookTitle);
			add (deleteBook);
			remove (deletingUserId);
			repaint();


		}

		if (evt.getSource()==deleteBook && !(deletingBookTitle.getText().trim().equals(""))){

			String deleteingBook= deletingBookTitle.getText().trim();
			returnResultOfDeletedBook = hogwartsLibrary.deleteBook( deleteingBook);// sends the title of the book to delete book method and deltes it from the list

		}

	}
}







