package com.maveric.balanceservice.repository;

import com.maveric.balanceservice.dao.Balance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends MongoRepository<Balance, String> {
Balance findByAccountId(String accountId);
void deleteByAccountId(String accountId);
}
