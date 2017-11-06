public class user {
        private String firstName;	//the first name of the user
        private String lastName;	//the last name of the user
        private int stuNum;			//the student number of the user
        private double fine;		//user's fine
        private int issuedNumOfBooks;	//number of books assigned to the user 
        public static book [] checkedOutBooks = new book[3];	//this is the list of assigned book of the user

        //this method gets the attributes of a user and makes it equal to the variables
        public user(int studentNum, String fName, String lName, double stuFine, int stuIssuedNumOfBooks, book[] userCheckedOutBooks){
        stuNum = studentNum;
        firstName = fName;
        lastName = lName;
        fine = stuFine;
        issuedNumOfBooks = stuIssuedNumOfBooks;
        checkedOutBooks = null;
        }
    
        //returns the student number
        public int  getstuNum(){
        return stuNum;
        }
        
        //returns the first name of a user
        public String getfirstName(){
        return firstName;
        }
    
        //returns the last name of a user
        public String  getlastName(){
        return lastName;
        }
    
        //changes user's fine 
        public void changeFine(double userFine){
         fine = userFine;
        }
        
        //returns user's fine
        public double  getFine(){
        return fine;
        }
    
        //changes the number of books assigned to the user
        public void changeIssuedNumOfBooks(int userBooks){
         issuedNumOfBooks = userBooks;
        }
    
        //returns the number of books assigned to the user
        public  int getIssuedNumOfBooks(){
        return issuedNumOfBooks;
        }
        
        //changes the assigned book list when user return, lost or checks out a book
        //public void changeCheckedOutBooks(book[] newBookList){
        //	checkedOutBooks = newBookList;
        //}
    
        //returns the assigned book list
        public book[] getCheckedOutBooks(){
         return checkedOutBooks;
        }
    
}

