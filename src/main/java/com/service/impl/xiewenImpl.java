package com.service.impl;

import com.mapper.xiewenMapper;
import com.pojo.xiewen;
import com.service.xiewenService;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class xiewenImpl implements xiewenService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<xiewen> selectall() {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        xiewenMapper mapper = sqlSession.getMapper(xiewenMapper.class);

        //4. 调用方法
        List<xiewen> xiewens = mapper.selectall();

        //5. 释放资源
        sqlSession.close();

        return xiewens;
    }

    @Override
    public void add(xiewen xiewen1) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        xiewenMapper mapper = sqlSession.getMapper(xiewenMapper.class);

        //4. 调用方法
         mapper.add(xiewen1);
        sqlSession.commit();//提交事务
        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public void deleteById(String xinwen) {
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        xiewenMapper mapper = sqlSession.getMapper(xiewenMapper.class);

        //4. 调用方法
        mapper.deleteById(xinwen);
        sqlSession.commit();//提交事务

        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public void updateById(xiewen xiewen) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        xiewenMapper mapper = sqlSession.getMapper(xiewenMapper.class);

        //4. 调用方法
        mapper.updateById(xiewen);

        sqlSession.commit();//提交事务

        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public List<xiewen> tiaocha(xiewen xiewen1) {
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        xiewenMapper mapper = sqlSession.getMapper(xiewenMapper.class);
        String xinwen = xiewen1.getXinwen();
        if (xinwen != null && xinwen.length() > 0) {
            xiewen1.setXinwen("%" + xinwen + "%");
        }


        String lanmu = xiewen1.getLanmu();
        if (lanmu != null && lanmu.length() > 0) {
            xiewen1.setLanmu("%" + lanmu + "%");
        }

        //4. 调用方法
        List<xiewen> tiaocha = mapper.tiaocha(xiewen1);


        /*  sqlSession.commit();//提交事务*/

        //5. 释放资源
        sqlSession.close();
        return tiaocha;
    }
}
