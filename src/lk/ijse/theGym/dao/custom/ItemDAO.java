package lk.ijse.theGym.dao.custom;

import lk.ijse.theGym.dao.CrudDAO;
import lk.ijse.theGym.dto.SupplierOrderDetailsDTO;
import lk.ijse.theGym.entity.Item;
import lk.ijse.theGym.view.data.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<Item, String> {
    ArrayList<String> getAllCategory() throws SQLException, ClassNotFoundException;

    ArrayList<Item> getSelectedCategoryData(String category) throws SQLException, ClassNotFoundException;

    boolean updateQty(ArrayList<Order> orderDetails) throws SQLException, ClassNotFoundException;

    boolean supplierUpdateQty(ArrayList<SupplierOrderDetailsDTO> orderDetails) throws SQLException, ClassNotFoundException;

    String CountOfAllItems() throws SQLException, ClassNotFoundException;

    String limitedStock() throws SQLException, ClassNotFoundException;


}
