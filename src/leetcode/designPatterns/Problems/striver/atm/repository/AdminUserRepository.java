package leetcode.designPatterns.Problems.striver.atm.repository;

import leetcode.designPatterns.Problems.striver.atm.domain.AdminUser;

import java.util.Optional;

public interface AdminUserRepository {
    AdminUser save(AdminUser adminUser);
    Optional<AdminUser> findById(String adminId);
    boolean validateAdminCredentials(String adminId, String pinHash);
}