package com.gupaoedu.vip.spring.demo.service.impl;

import com.gupaoedu.vip.spring.demo.service.IModifyService;
import com.gupaoedu.vip.spring.formework.annotation.GPService;

/**
 * xx类
 *
 * @author eric
 * @since 2020/12/22 15:14
 */
@GPService
public class ModifyService implements IModifyService {

    public String add(String name, String addr) {
        return "ModifyService add, name=" + name + ", addr=" + addr;
    }

    public String edit(Integer id, String name) {
        return "ModifyService edit, id=" + id + ", name=" + name;
    }

    public String remove(Integer id) {
        return "ModifyService remove, id=" + id;
    }
}
