package com.bt.booking.mobile.facade;

import com.bt.booking.mobile.entity.Mobile;
import com.bt.booking.mobile.repository.MobileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class MobileFacade {

    @Autowired
    private MobileRepository mobileRepository;

    public List<Mobile> findall() {
        return mobileRepository.findAll();
    }

    public Optional<Mobile> findById(Long id) {
        Optional<Mobile> mobile = mobileRepository.findById(id);
        return mobile;
    }

    public Mobile save(Mobile mobile) {
        return mobileRepository.save(mobile);
    }

    public void deleteById(Long id) {
        mobileRepository.deleteById(id);
    }
}
