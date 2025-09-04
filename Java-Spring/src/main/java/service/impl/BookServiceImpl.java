package service.impl;

import dao.BookDao;
import service.BookService;

public class BookServiceImpl implements BookService {
    // private BookDao bookDao = new BookDaoImpl();             // 不用new操作怎么写呢，如下：

    private BookDao bookDao;
    public void save() {
        System.out.println("调用save服务：book service save ...");
        bookDao.save();
    }

    // setter注入
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
