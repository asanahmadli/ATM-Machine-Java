import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu {
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	HashMap<Integer, Account> data = new HashMap<Integer, Account>();

	public void getLogin() throws IOException {
		boolean end = false;
		int customerNumber = 0;
		int pinNumber = 0;
		while (!end) {
			try {
				System.out.print("\nEnter your customer number: ");
				customerNumber = menuInput.nextInt();
				System.out.print("\nEnter your PIN number: ");
				pinNumber = menuInput.nextInt();

				Account account = new Account();
				account.setCustomerNumber(customerNumber);;
				account.setPinNumber(pinNumber);
				Integer custNum = account.getCustomerNumber();
				int pinNum = account.getPinNumber();
				loginData(custNum,pinNum);

//				data.put(custNum,account);
				Iterator it = data.entrySet().iterator();

				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					Account acc = (Account) pair.getValue();

					if (data.containsKey(customerNumber) && pinNumber == acc.getPinNumber()) {

						getAccountType(acc);
						end = true;
						break;

					}
				}
				if (!end) {
					System.out.println("\nWrong Customer Number or Pin Number");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Character(s). Only Numbers.");
			}
		}
	}

	public void loginData(int customerNUmber, int pinNumber){
		try {
			//PrintWriter printWriter = new PrintWriter("/Users/asan/Desktop/Projects/ATM-Machine-Java/loginDate.log");
			FileWriter fileWriter = new FileWriter("/Users/asan/Desktop/Projects/ATM-Machine-Java/loginDate.log",true);
			fileWriter.write(customerNUmber +" " +pinNumber + "\n");
			fileWriter.close();
			Scanner scanner = new Scanner("/Users/asan/Desktop/Projects/ATM-Machine-Java/loginDate.log");

			while (scanner.hasNextLine()){
				System.out.println(scanner.nextLine());
			}


		}
		catch (FileNotFoundException e){
			System.out.println("File not found "+e.getMessage());
		} catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


	public void getAccountType(Account acc) {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nSelect the account you want to access: ");
				System.out.println(" Type 1 - Checking Account");
				System.out.println(" Type 2 - Savings Account");
				System.out.println(" Type 3 - Investment Account");
				System.out.println(" Type 4 - Exit");

				System.out.print("\nChoice: ");

				int selection = menuInput.nextInt();

				switch (selection) {
				case 1:
					getChecking(acc);
					break;
				case 2:
					getSaving(acc);
					break;
					case 3:
					getInvestment(acc);
						break;
				case 4:
					end = true;
					break;
				default:
					System.out.println("\nInvalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				menuInput.next();
			}
		}
	}

	public void getChecking(Account acc) {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nChecking Account: ");
				System.out.println(" Type 1 - View Checking Balance");
				System.out.println(" Type 2 - Withdraw Funds");
				System.out.println(" Type 3 - Deposit Funds");
				System.out.println(" Type 4 - Transfer Funds");
				System.out.println(" Type 5 - Total Account Balance");
				System.out.println(" Type 6 - Show Transaction History");
				System.out.println(" Type 7 - Exit");
				System.out.print("\nChoice: ");

				int selection = menuInput.nextInt();

				switch (selection) {
				case 1:
					System.out.println("\nChecking Account Balance: " + moneyFormat.format(acc.getCheckingBalance()));
					break;
				case 2:
					acc.getCheckingWithdrawInput();
					break;
				case 3:
					acc.getCheckingDepositInput();
					break;

				case 4:
					acc.getTransferInput("Checking");
					break;
					case 5:
						System.out.println("\nTotal Account Balance: " + moneyFormat.format(acc.totalBalance()));
						break;
					case 6:
						acc.getCheckingLogs();
						break;
				case 7:
					end = true;
					break;
				default:
					System.out.println("\nInvalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				menuInput.next();
			}
		}
	}

	public void getSaving(Account acc) {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nSavings Account: ");
				System.out.println(" Type 1 - View Saving Balance");
				System.out.println(" Type 2 - Withdraw Funds");
				System.out.println(" Type 3 - Deposit Funds");
				System.out.println(" Type 4 - Transfer Funds");
				System.out.println(" Type 5-  Total Account Balance");
				System.out.println(" Type 6 - Show Transaction History");
				System.out.println(" Type 7 - Exit");
				System.out.print("Choice: ");
				int selection = menuInput.nextInt();
				switch (selection) {
				case 1:
					System.out.println("\nSavings Account Balance: " + moneyFormat.format(acc.getSavingBalance()));
					break;
				case 2:
					acc.getsavingWithdrawInput();
					break;
				case 3:
					acc.getSavingDepositInput();
					break;
				case 4:
					acc.getTransferInput("Savings");
					break;
					case 5:
						System.out.println("\nTotal Account Balance: " + moneyFormat.format(acc.totalBalance()));
						break;
					case 6:
						acc.getSavingLogs();
						break;
				case 7:
					end = true;
					break;
				default:
					System.out.println("\nInvalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				menuInput.next();
			}
		}
	}

	public void getInvestment(Account acc) {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nInvestment Account: ");
				System.out.println(" Type 1 - View Investment Balance");
				System.out.println(" Type 2 - Withdraw Funds");
				System.out.println(" Type 3 - Deposit Funds");
				System.out.println(" Type 4 - Transfer Funds");
				System.out.println(" Type 5 - All Account's Total Balance");
				System.out.println(" Type 6 - Show Transaction History");
				System.out.println(" Type 7 - Exit");
				System.out.print("Choice: ");
				int selection = menuInput.nextInt();
				switch (selection) {
					case 1:
						System.out.println("\nInvestment Account Balance: " + moneyFormat.format(acc.investmentBalance()));
						break;
					case 2:
					acc.investmentWithdrawInput();
						break;
					case 3:
					acc.investmentDepositInput();
						break;
					case 4:
						acc.getTransferInput("Investment");
						break;
					case 5:
						System.out.println("\nTotal Account Balance: " + moneyFormat.format(acc.totalBalance()));
						break;
					case 6:
						acc.getInvestmentLogs();
						break;
					case 7:
						end = true;
						break;
					default:
						System.out.println("\nInvalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				menuInput.next();
			}
		}
	}


	public void createAccount() throws IOException {
		int cst_no = 0;
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nEnter your customer number ");
				cst_no = menuInput.nextInt();
				Iterator it = data.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					if (!data.containsKey(cst_no)) {

						end = true;
					}
				}
				if (!end) {
					System.out.println("\nThis customer number is already registered");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				menuInput.next();
			}
		}
		System.out.println("\nEnter PIN to be registered");
		int pin = menuInput.nextInt();
		data.put(cst_no, new Account(cst_no, pin));
		System.out.println("\nYour new account has been successfuly registered!");
		System.out.println("\nRedirecting to login.............");
		getLogin();
	}

	public void mainMenu() throws IOException {
		data.put(952141, new Account(952141, 191904, 1000, 5000));
		data.put(123, new Account(123, 123, 20000, 50000));
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\n Type 1 - Login");
				System.out.println(" Type 2 - Create Account");
				System.out.print("\nChoice: ");
				int choice = menuInput.nextInt();
				switch (choice) {
				case 1:
					getLogin();
					end = true;
					break;
				case 2:
					createAccount();
					end = true;
					break;
				default:
					System.out.println("\nInvalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				menuInput.next();
			}
		}
		System.out.println("\nThank You for using this ATM.\n");
		menuInput.close();
		System.exit(0);
	}
}
