public class book {
        private String title;	//the title of a book
        private int ISBN;		//the ISBN of a book
        private String category;	//the category of a book
        private String author;	//the author's name of a book
        private double cost;	//the price of a book
        private int rating;	//the rating of a book
        private boolean isCheckedOut;	//determines if the book is checked our
        private user borrower;	//the holder of a book to whom the book is assigned 

        //this method gets the attributes of a book and makes it equal to the variables
        public book(String bookTitle, int bookISBN, String bookAuthor, String bookCatagory,double bookCost, int bookRating, boolean isBookCheckedOut, user bookBorrower){

                title = bookTitle;
                ISBN = bookISBN;
                category = bookCatagory;
                author = bookAuthor;
                cost = bookCost;
                rating = bookRating;
                isCheckedOut = isBookCheckedOut;
                borrower = bookBorrower;
        }
        
        //this returns the title of a book
        public String  getTitle(){
                return title;
        }
         
        //this return the ISBN of a book
        public int getISBN(){
                return ISBN;
        }
        
        //this returns the category of a book
        public String  getcatagory(){
                return category;
        }
        
        //this returns the authors name of a book
        public String  getAuthor(){
                return author;
        }
        
        //this returns the price of a book 
        public double  getCost(){
                return cost;
        }
        
        //this returns the rating of a book 
        public int getRating (){
                return rating;
        }
        
        //this changes the status of a book whether the book is already checked out or not 
        public void changeIsCheckedOut(boolean isCheckedOutBook){
                isCheckedOut = isCheckedOutBook ;
        }
        
        //returns if a book is checked out
                public boolean getIsCheckedOut(){            
                 return isCheckedOut;
        }
        
         //changes the holder of a book when the book is assigned to another user, returned or lost
         public void changeBorrower(user newBorrower){
                 newBorrower = borrower;                
         }
         
         //returns the holder of a book
        public user getBorrower(){
                 return borrower;
        }

}

