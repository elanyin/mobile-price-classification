package com.elanyin.classificationserver;

import com.elanyin.classificationserver.model.Device;
import com.elanyin.classificationserver.repository.DeviceRepository;
import com.elanyin.classificationserver.service.DeviceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClassificationServerApplicationTests {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private DeviceRepository deviceRepository;

    @Test
    void testCreateDevice() {
        Device device = new Device();
        device.setBatteryPower(1500);
        device.setBluetooth(true);
        device.setClockSpeed(1.8);
        device.setDualSim(true);
        device.setFrontCamera(5);
        device.setFourG(true);
        device.setInternalMemory(32);
        device.setMobileDepth(0.8);
        device.setMobileWeight(140);
        device.setNumCores(4);
        device.setPrimaryCamera(12);
        device.setPixelHeight(1280);
        device.setPixelWidth(720);
        device.setRam(4096);
        device.setScreenHeight(12);
        device.setScreenWidth(7);
        device.setTalkTime(18);
        device.setThreeG(true);
        device.setTouchScreen(true);
        device.setWifi(true);
        device.setPriceRange(2); // 可选

        deviceService.createDevice(device);

    }

    @Test
    void getDevices() {
        System.out.println(deviceRepository.findAll());
    }
}
