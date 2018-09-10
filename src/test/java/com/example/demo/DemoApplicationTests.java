package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.service.DeleteService;
import com.example.demo.service.PublishService;
import com.example.demo.service.SkuService;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	UserService userService;


	 @Autowired
	PublishService service;

	 @Autowired
	SkuService skuService;

	@Test
	public void usertest() {

		User user = new User();
		user.setAddress("流沙河畔有人家");
		user.setEmail("1012323@163.com");
		user.setHead_img("123123132_123123.jpg");
		user.setPhonenumber("18945464564");
        user.setUsername("fengjinman");
        user.setNickname("无敌");
		Result result = userService.addSelfInfo(user);
		log.info(result.toString());

	}
	@Test
	public void contextLoads() {

		Spu spu = new Spu();
		spu.setSpuname("冬季季新款皮夹克");
		spu.setClassid(1);
		spu.setBrandid(1);
		spu.setImg("00000_attr_test.jpg");
		spu.setDescribtion("当我是描述好了");
		spu.setPrice("188.22");
		spu.setUnit("dollar");
		Result result = service.addSpu(spu);
		log.info(result.toString());
	}

	@Test
	public void test1() {

		Attr attr = new Attr();
		attr.setSpuid(1);
		attr.setColor("黄色");
		attr.setSize("24");
		attr.setSize_unit("XL");
		attr.setAttr_img("00000_attr_test.jpg");
		Result result = service.addAttr(attr);

		log.info(result.toString());


	}
	@Test
	public void testsku() {

		Sku sku = new Sku();
		sku.setUserid(3);
		sku.setClassid(1);
		sku.setBrandid(1);
		sku.setSpuid(1);
		sku.setAttrid(1);
		sku.setPrice("400.25");
		sku.setUnit("rmb");
		sku.setDescribtion("描述xxxx");
		sku.setStock_count("613");
		sku.setStock_address("北京朝阳八里庄");
		sku.setSkuname("夏季爆款xxxx");

		Result result = skuService.addSku(sku);

		log.info(result.toString());


	}


	@Autowired
	DeleteService deleteService;
	@Test
	public void deletesku() {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(4);

		Result result = deleteService.deleteSkuByList(list);


		log.info(result.toString());


	}



}
