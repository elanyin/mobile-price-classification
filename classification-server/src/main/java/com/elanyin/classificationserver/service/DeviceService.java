package com.elanyin.classificationserver.service;

import com.elanyin.classificationserver.model.Device;
import com.elanyin.classificationserver.repository.DeviceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DeviceService {

    @Autowired
    private final DeviceRepository deviceRepository;

    private final RestTemplate restTemplate;

    private static final String FLASK_URL = "http://localhost:5010/predict";


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

    public void predictPrice(Long id) {
        System.out.println("Need implement");
    }

    public Integer predictPriceRange(Map<String, Object> deviceFeatures) {
        Map<String, Object> response = restTemplate.postForObject(FLASK_URL, deviceFeatures, Map.class);

        if (response != null && Boolean.TRUE.equals(response.get("success"))) {
            return (Integer) response.get("price_range");
        } else {
            String errorMessage = response != null ? (String) response.get("message") : "No response from Flask";
            throw new RuntimeException("Prediction failed: " + errorMessage);
        }
    }
}
