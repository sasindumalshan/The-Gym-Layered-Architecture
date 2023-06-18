package lk.ijse.theGym.dao.custom.impl;

import lk.ijse.theGym.dao.custom.Order_detailsDAO;
import lk.ijse.theGym.dao.custom.OrdersDAO;
import lk.ijse.theGym.dao.custom.impl.util.ReturnUtil;
import lk.ijse.theGym.dto.OrderDTO;
import lk.ijse.theGym.util.CrudUtil;
import lk.ijse.theGym.view.data.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Order_detailsDAOImpl implements Order_detailsDAO {

    @Override
    public boolean setOrderDetails(ArrayList<Order> orderDetails, OrderDTO order) throws SQLException, ClassNotFoundException {
        for (int i = 0; i < orderDetails.size(); i++) {
            if (CrudUtil.crudUtil("INSERT INTO order_details VALUES (?,?,?,?)",
                    order.getOrder_id(),
                    orderDetails.get(i).getId(),
                    orderDetails.get(i).getPrice(),
                    orderDetails.get(i).getQty()

            )) {
                System.out.println((i + 1) + " Order Details added");
            } else {
                System.out.println((i + 1) + " Order Details add fails !");
                return false;
            }
        }
        System.out.println("All Added ! ");
        return true;
    }

    @Override
    public ArrayList<String> getAllYears() throws SQLException, ClassNotFoundException {
        return ReturnUtil.getValues(CrudUtil.crudUtil("SELECT DISTINCT date FROM orders")) ;
    }

    @Override
    public ArrayList<OrderDTO> getDataForOrderId(String id) throws SQLException, ClassNotFoundException {

        ArrayList<OrderDTO> list=new ArrayList<>();

        ResultSet set= CrudUtil.crudUtil("SELECT customer_id,date,time,order_id,final_total FROM orders WHERE order_id=?",id);
        while (set.next()){
            list.add(
                    new OrderDTO(
                            set.getString(4),
                            set.getString(3),
                            set.getString(2),
                           Double.parseDouble( set.getString(5)),
                            set.getString(1)
                    )
            );
        }
        return list;
    }

    @Override
    public  ArrayList<OrderDTO> getAllData(String date) throws SQLException, ClassNotFoundException {
        ArrayList<OrderDTO> list=new ArrayList<>();
        ResultSet set= CrudUtil.crudUtil("SELECT customer_id,date,time,order_id,final_total FROM orders WHERE date LIKE ?",date+"%");
        while (set.next()){
            list.add(new OrderDTO(
                    set.getString(4),
                    set.getString(3),
                    set.getString(2),
                    Double.parseDouble( set.getString(5)),
                    set.getString(1)
            ));
        }
        return list;
    }
}
