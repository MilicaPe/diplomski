package com.ftn.sbnz.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationDTO<T> {
    private long totalCount;
    private List<T> resultList;
}
