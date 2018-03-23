## Spring IOC

### IOC容器初始化过程

#### Resource定位
> 即BeanDefinition资源的定位，由ResourceLoader通过统一的Resource接口完成，这个Resource对各种形式的BeanDefinition都使用了同意统一的接口。


#### BeanDefinition载入与解析
> BeanDefinition的载入是把用户定义好的Bean表示成IOC内部的数据结构，这个容器内部的数据结构就是BeanDefinition。BeanDefinition实际上就是POJO对象在IOC容器中的抽象，
通过BeanDefinition可以方便的对Bean进行管理。

#### 向IOC容器注册BeanDefinition
> 通过调用BeanDefinitionRegistry接口来实现。这个过程把载入过程解析得到的BeanDefinitionxiangIOC容器注册。
> 通过分析，我们可以看到，在IOC容器内部将BeanDefinition注入到一个HashMap中去，IOC容器就是通过HashMap来持有这些BeanDefinition数据的。

* 初始化的目的：建立BeanDefine数据映射

### IOC容器的依赖注入

* 触发时间：用户第一次向IOC容器索要Bean时触发的，当然也有例外，可以通过设置 `lazy-init` 使其预先初始化，提前完成依赖注入
