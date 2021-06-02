import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Generate {

    @Test
    public void generate(){
        /**
         * 创建代码生成器：数据库表的数据类型为tinyint时都会自动转换为实体类中的Boolean类型
         */
        AutoGenerator mpg = new AutoGenerator();



        /**
         * 创建全局配置
         */
        GlobalConfig gc = new GlobalConfig();
        //获取当前项目在磁盘中的路径
        String projectPath = System.getProperty("user.dir");
        //生成代码的输出路径，也就是在java目录下
        gc.setOutputDir(projectPath + "/src/main/java");
        //文件覆盖
        gc.setFileOverride(true);
        //定义注释中的作者
        gc.setAuthor("rose");
        //生成完成之后不打开资源管理器
        gc.setOpen(false);
        //去掉service接口的I首字母
        gc.setServiceName("%sService");
        //主键策略:设置主键策略为自增
        gc.setIdType(IdType.AUTO);
        //开启Swagger2模式
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        /**
         * 数据源策略配置
         */
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://8.140.6.169:3306/XinXinXiangRong?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("3701251997Zxj");
        //声明数据库的类型
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        /**
         * 包结构配置
         */
        PackageConfig pc = new PackageConfig();
        //指定生成的代码所在的包结构，就是指定生成的包所在的父包
        pc.setParent("com.xxxr.core.boot");
        mpg.setPackageInfo(pc);

        /**
         * 策略配置
         */
        StrategyConfig strategy = new StrategyConfig();
        //数据库表的名称转换为实体类的驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库的字段名称转换为实体类属性的驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //给所有的实体类添加lombok注解
        strategy.setEntityLombokModel(true);
        //该逻辑删除字段添加注解
        strategy.setLogicDeleteFieldName("is_deleted");
        //带is前缀的数据库字段转化为实体类的Boolean统一去掉is
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        //Controller层中统一使用Rest风格的编程，使用RestController注解
        strategy.setRestControllerStyle(true);
        mpg.setStrategy(strategy);

        mpg.execute();
    }
}
