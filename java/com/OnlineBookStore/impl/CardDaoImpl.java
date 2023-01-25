package com.OnlineBookStore.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.OnlineBookStore.Models.Card;
import com.OnlineBookStore.Util.Constant;
import com.OnlineBookStore.Util.Dbutil;
import com.OnlineBookStore.dao.CardDao;

public class CardDaoImpl implements CardDao{
@Override
public boolean addCard(Card c) {
	try {
		Connection con=Dbutil.getDbConnection();

		PreparedStatement ps= con.prepareStatement("INSERT INTO "+Constant.DBCONSTANT.get(Constant.CARDS_TABLE)+" (payType,customerName,bankName,cardNumber,cardName,date,cardCvv) values(?,?,?,?,?,?,?)");
		ps.setString(1, c.getPayType());
		ps.setString(2, c.getCustomerName());
		ps.setString(3, c.getBankName());
		ps.setInt(4, c.getCardNumber());
		ps.setString(5, c.getCardName());
		ps.setString(6, c.getDate());
		ps.setInt(7, c.getCardCvv());

		int x=ps.executeUpdate();
		if(x != 0) {
			return true;
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return false;
}
}
