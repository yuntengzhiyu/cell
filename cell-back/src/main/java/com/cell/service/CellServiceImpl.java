package com.cell.service;

import com.cell.dao.CellMapper;
import com.cell.pojo.Cell;
import com.cell.pojo.CellClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CellServiceImpl implements CellService{

    @Autowired
    CellMapper cellMapper;


    @Override
    public Map<String, Object> getcell() {
        List<Cell> cells = cellMapper.getAllCell();
//        cells.removeAll(Collections.singleton(null));
        //System.out.println(cells);
        int num = cells.size();
        List<Double> x = new ArrayList<>();
        List<Double> y = new ArrayList<>();
        List<String> cell_type = new ArrayList<>();
        List<Integer> cell_type1 = new ArrayList<>();

        //先得到一个去重的列表
        for(Cell cell: cells){
            //System.out.println(cell.getUmp1());
          //  System.out.println(cell.getCellType());
            cell_type.add(cell.getCellType());
        }
        Set<String> set = new LinkedHashSet<>(cell_type);
        List<String> ulist = new ArrayList<>(set);

        for(Cell cell: cells){
            x.add(cell.getUmp1());
            y.add(cell.getUmp2());
            cell_type1.add(ulist.indexOf(cell.getCellType()));
        }

        Map<String,Object> map = new HashMap<>();
        map.put("x",x);
        map.put("y",y);
        map.put("cell_type",cell_type1);
        return map;
    }

    @Override
    public List<Integer> getClassNum() {
        List<Integer> list = cellMapper.getClassNum();
        return list;
    }
}
