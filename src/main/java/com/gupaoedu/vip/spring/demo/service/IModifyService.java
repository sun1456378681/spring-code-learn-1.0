package com.gupaoedu.vip.spring.demo.service;

/**
 * xx类
 *
 * @author eric
 * @since 2020/12/22 15:11
 */

public interface IModifyService {

    String add(String name, String addr);

    String edit(Integer id, String name);

    String remove(Integer id);

}
