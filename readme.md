###项目内容
|场景|命令|
|---|---| 
|@componentScan注解自定义过滤规则demo演示|com.roy.configuration.PersonConfig3|
|自定义线程级别的bean的作用域 |com.roy.configuration.PersonConfig5|
|通过@conditional注解来选择性注入bean |com.roy.configuration.PersonConfig7|
#自定义@enablexxx注解来导入别的jar包配置类  -------------com.roy.configuration.OtherJarConfiguration
#选择性注入bean的实现原理演示demo         ---------------com.roy.configuration.PersonConfig10
#FactoryBean的使用demo                   --------------com.roy.configuration.PersonConfig11
#常规数值的注入                          ---------------com.roy.configuration.TeacherValueConfig
#@propertySource常规引入配置文件         ---------------com.roy.configuration.TeacherValueConfig
#测试如何选择运行的环境                   ---------------com.roy.ProfileTest.testProfile02
#AOP环境测试                            ----------------com.roy.AopTest
#测试@import的3中使用方式                  --------------com.roy.configuration.PersonConfig10
#测试线程池异步的使用                     ----------------com.roy.AopTest.testASsync
#演示Spring框架中的原型模式               -----------------com.roy.DesignModeTest.testPrototype
#演示父类的注入点同样生效                 ----------------com.roy.ExtTest.testExtendAutowired
#演示容器的监听事件                      -----------------com.roy.ExtTest.testListner
#测试自动注入的bean是原型的，@lookup注解的使用-------------com.roy.AutowiredTest.testLookup
#BeanFactoryPostProcessor的demo演示     ----------------com.roy.AutowiredTest.testBeanPostProcessor
