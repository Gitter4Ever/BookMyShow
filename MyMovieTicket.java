import java.util.Scanner;

public class MyMovieTicket  {
	static boolean moreSeats = false;
	static boolean price_flag = false;
	static boolean seat_flag = false;
	Scanner ss = new Scanner(System.in);
	static int[][] seats = { {60,10,20, 80,90,30, 40, 50 }, {40,20,10,30,70, 20, 30, 80 }, {60,10,20,80, 70, 30, 40, 10 },
			{ 10,20,30,80, 40, 30,70,40 },{40,20,50,30,10, 20, 30, 70 },{20,10,40,30,60, 90, 30, 80 },{90,20,10,30,60, 20, 30, 80 } };
	int row = 8, col = 8;

	public static void main(String[] args) {
		Scanner vv = new Scanner(System.in);
		MyMovieTicket sss = new MyMovieTicket();
		sss.bookSeat();
		do {
			System.out.println("Do you want to book more ?  y/n");
			String m = vv.next();
			if (m.equals("y")) {
				moreSeats = true;
				sss.bookSeat();
			} else {
				moreSeats = false;
			}
		} while (moreSeats);
	}

	private void bookSeat() {
		System.out.println("Book a seat for Movie !!  y or  n : ");
		String input = ss.next();
		if (((input.equals("y")) || (input.equals("Y")))) {
			bookSeatNext();
		} else {
			System.out.println("OK Enjoy the park stroll!");
		}
	}

	private void bookSeatNext() {
		String y_n;
		System.out.println("Type p for price and s for seat  p or s : ");
		y_n = ss.next();
		if (y_n.equals("s")) {
			int jjj = pickSeat();
			System.out.println("Price of seat is :  "+jjj);

		} else if (y_n.equals("p")) {
			String yy = pickPrice();
			System.out.println("Your seat number is : " + yy);

		} else {
			System.out.println("Please enter correctly !!!");
			bookSeatNext();
		}
	}

	private String pickPrice() {
		String seat_at_Price = "Seat Not Available";
		int input3 = 0;
		System.out.println("Pick price from $20 to $90 : ");
		try {
			input3 = ss.nextInt();
			if (input3 == 10 || input3 == 20 || input3 == 30 || input3 == 40
					|| input3 == 50 || input3 == 60 || input3 == 70
					|| input3 == 80 || input3 == 90) {
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						if ((seats[i][j] == input3) ){
								if((seats[i][j]) != 0) {
									seats[i][j] = 0;
									int gh =i+65;
									char tt = (char)gh;
									seat_at_Price = (tt + "" + j); //pp
									
									return seat_at_Price;
								}else {
									System.out.println(" This seat Already filled ! Plz choose another !");
									pickPrice();
						}
						}
					}
				}
			} else {
				System.out.println("Price not in Range!!");
				bookSeatNext();
			}
		} catch (Exception e) {
			System.out
					.println("Not a valid price... Sorry ! Plz Enter again !");
			bookSeatNext();
		}
		return seat_at_Price;
	}

	private int pickSeat() {
		int price_of_seat = 0;
		int first_letter = 0;
		System.out.println("Options Available for Seat numbers are : ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int new_first = i + 65;
				char ff = (char) new_first;
				System.out.print(ff + "" + j + " ");
			}
		}

		String inp = ss.next();
		char first_char = inp.charAt(0);
		int temp = (int) first_char;
		if (temp >= 65 && temp <= 91) {
			first_letter = (temp - 65);
		}

		char sec_char = (char) inp.charAt(1);
		String second_letter = Character.toString(sec_char); // store char into String; convert string to integer
		int bb = Integer.parseInt(second_letter);

		for (int i = 0; i < row; i++) {
			if (i == first_letter) {
				for (int j = 0; j < col; j++) {
					if (j == bb) {
						if (seats[i][j] != 0) {
							System.out.println(" Price is : " + seats[i][j]);
							System.out.println("Seat Available Congrats !! :)");
						
							price_of_seat = seats[i][j];
							seats[i][j] = 0;
							return price_of_seat;
							
						} else {
							System.out.println("Sorry Seat Already filled !! Choose again ! ");
							bookSeat();
						}
					}
					}
				}//else {System.out.println("Out of range : Go again !!");
	 		//	bookSeat();
			}
		return price_of_seat;
		}

	}

