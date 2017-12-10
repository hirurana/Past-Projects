package libraryAssignment4;

public class Library {
	//defining the initial variables
	String address;
	Book[] booksArray = new Book[4];
	
	//Method to create a library
	public Library(String libAddress){
		address = libAddress;
	}
	
	//Method to create a new book
	public void addBook(Book name){
		for (int i = 0; i < booksArray.length; i++){
			if (booksArray[i] == null){
					booksArray[i] = name;
					break;
			}
		}
	}
	
	//Method to print opening hours
	public static void printOpeningHours(){
		System.out.println("Libraries are open daily from 9am to 5pm.");
	}
	
	//Method to print the locations of all libraries
	public void printAddress(){
		System.out.println(address);
	}
	
	//Method to borrow a book
	public void borrowBook(String bookName){
		//iteration that goes through the array
		for (int i = 0; i < booksArray.length; i++){
			//if there is something in the array then look into it
			if (booksArray[i] != null){ 
				//if it's the book being searched for, borrow it
				if (booksArray[i].getTitle() == bookName) {
					//if it hasn't been borrowed before, borrow it
					if (booksArray[i].borrowed == false) {
						booksArray[i].borrowed();
						//remove the book from the library
						booksArray[i] = null;
						System.out.println("You have borrowed " + bookName);
					}
				}
			//if there isn't anything in the array, tell the user the book was never in the Library
			} else {
				System.out.println(bookName + " is not in this Library");
				break;
			}
			
		}
	}
	
	
	
	public void printAvailableBooks(){
			for (int i = 0; i < booksArray.length; i++){
				if (booksArray[i] != null){
					System.out.println(booksArray[i].getTitle());
				} else {
					if (i == 0 && booksArray[i+1] == null ){
						System.out.println("No book in catalog");
						break;
					} 
				}
			}
	}
	
	public void returnBook(String bookName){
		for (int i = 0; i < booksArray.length; i++){
			if (booksArray[i] == null){
				addBook(new Book(bookName));
				System.out.println("You have returned " + bookName);
				break;
				}
		}
	}
	
	public int getIndex(){
		for (int i = 0; i < booksArray.length; i++) {
			System.out.println(i);
			if (booksArray[i] == null){
				return i;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		
		// Create two libraries
		Library firstLibrary = new Library("10 Main St."); 
		Library secondLibrary = new Library("228 Liberty St.");
		
		// Add four books to the first library
		firstLibrary.addBook(new Book("The Da Vinci Code"));
		firstLibrary.addBook(new Book("Le Petit Prince"));
		firstLibrary.addBook(new Book("A Tale of Two Cities")); 
		firstLibrary.addBook(new Book("The Lord of the Rings"));
		
		// Print opening hours and the addresses
		System.out.println("Library hours:"); 
		printOpeningHours(); 
		System.out.println();
		
		System.out.println("Library addresses:"); 
		firstLibrary.printAddress(); 
		secondLibrary.printAddress(); 
		System.out.println();
		
		// Try to borrow The Lords of the Rings from both libraries
		System.out.println("Borrowing The Lord of the Rings:"); 
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings");
		secondLibrary.borrowBook("The Lord of the Rings"); 
		System.out.println();
		
		// Print the titles of all available books from both libraries
		System.out.println("Books available in the first library:"); 
		firstLibrary.printAvailableBooks();
		System.out.println();
		System.out.println("Books available in the second library:"); 
		secondLibrary.printAvailableBooks();
		System.out.println();
		
		
		// Return The Lords of the Rings to the first library
		System.out.println("Returning The Lord of the Rings:"); 
		firstLibrary.returnBook("The Lord of the Rings"); 
		System.out.println();
		
		// Print the titles of available from the first library
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks(); }
		
}