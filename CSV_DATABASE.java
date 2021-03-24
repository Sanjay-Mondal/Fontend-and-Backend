import java.sql.*;
import java.util.ArrayList;

public class csv_database {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("The driver is to be loaded");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/h2h_internship","root","root");
		System.out.println("The DB is connected");
		//Statement st=con.createStatement();
		//ResultSet rs=st.executeQuery("INSERT INTO invoice_details VALUES *");
		String s = " INSERT INTO";
		PreparedStatement st=con.prepareStatement(s)
		//Creating an ArrayList object
		ArrayList<Avenger> Datelist = new ArrayList<>();
		
		while(rs.next()) {
			Avenger studObj= new Avenger();
		//	String business_code = rs.getString("business_code");
		//	String cust_number  = rs.getString("cust_number");
		//	String name_customer = rs.getString("name_customer");	
		//	Date clear_date = rs.getDate("clear_date");	
		//	Date buisness_year = rs.getDate("buisness_year");			
		//	String doc_id = rs.getString("doc_id");
		//	Date posting_date = rs.getDate("posting_date");
		//	Date document_create_date = rs.getDate("document_create_date");
		//	Date due_in_date = rs.getDate("due_in_date");
		//	String invoice_currency = rs.getString("invoice_currency");
		//	String document_type = rs.getString("document_type");
		//	Integer posting_id = rs.getInt("posting_id");
		//	String area_business = rs.getString("area_business");
		//	Float total_open_amount= rs.getFloat("total_open_amount");
		//	Date baseline_create_date = rs.getDate("baseline_create_date");
		//	String cust_payment_terms = rs.getString("cust_payment_terms");
		//	String invoice_id = rs.getString("invoice_id");
		//	Integer isOpen = rs.getInt("isOpen");
			
			studObj.setBusiness_code(rs.getString("business_code"));
			studObj.setCust_number(rs.getString("cust_number"));
			studObj.setName_customer(rs.getString("name_customer"));
			studObj.setClear_date(rs.getDate("clear_date"));
			studObj.setBuisness_year(rs.getDate("buisness_year"));
			studObj.setDoc_id(rs.getString("doc_id"));
			studObj.setPosting_date(rs.getDate("posting_date"));
			studObj.setArea_business(rs.getString("area_business"));
			studObj.setTotal_open_amount(rs.getFloat("total_open_amount"));
			studObj.setBaseline_create_date(rs.getDate("baseline_create_date"));
			studObj.setCust_payment_terms(rs.getString("cust_payment_terms"));
			studObj.setInvoice_currency(rs.getString("invoice_id"));
			studObj.setIsOpen(rs.getInt("isOpen"));

			

			Datelist.add(studObj);
			
			//System.out.println(fName+" "+lName+" "+serial+" "+alias+" "+quote);
		}
		for (Avenger obj : Datelist) {
			System.out.print("business_code: "+obj.getBusiness_code()+", ");
			System.out.print("cust_number: "+obj.getCust_number()+", ");
			System.out.print("name_customer: "+obj.getName_customer()+", ");
			System.out.print("clear_date: "+obj.getClear_date()+", ");
			System.out.print("buisness_year: "+obj.getBuisness_year()+", ");
			System.out.print("doc_id: "+obj.getDoc_id()+", ");
			System.out.print("posting_date: "+obj.getPosting_date()+", ");
			System.out.print("area_business: "+obj.getArea_business()+", ");
			System.out.print("total_open_amount: "+obj.getTotal_open_amount()+", ");
			System.out.print("baseline_create_date: "+obj.getBaseline_create_date()+", ");
			System.out.print("cust_payment_terms: "+obj.getCust_payment_terms()+", ");
			System.out.print("invoice_id: "+obj.getInvoice_currency()+", ");
			System.out.print("isOpen: "+obj.getIsOpen()+", ");
			System.out.println();
			}
		st.close();
		con.close();
	}

}