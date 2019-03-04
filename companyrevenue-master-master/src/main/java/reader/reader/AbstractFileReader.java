package reader.reader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import businessLogic.CountryInfo;

public abstract class AbstractFileReader {

	static  public List<CountryInfo> countryInfoList;

	public abstract void readCountryFile(File file);

	public void saveCountryInfo(CountryInfo countryInfo){

		if(countryInfoList==null){
			countryInfoList = new ArrayList<CountryInfo>();
		}

		countryInfoList.add(calculateTransactionFee(countryInfo));

	}

	/**
	 * This method will be update the fee according to transaction.
	 * @param transaction
	 */
	private CountryInfo calculateTransactionFee(CountryInfo transaction) {
/*		if(isIntradayTransaction(transaction)){
			transaction.setTransactionFees(TRANSACTIONFEES.TEN.getFees());
		} else {

			if(transaction.getPriority()){
				transaction.setTransactionFees(TRANSACTIONFEES.FIVE_HUNDREAD.getFees());

			} else{				
				if(transaction.getTransactionType() == TRANSACTIONTYPE.SELL.getType() ||
						transaction.getTransactionType() == TRANSACTIONTYPE.WITHDRAW.getType()){

					transaction.setTransactionFees(TRANSACTIONFEES.HUNDREAD.getFees());

				} else if(transaction.getTransactionType() == TRANSACTIONTYPE.BUY.getType() ||
						transaction.getTransactionType() == TRANSACTIONTYPE.DEPOSIT.getType()){

					transaction.setTransactionFees(TRANSACTIONFEES.FIFTY.getFees());			
				}

			}

		}*/
		return transaction;
	}

	/**
	 * This method cheack weather transction is IntraDay or not.
	 * @param transaction
	 * @return
	 */
	private boolean isIntradayTransaction(CountryInfo transaction) {/*
		boolean isIntraDayTransaction= false;
		Transaction temp = null;
		if(transactionList.size() > 0 ){
			for (Transaction trans : transactionList) {
				if(trans.getClientId().equals(transaction.getClientId())&&
						trans.getSecurityId().equals(transaction.getSecurityId()) &&
						trans.getTransactionDate().equals(transaction.getTransactionDate())){
					if((trans.getTransactionType()==TRANSACTIONTYPE.BUY.getType() && 
							transaction.getTransactionType()==TRANSACTIONTYPE.SELL.getType()) ||
							(trans.getTransactionType()==TRANSACTIONTYPE.SELL.getType() && 
							transaction.getTransactionType()==TRANSACTIONTYPE.BUY.getType())){
						isIntraDayTransaction= true;
						temp= trans;						
						break;
					}
				}

			}

			if(temp!=null){
				transactionList.remove(temp);
				temp.setTransactionFees(TRANSACTIONFEES.TEN.getFees());
				transactionList.add(temp);
			}

		} else {
			isIntraDayTransaction= false;
		}

		return isIntraDayTransaction;
	*/
		return true;
		}

	/**
	 * 
	 * @param countryInfoAttributes
	 * @return
	 */
	public CountryInfo getCountryData(String[] countryInfoAttributes) {	
		for (String string : countryInfoAttributes) {
			System.out.print(" "+string);
		}
		CountryInfo countryInfo = new CountryInfo();
		countryInfo.setExternalTransactionID(countryInfoAttributes[0]);
		countryInfo.setCompanyName(countryInfoAttributes[1]);
		countryInfo.setRevanue(countryInfoAttributes[2]);
		countryInfo.setYear(countryInfoAttributes[3]);
		return countryInfo;
	}
}
