package lk.ijse.theGym.dao.custom.impl.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReturnUtil {
    public static ArrayList<String> getValues(ResultSet set) {
        ArrayList<String> list = new ArrayList<>();
        try {
            while (set.next()) {
                list.add(set.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }
    public static String getValue(ResultSet set) {
        try {
            if (set.next()) {
                return set.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
