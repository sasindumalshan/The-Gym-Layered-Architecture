package lk.ijse.theGym.dao.custom.impl;

import lk.ijse.theGym.dao.custom.ItemDAO;
import lk.ijse.theGym.entity.Item;
import lk.ijse.theGym.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    Item item;
    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Item> list=new ArrayList<>();
        ResultSet set= CrudUtil.crudUtil("SELECT *FROM item ORDER BY LENGTH(item_id),item_id");
        while (set.next()){
            item=new Item();
            item.setItem_id(set.getString(1));
            item.setItem_name(set.getString(2));
            item.setCategory(set.getString(3));
            item.setQut(Integer.parseInt(set.getString(4)));
            item.setPrice(Double.parseDouble(set.getString(5)));
            item.setBrand(set.getString(6));
            item.setDescription(set.getString(7));
            list.add(item);
        }
        return list;
    }

    @Override
    public boolean save(Item dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("INSERT INTO item VALUES (?,?,?,?,?,?,?)", dto.getItem_id(), dto.getItem_name(), dto.getCategory(), dto.getQut(), dto.getPrice(), dto.getBrand(), dto.getDescription());
    }

    @Override
    public boolean update(Item dto) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("UPDATE item SET item_name=?, category=?,price=?,brand=?,description=? WHERE item_id=?", dto.getItem_name(), dto.getCategory(), dto.getPrice(), dto.getBrand(), dto.getDescription(), dto.getItem_id());
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("DELETE  FROM item WHERE item_id=?", s);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> search(String s) throws SQLException, ClassNotFoundException {
       ResultSet set=CrudUtil.crudUtil("SELECT * FROM item WHERE item_id LIKE ? or item_name LIKE ? or brand LIKE ? ",s,s,s);
        ArrayList<String> list=new ArrayList<>();
        while (set.next()){
            list.add(set.getString(1));
        }
        return list;
    }

    @Override
    public ArrayList<Item> get(String s) throws SQLException, ClassNotFoundException {
        ArrayList<Item> list=new ArrayList<>();
        ResultSet set=CrudUtil.crudUtil("SELECT * FROM item WHERE item_id=?",s);
       while (set.next()){
           item =new Item();
           item.setItem_id(set.getString(1));
           item.setItem_name(set.getString(2));
           item.setCategory(set.getString(3));
           item.setQut(Integer.parseInt(set.getString(4)));
           item.setPrice(Double.parseDouble(set.getString(5)));
           item.setBrand(set.getString(6));
           item.setDescription(set.getString(7));
           list.add(item);
       }
       return list;
    }
}
