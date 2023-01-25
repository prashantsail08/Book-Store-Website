package com.OnlineBookStore.Util;

import java.util.HashMap;
import java.util.Map;

public class Constant {
public static Map<String, String> DBCONSTANT = new HashMap<>();

public static final String BOOK_TABLE = "booktable";
public static final String CUSTOMER_TABLE = "customertable";
public static final String CART_TABLE = "carttable";
public static final String ORDER_TABLE = "orderstable";
public static final String CATEGORY_TABLE ="categorytable";
public static final String PUBLISHER_TABLE = "publishertable";
public static final String PAYMENT_TABLE = "paymenttable";
public static final String CARDS_TABLE = "cardstable";

public static void loadTables(boolean isHome)
{
	if(isHome)
	{
		DBCONSTANT.put(BOOK_TABLE, "book");
		DBCONSTANT.put(CUSTOMER_TABLE, "customer");
		DBCONSTANT.put(CART_TABLE, "cart");
		DBCONSTANT.put(ORDER_TABLE, "orders");
		DBCONSTANT.put(CATEGORY_TABLE, "category");
		DBCONSTANT.put(PUBLISHER_TABLE, "publisher");
		DBCONSTANT.put(PAYMENT_TABLE, "payment");
		DBCONSTANT.put(CARDS_TABLE, "cards");
	}else {
		DBCONSTANT.put(BOOK_TABLE, "CT40_Book");
		DBCONSTANT.put(CUSTOMER_TABLE, "CT40_Customer");
		DBCONSTANT.put(CART_TABLE, "CT40_Cart");
		DBCONSTANT.put(ORDER_TABLE, "CT40_Order");
		DBCONSTANT.put(CATEGORY_TABLE, "CT40_Category");
		DBCONSTANT.put(PUBLISHER_TABLE, "CT40_Publisher");
	}
}
}
