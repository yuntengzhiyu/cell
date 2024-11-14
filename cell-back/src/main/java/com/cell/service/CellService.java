package com.cell.service;

import com.cell.pojo.CellClass;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CellService {
    //处理数据库的ump_1, ump_2, cell_type信息并返回给controller
    Map<String,Object>getcell();

    List<Integer> getClassNum();
}
