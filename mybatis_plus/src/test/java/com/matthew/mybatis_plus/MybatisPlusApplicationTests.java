package com.matthew.mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.matthew.entity.User;
import com.matthew.mapper.UserMapper;
import com.matthew.service.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.matthew")
public class MybatisPlusApplicationTests {

	@Resource
	private UserMapper userMapper;

	@Resource
	private IUserService userService;

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<User> userList = userMapper.selectList(null);
		Assert.assertEquals(5, userList.size());
		userList.forEach(System.out::println);
	}

	/**
	 * <p>
	 * 插入一条记录
	 * </p>
	 *
	 * @param entity 实体对象
	 * @return 插入成功记录数
	 */
	@Test
    public void insert(){
		User user=new User();
		user.setName("黎明");
		user.setAge(19);
		user.setEmail("teahel@163.com");
		userMapper.insert(user);
		System.out.println(("----- selectAll method test ------"));
		List<User> userList = userMapper.selectList(null);
		userList.forEach(System.out::println);
	}

	/**
	 * <p>
	 * 根据 ID 删除
	 * </p>
	 *
	 * @param id 主键ID
	 * @return 删除成功记录数
	 */
	@Test
	public void deleteById(){
		User user=new User();
		user.setId("1");
		userMapper.deleteById("1");
		System.out.println(("----- selectAll method test ------"));
		List<User> userList = userMapper.selectList(null);
		userList.forEach(System.out::println);
	}

	/**
	 * <p>
	 * 根据 columnMap 条件，删除记录
	 * </p>
	 *
	 * @param columnMap 表字段 map 对象
	 * @return 删除成功记录数
	 */
	@Test
    public void deleteByMap(){
		Map<String,Object> map=new HashMap<>();
		map.put("id","2");
		System.out.println(("----- selectAll method test ------"));
		int i=userMapper.deleteByMap(map);
		System.out.println("-----------结果--------"+i);
	}

	/**
	 * <p>
	 * 根据 entity 条件，删除记录
	 * </p>
	 *
	 * @param wrapper 实体对象封装操作类（可以为 null）
	 * @return 删除成功记录数
	 */
	@Test
	public void delete(){


	}

	/**
	 * 使用深层封装实现IService
	 */
	@Test
	public void userServiceAPI(){
		List<User> list=userService.list();
		list.forEach(System.out::println);
	}

	/**
	 * <p>
	 * 插入一条记录（选择字段，策略插入）
	 * </p>
	 *
	 * @param entity 实体对象
	 */
	@Test
	public void save(){
		User user=new User();
		user.setName("王五");
		user.setEmail("teahel@163.com");
		user.setAge(2);
		boolean flag=userService.save(user);
		System.out.println(("----- selectAll method test ------"));
		System.out.println((flag));
		System.out.println(("----- selectAll method test ------"));
	}
	/**
	 * 插入（批量）
	 *
	 * @param entityList 实体对象集合
	 * @param batchSize  插入批次数量
	 */
	@Test
	public void saveBatch(){
		List<User> list=new ArrayList<>();
		User user1=new User();
		user1.setName("王五");
		user1.setEmail("teahel@163.com");
		user1.setAge(2);
		User user2=new User();
		user2.setName("王五");
		user2.setEmail("teahel@163.com");
		user2.setAge(2);
		User user3=new User();
		user3.setName("王五");
		user3.setEmail("teahel@163.com");
		user3.setAge(2);
		list.add(user1);
		list.add(user2);
		list.add(user3 );
        boolean flag=userService.saveBatch(list);
		System.out.println(("----- selectAll method test ------"));
		System.out.println((flag));
		System.out.println(("----- selectAll method test ------"));
	}

	/**
	 * <p>
	 * 批量修改插入
	 * </p>
	 *
	 * @param entityList 实体对象集合
	 */
	@Test
	public void saveOrUpdateBatch(){
		List<User> list=new ArrayList<>();
		User user1=new User();
		user1.setId("3");
		user1.setName("王五");
		user1.setEmail("teahel@163.com");
		user1.setAge(2);
		User user2=new User();
		user2.setId("4");
		user2.setName("王五");
		user2.setEmail("teahel@163.com");
		user2.setAge(2);
		User user3=new User();
		user3.setId("5");
		user3.setName("王五");
		user3.setEmail("teahel@163.com");
		user3.setAge(2);
		list.add(user1);
		list.add(user2);
		list.add(user3);
		boolean flag=userService.saveOrUpdateBatch(list);
		System.out.println(("----- selectAll method test ------"));
		System.out.println((flag));
		System.out.println(("----- selectAll method test ------"));
	}

	/**
	 * <p>
	 * 根据 ID 删除
	 * </p>
	 *
	 * @param id 主键ID
	 */
	@Test
	public void removeById(){
		/*User user1=new User();
		user1.setId("3");
		user1.setName("王五");
		user1.setEmail("teahel@163.com");*/
		boolean flag=userService.removeById("3");
		System.out.println(("----- selectAll method test ------"));
		System.out.println((flag));
		System.out.println(("----- selectAll method test ------"));
	}

	/**
	 * <p>
	 * 根据 columnMap 条件，删除记录
	 * </p>
	 *
	 * @param columnMap 表字段 map 对象
	 */
	@Test
	public void removeByMap(){
		Map<String,Object> map=new HashMap<>();
		map.put("id","4");
		map.put("age","2");
		boolean flag=userService.removeByMap(map);
		System.out.println(("----- selectAll method test ------"));
		System.out.println((flag));
		System.out.println(("----- selectAll method test ------"));
	}

	/**
	 * <p>
	 * 根据 entity 条件，删除记录
	 * </p>
	 *
	 * @param queryWrapper 实体包装类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
	 */
	@Test
	public void remove(){
		QueryWrapper queryWrapper=new QueryWrapper();
		queryWrapper.eq("id","5");
		boolean flag=userService.remove(queryWrapper);
		System.out.println(("----- selectAll method test ------"));
		System.out.println((flag));
		System.out.println(("----- selectAll method test ------"));
	}

	/**
	 * <p>
	 * 删除（根据ID 批量删除）
	 * </p>
	 *
	 * @param idList 主键ID列表
	 */
	@Test
	public void removeByIds(){
		List<String> list=new ArrayList<>();
		list.add(new String("2c7568c41387bce6e69c07af9564a98e"));
		list.add(new String("4e0e932f8d4b0f0af50392f4f1ba3e7e"));
		list.add(new String("6da076688cf21d34bed2b8f68943fce5"));
		list.add(new String("b476c75bd6c52cef1d025f2c56bf449c"));
		boolean flag=userService.removeByIds(list);
		System.out.println(("----- selectAll method test ------"));
		System.out.println((flag));
		System.out.println(("----- selectAll method test ------"));
	}

	/**
	 * <p>
	 * 根据 ID 选择修改
	 * </p>
	 *
	 * @param entity 实体对象
	 */
	@Test
	public void updateById(){
        User user1=new User();
		user1.setId("e3429fedfea6054d559f0dbb4e565df4");
		user1.setName("王武");
		user1.setEmail("159077397156@163.com");
		boolean flag=userService.updateById(user1);
		System.out.println(("----- selectAll method test ------"));
		System.out.println((flag));
		System.out.println(("----- selectAll method test ------"));
	}

	/**
	 * <p>
	 * 根据 whereEntity 条件，更新记录
	 * </p>
	 *
	 * @param entity        实体对象
	 * @param updateWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper}
	 */
	@Test
	public void update(){
		User user1=new User();
		user1.setName("谢武");
		user1.setEmail("6666@163.com");
		UpdateWrapper updateWrapper=new UpdateWrapper();
		updateWrapper.eq("id","03ff02a536f723a590966b659feefb3a");
		boolean flag=userService.update(user1,updateWrapper);
		System.out.println(("----- selectAll method test ------"));
		System.out.println((flag));
		System.out.println(("----- selectAll method test ------"));
	}

	/**
	 * <p>
	 * 根据ID 批量更新
	 * </p>
	 *
	 * @param entityList 实体对象集合
	 * @param batchSize  更新批次数量
	 */
	@Test
	public void updateBatchById(){
		List<User> list=new ArrayList<>();
		User user1=new User();
		user1.setId("03ff02a536f723a590966b659feefb3a");
		user1.setName("谢谢");
		user1.setEmail("11@163.com");
		user1.setAge(2);
		User user2=new User();
		user2.setId("4ff1f2a6bc4ba6f8112e8d2a61b57322");
		user2.setName("谢谢");
		user2.setEmail("22@163.com");
		user2.setAge(2);
		User user3=new User();
		user3.setId("c65d16a15b065bd0338b880e7a24646a");
		user3.setName("谢谢");
		user3.setEmail("33@163.com");
		user3.setAge(2);
		list.add(user1);
		list.add(user2);
		list.add(user3);
        boolean flag=userService.updateBatchById(list,list.size());
		System.out.println(("----- selectAll method test ------"));
		System.out.println((flag));
		System.out.println(("----- selectAll method test ------"));
	}
	/**
	 * <p>
	 * 根据 ID 查询
	 * </p>
	 *
	 * @param id 主键ID
	 */
	@Test
	public void getById(){
        User user=userService.getById("03ff02a536f723a590966b659feefb3a");
        System.out.println(user.toString());
	}

	/**
	 * <p>
	 * 查询（根据ID 批量查询）
	 * </p>
	 *
	 * @param idList 主键ID列表
	 */
	@Test
	public void listByIds(){
		List<String> strings=new ArrayList<>();
		strings.add(new String("03ff02a536f723a590966b659feefb3a"));
		strings.add(new String("4ff1f2a6bc4ba6f8112e8d2a61b57322"));
		strings.add(new String("ab3a2a6c632d8f09ebe99b9e395cf069"));
		strings.add(new String("c65d16a15b065bd0338b880e7a24646a"));
		List<User> list= (List<User>) userService.listByIds(strings);
		System.out.println(("----- selectAll method test ------"));
		list.forEach(System.out::println);
		System.out.println(("----- selectAll method test ------"));
	}

	/**
	 * <p>
	 * 查询（根据 columnMap 条件）
	 * </p>
	 *
	 * @param columnMap 表字段 map 对象
	 */
	@Test
	public void listByMap(){
		Map<String,Object> map=new HashMap<>();
		map.put("email","teahel@163.com");
        List<User> list= (List<User>) userService.listByMap(map);
		System.out.println(("----- selectAll method test ------"));
		list.forEach(System.out::println);
		System.out.println(("----- selectAll method test ------"));
	}

	/**
	 * <p>
	 * 根据 Wrapper，查询一条记录
	 * </p>
	 *
	 * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
	 * @param throwEx      有多个 result 是否抛出异常
	 */
	@Test
	public void getOne(){
		boolean flag=true;
		QueryWrapper queryWrapper=new QueryWrapper();
		queryWrapper.eq("email","11@163.com");
		queryWrapper.eq("id","03ff02a536f723a590966b659feefb3a");
        User user=userService.getOne(queryWrapper,flag);
        if(flag){
			System.out.println(("----- selectAll method test ------"));
			System.out.println(user.toString());
			System.out.println(("----- selectAll method test ------"));
		}else {
			System.out.println(("----- selectAll method test ------"));
			System.out.println(flag);
			System.out.println(("----- selectAll method test ------"));
		}
	}

	/**
	 * <p>
	 * 根据 Wrapper，查询一条记录
	 * </p>
	 *
	 * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
	 */
	@Test
	public void getObj(){
		QueryWrapper queryWrapper=new QueryWrapper();
		queryWrapper.eq("id","03ff02a536f723a590966b659feefb3a");
		Object obj=userService.getObj(queryWrapper,Function.identity());
		System.out.println(obj.toString());
	}

	/**
	 * <p>
	 * 根据 Wrapper 条件，查询总记录数
	 * </p>
	 *
	 * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
	 */
	@Test
	public void count(){
		QueryWrapper queryWrapper=new QueryWrapper();
		queryWrapper.eq("email","11@163.com");
		int i=userService.count(queryWrapper);
		System.out.println(i);
	}
	/**
	 * <p>
	 * 查询列表
	 * </p>
	 *
	 * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
	 */
	@Test
	public void list(){
		QueryWrapper queryWrapper=new QueryWrapper();
		queryWrapper.eq("email","teahel@163.com");
		List<User> list=userService.list(queryWrapper);
		System.out.println(("----- selectAll method test ------"));
		list.forEach(System.out::println);
		System.out.println(("----- selectAll method test ------"));
	}

	/**
	 * <p>
	 * 翻页查询
	 * </p>
	 *
	 * @param page         翻页对象
	 * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
	 */
	@Test
	public void page(){

		Page page =new Page(1,2,4);
		QueryWrapper queryWrapper=new QueryWrapper();
		queryWrapper.eq("email","teahel@163.com");
		IPage<User> p=userService.page(page,queryWrapper);
		if(p!=null){
			List<User> list=p.getRecords();
			list.forEach(System.out::println);
		}
        System.out.println(p.getCurrent());
		System.out.println(p.getTotal());
	}

	/**
	 * <p>
	 * 翻页查询
	 * </p>
	 *
	 * @param page         翻页对象
	 * @param queryWrapper 实体对象封装操作类 {@link com.baomidou.mybatisplus.core.conditions.query.QueryWrapper}
	 */
	@Test
	public void pages(){
		Page<User> page = new Page<>(1,1);
		IPage<User> pages=userService.page(page,null);
		if ( 1 == 1 ){
			System.out.println("1111");
			String string = new String("测试");
			System.out.println(string);
		}
	}

}
