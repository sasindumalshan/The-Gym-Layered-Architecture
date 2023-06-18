package lk.ijse.theGym.bo.custom.impl;

import lk.ijse.theGym.bo.custom.ItemBo;
import lk.ijse.theGym.dao.DAOFactory;
import lk.ijse.theGym.dao.custom.ItemDAO;
import lk.ijse.theGym.dto.ItemsDTO;
import lk.ijse.theGym.dto.SupplierOrderDetailsDTO;
import lk.ijse.theGym.entity.Item;
import lk.ijse.theGym.view.data.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {
    ItemDAO itemDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    ItemsDTO dto;
    @Override
    public ArrayList<ItemsDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Item> all = itemDAO.getAll();
        ArrayList<ItemsDTO> list=new ArrayList<>();
        for (Item item:all) {
           dto=new ItemsDTO().toDTO(item);
           list.add(dto);
        }
        return list;
    }

    @Override
    public boolean save(ItemsDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.save(new Item().toEntity(dto));
    }

    @Override
    public boolean update(ItemsDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new Item().toEntity(dto));
    }

    @Override
    public boolean existByID(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(s);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> search(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.search(id);
    }

    @Override
    public ItemsDTO get(String s) throws SQLException, ClassNotFoundException {
       return new ItemsDTO().toDTO(itemDAO.get(s).get(0));
    }

    @Override
    public ArrayList<String> getAllCategory() throws SQLException, ClassNotFoundException {
        return itemDAO.getAllCategory();
    }

    @Override
    public ArrayList<Item> getSelectedCategoryData(String category) throws SQLException, ClassNotFoundException {
        return itemDAO.getSelectedCategoryData(category);
    }

    @Override
    public boolean updateQty(ArrayList<Order> orderDetails) throws SQLException, ClassNotFoundException {
        return itemDAO.updateQty(orderDetails);
    }

    @Override
    public boolean supplierUpdateQty(ArrayList<SupplierOrderDetailsDTO> orderDetails) throws SQLException, ClassNotFoundException {
        return itemDAO.supplierUpdateQty(orderDetails);
    }

    @Override
    public String CountOfAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.CountOfAllItems();
    }

    @Override
    public String limitedStock() throws SQLException, ClassNotFoundException {
        return itemDAO.limitedStock();
    }
}
