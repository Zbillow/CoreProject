# 该目录保存工具类代码

#IDCardUtil
用于检测身份证的工具类

# MybatisGenerator
用于生成mybatis后台代码,包含(modal,sqlmap和dao)
首先下载mysqlGeneratorjar包,引入项目.
创建配置文件mbg.xml
1.指定数据库链接地址
2.生成代码文件路径
3.指定代码生成的数据表
创建普通class类,在main方法中添加以下代码:
List<String> warnings = new ArrayList<String>();
boolean overwrite = true;
File configFile = new File("mbg.xml");
ConfigurationParser cp = new ConfigurationParser(warnings);
Configuration config = cp.parseConfiguration(configFile);
DefaultShellCallback callback = new DefaultShellCallback(overwrite);
MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
myBatisGenerator.generate(null);
直接执行后刷新项目,就可以看到生成的文件了