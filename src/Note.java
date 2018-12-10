import java.util.Date;

public class Note {
	private int leadNum;
	private String contents;
	Date date;
	
	public Note ()
	{
		leadNum = 0000;
		date = new Date ();
		contents = null;
	}

	/***************************************************************************************
	 * @param leadNum, lead number for link to Lead
	 * @param date, date note was made
	 * @param contents, actual notes for lead
	 ***************************************************************************************/
	public Note(int leadNum, String contents, Date date) {
		super();
		this.leadNum = leadNum;
		this.date = date;
		this.contents = contents;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Note [leadNum=" + leadNum + ", contents=" + contents + ", date=" + date + "]";
	}

	/***************************************************************************************
	 * @return the leadNum
	 ***************************************************************************************/
	public int getLeadNum() {
		return leadNum;
	}

	/***************************************************************************************
	 * @param leadNum the leadNum to set
	 ***************************************************************************************/
	public void setLeadNum(int leadNum) {
		this.leadNum = leadNum;
	}

	/***************************************************************************************
	 * @return the contents
	 ***************************************************************************************/
	public String getContents() {
		return contents;
	}

	/***************************************************************************************
	 * @param contents the contents to set
	 ***************************************************************************************/
	public void setContents(String contents) {
		this.contents = contents;
	}

	/***************************************************************************************
	 * @return the date
	 ***************************************************************************************/
	public Date getDate() {
		return date;
	}

	/***************************************************************************************
	 * @param date the date to set
	 ***************************************************************************************/
	public void setDate(Date date) {
		this.date = date;
	}	
	
}
