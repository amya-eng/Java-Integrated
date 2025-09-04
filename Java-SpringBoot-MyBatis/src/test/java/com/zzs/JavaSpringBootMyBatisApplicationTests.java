package com.zzs;

import com.zzs.dao.BookDao;
import com.zzs.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaSpringBootMyBatisApplicationTests {

    @Autowired
    private BookDao bookDao;
    @Test
    void testGetById() {
        Book book = bookDao.getById(1);
        System.out.println(book);
    }

}
