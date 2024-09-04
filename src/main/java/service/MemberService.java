package service;

import com.example.security_jpa.dao.MemberDAO;
import com.example.security_jpa.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements UserDetailsService {
    @Autowired
    private MemberDAO dao;

    public Member findById(String id) {
        return dao.findById(id).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member m = findById(username);
        if(m == null) {
            throw new UsernameNotFoundException(username);
        }
        return User.builder()
                .username(m.getId())
                .password(m.getPwd())
                .roles(m.getRole())
                .build();
    }


}
