package razred;

public class Main {

	public static void main(String[] args) {
		
		DBConnect baza = new DBConnect();
		baza.connection("razredi");
		baza.insert("Nadir", "Hujdur");
		baza.getData();
	}

}
