package com.ustc.user.controller;

import com.ustc.common.result.RestResult;
import com.ustc.common.web.anno.RequestLimit;
import com.ustc.common.web.auth.AuthHelper;
import com.ustc.user.pojo.User;
import com.ustc.user.pojo.UserGeneral;
import com.ustc.user.pojo.UserView;
import com.ustc.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * ClassName: UserController
 * Package: com.ustc.user.controller
 * Description: 用户信息
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 获取公开信息
     *
     * @param id 用户名id
     */
    @GetMapping
    @RequestLimit
    public User getByUserId(Integer id) {
        Integer getId = null;
        Integer userId = AuthHelper.getCurrentUserId();
        if (id == null && userId != null) {
            getId = userId;
        } else if (id != null) {
            getId = id;
        }
        return userService.getById(getId);
    }

    /**
     * 批量获取用户信息
     */
    @PostMapping("/list")
    public Map<Integer, UserView> getUserList(@RequestParam List<Integer> userIdList) {
        return userService.getUserListMap(new HashSet<>(userIdList));
    }

    /**
     * 查询用户创作数据
     *
     * @param userId 用户id
     * @return 批量用户统计数据
     */
    @GetMapping("/general")
    public UserGeneral getUserGeneral(@RequestParam Integer userId) {
        return userService.getUserGeneral(userId);
    }

    /**
     * 批量查询用户各项数据统计
     *
     * @param userIdList 用户id列表
     * @return 批量用户统计数据
     */
    @GetMapping("/general/map")
    public Map<Integer, UserGeneral> getUserGeneralList(@RequestParam List<Integer> userIdList) {
        return userService.getUserGeneralListMap(userIdList);
    }

    /**
     * 修改昵称
     *
     * @param nickname 昵称
     */
    @PutMapping("/nickname")
    public RestResult<Object> updateNickname(@NotNull String nickname) {
        Integer userId = AuthHelper.getCurrentUserIdOrExit();
        if (userService.updateNickname(userId, nickname)) {
            return RestResult.ok();
        }
        return RestResult.fail();
    }

    /**
     * 修改头像
     *
     * @param avatarFile 文件流
     */
    @PutMapping("/avatar")
    public RestResult<String> updateAvatar(@NotNull MultipartFile avatarFile) {
        Integer id = AuthHelper.getCurrentUserIdOrExit();
        log.debug("updateAvatar,fileSize->{}", avatarFile.getSize());
        // 检查文件，小于1Mib ,仅支持JPEG和PNG
        FileUtils.checkFile(avatarFile, 1024 * 1024L, FileType.JPEG, FileType.PNG);
        String avatar = userService.updateAvatar(id, avatarFile);
        if (avatar != null) {
            return RestResult.ok(avatar);
        } else {
            return RestResult.fail("上传失败");
        }
    }

    /**
     * 修改密码
     *
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     */
    @PutMapping("/password")
    public RestResult<Object> updatePassword(@NotNull String oldPassword, @NotNull String newPassword) {
        Integer id = AuthHelper.getCurrentUserIdOrExit();
        if (userService.checkPassword(id, oldPassword)) {
            boolean result = userService.updatePasswordById(id, newPassword);
            return RestResult.ok(result);
        }
        return RestResult.fail("修改失败");
    }

    /**
     * 更新用户院校代码
     *
     * @param code 院校代码
     */
    @PutMapping("/school/code")
    public Boolean updateSchoolCode(@NotNull Integer code) {
        Integer id = AuthHelper.getCurrentUserIdOrExit();
        return userService.updateSchoolCode(id, code);
    }

    /**
     * 修改邮箱
     *
     * @param mail       新邮箱
     * @param mailVerify 邮箱验证码
     */
    @PutMapping("/mail")
    public RestResult<Object> updateMail(@NotNull String mail, @NotNull String mailVerify) {
        Integer id = AuthHelper.getCurrentUserIdOrExit();
        if (userService.checkMailVerify(id, mailVerify)) {
            boolean result = userService.updateMail(id, mail);
            return RestResult.ok(result);
        }
        return RestResult.fail("修改失败");
    }

    /**
     * 发送邮箱验证码
     */
    @PostMapping("/mail/send-mail-verify")
    public Boolean sendMailVerifyForUpdateMail() {
        Integer id = AuthHelper.getCurrentUserIdOrExit();
        return userService.sendMailVerify(id);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/user")
    public RestResult<Object> delete(@NotNull String password) {
        Integer id = AuthHelper.getCurrentUserIdOrExit();
        if (!userService.checkPassword(id, password)) {
            return new RestResult<>(false, "密码错误");
        } else {
            return new RestResult<>(userService.removeById(id));
        }
    }

}