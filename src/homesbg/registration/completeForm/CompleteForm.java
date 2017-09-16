package homesbg.registration.completeForm;

import homesbg.registration.agencyData.AgencyData;
import homesbg.registration.agencyData.Type;
import homesbg.registration.contactData.Agency;
import homesbg.registration.contactData.Construction;
import homesbg.registration.contactData.IContactData;
import homesbg.registration.customerData.CustomerData;
import homesbg.registration.customerData.ICustomerData;
import homesbg.registration.pageData.Page;

public class CompleteForm implements ICompleteForm{
	private AgencyData data;
	private IContactData contactData;
	private Page page;
	private ICustomerData customer;
	
	public CompleteForm(){
		
	}

	@Override
	public void startRegistration() {
		System.out.println("Данни \n");
		data = new AgencyData();
		
		Messages.getContactDataMessage(data.getType());
		setContactDataType();
		contactData.fillTheGaps();
		
		Messages.getPageMessage(data.getType());		
		page = new Page();
		page.addName();
		
		
		Messages.getCustomerDataMessage(data.getType());
		customer = new CustomerData();
		customer.fillTheGaps();
		
	}

	
	
	private void setContactDataType() {
		if(data.getType().equals(Type.Агенция_за_недвижими_имоти)){
			contactData = new Agency();
		}else{
			contactData = new Construction();
		}
		
	}

	
}
