package com.cell.dao;


import com.cell.pojo.Cell;
import com.cell.pojo.CellClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CellMapper {
    //获取cell的cell_type, ump_1, ump_2数据
//    @Select("select ump_1, ump_2, cell_type from cell2")
    List<Cell> getAllCell();

    List<Integer>getClassNum();
}
