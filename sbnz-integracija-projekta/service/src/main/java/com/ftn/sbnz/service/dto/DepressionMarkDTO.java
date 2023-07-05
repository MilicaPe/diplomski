package com.ftn.sbnz.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kie.api.definition.rule.All;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepressionMarkDTO {
    private long id;
    private String text;
    /*
    * private DateTime time ???
    * */
}
