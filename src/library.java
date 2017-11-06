
public class library {

        private static book bookList[] = new book[100]; 	// The array object, that will store all of the books data in it        
        private static user stuList[] = new user [100]; 	// The array object, that will store all of the users data in it  
        private static book assignedBooks[] = null;     //this is being used to assign book to the student.
        
        private static boolean inStuList;       // When entered in a userId, this boolean is used to check if the student is in the list or no        
        private static boolean isReturned;      // This is being used when you return a book to this library, it will make it true
        private static boolean studentHasBeenAdded;     //this is used to return when a student is added successfully
       
        private static int userCounter = 0;     //userCounter is used to keep track of how many students are all in the list
        private static int bookCounter = 0;     //bookCounter is used to keep track of how many books are all in the list
        public static int bookSpot;     		//bookSpot is the spot at the bookList when user searches a book. This is used to check out the book. 
        public static int stuSpot;      		//stuSpot is the spot in the student list, which can be determined when a user logs in
        public static int userNumber = 0;       
              
        public library () {
            //initializes the book list and student list
                
            //Attributes: String bookTitle, int bookISBboolean isReturned;N, String bookCatagory, String bookAuthor, int bookCost, int bookRating, boolean isBookCheckedOut, user bookBorrower                
            bookList[0]= new book ("The Kite Runner",23232 ,"Hossien", "non-fiction", 50 ,5, false, null);
            bookList[1]= new book ("The Splended Sun",23232 ,"Hossien", "non-fiction", 70 ,6, false, null);
            bookList[2]= new book ("To Kill a Mocking Bird",23232 ,"Margaret", "fiction", 50 ,3, false, null);
            bookList[3]= new book ("The Lord of the Rings",23232 ,"Tolkien", "fiction", 70 ,4, false, null);
            bookCounter = 4;
              
            //Attributes: int studentNum, String fName, String lName, double stuFine, int stuIssuedNumOfBooks, book[] userCheckedOutBooks
            stuList[0] = new user (791211, "Tahmid", "Mostafa", 0.10, 0, null);
            stuList[1] = new user (773081, "Hasham", "Alam",0.0, 0, null);
            stuList[2] = new user (111111, "Johnathon", "Kent", 0, 0, null);
            stuList[3] = new user (222222, "Clark", "Kent", 0, 0, null);
            stuList[4] = new user (333333, "Harry", "Potter", 0, 0, null); 
            userCounter = 5;
        }
        
        //This is used to return the bookList to LoginClass
        public static book [] bookList (){
                return bookList;
        }
        
        //This is used to return the student list to Login Class
        public static user [] stuList(){
                return stuList;
        }
        
        //this is used to return the book counter to Login Class
        public static int bookNum (){
                return bookCounter;
        }
        
        //this used to return userCounter to LoginClass
        public static int userCounter(){
                return userCounter;
        }

        //this is used to return assigned book list to user class
        public static book [] assignedBooks(){
                return assignedBooks;
        }
        
        //this is returning the fine which is being updated every time
        public static double returnedTotalFine(){
                return stuList[stuSpot].getFine(); 
        }
        
        //this method is returning the number of books assigned to the user
        public static int returnTotalBookNum (){
                return stuList[stuSpot].getIssuedNumOfBooks(); //this is returning the updated num of books,
                        
        }


        // This method is used to delete user from library method***********************************************************************************
        public static boolean deleteUser (int deleteStudentId){ //this methods gets a student number 
                boolean userDeleted = false;
                for (int i =0; i<stuList.length; i++)   //go through the student list
                {
                        if (stuList[i].getstuNum() == deleteStudentId){ //if the student number is in the student list
                                stuList[i]= null;                                               //make that spot null, so that the student is no longer exits in the list                                
                                userDeleted = true;     //make the boolean true when the user is deleted
                                System.out.println("There is a null at " + i + "User is deleted" + userDeleted);
                                break;  //stop running the for loop when the user is deleted
                        }                                                 
                }
                return userDeleted;     //return the boolean to the login class to confirm
        }
       
        
        //this method is used to delete book from book list***********************************************************************************************
        public static boolean deleteBook (String toDeleteBookTitle){    //this method taked in a book title
                boolean bookDeleted = false;
                for (int i =0; i<bookList.length; i++)  //go through the book list
                {
                        if (bookList[i].getTitle().equalsIgnoreCase(toDeleteBookTitle) && bookList[i].getIsCheckedOut()==false){        //proceed if the title matches and the book is not checked out
                                bookList[i]= null;      //when the if statement is true, make the spot in the book list null so that the book no longer exists
                                System.out.println("There is a null at " + i);
                                bookDeleted = true;     //confirms the book is deleted
                                System.out.println("book is deleted" + bookDeleted);
                                break;
                        }                                                 
                }
                return bookDeleted;     //return to login class
        }
        
        
        
        public static user checkInUser (user checked){
                checked = null;
                if (inStuList==true){
                        System.out.println (stuList[userNumber].getfirstName());
                        checked = stuList[userNumber];
                }
                System.out.println ( checked);

                return checked;
        }
        
