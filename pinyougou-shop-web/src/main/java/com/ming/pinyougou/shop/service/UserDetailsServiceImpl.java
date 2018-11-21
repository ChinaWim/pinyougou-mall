package com.ming.pinyougou.shop.service;

import com.ming.pinyougou.pojo.TbSeller;
import com.ming.pinyougou.sellergoods.service.SellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/** 认证类
 * @author m969130721@163.com
 * @date 18-11-21 上午10:41
 */
public class UserDetailsServiceImpl implements UserDetailsService {


    private SellerService sellerService;

    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));

        TbSeller seller = sellerService.findOne(username);
        if (seller != null) {
            //未审核
            if("1".equals(seller.getStatus())){
                return new User(username,seller.getPassword(),grantedAuthorities);
            }
            return null;
        }else {
            return null;
        }


    }
}
