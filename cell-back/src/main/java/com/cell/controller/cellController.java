package com.cell.controller;

import com.cell.pojo.CellClass;
import com.cell.service.CellService;
import com.cell.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@CrossOrigin
public class cellController {
    @Autowired
    CellService cellService;

    @RequestMapping("getcell")
    public ServerResponse getcell() {
        Map<String, Object> map = cellService.getcell();
        return ServerResponse.createBySuccess("d", map);
    }

    @RequestMapping("getclass")
    public ServerResponse getclass() {
        List<Integer> list = cellService.getClassNum();
        return ServerResponse.createBySuccess("s", list);
    }
}

