package lk.ijse.theGym.bo.custom;

import lk.ijse.theGym.bo.CrudBO;
import lk.ijse.theGym.dao.custom.ItemDAO;
import lk.ijse.theGym.dto.ItemsDTO;
import lk.ijse.theGym.dto.SupplierOrderDetailsDTO;
import lk.ijse.theGym.entity.Item;
import lk.ijse.theGym.view.data.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo extends CrudBO<ItemsDTO,String> {

    ArrayList<String> search(String id) throws SQLException, ClassNotFoundException;

    ItemsDTO get(String s) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllCategory() throws SQLException, ClassNotFoundException;

    ArrayList<Item> getSelectedCategoryData(String category) throws SQLException, ClassNotFoundException;

    boolean updateQty(ArrayList<Order> orderDetails) throws SQLException, ClassNotFoundException;

    boolean supplierUpdateQty(ArrayList<SupplierOrderDetailsDTO> orderDetails) throws SQLException, ClassNotFoundException;

    String CountOfAllItems() throws SQLException, ClassNotFoundException;

    String limitedStock() throws SQLException, ClassNotFoundException;

}
