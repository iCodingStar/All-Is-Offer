package cn.codingstar.hash;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: ConsistentHash.java
 * @time: 18-3-7 下午10:18
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @desc: 一致性哈希算法研究与实现
 * @resource:
 */
public interface ConsistentHash {

    String getServer(String node);

}
