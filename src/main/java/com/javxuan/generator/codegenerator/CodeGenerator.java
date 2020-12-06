package com.javxuan.generator.codegenerator;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @author ：Javxuan@163.com
 * @date ：Created in 2020/12/6 19:14
 * @description：代码生成器运行类
 * @modified By：
 * @version: v1
 */
public class CodeGenerator {

    /**
     * 1.全局配置
     * 2.数据源配置
     * 3.策略配置
     * 4.包名配置
     * 5.加入配置运行
     */
    @Test
    public void v1(){
        //1.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setActiveRecord(true)
                .setAuthor("Javxuan@163.com")
                .setBaseResultMap(true)
                .setBaseColumnList(true) //是否生成基本sql片段
                .setEnableCache(true)
                .setEntityName("%sEntity")
                .setServiceName("%sService")//设置不以IUserService  而是UserService
                .setSwagger2(true)
                .setOutputDir("d://code")
                .setFileOverride(true);

        //2.数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/mp?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false")
                .setUsername("root")
                .setPassword("root");

        //3.设置策略
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setTablePrefix("t_")
                .setInclude("t_user");

        //4.包名设置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.javxuan.generator")
                .setController("controller")
                .setService("service")
                .setServiceImpl("service.impl")
                .setMapper("mapper")
                .setEntity("entity")
                .setXml("xml");

        //5.配置设置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);
        autoGenerator.execute();

    }


}