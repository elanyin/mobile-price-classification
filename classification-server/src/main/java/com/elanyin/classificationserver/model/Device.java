package com.elanyin.classificationserver.model;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "blue", nullable = false)
    private Boolean blue;

    @Column(name = "clock_speed", nullable = false)
    private Double clockSpeed;

    @Column(name = "dual_sim", nullable = false)
    private Boolean dualSim;

    @Column(name = "fc", nullable = false)
    private Integer fc;

    @Column(name = "four_g", nullable = false)
    private Boolean fourG;

    @Column(name = "int_memory", nullable = false)
    private Integer intMemory;

    @Column(name = "m_dep", nullable = false)
    private Double mDep;

    @Column(name = "mobile_wt", nullable = false)
    private Integer mobileWt;

    @Column(name = "n_cores", nullable = false)
    private Integer nCores;

    @Column(name = "pc", nullable = false)
    private Integer pc;

    @Column(name = "px_height", nullable = false)
    private Integer pxHeight;

    @Column(name = "px_width", nullable = false)
    private Integer pxWidth;

    @Column(name = "ram", nullable = false)
    private Integer ram;

    @Column(name = "sc_h", nullable = false)
    private Integer scH;

    @Column(name = "sc_w", nullable = false)
    private Integer scW;

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
