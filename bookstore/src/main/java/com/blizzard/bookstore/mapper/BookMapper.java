package com.blizzard.bookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blizzard.bookstore.entity.Book;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper extends BaseMapper<Book> {
    @Select("SELECT * FROM book WHERE id = #{id}")
    List<Book> selectBookById(Integer id);
}