package lk.ijse.theGym.bo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudBO<T,ID> extends SuperBO {
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    boolean save(T dto) throws SQLException, ClassNotFoundException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    boolean existByID(ID id) throws SQLException, ClassNotFoundException;

    boolean delete(ID id) throws SQLException, ClassNotFoundException;

    ID generateNewID() throws SQLException, ClassNotFoundException;
}
