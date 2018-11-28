
public class Lead 
{
	private String name;
	private String address;
	private String email;
	private String phone;
	private String status;
	private String leadSource;
	private int rating;
	
	public Lead ()
	{
		name = null;
		address = null;
		email = null;
		phone = null;
		status = null;
		leadSource = null;
		rating = 10;
	}
	
	/***************************************************************************************
	 * @param name
	 * @param address
	 * @param email
	 * @param phone
	 * @param status
	 * @param leadSource
	 * @param rating
	 ***************************************************************************************/
	public Lead(String name, String address, String email, String phone, String status, String leadSource, int rating) 
	{
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.leadSource = leadSource;
		this.rating = rating;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "Lead [name=" + name + ", address=" + address + ", email=" + email + ", phone=" + phone + ", status="
				+ status + ", leadSource=" + leadSource + ", rating=" + rating + "]";
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

}