        //this method is used to add book**************************************************************************************************************************
        public static boolean addBook (book newBook){   //this method takes in a book object from the login class
                boolean isAdded = false;        //initialize the boolean as false
                for (int i =0; i<bookList.length; i++)
                {
                        if (bookList[i] == null) { //Checks if the bookList spot is empty than perform
                                bookList[i]= newBook;   //fill out the empty space in the book list by the book object
                                isAdded = true; //if the spot is empty assigned it in input book                                
                                bookCounter++; //this it get the length of the list
                                break;
                        }
                }
                return isAdded; //return to loginClass
        }


        //This method is used to add user*******************************************************************************************************************************
        public static boolean addUser (user newUser){   //this method gets an user object from login class
                studentHasBeenAdded=false;      //initialize as false
                for (int i =0; i<stuList.length; i++)   //go through the student list
                {
                        if (stuList[i] == null) {       //check if the spot in student list is empty and perform
                                stuList[i]= newUser;    //fill the empty space with the user object
                                studentHasBeenAdded=true;       //confirms the user is added
                                userCounter++;  //keep tracks of how many users are in the list
                                break;  //stop running when the user is added
                        }
                }

                return studentHasBeenAdded;     //return to loginClass
        }    

        //this method checks if a book is available in the library and if the user is able to check out *****************************************************************************************************************
        public static boolean inBookList(String inputTitle){    //get the title from the user. This method will check whether the book is in the library
                System.out.println("seach to check out starts");
                //initialize as false
                boolean isAvailable = false;
                boolean canCheckOut = false;   
                
                for (int i=0; i<bookList.length; i++)   //goes through the book list
                {
                        //if the book is in library and the book is not checked out
                        if ((bookList[i]!=null) && (bookList[i].getTitle()).equalsIgnoreCase(inputTitle) && bookList[i].getIsCheckedOut() == false){
                                isAvailable = true;     //confirms that the book is available to check out
                                bookSpot = i;   //this spot used to change the attributes of this book when this book is checked out
                                System.out.println("The book is at spot: " + bookSpot + " is the book available? " + isAvailable);                                
                                break;
                        }
                }
                
                //checks if the student is able to check out and if the book is available to checkout 
                if (stuList[stuSpot].getFine()<5.00  && stuList[stuSpot].getIssuedNumOfBooks()<3 && isAvailable ==true){
                        canCheckOut =true;      //confirms if the student is able to check out
                        
                        System.out.println("student's fine is: " + stuList[stuSpot].getFine() + " num of assigned books: " + stuList[stuSpot].getIssuedNumOfBooks());
                        System.out.println("can user checkout? " + canCheckOut);

                }

                return canCheckOut;     //return the boolean to the login class: whether the user is able to check out a book
        }
        
        
        //this method is used to check out a book by the user*********************************************************************************************************
        public static book[] issueBook (boolean returnedBoolean){      //gets the boolean from the login class, which determines if the book is available and if the user is able to check out
                
                System.out.println("CheckOut method starts. The reurned oolean: " + returnedBoolean );
                boolean isCheckedOut = false;           
                int totalBookNum = stuList[stuSpot].getIssuedNumOfBooks();      //gets the number of of books assigned to the user
               
               


                for (int i = 0; i<assignedBooks.length;i++){    //goes through the assigned book list
                    
                        //checks if the book is assigned to the user and if the user able to check out
                    if (assignedBooks[i] == null && bookList[bookSpot]!=assignedBooks[i] && returnedBoolean == true){
                        
                                    assignedBooks[i]=bookList[bookSpot];        //fills the empty spot in the assigned book list with the book object
                                    bookList[bookSpot].changeIsCheckedOut(true);        //changes the book's attribute as the book is checked out
                                    bookList[bookSpot].changeBorrower(stuList[stuSpot]);        //records the holder of the book
                                    totalBookNum = totalBookNum+1;      
                                    stuList[stuSpot].changeIssuedNumOfBooks(totalBookNum);      //increases the number of books assigned to the user by 1

                                    System.out.println("num of assigned books: " + stuList[stuSpot].getIssuedNumOfBooks());
                                    isCheckedOut = true;        //confirms that the books is checked out
                                    System.out.println("Is book checked out? " + isCheckedOut);
                                    break;                 
                            }
                    }
                
                for (int i = 0; i<assignedBooks.length;i++){
                    if(assignedBooks[i]!=null)
                        System.out.println(assignedBooks[i].getTitle());        //prints the assigned bookList
                }
                return assignedBooks;   //returns the assigned book list to the login class
        }


