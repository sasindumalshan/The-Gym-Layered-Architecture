package lk.ijse.theGym.dao.custom.impl;


public class QueryDAOImpl {
    /*@Override
    public ArrayList<CustomEntity> searchOrderByOID(String oid) throws SQLException, ClassNotFoundException {
        ArrayList<CustomEntity> allRecords = new ArrayList<>();
        String sql = "select Orders.oid,Orders.date,Orders.customerID,OrderDetails.oid,OrderDetails.itemCode,OrderDetails.qty,OrderDetails.unitPrice from Orders inner join OrderDetails on Orders.oid=OrderDetails.oid where Orders.oid=?";
        ResultSet rst = SQLUtil.execute(sql, oid);
        while (rst.next()) {
            String orderID = rst.getString(1);
            LocalDate orderDate = LocalDate.parse(rst.getString(2));
            String customerID = rst.getString(3);
            String itemCode = rst.getString(5);
            int itemQty = rst.getInt(6);
            BigDecimal unitPrice = rst.getBigDecimal(7);
            CustomEntity customEntity = new CustomEntity(orderID, orderDate, customerID, itemCode, itemQty, unitPrice);
            allRecords.add(customEntity);
        }
       return allRecords;
    }*/
}