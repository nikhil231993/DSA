package leetcode.designPatterns.Problems.striver.hotelmanagementSystem.repository;

import leetcode.designPatterns.Problems.striver.hotelmanagementSystem.domain.CancellationPolicy;

import java.util.Optional;

public interface CancellationPolicyRepository {
    CancellationPolicy save(CancellationPolicy policy);

    Optional<CancellationPolicy> findById(String policyId);
}
