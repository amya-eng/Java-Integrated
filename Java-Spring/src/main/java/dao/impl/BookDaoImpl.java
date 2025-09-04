package dao.impl;

import dao.BookDao;

public class BookDaoImpl implements BookDao {
    public void save() {
        System.out.println("数据库持久化：book dao save ...");
    }

}
