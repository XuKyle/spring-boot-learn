### datasource
SpringBoot默认会自动配置DataSource，
它将优先采用HikariCP连接池，如果没有该依赖的情况则选取tomcat-jdbc，

如果前两者都不可用最后选取Commons DBCP2。
通过spring.datasource.type属性可以指定其它种类的连接池


###ddl-auto

* create： 每次运行程序时，都会重新创建表，故而数据会丢失
* create-drop： 每次运行程序时会先创建表结构，然后待程序结束时清空表
* upadte： 每次运行程序，没有表时会创建表，如果对象发生改变会更新表结构，原有数据不会清空，只会更新（推荐使用）
* validate： 运行程序会校验数据与数据库的字段类型是否相同，字段不同会报错

### jpa规范
JPA规范注解坐落在javax.persistence包下，

@Id注解一定不要引用错了，否则会报错。

@GeneratedValue(strategy = GenerationType.IDENTITY)自增策略，不需要映射的字段可以通过@Transient注解排除掉

####常见的几种自增策略

- TABLE： 使用一个特定的数据库表格来保存主键
- SEQUENCE： 根据底层数据库的序列来生成主键，条件是数据库支持序列。这个值要与generator一起使用，generator 指定生成主键使用的生成器（可能是orcale中自己编写的序列）。
- IDENTITY： 主键由数据库自动生成（主要是支持自动增长的数据库，如mysql）
- AUTO： 主键由程序控制，也是GenerationType的默认值。