package view;

public class CheckData {

	
	public boolean checkName(String s) {
		
		return s.matches("([a-zA-Z]{3,30}\\s*)+");
		
	}
	
	public boolean checkSurname(String s) {
		
		return s.matches("[a-zA-Z]{3,30}");
	}
	
	public boolean checkDate(String s) {
		return s.matches("^\\d{4}-(02-(0[1-9]|[12][0-9])|(0[469]|11)-(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))");
	}
	
	public boolean checkeMail(String s) {
		
		return s.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*"
				+ "|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\"
				+ "[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+"
				+ "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.)"
				+ "{3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\"
				+ "x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
	}
	
	public boolean checkID(String s) {
		
		return s.matches("[0-9]{9}");
	}
	
	public boolean checkPhone(String s) {
		return s.matches("^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$");
	}
	
	public boolean checkAddress(String s) {
		String[] txt1 = s.split(" ",4);
		if (txt1.length != 4) {
			return false;
		}
		return true;
	}
	
	public boolean checkYExp(String s) {
		int num = Integer.parseInt(s);
		if(num < 0 || num > 55) {
			return false;
		}
		return true;

	}
	
	public boolean checkTitle(String s) {
		
		return s.matches("[a-zA-Z]{2,15}");
	}
	
}
