package com.elanyin.classificationserver.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "devices")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "battery_power", nullable = false)
    private Integer batteryPower;

    @Column(name = "bluetooth", nullable = false)
    private Boolean bluetooth;

    @Column(name = "clock_speed", nullable = false)
    private Double clockSpeed;

    @Column(name = "dual_sim", nullable = false)
    private Boolean dualSim;

    @Column(name = "front_camera", nullable = false)
    private Integer frontCamera;

    @Column(name = "four_g", nullable = false)
    private Boolean fourG;

    @Column(name = "internal_memory", nullable = false)
    private Integer internalMemory;

    @Column(name = "mobile_depth", nullable = false)
    private Double mobileDepth;

    @Column(name = "mobile_weight", nullable = false)
    private Integer mobileWeight;

    @Column(name = "num_cores", nullable = false)
    private Integer numCores;

    @Column(name = "primary_camera", nullable = false)
    private Integer primaryCamera;

    @Column(name = "pixel_height", nullable = false)
    private Integer pixelHeight;

    @Column(name = "pixel_width", nullable = false)
    private Integer pixelWidth;

    @Column(name = "ram", nullable = false)
    private Integer ram;

    @Column(name = "screen_height", nullable = false)
    private Integer screenHeight;

    @Column(name = "screen_width", nullable = false)
    private Integer screenWidth;

    @Column(name = "talk_time", nullable = false)
    private Integer talkTime;

    @Column(name = "three_g", nullable = false)
    private Boolean threeG;

    @Column(name = "touch_screen", nullable = false)
    private Boolean touchScreen;

    @Column(name = "wifi", nullable = false)
    private Boolean wifi;

    @Column(name = "price_range")
    private Integer priceRange;
}
