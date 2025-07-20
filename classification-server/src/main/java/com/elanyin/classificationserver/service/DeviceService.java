package com.elanyin.classificationserver.service;

import com.elanyin.classificationserver.model.Device;
import com.elanyin.classificationserver.repository.DeviceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {

    @Autowired
    private final DeviceRepository deviceRepository;

    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device getDevice(Long id) {
        return deviceRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Device with id: " + id + " not found")
        );
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device updateDevice(Long id, Device newDevice) {
        Device oldDevice = getDevice(id);
        newDevice.setId(oldDevice.getId());
        return deviceRepository.save(newDevice);
    }

    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }
}
