package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan("com.itheima")
//导入配置类
@Import({JdbcConfig.class, TransactionConfig.class})
//指定配置文件位置
@PropertySource("JdbcConfig.properties")
//开启事务支持
@EnableTransactionManagement
public class SpringConfiguration {
}
