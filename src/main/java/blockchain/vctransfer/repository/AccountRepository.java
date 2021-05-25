package blockchain.vctransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import blockchain.vctransfer.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

	public boolean existsByUserName(String userName);
	
	@Modifying
	@Transactional
	@Query(value=" UPDATE account SET balance = balance + :amount ", nativeQuery = true)
	public void updateBalance(Double amount);
	
}
