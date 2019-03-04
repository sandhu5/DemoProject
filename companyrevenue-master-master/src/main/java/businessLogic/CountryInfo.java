package businessLogic;

import java.util.Comparator;


public class CountryInfo implements Comparator<CountryInfo> {

	private String externalTransactionID;
	private String companyName;
	private String revanue;
	private String year;
	
	
	public String getExternalTransactionID() {
		return externalTransactionID;
	}

	public void setExternalTransactionID(String externalTransactionID) {
		this.externalTransactionID = externalTransactionID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRevanue() {
		return revanue;
	}

	public void setRevanue(String revanue) {
		this.revanue = revanue;
	}

	

	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Transaction [externalTransactionID=" + externalTransactionID + ", companyName=" + companyName + ", revanue=" + revanue + ", year="
				+ year + "]";
	}

	@Override
	public int compare(CountryInfo trans1, CountryInfo trans2) {
		
		int value1 = trans1.getExternalTransactionID().compareTo(trans2.getExternalTransactionID());
		if (value1 == 0) {
			int value2 = trans1.getCompanyName().compareTo(trans2.getCompanyName());
			if (value2 == 0) {
				int value3 = trans1.getRevanue().compareTo(trans2.getRevanue());
				if (value3 == 0) {
					return trans1.getYear().compareTo(trans2.getYear());
				} else {
					return value3;
				}

			} else {
				return value2;
			}
		}
		return value1;

	}


}
