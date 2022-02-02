import java.util.Scanner;

class AccountDetails{
	private String accNo;
	private String name;
	private String accType;
	private long balance;
	
	Scanner sc=new Scanner(System.in);
	
	public void openAccount(){
		
		System.out.println("Enter Account No:");
		accNo=sc.next();
		System.out.println("Enter Account type:");
		accType=sc.next();
		System.out.println("Enter Name:");
		name=sc.next();
		System.out.println("Enter Balance");
		balance=sc.nextLong();
	}
	
	public void displayAccountDetails(){
		
		System.out.println("Name of account holder: "+name);
		System.out.println("Account no: "+accNo);
		System.out.println("Account type: "+accType);
		System.out.println("Balance: "+balance);		
	}
	
	public void deposit(){
		
		long amt;
		System.out.println("Enter the amount you want to deposit: ");
		amt=sc.nextLong();
		balance = balance + amt;
	}
	
	public void withdrawal(){
		
		long amt;
		System.out.println("Enter the amount you want to withdraw:");
		amt=sc.nextLong();
		
		if(balance >= amt){
			balance = balance - amt;
			System.out.println("Balance after withdrawal: "+balance);
		}else{
			System.out.println("Your balance is less than "+amt+"\tTransaction failed...!!!");
		}
	}
	
	public boolean search(String acc_no){
		
		if(accNo.equals(accNo)){
			displayAccountDetails();
			return(true);
		}
		return(false);
	}
}

public class BankApplication {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("How many number of customers do you want to input?");
		int n=sc.nextInt();
		AccountDetails c[]=new AccountDetails[n];
		for(int i=0;i<c.length;i++){
			c[i]=new AccountDetails();
			c[i].openAccount();
		}
		
		int ch;
		do{
			
			System.out.println("\n***Bank Application***");
			System.out.println("1.Display all account details \n 2.Search by Account number\n 3.Deposite the amount\n 4.Withdraw the amount\n 5.Exit");
			System.out.println("Enter your choice: ");
			ch=sc.nextInt();
			
			switch(ch){
			
			case 1:
				for(int i=0;i<c.length;i++){
					c[i].displayAccountDetails();
				}
				break;
				
			case 2:
				System.out.println("Enter account no. you want to search: ");
				String acc_no=sc.next();
				boolean found=false;
				for(int i=0;i<c.length;i++){
					found=c[i].search(acc_no);
					if(found){
						break;
					}
				}
				
				if(!found){
					System.out.println("Search failed! Account doesn't exist..!!");
				}
				break;
				
			case 3:
				System.out.println("Enter Account no.: ");
				acc_no=sc.next();
				found=false;
				for(int i=0;i<c.length;i++){
					found=c[i].search(acc_no);
					if(found){
						c[i].deposit();
						break;
					}
				}
				
				if(!found){
					System.out.println("Search failed! Account doesn't exist..!!");
				}
				break;
				
			case 4:
				System.out.print("Enter Account no: ");
				acc_no=sc.next();
				found=false;
				for(int i=0;i<c.length;i++){
					found=c[i].search(acc_no);
					if(found){
						c[i].withdrawal();
						break;
						
					}
				}
				if(!found){
					System.out.println("Search failed! Account doesn't exist..!!");
				}
				break;
				
			case 5:
				System.out.println(" Thank you for using our service\n See you soon...");
				break;
			}
		}
		while(ch!=5);
	}

}
