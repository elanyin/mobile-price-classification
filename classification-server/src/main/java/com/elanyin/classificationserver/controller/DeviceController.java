package com.elanyin.classificationserver.controller;

import com.elanyin.classificationserver.dto.ResultWrapper;
import com.elanyin.classificationserver.model.Device;
import com.elanyin.classificationserver.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class DeviceController {

    @Autowired
    private final DeviceService deviceService;

    @PostMapping
    public ResultWrapper<Device> createDevice(@RequestBody Device device) {
        Device created = deviceService.createDevice(device);
        return ResultWrapper.success(created, "Device created successfully");
    }

    @GetMapping("/{id}")
    public ResultWrapper<Device> getDevice(@PathVariable Long id) {
        Device found = deviceService.getDevice(id);
        return ResultWrapper.success(found);
    }

    @GetMapping
    public ResultWrapper<List<Device>> getAllDevices() {
        List<Device> allDevices = deviceService.getAllDevices();
        return ResultWrapper.success(allDevices);
    }

    @DeleteMapping("/{id}")
    public ResultWrapper<Void> deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return ResultWrapper.success(null, "Device deleted successfully");
    }
}
