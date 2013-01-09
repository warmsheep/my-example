package org.warmsheep.xml.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class LightingMode {
	
	private long id;
	private String name;
	private Date startDate;
	private Date endDate;
	private Date sendDate;
	private int status;
	private List<LightingCommand> commands = new ArrayList<LightingCommand>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<LightingCommand> getCommands() {
		return commands;
	}
	public void setCommands(List<LightingCommand> commands) {
		this.commands = commands;
	}
	
	

}
