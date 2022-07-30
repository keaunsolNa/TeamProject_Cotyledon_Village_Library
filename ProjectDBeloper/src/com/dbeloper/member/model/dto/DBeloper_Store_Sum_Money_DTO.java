package com.dbeloper.member.model.dto;

import java.io.Serializable;

public class DBeloper_Store_Sum_Money_DTO implements Serializable {

	private static final long serialVersionUID = -1888722029330731674L;
	private int storeSummoney;

	public DBeloper_Store_Sum_Money_DTO() {
	}

	public DBeloper_Store_Sum_Money_DTO(int storeSummoneyAmount) {
		this.storeSummoney = storeSummoneyAmount;
	}

	public int getStoreSummoneyAmount() {
		return storeSummoney;
	}

	public void setStoreSummoneyAmount(int storeSummoneyAmount) {
		this.storeSummoney = storeSummoneyAmount;
	}

	@Override
	public String toString() {
		return "DBeloper_Store_Sum_Money_DTO [storeSummoneyAmount=" + storeSummoney + "]";
	}

	
	

}
