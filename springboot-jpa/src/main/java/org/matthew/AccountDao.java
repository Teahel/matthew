package org.matthew;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Matthew
 * @Date: 2019/8/10
 * @Time: 18:34
 * @Description: No Description
 */

public interface AccountDao extends JpaRepository<Account,Integer> {
}
