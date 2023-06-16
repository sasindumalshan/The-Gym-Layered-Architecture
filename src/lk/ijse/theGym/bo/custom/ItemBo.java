package lk.ijse.theGym.bo.custom;

import lk.ijse.theGym.bo.CrudBO;
import lk.ijse.theGym.dao.custom.ItemDAO;
import lk.ijse.theGym.dto.ItemsDTO;
import lk.ijse.theGym.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo extends CrudBO<ItemsDTO,String> {

    ArrayList<String> search(String id) throws SQLException, ClassNotFoundException;

    ItemsDTO get(String s) throws SQLException, ClassNotFoundException;
}
