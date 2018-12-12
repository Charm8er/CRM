// Contains all functions needed to create Lead objects for the leadArray.

public class Lead 
{	
	private String name; // full name (first and last)
	private String address; // full address (street, city, state, zipcode)
	private String email; // email address for lead
	private String phone; // phone number for lead
	private String status; // status for lead ( New | Working | Qualified | Converted | Lost )
	private String leadSource; // lead source ( Flyer | Mailer | Other | Referral | Social Media | Website )
	private int rating; // rating, hot/cold scale (0-10) 
	private int leadNum; // auto-assigned identification number
	
	public Lead ()
	{	
		name = null; 
		address = null; 
		email = null; 
		phone = null; 
		status = null; 
		leadSource = null; // 
		leadNum = 0000;
		rating = 10;
	}
	
	/***************************************************************************************
	 * @param name, lead name
	 * @param address, lead address
	 * @param email, lead email
	 * @param phone, lead phone
	 * @param status, lead status
	 * @param leadSource, lead source
	 * @param rating, lead rating
	 * @param leadNum, assigned lead number
	 ***************************************************************************************/
	public Lead(int leadNum, String name, String address, String email, String phone, String status, String leadSource, int rating) 
	{
		super();	
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.leadSource = leadSource;
		this.rating = rating;
		this.leadNum = leadNum;
	}

	/************************************************************************** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 ***************************************************************************************/
	@Override
	public String toString() 
	{
		return "Lead [leadNum =" + leadNum + ",name=" + name + ", address=" + address + ", email=" + email + ", phone=" + phone + ", status="
				+ status + ", leadSource=" + leadSource + ", rating=" + rating + "]";
	}

	/***************************************************************************************
	 * @return the leadNum
	 ***************************************************************************************/
	public int getLeadNum() 
	{
		return leadNum;
	}

	/***************************************************************************************
	 * @param leadNum the leadNum to set
	 ***************************************************************************************/
	public void setLeadNum(int leadNum) 
	{
		this.leadNum = leadNum;
	}
	
	/***************************************************************************************
	 * @return the name
	 ***************************************************************************************/
	public String getName() 
	{
		return name;
	}

	/***************************************************************************************
	 * @param name the name to set
	 ***************************************************************************************/
	public void setName(String name) 
	{
		this.name = name;
	}

	/***************************************************************************************
	 * @return the address
	 ***************************************************************************************/
	public String getAddress() 
	{
		return address;
	}

	/***************************************************************************************
	 * @param address the address to set
	 ***************************************************************************************/
	public void setAddress(String address) 
	{
		this.address = address;
	}

	/***************************************************************************************
	 * @return the email
	 ***************************************************************************************/
	public String getEmail() 
	{
		return email;
	}

	/***************************************************************************************
	 * @param email the email to set
	 ***************************************************************************************/
	public void setEmail(String email) 
	{
		this.email = email;
	}

	/***************************************************************************************
	 * @return the phone
	 ***************************************************************************************/
	public String getPhone() 
	{
		return phone;
	}

	/***************************************************************************************
	 * @param phone the phone to set
	 ***************************************************************************************/
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	/***************************************************************************************
	 * @return the status
	 ***************************************************************************************/
	public String getStatus() 
	{
		return status;
	}

	/***************************************************************************************
	 * @param status the status to set
	 ***************************************************************************************/
	public void setStatus(String status) 
	{
		this.status = status;
	}

	/***************************************************************************************
	 * @return the leadSource
	 ***************************************************************************************/
	public String getLeadSource() 
	{
		return leadSource;
	}

	/***************************************************************************************
	 * @param leadSource the leadSource to set
	 ***************************************************************************************/
	public void setLeadSource(String leadSource) 
	{
		this.leadSource = leadSource;
	}

	/***************************************************************************************
	 * @return the rating
	 ***************************************************************************************/
	public int getRating() 
	{
		return rating;
	}

	/***************************************************************************************
	 * @param rating the rating to set
	 ***************************************************************************************/
	public void setRating(int rating) 
	{
		this.rating = rating;
	}
} // end Lead class
