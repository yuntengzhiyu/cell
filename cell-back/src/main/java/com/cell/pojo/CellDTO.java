package com.cell.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CellDTO {

    Double ump_1, ump_2;
    String cell_type;
}
