package com.ftn.sbnz.model.helper;

import com.ftn.sbnz.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepressionMark {
    private User user;
    private String text;
}
