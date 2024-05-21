package com.lvher.kodellia.service.impl;

import com.lvher.kodellia.domain.Tbuser;
import com.lvher.kodellia.repository.TbuserRepository;
import com.lvher.kodellia.service.TbuserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TbuserServiceImpl implements TbuserService {
    private final TbuserRepository tbuserRepository;
    public TbuserServiceImpl(
            TbuserRepository tbuserRepository
    ) {
        this.tbuserRepository = tbuserRepository;
    }

    public Map<String, Object> create(Map<String, Object> param){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        System.out.println(param);
        Tbuser tbuser = Tbuser.of(param.get("username") + "", param.get("password") + "");
        tbuserRepository.save(tbuser);
        returnMap.put("id", tbuser.getId());
        return returnMap;
    }
    public Map<String, Object> update(Map<String, Object> param){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        System.out.println(param);
        Tbuser tbuser = tbuserRepository.findById(param.get("id") + "").orElseThrow(() -> new RuntimeException(""));
        if(param.get("name") != null) {
            tbuser.setName(param.get("name") + "");
        }
        if(param.get("nick") != null) {
            tbuser.setNick(param.get("nick") + "");
        }
        if(param.get("phone") != null) {
            tbuser.setPhone(param.get("phone") + "");
        }

        tbuserRepository.save(tbuser);
        returnMap.put("id", tbuser.getId());
        return returnMap;
    }
    public Map<String, Object> get(String id){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        System.out.println(id);
        Tbuser tbuser = tbuserRepository.findById(id).orElseThrow(() -> new RuntimeException(""));

        returnMap.put("id", tbuser.getId());
        returnMap.put("username", tbuser.getUsername());
        returnMap.put("name", tbuser.getName());
        returnMap.put("nick", tbuser.getNick());
        returnMap.put("phone", tbuser.getPhone());

        return returnMap;
    }
}
