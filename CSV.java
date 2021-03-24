public class CSV {
	   public static void read(String csvFile) {
	      try {
	    	  int C=0;
	         File file = new File(csvFile);
	         FileReader fr = new FileReader(file);
	         BufferedReader br = new BufferedReader(fr);
	         String line = "";
	         String[] strArr;
	         int x=0;
	         ArrayList<POJO> database = new ArrayList<>();
	         // read the first line because it has all the columns names and will cause problem when converting data types 
	         line = br.readLine();
	         while ((line = br.readLine()) != null) {
	            strArr = line.split(",");
            	//Print all csv data
            	//System.out.println(x +" " + "business_code=" + strArr[0] +	", cust_number=" + strArr[1]	+", name_customer="+ strArr[2]	+", clear_date="+ strArr[3]	+", buisness_year="+ strArr[4]	+", doc_id="+ strArr[5]	+", posting_date="+ strArr[6]	+", document_create_date="+ strArr[7]	+", document_create_date.1="+ strArr[8]	+ ", due_in_date="+  strArr[9] +", invoice_currency="+ strArr[10]	+", document type="+ strArr[11]	+", posting_id=" + strArr[12]	+", area_business=" + strArr[13] + ", total_open_amount=" + strArr[14] +", baseline_create_date="+ strArr[15] +", cust_payment_terms="+  strArr[16]	+", invoice_id="+ strArr[17] +", isOpen=" + strArr[18]);
	            POJO studObj= new POJO();
            	//Business_code
				studObj.setBusiness_code(strArr[0]);
				//Customer_Number
				studObj.setCust_number(strArr[1]);
				//Customer Name
				studObj.setName_customer(strArr[2]);
				x = x + 1;
				//Clear Date
				// If isOpen 1 then put clear date as null
				if(Integer.parseInt(strArr[18]) == 0) {
					studObj.setClear_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strArr[3]));
					//System.out.println(x +" "+studObj.getClear_date());
				}
				else {
					studObj.setClear_date(null);
				}
				
				//Buisness_year
				if(strArr[4] == "") {
					studObj.setBuisness_year(null);
				}
				else {
					studObj.setBuisness_year(new SimpleDateFormat("yyyy").parse(strArr[4]));
				}
				
				// Doc Id
				studObj.setDoc_id(strArr[5]);
				
				// Posting Id
				if(strArr[6] == "") {
					
					studObj.setPosting_date(null);
				}
				else {
					studObj.setPosting_date(new SimpleDateFormat("yyyy-MM-dd").parse(strArr[6]));
	         	}
				
				// Doc create date
				if(strArr[7] == "") {
					studObj.setDocument_create_date(null);
				}
				else {
					studObj.setDocument_create_date(new SimpleDateFormat("yyyyMMdd").parse(strArr[7]));
				}
				
				//doc create date 1
				studObj.setDocument_create_date(new SimpleDateFormat("yyyyMMdd").parse(strArr[8]));
				
				//Due in date
				studObj.setDue_in_date(new SimpleDateFormat("yyyyMMdd").parse(strArr[9]));
				 
				//Invoice_currency
				studObj.setInvoice_currency(strArr[10]);
				
				//Doc type
				studObj.setDocument_type(strArr[11]);
				
				//Posting id
				studObj.setPosting_id(Float.parseFloat(strArr[12]));
				
				//Area business
				studObj.setArea_business(strArr[13]);
				
				//Open amount
				studObj.setTotal_open_amount(Float.parseFloat(strArr[14]));
				//Baseline create date
				studObj.setBaseline_create_date(new SimpleDateFormat("yyyyMMdd").parse(strArr[15]));
				
				//customer payment terms
				studObj.setCust_payment_terms(strArr[16]);
				
				//invoice id
				studObj.setInvoice_id(strArr[17]);
				
				//is open
				studObj.setIsOpen(Integer.parseInt(strArr[18]));
				database.add(studObj);
	         }
	     	for(POJO i : database) {
	     		C++;
	     		// print data from pojo
	    		System.out.println("Clear date = " + i.getClear_date() + ", is open :" + i.getIsOpen());
	    		
	     	}
	     	System.out.println(C);
	         br.close();
	         } catch(IOException | ParseException e ) {
	            e.printStackTrace();
	         }
	   }
	   
	   public static void main(String[] args) {
	      String csvFile = "C:\\Users\\KIIT\\Desktop\\1804602.csv";
	      CSV.read(csvFile);
	   }
}*/