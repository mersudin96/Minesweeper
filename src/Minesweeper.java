import java.util.Scanner;

public class Minesweeper {
	
	public static void ispisiPolje(String n[][]) {
		for(int r=0; r<n.length; r++) {
			if(r==0) {
				System.out.print("      ");
				for(int i=0; i<n[0].length; i++) {
					if(i<9)
						System.out.print(+i +".  ");
						
					else
						System.out.print(i +". ");
				}
				System.out.println(); 
			}
		if(r>=10)
			System.out.printf("%d. ", r);
		else
			System.out.printf("%d.  ", r);
		for(int k=0; k<n[0].length; k++) {
			if(k==n[0].length-1)
				System.out.print("|" +n[r][k] +"|");
			else
				System.out.print("|" +n[r][k]);
			}
			System.out.println();
		}
	}
	

	public static void main(String[] args) {
		Scanner unos=new Scanner(System.in);
		System.out.println("Unesite dimenzije polja:");
		int red=unos.nextInt();
		int kolona=unos.nextInt();
		
		while(red==0 || kolona==0) {
			System.out.println("Pogresan unos. Pokusajte ponovo: ");
			red=unos.nextInt();
			kolona=unos.nextInt();
		}
		
		
		String minesweeper[][]=new String[red][kolona];
		int broj,brojacPraznih=0;
		for(int r=0; r<minesweeper.length; r++) {
			for(int k=0; k<minesweeper[0].length; k++) {
				broj=(int)(Math.random()*2);
				if(broj==0) {
					minesweeper[r][k]="   ";
					brojacPraznih++;
				}
				else
					minesweeper[r][k]=" * ";
			}
		}
		
		
		String kopija[][]=new String[red][kolona];
		for(int a=0; a<kopija.length; a++) {
			for(int b=0; b<kopija[0].length; b++)
				kopija[a][b]="   ";
		}
		System.out.println();
		
		
		ispisiPolje(kopija);
		
		
		System.out.print("\nUnesite polje koju želite otkriti: ");
		int r1=unos.nextInt();
		int k1=unos.nextInt();
		while(r1<0 || r1>red-1 || k1<0 || k1>kolona) {
			System.out.println("Pogresan unos. Pokusajte ponovo: ");
			r1=unos.nextInt();
			k1=unos.nextInt();
		}
		System.out.println();
		
		
		while(minesweeper[r1][k1]!=" * ") {
			int brojac=0;
			
			if(r1==red-1 && k1==kolona-1) {
				if(minesweeper[r1-1][k1-1]==" * ")
					brojac++;
				if(minesweeper[r1-1][k1]==" * ")
					brojac++;
				if(minesweeper[r1][k1-1]==" * ")
					brojac++;
				
				if(brojac==0) {
					kopija[r1][k1]="   ";
					brojacPraznih--;
				}
				else {
					kopija[r1][k1]=" " +brojac+" ";
					minesweeper[r1][k1]=" " +brojac+" ";
					brojacPraznih--;
				}
			}
			
			else if(r1==red-1 && k1!=kolona-1 && k1!=0) {
				if(minesweeper[r1-1][k1-1]==" * ")
					brojac++;
				if(minesweeper[r1][k1-1]==" * ")
					brojac++;
				if(minesweeper[r1][k1+1]==" * ")
					brojac++;
				
				if(brojac==0) {
					kopija[r1][k1]="   ";
					brojacPraznih--;
				}
				else {
					kopija[r1][k1]=" " +brojac+" ";
					minesweeper[r1][k1]=" " +brojac+" ";
					brojacPraznih--;
				}
			}
			
			else if(r1==red-1 && k1==0) {
				if(minesweeper[r1-1][k1]==" * ")
					brojac++;
				if(minesweeper[r1][k1+1]==" * ")
					brojac++;
				if(minesweeper[r1-1][k1+1]==" * ")
					brojac++;
				
				if(brojac==0) {
					kopija[r1][k1]="   ";
					brojacPraznih--;
				}
				else {
					kopija[r1][k1]=" " +brojac+" ";
					minesweeper[r1][k1]=" " +brojac+" ";
					brojacPraznih--;
				}
			}
			
			else if(r1!=red-1 && k1==0 && r1!=0) {
				if(minesweeper[r1-1][k1]==" * ")
					brojac++;
				if(minesweeper[r1+1][k1]==" * ")
					brojac++;
				if(minesweeper[r1+1][k1+1]==" * ")
					brojac++;
				if(minesweeper[r1][k1+1]==" * ")
					brojac++;
				if(minesweeper[r1-1][k1+1]==" * ")
					brojac++;
				
				if(brojac==0) {
					kopija[r1][k1]="   ";
					brojacPraznih--;
				}
				else {
					kopija[r1][k1]=" " +brojac+" ";
					minesweeper[r1][k1]=" " +brojac+" ";
					brojacPraznih--;
				}
			}
			
			else if(r1!=red-1 && k1==kolona-1 && r1!=0) {
				if(minesweeper[r1-1][k1-1]==" * ")
					brojac++;
				if(minesweeper[r1-1][k1]==" * ")
					brojac++;
				if(minesweeper[r1][k1-1]==" * ")
					brojac++;
				if(minesweeper[r1+1][k1]==" * ")
					brojac++;
				if(minesweeper[r1+1][k1-1]==" * ")
					brojac++;
				
				if(brojac==0) {
					kopija[r1][k1]="   ";
					brojacPraznih--;
				}
				else {
					kopija[r1][k1]=" " +brojac+" ";
					minesweeper[r1][k1]=" " +brojac+" ";
					brojacPraznih--;
				}
			}
			
			else if(r1==0 && k1==kolona-1) {
				if(minesweeper[r1][k1-1]==" * ")
					brojac++;
				if(minesweeper[r1+1][k1]==" * ")
					brojac++;
				if(minesweeper[r1+1][k1-1]==" * ")
					brojac++;
				
				if(brojac==0) {
					kopija[r1][k1]="  ";
					brojacPraznih--;
				}
				else {
					kopija[r1][k1]=brojac+" ";
					minesweeper[r1][k1]=brojac+" ";
					brojacPraznih--;
				}
			}
			
			else if(r1==0 && k1==0) {
				if(minesweeper[r1+1][k1]==" * ")
					brojac++;
				if(minesweeper[r1+1][k1+1]==" * ")
					brojac++;
				if(minesweeper[r1][k1+1]==" * ")
					brojac++;
				
				if(brojac==0) {
					kopija[r1][k1]="   ";
					brojacPraznih--;
				}
				else {
					kopija[r1][k1]=" " +brojac+" ";
					minesweeper[r1][k1]=" " +brojac+" ";
					brojacPraznih--;
				}
				
			}
			
			else if(r1==0 && k1!=0 && k1!=kolona-1) {
				if(minesweeper[r1][k1-1]==" * ")
					brojac++;
				if(minesweeper[r1+1][k1]==" * ")
					brojac++;
				if(minesweeper[r1+1][k1+1]==" * ")
					brojac++;
				if(minesweeper[r1][k1+1]==" * ")
					brojac++;
				if(minesweeper[r1+1][k1-1]==" * ")
					brojac++;
				
				if(brojac==0) {
					kopija[r1][k1]="   ";
					brojacPraznih--;
				}
				else {
					kopija[r1][k1]=" " +brojac+" ";
					minesweeper[r1][k1]=" " +brojac+" ";
					brojacPraznih--;
				}
			}
			
			else {
				if(minesweeper[r1-1][k1-1]==" * ")
					brojac++;
				if(minesweeper[r1-1][k1]==" * ")
					brojac++;
				if(minesweeper[r1][k1-1]==" * ")
					brojac++;
				if(minesweeper[r1+1][k1]==" * ")
					brojac++;
				if(minesweeper[r1+1][k1+1]==" * ")
					brojac++;
				if(minesweeper[r1][k1+1]==" * ")
					brojac++;
				if(minesweeper[r1-1][k1+1]==" * ")
					brojac++;
				if(minesweeper[r1+1][k1-1]==" * ")
					brojac++;
				
				if(brojac==0) {
					kopija[r1][k1]="   ";
				}
				else {
					kopija[r1][k1]=" " +brojac+" ";
					minesweeper[r1][k1]=" " +brojac+" ";
					brojacPraznih--;
				}
			}
				
			
			ispisiPolje(kopija);
			
			if(brojacPraznih==0)
				break;
			
			System.out.println("\nJoš " +brojacPraznih +" slobodnih pozicija. Unesite sljedece polje: ");
			r1=unos.nextInt();
			k1=unos.nextInt();
			while(r1<0 || r1>red-1 || k1<0 || k1>kolona) {
				System.out.println("Pogresan unos. Pokusajte ponovo: ");
				r1=unos.nextInt();
				k1=unos.nextInt();
			}
			System.out.println();
		}
		
		if(brojacPraznih==0)
			System.out.println("Cestitamo. Pobijedili ste!");
		else {
			for(int d=0; d<(red*2)-2; d++)
				System.out.print(" ");
			System.out.println("GAME OVER!");
			minesweeper[r1][k1]=" X ";
			ispisiPolje(minesweeper);
		}
		unos.close();
	}
}

