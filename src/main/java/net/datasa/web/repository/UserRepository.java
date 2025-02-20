package net.datasa.web.repository;

import net.datasa.web.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private static Long sequence = 0L; // ID 자동 증가를 위한 시퀀스
    private final Map<Long, User> store = new HashMap<>(); // 메모리 저장소

    // User 저장
    public User save(User user) {
        user.setId(++sequence); // ID 자동 할당
        store.put(user.getId(), user);
        return user;
    }

    // ID로 User 조회
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    // 모든 User 조회
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

}
