package com.ustc.blink.pojo;

import com.ustc.user.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

/**
 * @author css
 */
@Data
public class BlinkVO {

    @JsonUnwrapped
    BlinkView blink;

    UserDTO user;

}