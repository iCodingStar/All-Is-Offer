package cn.codingstar.distribute.session;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: SessionManageStrategy.java
 * @time: 18-3-8 下午4:51
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource: http://www.cnblogs.com/xrq730/p/4954152.html
 * @desc: 分布式环境中session管理策略
 */
public class SessionManageStrategy {

    /**
     * 1. Session复制
     * 在所有服务器上同步Session对象
     * 优点：
     *      1)高可用，宕机也不会Session丢失
     *      2）实现简单
     * 缺点：
     *      无法在大规模集群环境中使用，消耗资源严重
     * 2. Session绑定
     * 负载均衡采用源地址hash策略
     * 优点：
     *      1）实现简单
     * 缺点：
     *      1）无法实现高可用，服务器宕机即丢失Session
     *  应用场景：
     *       很少实际使用
     * 3. 利用Cookie记录Session
     * 将Session记录在Session中，每次请求服务器的时候，将Session都发送给服务器
     * 优点：
     *      1）实现简单
     * 缺点：
     *      1）收到Cookie大小的显示，记录信息有限
     *      2）每次请求都携带cookie，影响性能
     *      3）如果用户关闭Cookie，访问就会不正常
     *
     * 4. Session服务器
     * 部署独立的Session服务器集群管理Session，应用服务器每次都从Session服务器中读取Session
     * 利用分布式缓存、数据库进行管理。
     * 实现SSO,用胡服务等功能
     *
     */
}
