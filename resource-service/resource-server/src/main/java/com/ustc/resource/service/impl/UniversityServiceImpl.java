package com.ustc.resource.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ustc.resource.mapper.CityMapper;
import com.ustc.resource.mapper.ProvinceMapper;
import com.ustc.resource.mapper.UniversityMapper;
import com.ustc.resource.pojo.City;
import com.ustc.resource.pojo.Province;
import com.ustc.resource.pojo.University;
import com.ustc.resource.service.UniversityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: UniversityServiceImpl
 * Package: com.ustc.resource.service.impl
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Slf4j
@Service
public class UniversityServiceImpl extends ServiceImpl<UniversityMapper, University> implements UniversityService {

    @Resource
    private ProvinceMapper provinceMapper;

    @Resource
    private CityMapper cityMapper;

    @Resource
    private UniversityMapper universityMapper;

    @Override
    public List<Province> getProvinceList() {
        return provinceMapper.selectList(null);
    }

    @Override
    public List<City> getCityList(int provinceId) {
        LambdaQueryWrapper<City> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(City::getProvinceId, provinceId);
        return cityMapper.selectList(wrapper);
    }

    @Override
    public List<University> getUniversityList(int cityId) {
        LambdaQueryWrapper<University> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(University::getCityId, cityId);
        return universityMapper.selectList(wrapper);
    }

    @Override
    public String getUniversityName(int schoolCode) {
        LambdaQueryWrapper<University> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(University::getCode, schoolCode);
        University university = universityMapper.selectOne(wrapper);
        return university == null ? null : university.getName();
    }

}
