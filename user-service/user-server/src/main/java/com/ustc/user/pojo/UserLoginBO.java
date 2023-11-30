package com.ustc.user.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName: UserLoginBO
 * Package: com.ustc.user.pojo
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30 11:26
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserLoginBO extends User {

    /**
     * 院校名称
     */
    String schoolName;

}
