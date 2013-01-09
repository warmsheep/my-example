package org.warmsheep.xml.entity;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("照明指令")
public class LightingCommand {

	@XStreamAsAttribute
	@XStreamAlias("ID")
	private long id;
	@XStreamAlias("名称")
	private String name;
	@XStreamAlias("开始时间")
	private Date startDate;
	private String type;
	private String content;
	private String operator;
	private LightingMode mode;

	
	public LightingMode getMode() {
		return mode;
	}
	public void setMode(LightingMode mode) {
		this.mode = mode;
	}
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	
}