        //This method is used to return books**********************************************************************************************************************************
        public static boolean returnBook (String name, int ISBN,int numOfDays){ //this methods takes in the title and ISBN of the book and the num of days the user is borrowing the book for
                boolean isReturned = false;              
                int exceededDays = numOfDays-14;        //determines by how many days the user has exceeded his limit of 2 weeks                
                double fine = stuList[stuSpot].getFine();       //gets the fine of the user
                int totalBookNum = stuList[stuSpot].getIssuedNumOfBooks();      //get the num of book assigned to the user
                
                for (int i=0; i<bookList.length; i++){  //goes through the book list
                        //checks if the book's name and ISBN match, and if the matched book is checked out
                	
                        if (bookList[i]!=null && bookList[i].getTitle().equalsIgnoreCase(name) && bookList[i].getISBN()==ISBN /*&& bookList[i].getIsCheckedOut()==true && bookList[i].getBorrower().getstuNum()==stuList[stuSpot].getstuNum()*/){
                                
                        	System.out.println("this is the student num of the borrower"+ bookList[i].getBorrower().getstuNum());
                        	bookList[i].changeIsCheckedOut(false);  //the book is returned and no longer checkedOut
                                
                                
                                bookList[i].changeBorrower(null);       //changes the holder of the book and makes it empty                             
                                totalBookNum = totalBookNum -1; 
                                stuList[stuSpot].changeIssuedNumOfBooks(totalBookNum);  //decreases the num of assigned books by 1
                                isReturned = true;      //confirms that the book is returned
                                System.out.println("is the book checked out? "+ bookList[i].getIsCheckedOut());
                                //checks if the user exceeds limit of 2 weeks
                                if (exceededDays>0){
                                    fine = fine + (exceededDays*0.10);  //add fine 10c for each exceeded day on to the existing fine
                                    stuList[stuSpot].changeFine(fine); //I am changing the fine of the holder in library
                                    System.out.println("The total fine is: " + fine);
                            }
                                break;
                        }
                }

                if (isReturned == true){
                        System.out.println("the book was successfully returned");
                }

                else {
                        System.out.println("failed to return. try again.");
                }
                return isReturned;    
        }
        
        //delete the book from book list and add fine to the user******************************************************************************************
        public static boolean lostBook (String lostBook){
    
                
                boolean lostNFined = false;
                double totalFine = 0;	//this is used to determine the fine
                int totalBookNum = stuList[stuSpot].getIssuedNumOfBooks();	//this user to determine the number of books assigned to the user
                
                for (int i=0; i<bookList.length; i++){	//go through the book list
                	//if the book title matches the book in the list and if the book is not checked out, then proceed
                        if (bookList[i]!=null && bookList[i].getTitle().equalsIgnoreCase(lostBook) && bookList[i].getIsCheckedOut()==true /*&& bookList[i].getBorrower()==stuList[stuSpot]*/){                                
                                totalFine = stuList[stuSpot].getFine() + bookList[i].getCost();	//add the cost of the book as fine to the user
                                System.out.println ("total fine" + totalFine);
                                stuList[stuSpot].changeFine(totalFine);	//change the fine of the user
                                System.out.println ("The fine was added. " + "The fine in total is:" + stuList[0].getFine());
                                totalBookNum = totalBookNum -1;	//decreases the num of assigned books by 1
                                stuList[stuSpot].changeIssuedNumOfBooks(totalBookNum);	//changes the number of assigned books to the user
                                System.out.println("you sadly lost this book : " + lostBook);
                                bookList[i]=null;	//deletes the book and makes the book spot empty
                                lostNFined = true;	//confirms that the book was deleted and the price was added     
                                break;
                        }                
                }                
                return lostNFined;
        }

        
        
        //pay the amount the user wants to pay and change the balance**************************************************************************************
        public static double payFine (double amountPaid){	//this method takes in the amount of money the user wants to pay

                double balance = stuList[stuSpot].getFine() - amountPaid;	//determines the fine of the user by subtracting the amount paid
                stuList[stuSpot].changeFine(balance);	//changes the fine of the user
                System.out.println(stuList[bookSpot].getFine());
                return balance;
        }

        //This method compares two book and returns the book which has higher rating*************************************************************************
	        public static String compareBook (String title1, String title2){	//takes in two book titles
	                String higherBookTitle = "";
	                int rating1=0;	//this is used to determine the rating
	                int rating2=0;
	                boolean equalRating = false;
	                for (int i=0; i<bookList.length; i++){	//goes through the book List
	                        if (bookList[i]!=null && bookList[i].getTitle().equalsIgnoreCase(title1)){
	                                rating1 = bookList[i].getRating();	//finds the rating of the first book entered
	                        }
	
	                }
	                for (int i=0; i<bookList.length; i++){
	                        if (bookList[i]!=null && bookList[i].getTitle().equalsIgnoreCase(title2)){
	                                rating2 = bookList[i].getRating();	//finds the rating of the second book entered
	                        }
	                }
	                if(rating1>rating2){
	                        higherBookTitle = title1;	//if the first book has higher rating than the other, get the title of the first book
	                }
	                else if (rating2 > rating1){
	                        higherBookTitle = title2;	//conversely, get the title of the second book
	                }
	                else{
	                	equalRating = true;	//confirms if the books has equal rating
	                        System.out.println("the books have the same rating");
	                }
	                System.out.println(higherBookTitle);
	                return higherBookTitle;	//return the book which has higherTitle
	        }
	        
	        public user [] returnUserList(){
	        	return stuList;
	        }
	        
	        public book [] returnBookList(){
	        	return bookList;
	        }
}




