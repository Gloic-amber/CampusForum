package com.ustc.blink.service.impl;

import com.ustc.blink.mapper.BlinkGeneralMapper;
import com.ustc.blink.mapper.BlinkMapper;
import com.ustc.blink.pojo.Blink;
import com.ustc.blink.pojo.BlinkGeneral;
import com.ustc.blink.pojo.SaveBlinkBO;
import com.ustc.blink.pojo.UpdateBlinkBO;
import com.ustc.blink.service.BlinkService;
import com.ustc.common.exception.MapperException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;

/**
 * @author css
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class BlinkServiceImpl extends ServiceImpl<BlinkMapper, Blink> implements BlinkService {

    @Resource
    private BlinkMapper blinkMapper;

    @Resource
    private BlinkGeneralMapper blinkGeneralMapper;

    @Override
    public void create(SaveBlinkBO blinkBO) {
        Blink blink = new Blink();
        BeanUtils.copyProperties(blinkBO, blink);
        blink.setCreateTime(new Timestamp(System.currentTimeMillis()));
        blinkMapper.insert(blink);
        BlinkGeneral general = new BlinkGeneral();
        general.setBlinkId(blink.getId());
        general.setScore(getRating(blink));
        blinkGeneralMapper.insert(general);
    }

    @Override
    public void remove(int id, int userId) {
        LambdaQueryWrapper<Blink> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Blink::getId, id).eq(Blink::getUserId, userId);
        if (blinkMapper.delete(wrapper) != 1) {
            throw new MapperException("动态删除失败", "id -> " + id);
        }
        blinkGeneralMapper.deleteById(id);
    }

    @Override
    public void update(UpdateBlinkBO blinkBO) {
        LambdaUpdateWrapper<Blink> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Blink::getId, blinkBO.getId()).eq(Blink::getUserId, blinkBO.getUserId());
        wrapper.set(Blink::getContent, blinkBO.getContent());
        if (blinkMapper.update(null, wrapper) != 1) {
            throw new MapperException("动态更新失败", blinkBO);
        }
    }

    private double getRating(Blink blink) {
        return blink.getContent().length();
    }

}