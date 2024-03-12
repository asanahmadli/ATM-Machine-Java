import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
	// variables
	private int customerNumber;
	private int pinNumber;
	private double checkingBalance = 0;
	private double savingBalance = 0;
	private double totalBalance = 0;
	private double investmentBalance = 0;

	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	public Account() {
	}

	public Account(int customerNumber, int pinNumber) {
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
	}

	public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance) {
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
		this.checkingBalance = checkingBalance;
		this.savingBalance = savingBalance;
	}

	public double totalBalance() {
		totalBalance = checkingBalance + savingBalance + investmentBalance;
		return totalBalance;
	}





	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		//return customerNumber;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		//return pinNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public double getSavingBalance() {
		return savingBalance;
	}

	public double calcCheckingWithdraw(double amount) {
		checkingBalance = (checkingBalance - amount);
		return checkingBalance;
	}

	public double calcSavingWithdraw(double amount) {
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}

	public double calcCheckingDeposit(double amount) {
		checkingBalance = (checkingBalance + amount);
		return checkingBalance;
	}

	public double calcSavingDeposit(double amount) {
		savingBalance = (savingBalance + amount);
		return savingBalance;
	}

	public void calcCheckTransfer(double amount) {
		checkingBalance = checkingBalance - amount;
		savingBalance = savingBalance + amount;
	}

	public void calcSavingTransfer(double amount) {
		savingBalance = savingBalance - amount;
		checkingBalance = checkingBalance + amount;
	}

	public double investmentBalance(){
		return investmentBalance;
	}

	public double calcInvestmentWithdraw(double amount){
		investmentBalance-=amount;
		return investmentBalance;
	}

	public double calcInvestmentDepositFromChecking(double amount){
		checkingBalance-=amount;
		investmentBalance+=amount;
		return investmentBalance;
	}

	public double calcInvestmentDepositFromSaving(double amount){
		savingBalance-=amount;
		investmentBalance+=amount;
		return investmentBalance;
	}

	public void getCalcInvestmentTransferToChecking(double amount){
		investmentBalance-=amount;
		checkingBalance+=amount;
	}

	public void getCalcInvestmentTransferToSaving(double amount){
		investmentBalance-=amount;
		savingBalance+=amount;
	}




	public double calcInvestmentDeposit(double amount) {
		investmentBalance = (investmentBalance + amount);
		return investmentBalance;
	}


	public void investmentWithdrawInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Investment Account Balance: " + moneyFormat.format(investmentBalance));
				System.out.print("\nAmount you want to withdraw from Investment Account: ");
				double amount = input.nextDouble();
				if ((investmentBalance - amount) >= 0 && amount >= 0) {
					calcInvestmentWithdraw(amount);
					System.out.println("\nCurrent Investment Account Balance: " + moneyFormat.format(investmentBalance));
					end = true;
				} else {
					System.out.println("\nBalance Cannot be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getCheckingWithdrawInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
				System.out.print("\nAmount you want to withdraw from Checking Account: ");
				double amount = input.nextDouble();
				if ((checkingBalance - amount) >= 0 && amount >= 0) {
					calcCheckingWithdraw(amount);
					System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
					end = true;
				} else {
					System.out.println("\nBalance Cannot be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getsavingWithdrawInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
				System.out.print("\nAmount you want to withdraw from Savings Account: ");
				double amount = input.nextDouble();
				if ((savingBalance - amount) >= 0 && amount >= 0) {
					calcSavingWithdraw(amount);
					System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void investmentDepositInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Investment Account Balance: " + moneyFormat.format(investmentBalance));
				System.out.print("\nAmount you want to deposit your Investment Account: ");
				double amount = input.nextDouble();
				if ((investmentBalance + amount) >= 0 && amount >= 0) {
					calcInvestmentDeposit(amount);
					System.out.println("\nCurrent Investment Account Balance: " + moneyFormat.format(investmentBalance));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getCheckingDepositInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
				System.out.print("\nAmount you want to deposit your Checking Account: ");
				double amount = input.nextDouble();
				if ((checkingBalance + amount) >= 0 && amount >= 0) {
					calcCheckingDeposit(amount);
					System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getSavingDepositInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
				System.out.print("\nAmount you want to deposit into your Savings Account: ");
				double amount = input.nextDouble();

				if ((savingBalance + amount) >= 0 && amount >= 0) {
					calcSavingDeposit(amount);
					System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getTransferInput(String accType) {
		boolean end = false;
		while (!end) {
			try {
				if (accType.equals("Checking")) {
					System.out.println("\nSelect an account you wish to transfer funds to:");
					System.out.println("1. Savings");
					System.out.println("2. Investment");
					System.out.println("3. Exit");
					System.out.print("\nChoice: ");
					int choice = input.nextInt();
					switch (choice) {
					case 1:
						System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
						System.out.print("\nAmount you want to deposit into your Savings Account: ");
						double amount = input.nextDouble();
						if ((savingBalance + amount) >= 0 && (checkingBalance - amount) >= 0 && amount >= 0) {
							calcCheckTransfer(amount);
							System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
							System.out.println(
									"\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
							end = true;
						} else {
							System.out.println("\nBalance Cannot Be Negative.");
						}
						break;
						case 2:
							System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
							System.out.print("\nAmount you want to deposit into your Investment Account: ");
							double amount1 = input.nextDouble();
							if ((investmentBalance + amount1) >= 0 && (checkingBalance - amount1) >= 0 && amount1 >= 0) {
								calcCheckTransfer(amount1);
								System.out.println("\nCurrent Investment Account Balance: " + moneyFormat.format(investmentBalance));
								System.out.println(
										"\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
								end = true;
							} else {
								System.out.println("\nBalance Cannot Be Negative.");
							}
							break;
					case 3:
						return;
					default:
						System.out.println("\nInvalid Choice.");
						break;
					}
				}

				else if (accType.equals("Investment")) {
					System.out.println("\nSelect an account you wish to transfer funds to: ");
					System.out.println("1. Checking");
					System.out.println("2. Saving");
					System.out.println("3. Exit");
					System.out.print("\nChoice: ");
					int choice = input.nextInt();
					switch (choice) {
						case 1:
							System.out.println("\nCurrent Investment Account Balance: " + moneyFormat.format(investmentBalance));
							System.out.print("\nAmount you want to deposit into your checking account: ");
							double amount = input.nextDouble();
							if ((checkingBalance + amount) >= 0 && (investmentBalance - amount) >= 0 && amount >= 0) {
								getCalcInvestmentTransferToChecking(amount); //
								System.out.println("\nCurrent investment account balance: " + moneyFormat.format(investmentBalance));
								System.out.println("\nCurrent checking account balance: " + moneyFormat.format(checkingBalance));
								end = true;
							} else {
								System.out.println("\nBalance Cannot Be Negative.");
							}
							break;
						case 2:
							System.out.println("\nCurrent Investment Account Balance: " + moneyFormat.format(investmentBalance));
							System.out.print("\nAmount you want to deposit into your saving Account: ");
							double amount1 = input.nextDouble();
							if ((savingBalance + amount1) >= 0 && (investmentBalance - amount1) >= 0 && amount1 >= 0) {
								getCalcInvestmentTransferToSaving(amount1);
								System.out.println("\nCurrent Investment Account Balance: " + moneyFormat.format(investmentBalance));
								System.out.println(
										"\nCurrent Saving Account Balance: " + moneyFormat.format(savingBalance));
								end = true;
							} else {
								System.out.println("\nBalance Cannot Be Negative.");
							}
							break;
						case 3:
							return;
						default:
							System.out.println("\nInvalid Choice.");
							break;
					}
				}

				else if (accType.equals("Savings")) {
					System.out.println("\nSelect an account you wish to transfer funds to: ");
					System.out.println("1. Checking");
					System.out.println("2. Investment");
					System.out.println("3. Exit");
					System.out.print("\nChoice: ");
					int choice = input.nextInt();
					switch (choice) {
					case 1:
						System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
						System.out.print("\nAmount you want to deposit into your checking account: ");
						double amount = input.nextDouble();
						if ((checkingBalance + amount) >= 0 && (savingBalance - amount) >= 0 && amount >= 0) {
							calcSavingTransfer(amount);
							System.out.println("\nCurrent checking account balance: " + moneyFormat.format(checkingBalance));
							System.out.println("\nCurrent savings account balance: " + moneyFormat.format(savingBalance));
							end = true;
						} else {
							System.out.println("\nBalance Cannot Be Negative.");
						}
						break;
						case 2:
							System.out.println("\nCurrent Saving Account Balance: " + moneyFormat.format(savingBalance));
							System.out.print("\nAmount you want to deposit into your Investment Account: ");
							double amount1 = input.nextDouble();
							if ((investmentBalance + amount1) >= 0 && (savingBalance - amount1) >= 0 && amount1 >= 0) {
								calcInvestmentDepositFromSaving(amount1);
								System.out.println("\nCurrent Investment Account Balance: " + moneyFormat.format(investmentBalance));
								System.out.println(
										"\nCurrent Saving Account Balance: " + moneyFormat.format(savingBalance));
								end = true;
							} else {
								System.out.println("\nBalance Cannot Be Negative.");
							}
							break;
					case 3:
						return;
					default:
						System.out.println("\nInvalid Choice.");
						break;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}
}
