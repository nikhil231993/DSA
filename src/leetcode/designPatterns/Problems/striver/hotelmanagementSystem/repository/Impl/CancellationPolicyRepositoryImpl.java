package leetcode.designPatterns.Problems.striver.hotelmanagementSystem.repository.Impl;

import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.CancellationPolicy;
import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.repository.CancellationPolicyRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CancellationPolicyRepositoryImpl implements CancellationPolicyRepository {
    private Map<String, CancellationPolicy> policies = new ConcurrentHashMap<>();

    @Override
    public CancellationPolicy save(CancellationPolicy policy) {
        policies.put(policy.getId(), policy);
        return policy;
    }

    @Override
    public Optional<CancellationPolicy> findById(String policyId) {
        return Optional.ofNullable(policies.get(policyId));
    }
}
